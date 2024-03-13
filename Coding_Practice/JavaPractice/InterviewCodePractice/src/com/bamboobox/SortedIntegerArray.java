package com.bamboobox;

import java.util.Arrays;

public class SortedIntegerArray {
	public static void main(String[] args) {
		
		int arr[] = {23,31,54,76,89,97};
		int newElement = 29;
		int insertIndex = Arrays.binarySearch(arr, newElement);
		
		if(insertIndex < 0)
		{
			insertIndex = -(insertIndex+1);
		}
		
		int[] newArray = new int[arr.length + 1];
		System.arraycopy(arr, 0, newArray, 0, insertIndex);
		System.arraycopy(arr, insertIndex, newArray, insertIndex+1, arr.length-insertIndex);
		newArray[insertIndex] = newElement;
		System.out.println(Arrays.toString(newArray));
		System.out.println("HELLO");

		
	}
}
