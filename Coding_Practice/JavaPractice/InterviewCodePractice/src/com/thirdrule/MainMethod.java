package com.thirdrule;

class A{
	
	public void show()
	{
		System.out.println("Class A.");
	}
}

class B extends A implements I{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Add method from Interface I.");
	}
	
}

public class MainMethod {

	public static void main(String[] args) {
	
		B obj = new B();
		obj.show();
		obj.add();
	}
	
}
