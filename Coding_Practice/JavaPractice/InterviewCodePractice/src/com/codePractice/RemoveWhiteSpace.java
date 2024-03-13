package com.codePractice;

public class RemoveWhiteSpace {
	
	public static void main(String[] args) {
		
		String str = "Java Programming Selenium   Automation";
		System.out.println("Before Removing The White Space :: "+str);
		str = str.replaceAll("\\s", "");
		System.out.println("After Removing The White Space :: "+str);
		
	}
	
}

