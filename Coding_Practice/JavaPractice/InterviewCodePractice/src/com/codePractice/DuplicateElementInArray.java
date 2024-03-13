package com.codePractice;

import java.util.HashSet;

public class DuplicateElementInArray {
	public static void main(String[] args) {
	
		String arr[] = {"Java", "C", "C++", "Python", "Java", "C++"};
		
		//Approach 1
		
//		boolean flag = false;
//		
//		for(int i=0; i<arr.length; i++)
//		{
//			for(int j=i+1; j<arr.length; j++)
//			{
//				if(arr[i]==arr[j])
//				{
//					System.out.println("Found Duplicate Element :: "+arr[i]);
//					flag = true;
//				}
//			}
//		}
//		
//		if(flag == false)
//		{
//			System.out.println("There is No Duplicate Value.");
//		}
		
		
		//Approach 2
		
		HashSet<String> langs = new HashSet<String>();
		
		boolean flag = false;
		
		for(String l:arr)
		{
			if(langs.add(l)==false)
			{
				System.out.println("Found Duplicate Element. "+l);
				flag=true;
			}
		}
		if(flag==false)
		{
			System.out.println("Not Found Duplicates");
		}
		
}
}
