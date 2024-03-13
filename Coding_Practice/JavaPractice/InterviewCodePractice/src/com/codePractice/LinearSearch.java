package com.codePractice;

public class LinearSearch {

	public static void main(String[] args) {
		int a[] = {10,20,40,50,30};
		int search_ele = 30;
		boolean flag = false;
		
		for(int i=0; i<a.length; i++)
		{
			//System.out.print(a[i]+" ");
			
			if(search_ele == a[i])
			{
				System.out.println("Element Found At "+i+"th Position");
				flag = true;
				break;
			}
		}
		if(flag==false)
		{
			System.out.println("Element Not Found");
		}
	}
}
