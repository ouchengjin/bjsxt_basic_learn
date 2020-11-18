package com.bjsxt.zerenlian;

public class Client {

	public static void main(String[] args) {
		ZuZhang zuZhang = new ZuZhang("王组长");
		JingLi jingLi = new JingLi("李经理");
		FuZongJingLi fuZongJingLi = new FuZongJingLi("丁副总经理");//后来加的
		ZongJingLi zongJingLi = new ZongJingLi("欧总经理");
		//组织责任链对象的关系
		zuZhang.setNextLeader(jingLi);
		jingLi.setNextLeader(fuZongJingLi);
		fuZongJingLi.setNextLeader(zongJingLi);
		//开始请假操作
		zuZhang.doRequest(new Request("小赵", 31, "回美国探亲"));
	}

}
