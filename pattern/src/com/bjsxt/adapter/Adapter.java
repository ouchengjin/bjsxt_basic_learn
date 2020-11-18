package com.bjsxt.adapter;
/**
 * 实现类
 * 适配器(对象适配器方式，使用了组合的方式，跟被适配对象整合)，相当于转接器
 * @ClassName: Adpater
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-02 21:31:31
 */
public class Adapter implements Target{
	private Adaptee adpatee;//被适配对象整合
	public Adapter() {
		adpatee=new Adaptee();
	}

	@Override
	public void handleReq() {
		adpatee.request();
		
	}

}
