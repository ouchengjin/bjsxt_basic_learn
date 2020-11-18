package com.bjsxt.io.byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 文件的拷贝
 * 文件夹的拷贝
 * @ClassName: FileUtil
 * @Description: TODO(描述)
 * @author author
 * @date 2020-03-26 22:14:05
 */
public class FileUtil {
	
	/**
	 * 拷贝文件夹
	 * @param src 源路径
	 * @param dest 目标路径
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String srcPath,String destPath) throws FileNotFoundException, IOException {
		File src = new File(srcPath);
		File dest=new File(destPath);
		
		copyDir(src,dest);
	}
	
	/**
	 * 拷贝文件夹
	 * @param src 源File对象
	 * @param dest 目标File对象
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src,File dest) throws FileNotFoundException, IOException {
		if(src.isDirectory()) {//文件夹
			dest = new File(dest,src.getName());
//			if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
//				System.out.println("不能将父文件夹拷贝到子文件夹中");
//				return ;
//			}
			
		}
		copyDirDetial(src ,dest);
	}
	
	/**
	 * 拷贝文件夹细节
	 * @Title: copyDir
	 * @Description: TODO(描述)
	 * @param src
	 * @param dest
	 * @author author
	 * @throws IOException 
	 * @date 2020-03-26 23:15:19
	 */
	public static void copyDirDetial(File src,File dest) throws FileNotFoundException, IOException {
		if(src.isFile()) {//文件
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
//				e.printStackTrace();
				throw e;
			} catch (IOException e) {
// 				e.printStackTrace();
 				throw e;
			}
		}else if (src.isDirectory()) {
			//确保目标文件夹存在
			dest.mkdirs();
			//获取下一级目录|文件
			for(File sub:src.listFiles()) {
				copyDirDetial(sub, new File(dest,sub.getName()));
			}
		}
	}


	/**
	 * 文件的拷贝
	 * @param 源文件路径
	 * @param 目标文件路径
	 * @throws IOException
	 */
	public static void copyFile(String srcPath,String destPath) throws FileNotFoundException, IOException  {
		//1、建立联系 源（存在且为文件）+目的地（文件可以不存在）
		copyFile(new File(srcPath), new File(destPath));
		
	}
	
	/**
	 * 文件的拷贝
	 * @param 源文件File对象
	 * @param 目标文件File对象
	 * @throws IOException
	 */
	public static void copyFile(File srcPath,File destPath) throws FileNotFoundException, IOException  {
		if(!srcPath.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		
		//若dest为已经存在的文件夹，不能建立与文件夹同名的文件
		if(destPath.isDirectory()) {
			System.out.println(destPath.getAbsolutePath()+"不能建立与文件夹同名的文件");
			throw new IOException(destPath.getAbsolutePath()+"不能建立与文件夹同名的文件");
		}
		//2.选择流
		InputStream is = new BufferedInputStream(new FileInputStream(srcPath));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath));
		//3文件的拷贝，循环+读取+写出
		byte[] flush= new byte[1024];
		int len = 0;
		//读取
		while(-1!=(len = is.read(flush))) {
			//写出
			os.write(flush, 0, len);
		}
		os.flush();//强制刷出
		//关闭流，一般先打开的后关闭
		os.close();
		is.close();
	}
}
