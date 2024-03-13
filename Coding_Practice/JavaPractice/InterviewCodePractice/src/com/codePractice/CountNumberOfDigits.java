package com.codePractice;

public class CountNumberOfDigits {
	public static void main(String[] args) {
		
		int num = 123456;
		int org_num = num;
		int count = 0;
		
		while(num>0)
		{
			num = num/10;
			count++;
		}
		
		System.out.println("Number of Digits in Number "+org_num+" is :: " +count);
	}
}

