package com.practice.euler;

/**
 * Problem webpage: http://projecteuler.net/problem=15
 */
public class LatticePaths {

	/**
	 * Find the count of all possible paths in a size*size grid 
	 * @param size
	 * @return
	 */
	public static long pathCount(int size) {
		long[][] grid = new long[size+1][size+1];
		for (int i = 0; i <= size; i++) {
			grid[i][0] = 1;
			grid[0][i] = 1;
		}
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}
		
		return grid[size][size];
	}
	
	public static void main(String[] args) {
		System.out.println("Path count: " + pathCount(20));
	}

}
