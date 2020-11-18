package com.bjsxt.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//通过IO流操作，将字符串存储为一个临时文件（.java），（然后可以调用动态编译方法）
		String str= "public class Hi{public class{public static void main(String[] args) {System.out.println(\"Hi,sxt\");}}}";
		makeFile(str,"D:\\mycode\\myjava\\Hi.java");
		//动态编译一个文件
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, "D:\\mycode\\myjava\\HelloWorld.java");
		System.out.println(result==0?"编译成功":"编译失败");
		//执行编译好的文件，通过Runtime调用执行类
//		Runtime run= Runtime.getRuntime();
//		Process process=run.exec("java -cp D:\\mycode\\myjava HelloWorld");
//		
//		InputStream is = process.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		String info="";
//		while((info = br.readLine())!=null) {
//			System.out.println(info);
//			
//		}
		
		try {
			URL[] urls = new URL[] { new URL("file:/" + "D:/mycode/myjava/") };
			URLClassLoader loader = new URLClassLoader(urls);
			Class<?> c = loader.loadClass("HelloWorld");
			//调用加载类的main方法
			Method m=c.getMethod("main", String[].class);
			//由于可变参数时jdk1.5之后才有。会被编译为m.invoke(null, "aa","bb")，就发生了参数个数不匹配的问题
			//因此必须要加上（Object）转型，避免这个问题
//			m.invoke(null, new String[] {"aa","bb"});
			//加上Object就会以数组使用
			//有参数就穿进去，无参数的话也可以将"aa","bb"去除
			m.invoke(null, (Object) new String[] {"aa","bb"});
			
			//public static void mmm(String[] a,String[] b)
			//public static void main(String[] a)
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 将字符串写进文件
	 * @Title: makeFile
	 * @Description: TODO(描述)
	 * @param str
	 * @param path
	 * @throws IOException
	 * @author author
	 * @date 2020-05-21 22:05:23
	 */
	public static void makeFile(String str,String path) throws IOException {
		
		FileWriter fw= new FileWriter(new File(path));
		fw.write(str);
		fw.flush();
		fw.close();
		
	}
}
