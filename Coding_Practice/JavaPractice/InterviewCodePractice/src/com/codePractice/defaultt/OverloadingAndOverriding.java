package com.codePractice.defaultt;

public class OverloadingAndOverriding {
	public static void main(String[] args) {
		
		Aaa a = new Aaa();
		System.out.println("Using Aaa Object.");
		int result1 = a.add(4,5);
		System.out.println(result1);
		
		
		Bbb b = new Bbb();
		System.out.println("Using Bbb Object.");
		int result2 = b.add(7, 9);
		System.out.println(result2);
		float result3 = b.add(5.7f, 3.9f);
		System.out.println(result3);
		
	}

}

class Aaa {
	public int add(int a, int b) {
		int x;
		System.out.println("Result form Class A");
		return x = a+b;
	}
}

class Bbb extends Aaa {
	
	public float add(float a, float b) {
		float x;
		System.out.println("Result form Class B");
		return x = a+b;
		
	}
}
