package com.bjsxt.state;

public class Client {

	public static void main(String[] args) {
		HomeContext homeContext = new HomeContext();
		homeContext.setzhuangtaijiekou(new FreeState());
		homeContext.setzhuangtaijiekou(new BookedState());
		homeContext.setzhuangtaijiekou(new CheckedInState());
	}

}
