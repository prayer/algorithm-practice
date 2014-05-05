package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/palindrome-number/
 * 	
 * Judge is a number is palindrome WITHOUT USING EXTRA SPACE
 */
public class PalindromeNumber {

	/**
	 * Reverse a number with O(1) space, 1234 -> 4321
	 * @param x
	 * @return
	 */
	private static int reverseNumber(int x) {
		int newNum = 0;
		while (x > 0) {
			int remainder = x % 10;
			newNum = newNum * 10 + remainder;
			x /= 10;
		}
		return newNum;
	}
	
	public static boolean isPalindrome(int x) {
        return (x == reverseNumber(x));
    }
	
	public static void main(String[] args) {
		System.out.println(reverseNumber(123456));
		System.out.println(reverseNumber(0));
		System.out.println(reverseNumber(1));
	}

}
