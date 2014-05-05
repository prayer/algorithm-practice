package com.practice.euler;

import java.util.LinkedList;

/**
 * @author Prayer
 *
 * Find the largest prime factor of the given number
 * Problem webpage: http://projecteuler.net/problem=3
 */
public class LargestPrimeFactor {

	public static long getLargestPrimeFactor(long num) {
		int maxFactor = 2;
		int maxPrime = (int) Math.sqrt(num);
		
		// Generate prime list
		LinkedList<Integer> primeList = new LinkedList<Integer>();
		primeList.add(2);
		primeList.add(3);
		int currNum = 3; 
		while (currNum < maxPrime) {
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
			}			
		}		
		
		// Find the largest factor
		boolean isPrime = true;
		for (Integer prime : primeList) {
			if (num % prime == 0) {
				maxFactor = prime;
				num = num / prime;
				isPrime = false;
			}
		}
		
		System.out.println("Prime list size: " + primeList.size());
		return isPrime? num : maxFactor;
	}
	
	public static long getLargestPrimeFactor_Fast(long num) {
		int maxFactor = 2;
		int maxPrime = (int) Math.sqrt(num);
		
		LinkedList<Integer> primeList = new LinkedList<Integer>();
		primeList.add(2);
		primeList.add(3);
		if (num % 2 == 0) {
			maxFactor = 2;
			num = num / 2;
		}
		if (num % 3 == 0) {
			maxFactor = 3;
			num = num / 3;
		}
		
		int currNum = 3; 
		while (currNum < maxPrime && num > 1) {
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
				if (num % currNum == 0) {
					maxFactor = currNum;
					num = num / currNum;
				}
			}			
		}			
		
		System.out.println("Prime list size: " + primeList.size());
		return (num == 1)? num : maxFactor;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		System.out.println("Largest factor: " + getLargestPrimeFactor_Fast(600851475143L));
		
		long end = System.currentTimeMillis();
		System.out.println("It takes " + (end - start) / 1000 + " seconds");
	}

}
