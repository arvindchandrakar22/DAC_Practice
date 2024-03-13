package com.codePractice;

import java.util.Scanner;

public class CountTheWord {
	public static void main(String[] args) {
		
		System.out.print("Enter The String :: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = 1;
		
		for(int i=0; i<s.length()-1; i++)
		{
			if((s.charAt(i)==' ')&& (s.charAt(i+1)!=' '))
			{
				count++;
			}
		}
		System.out.println("No Of Words In A String '"+s+"' :: "+count);
	}
}
