package com.codePractice.defaultt;

public class MissingDigit {

	public static int MissingDigit(String exp) {
		String[] expArr = exp.split(" ");

		String firstOperand = expArr[0];
		String operator = expArr[1];
		String secondOperand = expArr[2];
		String resultant = expArr[4];

		int res = 0;
		String x = "";

		if (resultant.contains("x")) {
		x = resultant;
		firstOperand = expArr[0];
		secondOperand = expArr[2];

		int first = Integer.parseInt(firstOperand);
		int second = Integer.parseInt(secondOperand);

		if (operator.equals("+")) {
			res = first + second;
		} else if (operator.equals("-")) {
			res = first - second;
		} else if (operator.equals("*")) {
			res = first * second;
		} else {
			res = first / second;
		}
		} else {
		resultant = expArr[4];
		int result = Integer.parseInt(resultant);

		if (firstOperand.contains("x")) {
			x = firstOperand;
			secondOperand = expArr[2];
			int second = Integer.parseInt(secondOperand);

			if (operator.equals("+")) {
			res = result - second;
			} else if (operator.equals("-")) {
			res = result + second;
			} else if (operator.equals("*")) {
			res = result / second;
			} else {
			res = result * second;
			}
		} else {
			x = secondOperand;
			firstOperand = expArr[0];
			int first = Integer.parseInt(firstOperand);

			if (operator.equals("+")) {
			res = result - first;
			} else if (operator.equals("-")) {
			res = first - result;
			} else if (operator.equals("*")) {
			res = result / first;
			} else {
			res = first / result;
			}
		}
		}

		String resStr = String.valueOf(res);
		int k = 0;
		for (int i = 0; i < x.length(); i++) {
		if (x.charAt(i) == 'x') {
			return Character.getNumericValue(resStr.charAt(k));
		} else {
			k++;
		}
		}

		return 0;
	}

	public static void main(String[] args) {
		String exp = "18x1 + 9 = 189x";
		System.out.println(MissingDigit(exp));
	}

}
