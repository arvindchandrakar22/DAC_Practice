package com.codePractice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Variations {
	
	public static void butterfly(int n)
	{
		for (int i=0;i<n/2;i++)  //n=7 0,1,2
		{		
			for(int j=0;j<n;j++)
			{
				if(j<=i||j>=n-i-1) //<=1||6>=5
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		for (int i=n/2;i>=0;i--) // 3,2,1,0
		{
			for(int j=0;j<n;j++)
			{
				if(j<=i||j>=n-i-1) //3<=2||>=4
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public static void butterflyEven(int n)
	{
		for (int i=0;i<n;i++)  //n=7 0,1,2
		{		
			for(int j=0;j<2*n;j++)
			{
				if(j<=i||j>=2*n-i-1) //0<=1||6>=5
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		for (int i=n-1;i>=0;i--) // 3,2,1,0
		{
			for(int j=0;j<2*n;j++)
			{
				if(j<=i||j>=2*n-i-1) //3<=2||>=4
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public static int fib(int n)
	{
		if(n==0||n==1)
		{
			return n;
		}
		else
			return fib(n-1)+fib(n-2);
	}
	
	public static void palindrome(int n)
	{
		int num = 0;
		int q = n;
		while(q>0)
		{
		  num = num*10 + q%10;
		  q = q/10;
		}
		if (num==n)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}
	
	public static void armStrong(int n)
	{
		int num = 0; // 174 
		int q = n;
		int p = 0;
		
		while(q>0)
		{
		  p++;
		  q = q/10;
		}
		q=n;
		while(q>0)
		{
		  int k = 1;
		  for(int i=0;i<p;i++)
			  k = k*(q%10);
		  num = num + k; 
		  q = q/10;
		}
		if (num==n)
			System.out.println("Armstrong");
		else
			System.out.println("Not Armstrong");
	}
	
	public static void pyramid(int n)
	{
		for (int i=0;i<n;i++)
		{
			for(int j=0;j<2*n-1;j++)
			{
				if(j>=(2*n-1)/2-i&&j<=(2*n-1)/2+i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public static void missingNo()
	{
		int a[] = {1,2,4,5,6,7,8};
		int x=15,y=6,z=7;
		
//		System.out.println(x>y?(x>z?x:z):(y>z?y:z));
		for(int i=0;i<a.length-1;i++)
		{
			if(a[0]!=1)
			{
				System.out.println(1);
				return;
			}
			if(a[i]!=a[i+1]-1)
			{
				System.out.println(a[i]+1);
				return;
			}
		}
	}
	
	public static void swap(int a,int b)
	{
//		a = a+b;
//		b = a-b;
//		a = a-b;
//		System.out.println(a+","+b);
		
//		a = a*b;
//		b = a/b;
//		a = a/b;
//		System.out.println(a+","+b);
		
		a = a^b; //1100 0011
		b = a^b; //1111 1100
		a = a^b; //0011 1100
		System.out.println(a+","+b);
	}
	
	public static void binarySearch(int n,int... a)
	{
		int first=0;
		int last=a.length-1;
				
		while(first<=last)
		{
			int mid = (first+last)/2;
			if(n==a[mid])
			{
				System.out.println(mid);
				return;
			}
			else if(n<a[mid])
			{
				last = mid-1;
			}
			else if(n>a[mid])
			{
				first = mid+1;
			}
		}
		System.out.println("not found");
	}
		
	public static void bubbleSort(int... a)
	{
		boolean flag = true;
		while(flag)
		{
			flag = false;
			for(int i=0;i<a.length-1;i++)
			{
				if(a[i]>a[i+1])
				{
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
					flag = true;
				}
			}
		}
		for(int i:a)
		{
			System.out.print(i+",");
		}
	}
	
	public static void reverseString(String str) 
	{
		String rev = "";
		for(int i=str.length()-1;i>=0;i--)
			rev += str.charAt(i);
		
		System.out.println(rev);
	}
	
	public static void reversebyWord(String str) 
	{
		String s[] = str.split(" ");
		String r[] = new String[s.length];
		String rev = "";
		
		for(int i=0;i<s.length;i++)
		{
			r[i]="";
			for(int j=s[i].length()-1;j>=0;j--)
				r[i] += s[i].charAt(j);
			rev = rev+r[i]+" ";
		}
				
		System.out.println(rev);
	}
	
	public static void countRepeatChar(String str)
	{
		char s[] = str.toCharArray();
		
		for(int i=0;i<s.length;i++)
		{
			if(s[i]!=' '&&s[i]!='0')
			{
				int count = 1;
				for(int j=0;j<s.length;j++)
				{
					if(i!=j&&s[i]==s[j])
					{
						count++;
						s[j]='0';
					}
				}
				System.out.println("the char "+s[i]+" appeared "+count+" times");
			}
		}
	}
	
	public static void vowels(String str)
	{
		char c[] = str.toLowerCase().toCharArray();
		for(int i=0;i<c.length;i++)
		{
			if(c[i]!=' '||c[i]!='0') //Hello how are you
			{
				if(c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u')
				{
					System.out.print(c[i]);
					for(int j=i;j<c.length;j++)
					{
						if(c[j]==str.toLowerCase().charAt(i))
							c[j]='0';
					}
				}
			}
		}
		System.out.println();
		
//		String vowels = "aeiouAEIOU";
//
//		for (int i = 0; i < str.length(); i++) {
//		    char c = str.charAt(i);
//		    if (vowels.indexOf(c) != -1) {
//		        
//		    	System.out.print(c);
//		        
//		        for(int j=0;j<str.length();j++)
//		        {
//		        	if(str.charAt(i)==str.charAt(j))
//		        		str.charAt(j)='0';
//		        	str.
//		        }
//		    }
//		}
		
	}
	
	public static void countWords(String str)
	{
		int count = 0;
		if(str.length()!=0)
		{
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i)==' '&&str.charAt(i+1)!=' ')
					count++;
			}	
			count++;
		}
		System.out.println("No. of Words : "+count);
	}
	
	public static int findMissingNumber(int... arr) 
	{
	    int n = arr.length;
	    int totalSum = 0;
	    int first = Integer.MAX_VALUE; //my code
	    for (int i = 0; i < n; i++) {
	        totalSum += arr[i];
	        if(arr[i]<first)   //my code
	        	first=arr[i];  //my code
	    }
//	    System.out.println(first);  //my code
//	    int expectedSum = (n+1)*(n+2)/2;  //chatGPT
	    int expectedSum = (n+1)*(2*first+n)/2;  //my code
	    return expectedSum - totalSum;
	}
	
	public static void stringSplit(String s)
	{
		int n = 0;
		if(s.length()!=0)
		{
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)==' '&&s.charAt(i+1)!=' ')
					n++;
			}	
			n++;
		}
		String str[] = new String[n];
		
		int i=0;
	
		for(int j=0;j<str.length;j++)
		{
			str[j]="";
			while(i<s.length())
			{
				if(s.charAt(i)==' '&&s.charAt(i+1)!=' ')
				{
					i++;
					break;
				}
										
				else if(s.charAt(i)!=' ')
					str[j]+=s.charAt(i);
				
				i++;
			}
		}
		
		for(String sc:str)
			System.out.println(sc);
		
	}
	
	public static boolean findElement(int... arr) 
	{
	    boolean flag = false;
	   
	    for(int i=1;i<arr.length-1;i++)  
	    {
	    	for(int j=0;j<arr.length;j++)
	    	{
	    		if(j<i&&arr[i]>arr[j])
	    			flag=true;
	    		
	    		else if(j>i&&arr[i]<arr[j])
	    			flag=true;
	    		
	    		else
	    			flag=false;
	    		
	    	}
	    	if(flag==true)
	    		return flag;
	    }
	    return flag;
	}
	
//	public static boolean repeatNo(int... arr) 
//	{
//		
//	}
	
	public static void main(String... args) 
	{
//		System.out.println(fib(7));
//		palindrome(212); 
//		armStrong(1634);
//		butterfly(7);
//		butterflyEven(5);
//		pyramid(5);
//		missingNo();
//		swap(9,10);
//		binarySearch(5,1,2,3,4,5,6);
//		bubbleSort(5,6,8,4,1,2);
//		int a[] = {5,8,6,2,1,4,3,7};
//		Arrays.sort(a);
//		for(int i:a)
//		System.out.print(i);
//		reverseString("Hello how are you");
//		reversebyWord("Hello how are you");
//		countRepeatChar("Hello how are you");
//		System.out.println(findMissingNumber(5,2,4,3,1));
		vowels("HEllo how are you");
//		countWords("HEllo how are you");
//		stringSplit("Hello how are you");
//		System.out.println(findElement(1,2,3,6,8,5));
	
		InputStreamReader isr;
		OutputStreamWriter osw;
		FileReader fr;
		FileWriter fw;
		ObjectInputStream ois;
		ObjectOutputStream oos;
	}
	

	
}
