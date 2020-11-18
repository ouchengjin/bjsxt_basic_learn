package com.bjsxt.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义文件系统类加载器
 * @ClassName: FileSystemClassLoader
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-25 21:50:38
 */
public class FileSystemClassLoader extends ClassLoader{
	//com.bjsxt.test.User  -->D:/mycode/myjava/com/bjsxt/test/User
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
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
			byte[] flush = new byte[10];
			int len = 0;
			while((len=fis.read(flush))!=-1) {
				bos.write(flush, 0, len);
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
