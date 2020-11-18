package com.bjsxt.state;
//已入住状态
public class CheckedInState implements State {

	@Override
	public void handle() {
		System.out.println("入住状态，请勿打扰");

	}

}
