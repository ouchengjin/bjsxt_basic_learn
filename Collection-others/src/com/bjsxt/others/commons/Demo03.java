package com.bjsxt.others.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

public class Demo03 {

	public static void main(String[] args) {
//		whileClosure();
		ifClosure();
		chainClosure();
	}
	
	/**
	 * 折上减，先打折商品，进行九折，满百减二十
	 * @Title: ifClosure
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-07 19:41:35
	 */
	public static void chainClosure() {
		List<Goods> goodsList= new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频", 120, true));
		goodsList.add(new Goods("javaee视频", 100, false));
		goodsList.add(new Goods("高新技术视频", 60, false));
		
		//满百减20
		Closure<Goods> subtract= new Closure<Goods>() {@Override
		public void execute(Goods goods) {
//			goods.setPrice(goods.getPrice()>=100?(goods.getPrice()-20):goods.getPrice());
			if(goods.getPrice()>=100) {
				
				goods.setPrice(goods.getPrice()-20);
			}
		}
		}; 
		
		//打折
		Closure<Goods> discount= new Closure<Goods>() {@Override
			public void execute(Goods goods) {
			if(goods.isDiscount()) {
				goods.setPrice(goods.getPrice()*0.9);
				
			}
			}
			}; 
	
		//链式操作
		Closure<Goods> chainedClo=ChainedClosure.chainedClosure(discount,subtract);
		//关联
		CollectionUtils.forAllDo(goodsList, chainedClo);
		
		//查看
//		Iterator<Goods> goodIt=goodsList.iterator();
//		while(goodIt.hasNext()) {
//			System.out.println(goodIt.next());
//		}
		for (Goods temp:goodsList)
		{
			System.out.println(temp);
		}
	}
	
	/**
	 * 确保所有的员工工资都大于10000，如果已经超过的不再上涨
	 * @Title: whileClosure
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-07 19:23:22
	 */
	public static void whileClosure() {
		
		//数据
		List<Employee> emplist= new ArrayList<Employee>();
		emplist.add(new Employee("bjsxt", (double) 20000));
		emplist.add(new Employee("is", (double) 10000));
		emplist.add(new Employee("good", (double) 5000));
		
		//业务功能 每次上涨0.2
		Closure<Employee> clos = new Closure<Employee>() {
		@Override
		public void execute(Employee emp) {
		emp.setSalary(emp.getSalary()*1.2);
			
		}};
		
		//判断
		Predicate<Employee> empPre = new Predicate<Employee>() {@Override
		public boolean evaluate(Employee emp) {
			return emp.getSalary()<10000;
		}
		};
		//false表示是while循环先判断再执行，当为true，就是do...while结构，先执行后判断
		Closure<Employee> whileClos= WhileClosure.whileClosure(empPre, clos, false);
		//工具类
		CollectionUtils.forAllDo(emplist, whileClos);
		//操作后的数据
		Iterator<Employee> empIt= emplist.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
		}
	}
	/**
	 * 二选一，如果是打折商品，进行九折，否则满百减二十
	 * @Title: ifClosure
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-03-07 19:41:35
	 */
	public static void ifClosure() {
		List<Goods> goodsList= new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频", 120, true));
		goodsList.add(new Goods("javaee视频", 100, false));
		goodsList.add(new Goods("高新技术视频", 60, false));
		
		//满百减20
		Closure<Goods> subtract= new Closure<Goods>() {@Override
		public void execute(Goods goods) {
//			goods.setPrice(goods.getPrice()>=100?(goods.getPrice()-20):goods.getPrice());
			if(goods.getPrice()>=100) {
				
				goods.setPrice(goods.getPrice()-20);
			}
		}
		}; 
		
		//打折
		Closure<Goods> discount= new Closure<Goods>() {@Override
			public void execute(Goods goods) {
			if(goods.isDiscount()) {
				goods.setPrice(goods.getPrice()*0.9);
				
			}
			}
			}; 
		//判断
		Predicate<Goods> pre = new Predicate<Goods>() {@Override
		public boolean evaluate(Goods goods) {
			return goods.isDiscount();
		}
		};
		//二选一
		Closure<Goods> ifClo=IfClosure.ifClosure(pre, discount,subtract);
		//关联
		CollectionUtils.forAllDo(goodsList, ifClo);
		
		//查看
//		Iterator<Goods> goodIt=goodsList.iterator();
//		while(goodIt.hasNext()) {
//			System.out.println(goodIt.next());
//		}
		for (Goods temp:goodsList)
		{
			System.out.println(temp);
		}
	}
	
	public static void basic() {
		List<Employee> emplist= new ArrayList<Employee>();
		emplist.add(new Employee("bjsxt", (double) 20000));
		emplist.add(new Employee("is", (double) 10000));
		emplist.add(new Employee("good", (double) 5000));
		
		Closure<Employee> clos = new Closure<Employee>() {
		@Override
		public void execute(Employee emp) {
		emp.setSalary(emp.getSalary()*1.2);
			
		}};
		
		CollectionUtils.forAllDo(emplist, clos);
		
		Iterator<Employee> empIt= emplist.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
		}
	}

}
