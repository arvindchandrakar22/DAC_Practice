package com.codePractice;

public class ReverseString {

	public static void main(String[] args) {
		
		//LOGIC 1 Using + (String Concatenation) Operator
		String str = "ABCD";
		String rev = "";
		
//		int len = str.length();
//		
//		for(int i=len-1;i>=0;i--)
//		{
//			rev = rev+str.charAt(i);
//		}
//		System.out.println("Reversed String is :: "+rev);
		
		//LOGIC 2 By Using Character Array
//		char a[] = str.toCharArray();
//		int len = a.length;
//		
//		for(int i=len-1; i>=0 ;i--)
//		{
//			rev = rev+a[i];
//		}
//		System.out.println("Reversed String is :: "+rev);
		
		//LOGIC 3 Using Buffer Class
		StringBuffer sb = new StringBuffer(str);
		System.out.println("Reversed String is :: "+sb.reverse());
		
	}
}
