package com.codePractice;

public class CheckArraysEquals2 {
	public static void main(String[] args) {
		
		int a1[] = {4,1,2,5,5};
		int a2[] = {1,2,5,5,4};
		
		int count = 0;
		
		if(a1.length == a2.length)
		{
			for(int i=0;i<a1.length;i++)
			{
				for(int j=0;j<a1.length;j++)
				{
					if(a1[i]==a2[j])
					{
						count++;
						break;
					}
				}
			}
		}
		
		if(count == a1.length)
		{
			System.out.println("Arrays are EQUAL.");
		}
		else
		{
			System.out.println("Arrays are not EQUAL.");
		}
	}
}
