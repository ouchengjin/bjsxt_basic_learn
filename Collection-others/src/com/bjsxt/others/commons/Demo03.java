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
	 * ���ϼ����ȴ�����Ʒ�����о��ۣ����ټ���ʮ
	 * @Title: ifClosure
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-07 19:41:35
	 */
	public static void chainClosure() {
		List<Goods> goodsList= new ArrayList<Goods>();
		goodsList.add(new Goods("javase��Ƶ", 120, true));
		goodsList.add(new Goods("javaee��Ƶ", 100, false));
		goodsList.add(new Goods("���¼�����Ƶ", 60, false));
		
		//���ټ�20
		Closure<Goods> subtract= new Closure<Goods>() {@Override
		public void execute(Goods goods) {
//			goods.setPrice(goods.getPrice()>=100?(goods.getPrice()-20):goods.getPrice());
			if(goods.getPrice()>=100) {
				
				goods.setPrice(goods.getPrice()-20);
			}
		}
		}; 
		
		//����
		Closure<Goods> discount= new Closure<Goods>() {@Override
			public void execute(Goods goods) {
			if(goods.isDiscount()) {
				goods.setPrice(goods.getPrice()*0.9);
				
			}
			}
			}; 
	
		//��ʽ����
		Closure<Goods> chainedClo=ChainedClosure.chainedClosure(discount,subtract);
		//����
		CollectionUtils.forAllDo(goodsList, chainedClo);
		
		//�鿴
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
	 * ȷ�����е�Ա�����ʶ�����10000������Ѿ������Ĳ�������
	 * @Title: whileClosure
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-07 19:23:22
	 */
	public static void whileClosure() {
		
		//����
		List<Employee> emplist= new ArrayList<Employee>();
		emplist.add(new Employee("bjsxt", (double) 20000));
		emplist.add(new Employee("is", (double) 10000));
		emplist.add(new Employee("good", (double) 5000));
		
		//ҵ���� ÿ������0.2
		Closure<Employee> clos = new Closure<Employee>() {
		@Override
		public void execute(Employee emp) {
		emp.setSalary(emp.getSalary()*1.2);
			
		}};
		
		//�ж�
		Predicate<Employee> empPre = new Predicate<Employee>() {@Override
		public boolean evaluate(Employee emp) {
			return emp.getSalary()<10000;
		}
		};
		//false��ʾ��whileѭ�����ж���ִ�У���Ϊtrue������do...while�ṹ����ִ�к��ж�
		Closure<Employee> whileClos= WhileClosure.whileClosure(empPre, clos, false);
		//������
		CollectionUtils.forAllDo(emplist, whileClos);
		//�����������
		Iterator<Employee> empIt= emplist.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
		}
	}
	/**
	 * ��ѡһ������Ǵ�����Ʒ�����о��ۣ��������ټ���ʮ
	 * @Title: ifClosure
	 * @Description: TODO(����)
	 * @author author
	 * @date 2020-03-07 19:41:35
	 */
	public static void ifClosure() {
		List<Goods> goodsList= new ArrayList<Goods>();
		goodsList.add(new Goods("javase��Ƶ", 120, true));
		goodsList.add(new Goods("javaee��Ƶ", 100, false));
		goodsList.add(new Goods("���¼�����Ƶ", 60, false));
		
		//���ټ�20
		Closure<Goods> subtract= new Closure<Goods>() {@Override
		public void execute(Goods goods) {
//			goods.setPrice(goods.getPrice()>=100?(goods.getPrice()-20):goods.getPrice());
			if(goods.getPrice()>=100) {
				
				goods.setPrice(goods.getPrice()-20);
			}
		}
		}; 
		
		//����
		Closure<Goods> discount= new Closure<Goods>() {@Override
			public void execute(Goods goods) {
			if(goods.isDiscount()) {
				goods.setPrice(goods.getPrice()*0.9);
				
			}
			}
			}; 
		//�ж�
		Predicate<Goods> pre = new Predicate<Goods>() {@Override
		public boolean evaluate(Goods goods) {
			return goods.isDiscount();
		}
		};
		//��ѡһ
		Closure<Goods> ifClo=IfClosure.ifClosure(pre, discount,subtract);
		//����
		CollectionUtils.forAllDo(goodsList, ifClo);
		
		//�鿴
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
