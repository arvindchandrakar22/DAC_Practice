package com.codePractice;

public class CountCharacterOccurance {
	public static void main(String[] args) {
		
		String s = "Java Programing Java Ooops !!";
		int totalcount = s.length();
		int totalcount_afterRemove = s.replace("a", "").length();
		int count = totalcount-totalcount_afterRemove;
		System.out.println("Number Occurance Of 'a' Is :: "+count);
	}
}
