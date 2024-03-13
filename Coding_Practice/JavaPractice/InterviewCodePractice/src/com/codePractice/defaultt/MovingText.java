package com.codePractice.defaultt;

import java.util.Scanner;

public class MovingText{
	
	static String str = "   Hello there";
//	public static int a = 5;
	
	public static void main(String[] args) throws InterruptedException {
	
		int j=0;
		
		while(true)
		{
			for(int i=0;i<20;i++)
				System.out.println();
			
			for(int i=0;i<10;i++)
			{
				System.out.print(str.charAt((i+j)%str.length())); 
			}										
			j++;  
						
			Thread.sleep(1000);
//			System.out.println(a);
		}		
		
	}
	
	public static void addText()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string to add::");
		
		while(true)
		{
			String s = sc.nextLine();
			str = str+" "+s;
			System.out.println(str);
		}
	}
	
//	public static void addInt(int i)
//	{
//		a=i;
//	}
	
    
}
