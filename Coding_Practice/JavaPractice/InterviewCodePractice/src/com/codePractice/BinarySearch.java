package com.codePractice;

//for binary search array should be sorted

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		
		binarySearchAlgo(a);
		binarySearchUsingInbuildMethods(a);
		
	}
	
	public static void binarySearchUsingInbuildMethods(int[] a)
	{
		//here we will use Arrays.binarySearch()
		
		System.out.println(Arrays.binarySearch(a, 5));
		
	}

	public static void binarySearchAlgo(int a[])
	{
		boolean flag = false;
		
		int key = 5;
		
		int l = 0;
		int h = a.length-1;
		
		while(l<=h)
		{
			int m = (l+h)/2; //finding mid value here
			
			if(a[m] == key)
			{
				System.out.println("Element Found...");
				flag = true;
				break;
			}
			
			if(a[m]<key)
			{
				l = m+1;
			}
			
			if(a[m]>key)
			{
				h = m-1;
			}
			
			if(flag == false)
			{
				System.out.println("Element NOT Found !!");
			}
		}
		
		
	}
}

