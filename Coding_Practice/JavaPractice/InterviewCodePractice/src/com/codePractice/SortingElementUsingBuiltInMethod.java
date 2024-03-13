package com.codePractice;

import java.util.Arrays;
import java.util.Collections;

public class SortingElementUsingBuiltInMethod {

	public static void main(String[] args) {
		
		int a[] = {30,10,50,20,60,90};
		
		System.out.println("Array Before Sorting :: "+Arrays.toString(a));
		//approach1(a); //using a method called parallelSort
		//approach2(a); //using Arrays.sort method
		System.out.println("Array After Sorting :: "+Arrays.toString(a));
		Integer a1[] = reverseDescendingOrder();
		System.out.println("Array After Sorting :: "+Arrays.toString(a1));
		
	}

	private static Integer[] reverseDescendingOrder() {
		Integer a1[] = {30,10,50,20,60,90};
		Arrays.sort(a1,Collections.reverseOrder());
		return a1;
	}

	private static void approach1(int a[]) {
		Arrays.parallelSort(a);
	}
	
	private static void approach2(int a[]) {
		Arrays.sort(a);
	}
	
	
}