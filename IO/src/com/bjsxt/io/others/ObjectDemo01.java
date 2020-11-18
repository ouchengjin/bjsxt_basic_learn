package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * 不是所有的对象都可以序列化，java.io.NotSerializableException 
 * 不是所有的属性都需要序列化，transient
 * @ClassName: ObjectDemo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-02 22:57:47
 */
public class ObjectDemo01 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		try {
//			serial("D:/mycode/cp/serial.txt");
			read("D:/mycode/cp/serial.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//反序列化
	public static void read(String src) throws FileNotFoundException, IOException, ClassNotFoundException {
		//创建源
		File sc= new File(src);
		//选择流
		ObjectInputStream dis = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(sc)));
		//操作	读取的顺序和写出一致，必须存在才能读取
		//不一致，读出数据会出现问题
		Object obj =  dis.readObject();
		if(obj instanceof Employee) {
			Employee emp = (Employee) obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
		obj= dis.readObject();
		int[] arr= (int[]) obj;
		System.out.println(Arrays.toString(arr));
		dis.close();
	}

	//序列化
	public static void serial(String destPath) throws IOException {
		Employee emp = new Employee("bjsxt", 1000000);
		int[] arr = {1,2,3,45};

		// 创建源
		File dest = new File(destPath);
//		选择流DataOutputStream
		ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
//		操作 写出的顺序，为读取做准备
		dos.writeObject(emp);
		dos.writeObject(arr);
		dos.flush();
		// 释放资源
		dos.close();
	}

}
