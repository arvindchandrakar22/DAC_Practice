package com.codePractice;

//Natural Number > 1
//Which has only 2 factors 1 and itself

//19 => 1 and 19 => Prime Number
//28 => 1,2,4,7,14,28 => Not a prime number

public class PrimeNumber {

	public static void main(String[] args) {
		int num = 19;
		int count = 0;
		
		if(num>1)
		{
			for(int i=1;i<=num;i++)
			{
				if(num%i == 0)
				{
					count++;
				}
			}
			if(count==2)
			{
				System.out.println("Prime Number");
			}
			else
			{
				System.out.println("Not a PRIME number.");
			}
		}
		else
		{
			System.out.println("Not a PRIME number.");
		}
	}
}

