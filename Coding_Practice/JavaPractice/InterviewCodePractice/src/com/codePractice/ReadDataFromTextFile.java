package com.codePractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataFromTextFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Approach 1 : Using File Reader
		
//		FileReader fr = new FileReader("E:\\DAC\\Practice\\PracticeProjects\\JavaPractice\\InterviewCodePractice\\src\\com\\codePractice\\New Text Document.txt");
//		BufferedReader br = new BufferedReader(fr);
//		
//		String str;
//		
//		while((str = br.readLine()) != null)
//		{
//			System.out.println(str);
//		}
//		br.close();
		
		//Approach 2 : Using Scanner & File
		
		File file = new File("E:\\DAC\\Practice\\PracticeProjects\\JavaPractice\\InterviewCodePractice\\src\\com\\codePractice\\New Text Document.txt");
		Scanner sc = new Scanner(file);
		
//		while(sc.hasNextLine())
//		{
//			System.out.println(sc.nextLine());
//		}
		
		//Approach 3 : Use Delimeter
		
		sc.useDelimiter("\\z");
		System.out.println(sc.next());
	}

}
