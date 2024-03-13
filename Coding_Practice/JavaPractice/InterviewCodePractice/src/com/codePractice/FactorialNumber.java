package com.codePractice;

//5! = 1*2*3*4*5
public class FactorialNumber {
	public static void main(String[] args) {
		
		int num = 5;
		long factorial = 1;
		
		for(int i=1; i<=num; i++)
		{
			factorial = factorial*i;
		}
		System.out.println("Factorial of a Number is :: "+factorial);
	}
}

