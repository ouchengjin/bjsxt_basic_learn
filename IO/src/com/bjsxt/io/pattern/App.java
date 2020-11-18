package com.bjsxt.io.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Voice v= new Voice();
		v.say();
		
		Amplifier amp= new Amplifier(v);
		amp.say();
		

	}

}
