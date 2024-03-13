package com.codePractice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataInToTextFile {
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("E:\\DAC\\Practice\\PracticeProjects\\JavaPractice\\InterviewCodePractice\\src\\com\\codePractice\\New Text Document 2.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Selenium With JAVA");
		bw.write("Selenium With Python");
		bw.write("Selenium With C#");
		
		System.out.println("Finished !!");
		
		bw.close();
		
	}
}

