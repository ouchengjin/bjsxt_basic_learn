package com.bjsxt.adapter;
/**
 * 实现类
 * 适配器（类适配器方式（继承）），相当于转接器
 * @ClassName: Adpater
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-02 21:31:31
 */
public class Adapter2 extends Adaptee implements Target{
	@Override
	public void handleReq() {
		super.request();
		
	}

}
