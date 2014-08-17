package com.practice.euler;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Problem webpage: http://projecteuler.net/problem=20
 */
public class FactorialDigitsSum {

	public static int digitsSum(int n) {
		BigInteger number = new BigInteger(String.valueOf(n));
		//System.out.println(number.toString());
		while (n-- > 1) {
			number = number.multiply(new BigInteger(String.valueOf(n)));
			//System.out.println(number.toString());
		}
		
		int sum = 0;
		String numStr = number.toString();
		for (int i = 0; i < numStr.length(); i++) {
			sum += (numStr.charAt(i) - 48);
		}		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(digitsSum(100));
	}

}
