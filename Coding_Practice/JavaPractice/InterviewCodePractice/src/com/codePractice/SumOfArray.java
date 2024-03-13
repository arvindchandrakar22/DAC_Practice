package com.codePractice;

public class SumOfArray {
	public static void main(String[] args) {
		
		int a[] = {5,2,7,9,6};
		int sum = 0;
		
//		for(int i=0; i<=a.length-1; i++)
//		{
//			sum = sum + a[i];
//		}
		
		//Enhanced For Loop
		
		for(int value:a)
		{
			sum = sum+value;
		}
		
		System.out.println("Sum Of Element Of Array Is :: "+sum);
	}
}