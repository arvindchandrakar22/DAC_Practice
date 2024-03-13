package com.codePractice;

public class EvenOddFromArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		
//		//Extracting Even Numbers ....
//		System.out.println("Even Numbers Are : ");
//		for(int i=0; i<a.length; i++)
//		{
//			if(a[i]%2 == 0)
//				System.out.println(a[i]);
//		}
//		
//		//Extracting Odd Numbers ....
//		System.out.println("Odd Numbers Are : ");
//		for(int i=0; i<a.length; i++)
//		{
//			if(a[i]%2 != 0)
//				System.out.println(a[i]);
//		}
		
		//Using Enhanced For Loop
		System.out.println("Even Numbers Are : ");
		for(int value:a)
		{
			if(value%2==0)
			{
				System.out.println(value);
			}
		}
		
		//Using Enhanced For Loop
		System.out.println("Odd Numbers Are : ");
		for(int value:a)
		{
			if(value%2 != 0)
			{
				System.out.println(value);
			}
		}
	}
}
