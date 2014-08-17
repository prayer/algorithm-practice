package com.practice.euler;

import java.util.LinkedList;

/**
 * Problem webpage: http://projecteuler.net/problem=7
 */

public class NthPrime {
	
	public static long getNthPrime(int n) {
		if (n == 1) return 2;
		if (n == 2) return 3;
		n -= 2;
		// Generate prime list
		LinkedList<Integer> primeList = new LinkedList<Integer>();
		primeList.add(2);
		primeList.add(3);
		int currNum = 3; 
		while (n > 0) {
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
				primeList.add(currNum);
				n--;
			}			
		}
		return primeList.getLast();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Prime: " + getNthPrime(10001));
	}

}
