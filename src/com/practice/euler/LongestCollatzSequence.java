package com.practice.euler;

import java.util.Arrays;

/**
 * Find which starting number, under one million, produces the longest chain?
 * Problem webpage: http://projecteuler.net/problem=14
 */
public class LongestCollatzSequence {

	public static int[] longestSequence(int bound) {
		int maxLength = 2;
		int maxLengthNum = 2;
		
		int[] termsCounts = new int[bound];
		Arrays.fill(termsCounts, 1);
		
		for (int num = 2; num <= bound; num++) {
			if (termsCounts[num-1] > 1) {
				continue;
			}
			
			long term = num;
			int count = 1;
			while (term > 1) {
				term = (term % 2 == 0)? term / 2 : term * 3 + 1;
				if ((term-1 < bound) && termsCounts[(int)(term-1)] > 1) {
					count += termsCounts[(int)(term-1)];
					break;
				}
				count++;
			}
			termsCounts[num-1] = count;			
			
			if (count > maxLength) {
				maxLength = count;
				maxLengthNum = num;
			}
		}
		
		return new int[]{maxLength, maxLengthNum};
	}
	
	public static void main(String[] args) {
		System.out.println("Max Length and corresponding number: " + Arrays.toString(longestSequence(1000000)));
	}

}
