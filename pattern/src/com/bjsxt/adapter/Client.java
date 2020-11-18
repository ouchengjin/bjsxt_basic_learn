package com.bjsxt.adapter;
/**
 * 客户端类
 * 相当于例子中的笔记本（只有usb接口）
 * @ClassName: Client
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-02 21:28:44
 */
public class Client {

	public void test1(Target t) {
		t.handleReq();
	}
	public static void main(String[] args) {
//		new Client().test1(new Adapter());
		new Client().test1(new Adapter2());
	}
}
