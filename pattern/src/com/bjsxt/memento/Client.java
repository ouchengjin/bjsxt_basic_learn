package com.bjsxt.memento;

public class Client {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(描述)
	 * @param args
	 * @author Alan Ouyang
	 * @date 2020-06-10 21:57:12
	 */
	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		Emp emp = new Emp("Alan", 18, 100000);
		Emp emp2 = new Emp("Alan2", 19, 200000);
		System.out.println("新建时，名字："+emp.getName()+"，年龄："+emp.getAge()+"，薪水："+emp.getSalary());
		System.out.println("Alan2新建时，名字："+emp2.getName()+"，年龄："+emp2.getAge()+"，薪水："+emp2.getSalary());
		careTaker.setEmpMemento(emp.memento());//备忘一次
		careTaker.setEmpMemento(emp2.memento());//备忘一次
		emp.setName("Tom");
		emp.setAge(17);
		emp.setSalary(1000000);
		emp2.setName("Tom2");
		emp2.setAge(20);
		emp2.setSalary(300000);
		System.out.println("修改后，名字："+emp.getName()+"，年龄："+emp.getAge()+"，薪水："+emp.getSalary());
		System.out.println("Alan2修改后，名字："+emp2.getName()+"，年龄："+emp2.getAge()+"，薪水："+emp2.getSalary());
		emp2.recovery(careTaker.getEmpMemento());//恢复成备忘录对象保存的状态
		emp.recovery(careTaker.getEmpMemento());//恢复成备忘录对象保存的状态
		System.out.println("恢复后，名字："+emp.getName()+"，年龄："+emp.getAge()+"，薪水："+emp.getSalary());
		System.out.println("Alan2恢复后，名字："+emp2.getName()+"，年龄："+emp2.getAge()+"，薪水："+emp2.getSalary());
		
	}

}
