package com.codePractice.defaultt;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MissingDigitII {

	 public static String findMissingDigits(String str) {
	        String[] equationParts = str.split(" ");
	        String firstNumber = equationParts[0];
	        String operator = equationParts[1];
	        String secondNumber = equationParts[2];
	        String result = equationParts[4];

	        int missingDigit1 = findMissingDigit(firstNumber);
	        int missingDigit2 = findMissingDigit(result);

	        return missingDigit1 + " " + missingDigit2;
	    }

	    private static int findMissingDigit(String number) {
	        Pattern pattern = Pattern.compile("\\?");
	        Matcher matcher = pattern.matcher(number);
	        if (matcher.find()) {
	            int index = matcher.start();
	            return 9 - (number.length() - index);
	        }
	        return -1; // Return -1 if no missing digit found
	    }

	    public static void main(String[] args) {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	
//	        String input1 = "38?5 * 3 = 1?595";
	    	System.out.println("Enter Input :: ");
	    	String input1 = sc.nextLine();
	        System.out.println(findMissingDigits(input1)); // Output: 6 1

//	        String input2 = "56? * 106 = 5?678";
//	        System.out.println(findMissingDigits(input2)); // Output: 3 9
//
//	        String input3 = "18?1 + 9 = 189?";
//	        System.out.println(findMissingDigits(input3)); // Output: 8 0
	    }
}
