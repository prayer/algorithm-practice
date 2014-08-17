package com.practice.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem webpage: http://projecteuler.net/problem=35
 * 
 * Use another way to generate primes
 */
public class CircularPrimes {

	/**
	 * @param bound find all the primes below this bound
	 * @return a bit vector to represent if a number is a prime
	 */
	private static boolean[] genPrimes(int bound) {
		boolean[] primes = new boolean[bound+1];
		Arrays.fill(primes, true);
		
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
	
	private static List<Integer> getPrimes(boolean[] primes) {
		List<Integer> primeList = new ArrayList<Integer>();
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] == true) {
				primeList.add(i);
			}
		}
		return primeList;
	}
	
	/**
	 * Generate all the rotations for a number
	 * For example: 123 --> 312 --> 231
	 * @param number
	 * @return
	 */
	private static int[] getShifts(int number) {
		if (number < 10) return new int[]{};
		
		// Get digits count
		int tempNum = number;
		int count = 0;
		while (tempNum > 0) {
			tempNum = tempNum / 10;
			count++;
		}
		
		int base = 1;
		for (int i = 0; i < count-1; i++) {
			base *= 10;
		}
		
		// Get shifts
		int[] shifts = new int[count-1];
		int currNum = number;
		for (int i = 0; i < count-1; i++) {
			int remainder = currNum % 10;
			int left = currNum / 10;
			currNum = remainder * base + left;
			shifts[i] = currNum;
		}		
		return shifts;
	}
	
	/**
	 * Count how many circular primes are there below the bound
	 * @param bound
	 * @return
	 */
	public static int countPrimes(int bound) {
		int count = 4;	// 2, 3, 5, 7
		boolean[] primes = genPrimes(bound);
		for (int i = 11; i < primes.length; i++) {
			if (primes[i] == true) {
				boolean isPrime = true;
				int[] shifts = getShifts(i);
				for (int shift : shifts) {
					if (primes[shift] == false) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(getPrimes(genPrimes(100)));
		//System.out.println(Arrays.toString(getShifts(971)));
		System.out.println(countPrimes(1000000));
	}

}
