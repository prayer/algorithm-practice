package com.practice.euler;

/**
 * Find the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed
 * Problem webpage: http://projecteuler.net/problem=28
 */
public class NumberSpiralDiagonals {
	
	/**
	 * This is to calculate the diagonal sum for the 2k+1 level spiral
	 * @param k
	 * @return
	 */
	public static int fomula(int k) {
		return 16*k*k + 4*k + 4;
	}
	
	/*
	 * This is simple, so we just calculate the result by fomula
	 */
	public static void main(String[] args) {
		int sum = 0;
		int level = 500; // 2k+1 = 1001
		for (int k = 1; k <= level; k++) {
			sum += fomula(k);
		}
		sum += 1;
		
		System.out.println(sum);
	}

}
