package com.practice.euler;

import java.util.LinkedList;

/**
 * Get the sum of all the primes less than 2,000,000
 * Problem webpage: http://projecteuler.net/problem=10
 */
public class SummationOfPrimes {

	public static long sum(int bound) {
		long sum = 2 + 3;
		int limitOverall = (int) Math.sqrt(bound);
		// Generate prime list
		LinkedList<Integer> primeList = new LinkedList<Integer>();
		primeList.add(2);
		primeList.add(3);
		int currNum = 3; 
		while (currNum <= (bound - 2)) {
			currNum += 2;
			int limit = (int) Math.sqrt(currNum);
			boolean isPrime = true;
			for (Integer prime : primeList) {
				if (prime <= limit && currNum % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				sum += currNum;
				if (currNum <= limitOverall) {
					primeList.add(currNum);
				}
			}			
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("Sum of all primes: " + sum(5000000));
	}

}
