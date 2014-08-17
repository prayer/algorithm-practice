package com.practice.euler;

/**
 * Problem webpage: http://projecteuler.net/problem=36
 * 
 */
public class DoubleBasePalindromes {
	
	private static boolean isPalindrome(String numStr) {
		for (int i = 0; i < numStr.length() / 2; i++) {
			if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
				return false;
			}
		}		
		return true;
	}
	
	public static int getSum(int bound) {
		int sum = 0;
		for (int i = 1; i <= bound; i++) {
			if (isPalindrome(String.valueOf(i)) == false) continue;
			if (isPalindrome(Integer.toBinaryString(i)) == false) continue;
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		//System.out.println(Integer.toBinaryString(2));
		System.out.println(getSum(1000000));
	}

}
