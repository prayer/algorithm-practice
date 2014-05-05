package com.practice.euler;

/**
 * Problem webpage: http://projecteuler.net/problem=6
 */
public class SumSquareDifference {
	
	public static final int MAX = 100;
	
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i < MAX; i++) {
			for (int j = i+1; j <= MAX; j++) {
				sum += i * j;
			}
		}
		System.out.println(2 * sum);
	}

}
