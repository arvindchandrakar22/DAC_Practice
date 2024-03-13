package com.codePractice;

public class CountEvenAndOddDigit {

	public static void main(String[] args) {
		
		int num = 123293794;
		
		int even_count = 0;
		int odd_count = 0;
		
		while(num>0) {
			
			int rem = num%10;
			if(rem%2 == 0)
			{
				even_count++;
			}
			else
			{
				odd_count++;
			}
			
			num = num/10;
		}
		
		System.out.println("Even Count is :: " +even_count);
		System.out.println("Odd Count is :: " +odd_count);
	}
}