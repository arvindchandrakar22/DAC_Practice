package com.codePractice;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number :: ");
		int num = sc.nextInt();
		
		//LOGIC 1 Using Algorithm

//		int rev = 0;
//		while(num != 0)
//		{
//			rev = rev*10 + num%10;
//			num = num/10;
//		}
//		System.out.println("Reverse Number Is :: "+rev);
		
		
		//LOGIC 2 Using String Buffer(Thread Safe) Class

//		StringBuffer sb = new StringBuffer(String.valueOf(num));
//		StringBuffer rev = sb.reverse();
//		
//		System.out.println("Reverse Number Is :: "+rev);
		
		//LOGIC 3 Using String Builder(Not a thread safe) class
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		StringBuilder rev= sb.reverse();
		
		System.out.println("Reverse Number Is :: "+rev);
		
	}
	
	
}

