package com.bjsxt.zerenlian;
//经理
public class JingLi extends Leader {
	
	public JingLi(String name) {
		super(name);
	}
	
	@Override
	public void doRequest(Request request) {
		if(request.getQingjiaTime()>0&&request.getQingjiaTime()<=10) {
			System.out.println(this.name+"批准了"+request.getName()+"请假"+request.getQingjiaTime()+"天");
			System.out.println("请假理由："+request.getReason());
		}else {
			if(this.nextLeader!=null) {
			System.out.println(this.name+":"+request.getName()+"请假天数大于10天，交给上级审批");
			this.nextLeader.doRequest(request);
			}
		}

	}

}
