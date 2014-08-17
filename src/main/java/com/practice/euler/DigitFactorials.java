package com.practice.euler;

/**
 * Problem webpage: http://projecteuler.net/problem=34
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits
 */
public class DigitFactorials {

	private static int[] factorials = null;
	
	private static int DIGITS = 9;
	
	/**
	 * Generate all the factorials of digit from 1 to n
	 * @param n
	 * @return
	 */
	private static int[] genFactorials(int n) {
		int[] facts = new int[n+1];
		facts[0] = 1; // 0! = 1
		for (int i = 1; i <= n; i++) {
			int base = 1;
			int num = i;
			while (num > 0) {
				base *= num--;
			}
			facts[i] = base;
		}
		return facts;
	}
	
	/**
	 * Check if the sum of the factorial of a number's digits is equal to this number
	 * @param number
	 * @return
	 */
	private static boolean isEqual(int number) {
		if (factorials == null) {
			factorials = genFactorials(DIGITS);
		}
		
		int factSum = 0;
		int originNum = number;
		while (number > 0) {
			int digit = number % 10;
			number /= 10;
			factSum += factorials[digit];
			if (factSum > originNum) {
				return false;
			}
		}
		return (factSum == originNum);
	}
	
	public static long getSum() {
		long result = 0;
		int limit = 2000000; // any number bigger than this is not possible to meet the requirement
		for (int num = 3; num <= limit; num++) {
			if (isEqual(num)) {
				System.out.println("Found: " + num);
				result += num;
			}
		}		
		return result;
	}
	
	public static void main(String[] args) {
		//int[] factorials = genFactorials(9);
		//System.out.println(Arrays.toString(factorials));
		//System.out.println(isEqual(145));
		
		System.out.println("Sum: " + getSum());
	}

}
