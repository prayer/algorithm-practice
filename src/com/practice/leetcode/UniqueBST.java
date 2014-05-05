package com.practice.leetcode;

/**
 * http://oj.leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBST {

	/**
	 * 1D dynamic programming instead of recursive
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
		if (n < 2) return 1;
		
        int[] table = new int[n+1];	// memorize the number of unique BSTs for each n
        table[0] = 1;
        table[1] = 1;
        
        for (int i = 2; i <= n; i++) {
        	int count = 0;
        	for (int leftNum = 0; leftNum < i; leftNum++) {
        		int rightNum = i - 1 - leftNum;
        		count += table[leftNum] * table[rightNum];
        	}
        	table[i] = count;
        }
        return table[n];        
    }
	
	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

}
