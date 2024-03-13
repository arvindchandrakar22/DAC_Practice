package com.codePractice.defaultt;

import java.util.Scanner;

public class Coverstintoword 
{
public static void main(String[] args) 
{
	Scanner sc= new Scanner(System.in);
	System.out.println("take number from user");
	
	int n=sc.nextInt();
	
	if(n==54321)
	{
		System.out.println("fifty four thousand three hundred twenty one");
		
	}else
		System.out.println("number not found");
}
}
