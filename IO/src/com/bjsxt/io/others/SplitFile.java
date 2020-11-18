package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.bjsxt.io.util.FileUtil;

public class SplitFile {
	//文件路径
	private String filePath;
	//文件名字
	private String fileName;
	//文件大小
	private long length;
	//文件块数
	private int size;
	//每块文件大小
	private long blockSize;
	//分割后的存放目录
	private String destBlockPath;
	//每块文件名称
	private List<String> blockPath;

	public SplitFile() {
		this.blockPath = new ArrayList<String>();
	}
	public SplitFile(String filePath,String destBlockPath) {
		this(filePath,destBlockPath,1024);
		
	}
	
	public SplitFile(String filePath,String destBlockPath, long blockSize) {
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		this.destBlockPath= destBlockPath;
		init();
	}
	/**
	 * 初始化操作，计算块数，确定文件名 
	 * @Title: init
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-04-05 21:45:34
	 */
	public void init() {
		File src = null;
		//健壮性
		if(null==filePath|| !((src=new File(filePath)).exists()) ) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//文件名
		this.fileName=src.getName();
		
		//计算块数，实际大小，每一块大小
		this.length= src.length();
		//修正每块大小
		if(this.blockSize>length) {
			this.blockSize=length;
		}
		//确定块数
		size= (int)Math.ceil(length*1.0/blockSize);
		//确定文件路径
		initPathName();
	}
	
	private void initPathName() {
		for(int i=0;i<size;i++) {
			blockPath.add(destBlockPath+"/"+fileName+".part"+i);
		}
	}
	/**
	 * 文件的分割
	 * 0)第几块
	 * 1)起始位置
	 * 2)实际大小
	 * @Title: split
	 * @Description: TODO(描述)
	 * @param destPath 分割文件存放目录
	 * @author author
	 * @date 2020-04-05 22:26:06
	 */
	public void split(){
		
		long beginPos=0;//起始点
		long actualBlockSize= blockSize;//实际大小
		//计算所有块的大小位置索引
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				actualBlockSize= length-beginPos;
			}
			splitDetail(i, beginPos, actualBlockSize);
			beginPos+=actualBlockSize;//本次的终端，下一次的起点
		}
		
		
	}
	/**
	 * 文件的分割
	 * 文件的拷贝
	 * @Title: splitDetail
	 * @Description: TODO(描述)
	 * @param idx
	 * @param beginPos
	 * @param actualBlockSize
	 * @author author
	 * @date 2020-04-05 22:40:12
	 */
	public void splitDetail(int idx,long beginPos,long actualBlockSize) {
		//创建源
		File src= new File(this.filePath);//源文件
		File dest= new File(blockPath.get(idx));//目标文件
		//2.选择流
		RandomAccessFile raf=null;//输入流
		BufferedOutputStream bos = null;//输出流
		try {
			raf= new RandomAccessFile(src, "r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
//			读取文件
			raf.seek(beginPos);
			//缓冲区
			byte[] flush= new byte[1024];
//			接收长度
			int len = 0;
			while(-1!=(len=raf.read(flush))) {
				if(actualBlockSize-len>=0) {//查看是足够写出,单个模块剩余量和读取量做字节大小比较
					//写出
					System.out.println(len);
					bos.write(flush, 0, len);
					actualBlockSize-=len;//剩余量
					
				}else {//写出最后一次剩余量
					System.out.println(actualBlockSize+"-------------"+len);
					bos.write(flush, 0, (int) actualBlockSize);
					break;
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			FileUtil.closeAll(bos,raf);
		}
		
	}
	/**
	 * 
	 * @Title: mergeFile
	 * @Description: TODO(描述)
	 * @param destPath
	 * @author author
	 * @date 2020-04-07 22:25:02
	 */
	public void mergeFile(String destPath) {
		//创建源
		File dest = new File(destPath);
		//选择流
		BufferedOutputStream bos= null;//输出流
		SequenceInputStream sis = null;//输入流
		//创建一个容器
		Vector<InputStream> vi = new Vector<InputStream>();

		try {
			for (int i = 0; i < this.blockPath.size(); i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(blockPath.get(i)))));
			}
			bos= new BufferedOutputStream(new FileOutputStream(dest,true));//追加
			sis = new SequenceInputStream(vi.elements());
			//		缓冲区
			byte[] flush = new byte[1024];
			//		接收长度
			int len = 0;
			while (-1 != (len = sis.read(flush))) {
				bos.write(flush, 0, len);
			}
			bos.flush();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			FileUtil.closeAll(sis);
			FileUtil.closeAll(bos);
			
		}
		

	}
	
	/**
	 * 文件合并
	 * @Title: main
	 * @Description: TODO(描述)
	 * @param args
	 * @author author
	 * @date 2020-04-06 20:36:06
	 */
	public void mergeFile1(String destPath) {
		//创建源
		File dest = new File(destPath);
		//选择流
		BufferedInputStream bis = null;
		BufferedOutputStream bos= null;
		try {
			bos= new BufferedOutputStream(new FileOutputStream(dest,true));//追加
			System.out.println(blockPath.get(0));
			for (int i = 0; i < this.blockPath.size();i++) {
				System.out.println(blockPath.get(i)+"da");
				bis = new BufferedInputStream(new FileInputStream(new File(blockPath.get(i))));
//				缓冲区
				byte[] flush= new byte[1024];
//				接收长度
				int len= 0;
				while(-1!=(len=bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
				FileUtil.closeAll(bis);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			FileUtil.closeAll(bos);
		}
		
		
	}

	public static void main(String[] args) {
		SplitFile split= new SplitFile("D:/mycode/cp/03 简历-神州数码-欧成金.docx","D:/mycode/", 2000);//1是字节数
//		System.out.println(split.size);
//		split.split();
		split.mergeFile("D:/mycode/test1.docx");
	}

}
