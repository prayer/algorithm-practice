package com.practice.euler;

import java.math.BigInteger;

/**
 * Find the first term in the Fibonacci sequence to contain 1000 digits
 * Problem webpage: http://projecteuler.net/problem=25
 * 
 * For this problem, we can calculate the number directly by the method in 
 * http://www.mathblog.dk/project-euler-25-fibonacci-sequence-1000-digits/
 */
public class FibonacciNumber {

	
	public static int findNumber(int digitNum) {
		int count = 3;
		
		BigInteger n1 = new BigInteger("1");
		BigInteger n2 = new BigInteger("1");
		BigInteger n3 = new BigInteger("2");
		while (n3.toString().length() < digitNum) {
			n1 = n2;
			n2 = n3;
			n3 = n1.add(n2);
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("The first number's sequence is: " + findNumber(1000));
	}

}
