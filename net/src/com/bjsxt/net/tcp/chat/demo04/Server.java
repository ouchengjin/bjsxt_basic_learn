package com.bjsxt.net.tcp.chat.demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 创建服务器
 *  写出数据：输出流
 * 读入数据：输入流
 * @ClassName: Server
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-20 21:25:27
 */
public class Server {
	private List<MyChannel> all= new ArrayList<Server.MyChannel>();
	

	public static void main(String[] args) throws IOException {
		new Server().start();

	}
	
	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
		Socket client=server.accept();
		MyChannel channel= new MyChannel(client);
		all.add(channel);//统一管理 
		new Thread(channel).start();//一条道路
		}
	}
	/**
	 * 一个客户端一个道路
	 * 1.输入流
	 * 2.输出流
	 * 3.接收数据
	 * 4.发送数据
	 * @ClassName: MyChannel
	 * @Description: TODO(描述)
	 * @author author
	 * @date 2020-04-23 22:03:27
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis =null;
		private DataOutputStream dos =null;
		private boolean isRunning=true;
		private String name;
		
		
		

		public MyChannel(Socket client) {
			
			try {
				this.dis = new DataInputStream(client.getInputStream());
				this.dos =  new DataOutputStream(client.getOutputStream());
				this.name = dis.readUTF();
				this.send("welcome to chatroom");
				sendOthers(this.name+" come in",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dis,dos);
				all.remove(this);//移除自身
			}
		}
		//读取数据
		private String receive() {
			String msg ="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dis);
				all.remove(this);//移除自身
			}
			
			return msg;
		}

		//发送数据
		private void send(String msg) {
			if(null==msg||msg.equals("")) {
				return;
			}
			try {
				
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dos);
				all.remove(this);//移除自身
			}
		}

		//发送个其他客户端
		public void sendOthers(String msg,boolean system) {
			//是否为私聊
			if(msg.startsWith("@")&&msg.indexOf(":")>-1) {//私聊
				String name=msg.substring(1,msg.indexOf(":"));
				String content=msg.substring(msg.indexOf(":")+1);
				for(MyChannel temp:all) {
					//发送其他客户端

					if(name.equals(temp.name)) {
						temp.send(this.name+"对您悄悄地说："+content);
						
					}

					
					
				}
				
			}else {
				//遍历容器
				for(MyChannel temp:all) {
					if(this==temp) {
						continue;
					}
					//发送其他客户端
					if(null==msg||msg.equals("")) {
						return;
					}
					if(system) {
						temp.send("系统消息："+msg);
					}else {
						
						temp.send(this.name+"对所有人说："+msg);
					}

					
					
				}
			}
			
			
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				sendOthers(this.receive(),false);
			}
			
		}
	
	
}
}
 


