package com.practice.euler;

import java.util.Arrays;

/**
 * Problem webpage: http://projecteuler.net/problem=37
 * 
 */
public class TruncatablePrimes {

	/**
	 * @param bound find all the primes below this bound
	 * @return a bit vector to represent if a number is a prime
	 */
	private static boolean[] genPrimes(int bound) {
		boolean[] primes = new boolean[bound+1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		
		for (int num = 2; num <= bound; num++) {
			if (primes[num] == false) continue;	
			int multiple = 2;
			int currNum = num * multiple;
			while (currNum <= bound) {
				primes[currNum] = false;
				currNum = num * (++multiple);
			}
		}		
		return primes;
	}
	
	public static int findPrimes(int bound) {
		boolean[] primes = genPrimes(bound);
		
		int sum = 0;
		for (int num = 11; num <= bound; num++) {
			if (primes[num] == false) continue;
			
			boolean isPrime = true;
			// remove left to right
			int numLen = String.valueOf(num).length();
			int remainder = num;
			for (int i = numLen-1; i > 0; i--) {
				int len = i;
				int base = 1;
				while (len-- > 0) base *= 10;
				remainder = remainder % base;
				if (primes[remainder] == false) {
					isPrime = false;
					break;
				}
			}			
			if (isPrime == false) continue;
			
			// remove right to left
			int left = num / 10;
			while (left > 0) {
				if (left == 1 || primes[left] == false) {
					isPrime = false;
					break;
				}
				left = left / 10;
			}
			if (isPrime == false) continue;
			
			// is truncatable prime
			System.out.println("prime: " + num);
			sum += num;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Sum: " + findPrimes(1000000));
	}

}
