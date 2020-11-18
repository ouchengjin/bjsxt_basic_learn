package com.bjsxt.net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据 线程
 * @ClassName: Send
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-22 21:55:36
 */
public class Send implements Runnable{
	//控制台输入流
	private BufferedReader console=null; 
	//管道输出流
	private DataOutputStream dos =null; 
	//控制线程
	private boolean isRunning = true;
	//初始化
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
		
	}
	public Send(Socket client) {
		this();
		try {
			dos=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	/**
	 * 1.从控制台接收数据
	 * @Title: getMsgFromConsole
	 * @Description: TODO(描述)
	 * @return
	 * @author author
	 * @date 2020-04-22 22:26:24
	 */
	private String getMsgFromConsole() {
		String msg="";
		try {
			msg= console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * 1.从控制台接收数据
	 * 2.发送数据
	 * @Title: send
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-04-22 22:22:54
	 */
	public void send() {
		String msg =getMsgFromConsole();
		try {
			if (null != msg && !msg.equals("")) {
				dos.writeUTF(msg);
				dos.flush();//强制刷新
			} 
		} catch (Exception e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
		
		
		
	}
	
	@Override
	public void run() {
		//线程体
		while(isRunning) {
			send();
		}
	}



}
