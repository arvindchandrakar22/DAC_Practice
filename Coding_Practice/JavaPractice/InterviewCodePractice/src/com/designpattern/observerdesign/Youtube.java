package com.designpattern.observerdesign;

public class Youtube {

	public static void main(String[] args) {
		
	Channel arch = new Channel();
	
	Subscriber s1 = new Subscriber("Arvind");
	Subscriber s2 = new Subscriber("Arun");
	Subscriber s3 = new Subscriber("Kushagra");
	Subscriber s4 = new Subscriber("Swapnil");
	Subscriber s5 = new Subscriber("Sagar");
	
	arch.subscribe(s1);
	arch.subscribe(s2);
	arch.subscribe(s3);
	arch.subscribe(s4);
	arch.subscribe(s5);
	
	arch.unSubscribe(s3);
	
	s1.subscribeChannel(arch);
	s2.subscribeChannel(arch);
	s3.subscribeChannel(arch);
	s4.subscribeChannel(arch);
	s5.subscribeChannel(arch);
	
	arch.upload("How to learn Programming ??");
	

	}
}
