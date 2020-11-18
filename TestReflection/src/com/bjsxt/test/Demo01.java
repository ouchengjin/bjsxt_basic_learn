package com.bjsxt.test;
/**
 * 测试各种类型（class,interface,enum,annotation,primitive type,void 等）对应的java.lang.Class对象的获取方式
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-15 21:27:33
 */
public class Demo01 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		String path = "com.bjsxt.bean.User";
		try {
			Class clazz = Class.forName(path);
			//对象时表示或封装一些数据。一个类被加载后，JVM会创建一个Class对象，类的整个结构信息会放到对应的Class对象中。
			//这个Class对象就像一面镜子一样，通过这面镜子我可以看到对应类的全部信息
			System.out.println(clazz);
			System.out.println(clazz.hashCode());
			Class clazz2 = Class.forName(path);//一个类只对应一个Class对象
			System.out.println(clazz2.hashCode());
			
			Class strClazz=String.class;
			Class strClazz2=path.getClass();
			System.out.println(strClazz.hashCode());
			System.out.println(strClazz2.hashCode());
			System.out.println(strClazz==strClazz2);
			
			Class intClazz=int.class;

			int[] arr01=new int[10];
			int[] arr02=new int[30];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			
			int[][] arr03=new int[10][10];
			int[][] arr04=new int[30][30];
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());
			
			double[] arr05 = new double[10];
			System.out.println(arr05.getClass().hashCode());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
