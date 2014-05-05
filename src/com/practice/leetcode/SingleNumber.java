package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/single-number/
 *
 */
public class SingleNumber {

	/**
	 * A solution without using extra space, using XOR operator
	 * @param A
	 * @return
	 */
	public static int singleNumber(int[] A) {
		int num = 0;
		for (int i : A) {
			num ^= i;
		}
		return num;
    }
	
	public static void main(String[] args) {
		
	}
}
