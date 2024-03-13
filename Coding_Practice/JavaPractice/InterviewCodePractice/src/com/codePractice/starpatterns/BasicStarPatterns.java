package com.codePractice.starpatterns;

public class BasicStarPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//starPattern1();
		//starPattern2();
		//starPattern3();
		//starPattern4();
		//starPattern5();
		//starPattern6();
		//starPattern7();
		//starPattern8();
		//starPattern9();
		//starPattern10();
		//starPattern11(5);
		//starPattern12(5);
		starPattern13(5);
		
	}
	
	private static void starPattern13(int n) {
		// TODO Auto-generated method stub
		
//		    *      
//		  * * *    
//		* * * * *  
//		  * * *    
//		    *
		
		for(int i=0; i<n/2; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(j>=((n-1)/2)-i && j<=((n-1)/2)+i)
				{
					System.out.print("* ");
				}
				else
				System.out.print("  ");
			}
			System.out.println(" ");
		}
		
		for(int i=n/2; i>=0; i--)
		{
			for(int j=0; j<n; j++)
			{
				if(j>=((n-1)/2)-i && j<=((n-1)/2)+i)
				{
					System.out.print("* ");
				}
				else
				System.out.print("  ");
			}
			System.out.println(" ");
		}
		
	}

	private static void starPattern12(int n) {
		// TODO Auto-generated method stub
		
//          *          
//        * * *        
//      * * * * *      
//    * * * * * * *    
//  * * * * * * * * *  
//    * * * * * * *    
//      * * * * *      
//        * * *        
//          *
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<2*n-1; j++)
			{
				if(j>=((2*n-1)/2)-i && j<=((2*n-1)/2)+i)
				{
					System.out.print("* ");
				}
				else
				System.out.print("  ");
			}
			System.out.println(" ");
		}
		
		for(int i=n-2; i>=0; i--)
		{
			for(int j=0; j<2*n-1; j++)
			{
				if(j>=((2*n-1)/2)-i && j<=((2*n-1)/2)+i)
				{
					System.out.print("* ");
				}
				else
				System.out.print("  ");
			}
			System.out.println(" ");
		}
		
	}
	
	private static void starPattern11(int n) {
		// TODO Auto-generated method stub
	
//			 *
//		   * * *
//		 * * * * * 
//	   * * * * * * *
//	 * * * * * * * * *
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<2*n-1; j++)
			{
				if(j>=((2*n-1)/2)-i && j<=((2*n-1)/2)+i)
				{
					System.out.print("* ");
				}
				else
				System.out.print("  ");
			}
			System.out.println(" ");
		}
	}

	private static void starPattern10() {
		// TODO Auto-generated method stub
		
//		  * * * * *   
//		    * * * *   
//		      * * *   
//		        * *   
//		          * 
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=5; j++)
			{
				if(j<i)
				{
					System.out.print("  ");
				}
				else
				System.out.print("* ");
			}
			System.out.println("  ");
		}
	}

	private static void starPattern9() {
		// TODO Auto-generated method stub
		
//		* * * * *   
//		  * * * *   
//		    * * *   
//		      * *   
//		        *
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<i; j++)
			{
				System.out.print("  ");
			}
			for(int k=5; k>=i; k--)
			{
				System.out.print("* ");
			}
			System.out.println("  ");
		}
		
	}

	private static void starPattern8() {
		// TODO Auto-generated method stub
		
//		    *  
//	      * *  
//	    * * *  
//	  * * * *  
//	* * * * *
		
		for(int i=1; i<=5; i++)
		{
			for(int j=5; j>=1; j--)
			{
				if(j>i)
				{
					System.out.print("  ");
				}
				else
				{
					//System.out.print(j+" ");
					System.out.print("* ");
				}
			}
			System.out.println(" ");
		}
	}

	private static void starPattern7() {
		// TODO Auto-generated method stub
		
//		* * * * *  
//		* * * *  
//		* * *  
//		* *  
//		*
		
		for(int i=1; i<=5; i++)
		{
			for(int j=5; j>=i; j--)
			{
				System.out.print("* ");
			}
			System.out.println(" ");
		}
		
	}

	private static void starPattern6() {
		// TODO Auto-generated method stub
		
//		1  
//		2 2  
//		3 3 3  
//		4 4 4 4  
//		5 5 5 5 5
		
		for(int i=1;i<=5;i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(i+" ");
			}
			System.out.println(" ");
		}
	}

	private static void starPattern5() {
		// TODO Auto-generated method stub
		
//		1  
//		0 1  
//		1 0 1  
//		0 1 0 1  
//		1 0 1 0 1
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				if((i+j)%2 == 0)
				{
					System.out.print("1 ");
				}
				else
				{
					System.out.print("0 ");
				}
			}
			System.out.println(" ");
		}
	}

	private static void starPattern4() {
		// TODO Auto-generated method stub
		
//		1 2 3 4  
//		2 3 4 1  
//		3 4 1 2  
//		4 1 2 3
		
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=4; j++)
			{
				int k = i+j-1;
				if(k>4)
				{
					System.out.print(k-4 +" ");
				}
				else
				{
					System.out.print(k +" ");
				}
			}
			System.out.println(" ");
		}
	}

	private static void starPattern3() {
		// TODO Auto-generated method stub
		
//		* * * *  
//		*     *  
//		*     *  
//		* * * *  
		
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=4; j++)
			{
				if(i==1||i==4||j==1||j==4)
				{
					System.out.print("* ");
					//System.out.print(j+" ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
	}

	private static void starPattern2() {
		// TODO Auto-generated method stub
		
//		* 
//		* * 
//		* * * 
//		* * * * 
//		* * * * *
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				//System.out.print(j +" ");
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void starPattern1() {
		// TODO Auto-generated method stub
		
//		* * * * 
//		* * * * 
//
//		* * * *
		
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=4; j++)
			{
				if(i==3)
				{
					break;
				}
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
