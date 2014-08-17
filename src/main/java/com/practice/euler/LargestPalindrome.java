package com.practice.euler;

/**
 * Find the largest palindrome made from the product of two 3-digit numbers
 * Problem webpage: http://projecteuler.net/problem=4
 */
public class LargestPalindrome {

	private static boolean isPalindrome(int num) {
		String numStr = String.valueOf(num);
		for (int i = 0; i < numStr.length() / 2; i++) {
			if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
				return false;
			}
		}		
		return true;
	}
	
	public static void main(String[] args) {		
		int currMax = 111111;
		for (int num1 = 999; num1 > 99; num1--) {
			for (int num2 = num1; num2 > 99; num2--) {
				int currNum = num1 * num2;
				if (isPalindrome(currNum)) {
					if (currNum > currMax) {
						System.out.println("Found a palindrome: " + currNum + " by " + num1 + " and " + num2);
						currMax = currNum;
					}
				}
			}
		}
		System.out.println("Largest palindrome: " + currMax);
	}

}
