package com.codePractice;


import java.util.Scanner;

public class LargestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1st Number : ");
		int a = sc.nextInt();
		
		System.out.println("Enter 2nd Number : ");
		int b = sc.nextInt();
		
		System.out.println("Enter 3rd Number : ");
		int c = sc.nextInt();
		
		//LOGIC 1
		
//		if(a>b && a>c)
//		{
//			System.out.println(a+ " is Largest Number.");
//		}
//		if(b>a && b>c)
//		{
//			System.out.println(b+ " is Largest Number. ");
//		}
//		else
//		{
//			System.out.println(c+ " is Largest Number. ");
//		}
		
		//LOGIC 2 : Ternary Operator
		
//		int largest1 = a>b?a:b;  //largest of a & b
//		int largest2 = c>largest1?c:largest1; // Largest of c & largest1
		
		int largest = c>(a>b?a:b)?c:(a>b?a:b);
		
		System.out.println(largest +" is Largest Number.");
		
	}
}

