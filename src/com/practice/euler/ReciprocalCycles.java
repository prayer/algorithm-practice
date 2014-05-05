package com.practice.euler;

import java.util.Arrays;

/**
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part
 * Problem webpage: http://projecteuler.net/problem=26
 */
public class ReciprocalCycles {

	private static int getRecurCycleLength(int number) {
		int[] remainderPos = new int[number+1];
		Arrays.fill(remainderPos, -1);
		
		int remainder = 1;
		int pos = 0;
		while (remainderPos[remainder] == -1) {
			remainderPos[remainder] = pos++;
			remainder = (remainder * 10) % number;			
		}
		
		return (pos - remainderPos[remainder]);
	}
	
	public static void getMaxCycle(int upperBound) {
		int maxCycleLength = 0;
		int maxCycleNumber = 0;
		
		for (int i = 1; i <= upperBound; i++) {
			int cycleLength = getRecurCycleLength(i);
			if (cycleLength > maxCycleLength) {
				maxCycleLength = cycleLength;
				maxCycleNumber = i;
			}
		}
		
		System.out.println("Max cycle is " + maxCycleLength + " and the corresponding number is: " + maxCycleNumber);
	}
	

	public static void main(String[] args) {
		System.out.println(getRecurCycleLength(7));
		
		getMaxCycle(1000);
	}

}
