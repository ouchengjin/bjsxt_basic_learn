package com.bjsxt.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 加载文件系统中加密后的class字节码的类加载器
 * @ClassName: DecrptClassLoader
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-26 23:15:25
 */
public class DecrptClassLoader extends ClassLoader{
	//com.bjsxt.test.User  -->D:/mycode/myjava/com/bjsxt/test/User
	private String rootDir;

	public DecrptClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);
		//先查询有没有加载过这个类，如果已经加载则直接返回加载好的类。如果没有则加载新的类
		if(c!=null) {
			return c;
		}else {
			ClassLoader parent=this.getParent();
			try {
				c = parent.loadClass(name);//委派给父类加载
			} catch (Exception e) {
//				e.printStackTrace();
			}
			if(c!=null) {
				return c;
			}else {
				byte[] classData= getClassData(name);
				if(classData==null) {
					throw new ClassNotFoundException();
				}else {
					c=defineClass(name, classData,0,classData.length);
				}
			}
		}
		return c;
	}
	
	private byte[] getClassData(String className) {//com.bjsxt.test.User  -->D:/mycode/myjava/com/bjsxt/test/User
	
		String path =rootDir+"/"+className.replace(".", "/")+".class";
		//apache中的IOUtils可以将流中的数据转化为字节数组
		InputStream fis=null;
		ByteArrayOutputStream bos =null;
		try {
			fis= new FileInputStream(path);
			bos = new ByteArrayOutputStream();
			
			int content = -1;
			while((content=fis.read())!=-1) {
				bos.write(content^0xff);//取反操作
			}
			return bos.toByteArray();
			
		} catch (Exception e) {
			return null;
		}finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (bos != null) {
					bos.close();
				} 
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	
		
	}
	
	
}
