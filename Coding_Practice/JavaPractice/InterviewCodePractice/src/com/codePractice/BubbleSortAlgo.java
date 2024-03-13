package com.codePractice;

import java.util.Arrays;

public class BubbleSortAlgo {

	public static void main(String[] args) {
		
		int a[] = {2,4,6,1,7,0,9,3,8,5};
		
		System.out.println("Array Before Sorting :: " +Arrays.toString(a));
		
		letsDoBubbleSort(a);
		
		System.out.println("Array After Sorting :: " +Arrays.toString(a));
	}

	private static void letsDoBubbleSort(int[] a) {
		
		int n = a.length;
		
		for(int i=0; i<n-1; i++) //Number Of Passes
		{
			for(int j=0; j<n-1; j++) //Iteration in each pass
			{
				if(a[j]>a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}	
	}
}

