package com.codePractice.defaultt;

public class FifthMaxElement {
	  	public static void main(String[] args) {
	        int[] arr = { 3, 7, 2, 8, 4, 5, 1, 6, 9 }; 
	        int fifthMax = findFifthMax(arr);
	        System.out.println("The 5th maximum element is " + fifthMax);
	    }

	    public static int findFifthMax(int[] arr) {
	        if (arr == null || arr.length < 5) {
	            throw new IllegalArgumentException("Array must have at least 5 elements");
	        }

	        int max1 = Integer.MIN_VALUE;
	        int max2 = Integer.MIN_VALUE;
	        int max3 = Integer.MIN_VALUE;
	        int max4 = Integer.MIN_VALUE;
	        int max5 = Integer.MIN_VALUE;

	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] > max1) {
	                max5 = max4;
	                max4 = max3;
	                max3 = max2;
	                max2 = max1;
	                max1 = arr[i];
	            } else if (arr[i] > max2 && arr[i] != max1) {
	                max5 = max4;
	                max4 = max3;
	                max3 = max2;
	                max2 = arr[i];
	            } else if (arr[i] > max3 && arr[i] != max1 && arr[i] != max2) {
	                max5 = max4;
	                max4 = max3;
	                max3 = arr[i];
	            } else if (arr[i] > max4 && arr[i] != max1 && arr[i] != max2 && arr[i] != max3) {
	                max5 = max4;
	                max4 = arr[i];
	            } else if (arr[i] > max5 && arr[i] != max1 && arr[i] != max2 && arr[i] != max3 && arr[i] != max4) {
	                max5 = arr[i];
	            }
	        }

	        return max5;
	    }
	}
