package com.bjsxt.state;
//已预订状态
public class BookedState implements State {

	@Override
	public void handle() {
		System.out.println("房间已预订状态，别人不能订");

	}

}
