package com.bjsxt.zerenlian;
//总经理
public class ZongJingLi extends Leader {
	
	public ZongJingLi(String name) {
		super(name);
	}
	
	@Override
	public void doRequest(Request request) {
		if(request.getQingjiaTime()>20&&request.getQingjiaTime()<=30) {
			System.out.println(this.name+"批准了"+request.getName()+"请假"+request.getQingjiaTime()+"天");
			System.out.println("请假理由："+request.getReason());
		}else {
			System.out.println(this.name+":"+request.getName()+"请假天数大于30天，是不是要离职了");
		}

	}

}
