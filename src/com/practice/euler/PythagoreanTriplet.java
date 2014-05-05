package com.practice.euler;

import java.util.Arrays;

/**
 * Problem webpage: http://projecteuler.net/problem=9
 */
public class PythagoreanTriplet {
	
	public static final double SQRT2 = Math.sqrt(2);
	
	/*
	 * find the a, b, c which meets the following constraints:
	 * a^2 + b^2 = c^2
	 * a + b + c = bound
	 */
	public static int[] findTriplet(int bound) {
		int[] result = new int[3];
		
		int cMax = bound / 2;
		int cMin = (int) (bound * (SQRT2 - 1));
		for (int c = cMin; c <= cMax; c++) {
			int remains = bound - c; 
			for (int a = 1; a <= remains/2; a++) {
				int b = remains - a;
				if (a * a + b * b == c * c) {
					result[0] = a;
					result[1] = b;
					result[2] = c;
					return result;
				}
			}
		}	
		
		result[0] = -1;
		result[1] = -1;
		result[2] = -1;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Triplet: " + Arrays.toString(findTriplet(1000)));
	}

}
