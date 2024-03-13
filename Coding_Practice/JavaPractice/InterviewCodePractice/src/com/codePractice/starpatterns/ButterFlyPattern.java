package com.codePractice.starpatterns;

public class ButterFlyPattern {
	public static void main(String args[]) {
	for(int i=0;i<4;i++) {
		for(int j=0;j<=i;j++) {
			System.out.print("* ");
		}
		for(int k=1;k<4-i;k++) {
			System.out.print(" ");
		}
		for(int l=1;l<4-i;l++) {
			System.out.print(" ");
		}
		for(int m=0;m<=i;m++) {
			System.out.print("* ");
		}
		System.out.println();
	}
	for(int i=0;i<=3;i++) {
		for(int j=1;j<4-i;j++) {
			System.out.print("* ");
		}
		for(int k=0;k<=i;k++) {
			System.out.print(" ");
		}
//		for(int l=0;l<=i;l++) {
//			System.out.print(" ");
//		}
//		for(int m=1;m<=4-i;m++) {
//			System.out.print("* ");
//		}
		System.out.println();
	}
		}	
}
