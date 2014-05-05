package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/reverse-integer/
 *
 */
public class ReverseInteger {

	public static int reverse(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x *= -1;
		}
		int newNum = 0;
		while (x > 0) {
			int remainder = x % 10;
			newNum = newNum * 10 + remainder;
			x /= 10;
		}
		return (isNegative? -newNum : newNum);    
	}

	public static void main(String[] args) {
		Math.max(2, 3);

	}

}
