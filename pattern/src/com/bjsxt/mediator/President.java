package com.bjsxt.mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {
	private Map<String, Department> departments=new HashMap<String, Department>();
	
	@Override
	public void registor(String dname, Department department) {
		departments.put(dname, department);
		if(departments.containsKey(dname)) {
			System.out.println(dname+"登记成功");
		}else {
			System.out.println(dname+"登记失败");
			
		}
	}

	@Override
	public void command(String command) {
		departments.get(command).selfAction();
		
	}
	
}
