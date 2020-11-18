package com.bjsxt.net.tcp.chat.demo04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收线程
 * @ClassName: Receive
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-22 21:58:22
 */
public class Receive implements Runnable {
	//输入流
	private DataInputStream dis =null;
	//线程标识
	private boolean isRunning=true;
	public Receive() {
		// TODO Auto-generated constructor stub
	}

	public Receive(Socket client) {
		try {
			this.dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
	}
	//接收数据
	public String receive() {
		//输入流
		String msg="";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
		return msg;
		
	}

	@Override
	public void run() {
		//线程体
		while(isRunning) {
			System.out.println(receive());
		}

	}

}
