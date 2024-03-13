package com.designpattern.singleton;

public class Singleton {

	public static void main(String[] args) {
		
		SingletonPrac sp1 = SingletonPrac.getIntance();
		SingletonPrac sp2 = SingletonPrac.getIntance();
		
		System.out.println(sp1==sp2);
//		sp.display();
	}
	
}

class SingletonPrac {
	
	private int a;
	private int b;
	
	private SingletonPrac() {
		this.a=10;
		this.b=20;
	}
	
	private static SingletonPrac sp = null;
	
	public static SingletonPrac getIntance() {
		
//		sp = new SingletonPrac();
//		return sp;
		
		if(sp==null)
		{
			sp = new SingletonPrac();
			return sp;
		}
		else
			return sp;
	}
	
	public void display() {
		System.out.println(this.a+" "+this.b);
	}
}
