package com.bamboobox;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortStringArray {
	public static void main(String[] args) {
		//String arr[] = {"Banana","Apple","Orange","Pear"};
		String arr[] = {"Put","Strong","On","Novice","Excellent","From"};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr,Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr,Comparator.comparing(String :: length));
		System.out.println(Arrays.toString(arr));
	}

}
