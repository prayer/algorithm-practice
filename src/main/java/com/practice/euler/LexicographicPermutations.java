package com.practice.euler;

import java.util.ArrayList;

/**
 * Find the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * Problem webpage: http://projecteuler.net/problem=24
 * 
 */
public class LexicographicPermutations {
	
	private static final int DIGITS_COUNT = 10;
	
	private static long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		
		long base = n;
		while (--n > 0) {
			base *= n;
		}
		return base;
	}
	
	/**
	 * Find the permutation of the digits (0, 1, 2, 3, 4, 5, 6, 7, 8 and 9)
	 * @param seq the sequence of the permutation needed
	 * @return
	 */
	public static String getPermutation(long seq) {
		StringBuilder permutation = new StringBuilder();
		
		ArrayList<Integer> digitList = new ArrayList<Integer>();
		for (int i = 0; i < DIGITS_COUNT; i++) {
			digitList.add(i);
		}
		
		long mod = seq;
		for (int i = DIGITS_COUNT-1; i >= 1; i--) {
			long fact = factorial(i);
			int digitIndex = (int)(mod / fact);	// which digit will be here
			mod = mod % fact; // get the mod for next iteration
			
			if (mod == 0) { // special case, 
				digitIndex--;	// restore to previous one, 
				permutation.append(digitList.get(digitIndex));
				digitList.remove(digitIndex);
				for (int j = digitList.size()-1; j >= 0; j--) { // reverse, because we need the last permutation
					permutation.append(digitList.get(j));
				}
				break;
			}
			
			permutation.append(digitList.get(digitIndex));
			digitList.remove(digitIndex);
		}
		
		return permutation.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getPermutation(1000000));
	}

}
