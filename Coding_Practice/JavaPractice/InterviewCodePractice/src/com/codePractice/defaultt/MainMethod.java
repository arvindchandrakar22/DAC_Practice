package com.codePractice.defaultt;

class A {
	
	int num1,num2,result;
	public void add() {
		result = num1 + num2;
	}
}

class B extends A {
	
	public void sub() {
		result = num1 - num2;
	}
}

class C extends B {
	
	public void mul() {
		result = num1 * num2;
	}
}

class D extends C {
	
	public void div() {
		result = num1 / num2;
	}
}

public class MainMethod {

	public static void main(String[] args) {
		
		D objd = new D();
		objd.num1 = 5;
		objd.num2 = 8;
		
		objd.add();
		System.out.println(objd.result);
		
		objd.sub();
		System.out.println(objd.result);
		
		objd.mul();
		System.out.println(objd.result);
		
		objd.div();
		System.out.println(objd.result);
		
	}
}