package com.bjsxt.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * 负责管理备忘录对象
 * @ClassName: CareTaker
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-10 21:43:15
 */
public class CareTaker {
	private EmpMemento  empMemento;
	//自己添加的容器，使用时，后进的先恢复，才不会出错
	private List<EmpMemento> empMementos= new ArrayList<EmpMemento>();
	

	public EmpMemento getEmpMemento() {
		EmpMemento ret = empMementos.get(empMementos.size()-1);
		empMementos.remove(empMementos.size()-1);
		return ret;
		
	}

	public void setEmpMemento(EmpMemento empMemento) {
		this.empMemento = empMemento;
		empMementos.add(empMemento);
	}
	
	

}
