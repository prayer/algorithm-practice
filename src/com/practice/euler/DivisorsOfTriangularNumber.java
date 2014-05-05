package com.practice.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the value of the first triangle number to have over five hundred divisors
 * Problem webpage: http://projecteuler.net/problem=12
 */
public class DivisorsOfTriangularNumber {
	
	private static int PRIME_COUNT = 2000;
	
	private static List<Integer> generatePrimeList(int primeCount) {
		ArrayList<Integer> primeList = new ArrayList<Integer>(primeCount);
		primeList.add(2);
		primeList.add(3);
		primeCount -= 2;
		int currNum = 3;
		while (0 < primeCount) {
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
				primeCount--;
			}			
		}
		return primeList;
	}
	
	/**
	 * Get the count of divisors for a number
	 * @param num the number
	 * @return count of divisors
	 */
	private static int numOfDivisors_Simple(long num) {
		int count = 0;
		int limit = (int) Math.sqrt(num);
		for (int divisor = 1; divisor <= limit; divisor++) {
			if (num % divisor == 0) {
				count += 2;
			}
		}
		if (limit * limit == num) {
			count--;
		}
		return count;
	}
	
	private static int numOfDivisors_Fast(long num, List<Integer> primeList) {
		int count = 1;
		int limit = (int) Math.sqrt(num);
		
		for (Integer prime : primeList) {
			if (num == 1) {
				//break;
			}
			
			int exp = 0;
			while (num % prime == 0 && num > 1) {
				num = num / prime;
				exp++;
			}
			count = count * (exp + 1);
		}
		
		return count;
	}
	
	
	/**
	 * Find the first triangle number with required count of divisors
	 * @param divisorCount
	 * @return
	 */
	public static long findNumber(int divisorCount) {
		List<Integer> primeList = generatePrimeList(PRIME_COUNT);
		int limit = 500000000;
		for (int i = 1; i <= limit; i++) {
			long num = i * (i+1) / 2;	// a triangle number
			int d = numOfDivisors_Fast(i, primeList) * numOfDivisors_Fast(i+1, primeList);;
			if (d >= divisorCount) {
				return num;
			}
		}
		return -1;
	}

	
	public static void main(String[] args) {
		//List<Integer> primeList = generatePrimeList(PRIME_COUNT);
		// test
		//System.out.println("Divisors count: " + numOfDivisors_Fast(19, primeList));
		System.out.println("Found triangle numbers: " + findNumber(500));
	}

}
