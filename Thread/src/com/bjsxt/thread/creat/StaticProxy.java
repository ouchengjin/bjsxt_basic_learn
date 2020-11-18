package com.bjsxt.thread.creat;
/**
 * 静态代理设计模式
 * 1.真实角色
 * 2.代理角色：持有真实角色的引用
 * 3.二者要实现相同的接口
 * @ClassName: StaticProxy
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-09 11:17:35
 */
public class StaticProxy {
	public static void main(String[] args) {
		//创建真实角色
		Marry you= new You();
		
		//创建代理角色+真实角色的引用
		Marry wed = new WeddingCompany(you);
		wed.marry();
	}

}
//接口
interface Marry{
	public abstract void marry();
}
//真实角色
 class You implements Marry{
	 @Override
	public void marry() {
		System.out.println("you and liuyifei jiehunle");
		
	}
 }
 //代理角色
 class WeddingCompany implements Marry{

	 private Marry you;
	 public WeddingCompany() {
		// TODO Auto-generated constructor stub
	}
	 
	 
	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}
	



	public Marry getYou() {
		return you;
	}


	public void setYou(Marry you) {
		this.you = you;
	}


	private void before() {
		System.out.println("整理婚房");
	}
	
	private void after() {
		System.out.println("闹洞房");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
		
	}
	 
 }
