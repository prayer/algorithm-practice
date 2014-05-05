package com.practice.euler;

/**
 * Find the smallest positive number that is evenly divisible by all of the numbers from 1 to 20
 * Problem webpage: http://projecteuler.net/problem=5
 */
public class SmallestMultiple {
	
	public static final int MAX_NUM = 20;
	
	public static long gcd(long m, long n) {
		if (m < n) {
			long tmp = m;
			m = n;
			n = tmp;
		}
		
		if (n == 0) {
			return m;
		} else {
			return gcd(n, m % n);
		}
	}
	
	public static long lcm(long m, long n) {
		return m * n / gcd(m, n);
	}
	
	public static void main(String[] args) {
		// find the LCM for all the given numbers
		long currNum = 1;
		for (int i = 1; i <= MAX_NUM; i++) {
			currNum = lcm(i, currNum);
			System.out.println(currNum + " " + i);
		}	
		
		System.out.println(currNum);
	}

}
