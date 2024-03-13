package com.codePractice;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void removeDuplicate(HashMap<Integer,String> hm)
	{
		int n = hm.size();
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i!=j && hm.get(i)!=null && hm.get(j)!=null && hm.get(i).compareToIgnoreCase(hm.get(j))==0)
						{
							hm.remove(j);
						}
			}
		}
			
	}
	
	public static void swapString(String s1,String s2)
	{
		
		s1 = s1+s2; // s1=Hello s2=World  s1=HelloWorld
		s2 = s1.substring(0, s1.length()-s2.length()-1);
		s1 = s1.substring(s1.length()-s2.length(), s1.length()-1);
		
		System.out.println(s1);
		System.out.println(s2);
	}
	
	public static void main(String[] args) {
		
		HashMap<Integer,String> hm = new HashMap();
		
		hm.put(1,"One");
		hm.put(2,"Two");
		hm.put(3,"Three");
		hm.put(4,"three");
		hm.put(5,"Four");
		hm.put(6,"five");
		hm.put(7,"four");
		
		removeDuplicate(hm);
		
//		for(Map.Entry<Integer, String> h : hm.entrySet())
//		{
//			System.out.println(h);
//		}
		
		String s1 = "Hello";
		String s2 = "World";
		
		swapString(s1, s2);
		
//		System.out.println(s1);
//		System.out.println(s2);
		
	}
}

