package com.bjsxt.test;
/**
 * 测试匿名内部类
 * @ClassName: Demo05
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-28 22:24:56
 */
public class Demo05 {

	public static void main(String[] args) {
		Outer05 outer05= new Outer05();
		outer05.test();
	}
}

class Outer05{
	
	public void test02(Car car) {
		car.run();
	}
	//根据定义位置判断成员内部类
	Runnable runnable= new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
	public void test() {
		//new了这个接口的实现类的对象，一定不要忘记分号
		//匿名内部类，由于定义在方法内部，同时也是方法内部类
		//接口内部类
		Runnable runnable= new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};//一定不要忘记分号
		
		//继承式匿名内部类
		Car car= new Car() {
			@Override
			public void run() {
				System.out.println("子类的车跑");
			}
		};
		car.run();
		//参数式匿名内部类
		test02(new Car() {
			@Override
			public void run() {
				System.out.println("参数式匿名内部类，车在跑");;
			}
		});
		
	}
}

class Car{
	public void run() {
		System.out.println("汽车跑");
	}
}
