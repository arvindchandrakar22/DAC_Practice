package com.codePractice;

public class ReverseEachWordInAString {
	public static void main(String[] args) {
		
		//Approach 1
//		String str = "Welcome to Java";
//		String[] words = str.split(" "); //Splitting string into words where space occurs
//		
//		String reverseString = "";
//		
//		for(String w:words)
//		{
//			String reversewords="";
//			for(int i=w.length()-1;i>=0;i--)
//			{
//				reversewords = reversewords + w.charAt(i);
//			}
//			
//			reverseString = reverseString+reversewords+" ";
//		}
//		System.out.println(reverseString);
		
		//Approach 2
		String str = "Welcome To Java";
		String[] words = str.split("\\s"); //here "\\s" means space
		
		String reverseword = "";
		
		for(String w:words) //Welcome
		{
			StringBuilder sb = new StringBuilder(w);
			sb.reverse();  //emocleW
			
			reverseword = reverseword + sb.toString() + " ";
		}
		
		System.out.println(reverseword);
	}
}