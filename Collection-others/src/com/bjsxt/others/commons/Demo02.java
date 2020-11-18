package com.bjsxt.others.commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

/**
 * 
 * @ClassName: Demo02
 * @Description: TODO(����)
 * @author author
 * @date 2020-03-01 22:55:02
 */
public class Demo02 {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(����)
	 * @param args
	 * @author author
	 * @date 2020-03-01 22:55:07
	 */
	public static void main(String[] args) {
		System.out.println("==============�Զ������͵�ת��===============");
		Predicate<Employee> isLow=new Predicate<Employee>() {
		@Override
		public boolean evaluate(Employee emp) {
			// TODO Auto-generated method stub
			return emp.getSalary()<10000;
		}};
		Predicate<Employee> isHigh=new Predicate<Employee>() {
			@Override
			public boolean evaluate(Employee emp) {
				// TODO Auto-generated method stub
				return emp.getSalary()>=10000;
			}};
			
			Predicate[] pres= {isLow,isHigh};
			
			Transformer<Employee, Level> lowTrans= new Transformer<Employee, Level>() {
				@Override
				public Level transform(Employee input) {
					// TODO Auto-generated method stub
					return new Level(input.getName(),"������");
				}
			};
			
			Transformer<Employee, Level> highTrans= new Transformer<Employee, Level>() {
				@Override
				public Level transform(Employee input) {
					// TODO Auto-generated method stub
					return new Level(input.getName(),"������");
				}
			};
			
			Transformer[] trans= {lowTrans,highTrans};
			
			Transformer switchTrans= new SwitchTransformer(pres, trans, null);
			
			List<Employee> list =new ArrayList<Employee>();
			list.add(new Employee("����",(double) 100000));
			list.add(new Employee("����",(double) 999));
			
			Collection<Level> levelList=CollectionUtils.collect(list, switchTrans);
			
			Iterator<Level> levelIt=levelList.iterator();
			while(levelIt.hasNext()) {
				System.out.println(levelIt.next());
			}
			
			
	}
	/**
	 * 
	 * @Title: inner
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-02 21:32:22
	 */
	public static void  inner() {
		System.out.println("��������ת�� ������ʱ�����ڣ�ת��ָ����ʽ���ַ���");
		
		Transformer<Long, String> trans= new Transformer<Long, String>() {
			@Override
			public String transform(Long input) {
				// TODO Auto-generated method stub
				return new SimpleDateFormat("yyyy��MM��dd��").format(input);
			}
		};
		
		List<Long> list=new ArrayList<Long>();
		list.add(9999999999L);
		list.add(30000000L);
		
		Collection<String> result= CollectionUtils.collect(list, trans);
		for (String timeTemp:result) {
			
			System.out.println(timeTemp);
		}
		
	}

}
