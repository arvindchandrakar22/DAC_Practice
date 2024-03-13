package com.codePractice;

public class Swapping2Numbers {

	public static void main(String[] args) {
		
		int a = 11;
		int b = 22;
		
		System.out.println("Before Swapping :");
		System.out.println("a = "+a+ " & b = "+b);
		
		//LOGIC 1 - Using Third Variable
//		int t = a;
//		a=b;
//		b=t;
		
		//LOGIC 2 - Without Using Third Variable
//		a = a+b;
//		b = a-b;
//		a = a-b;
		
		//LOGIC 3 Using Multiplication (*) and Division (/)
		//here a and b should be non zero value
//		a = a*b;
//		b = a/b;
//		a = a/b;
		
		//LOGIC 4 Using Bitwise XOR (^)
//		a = a^b;
//		b = a^b;
//		a = a^b;
		
		//LOGIC 5 Single Statement
		b = a+b-(a=b);
		
		
		
		System.out.println("After Swapping :");
		System.out.println("a = "+a+ " & b = "+b);
	}
}

