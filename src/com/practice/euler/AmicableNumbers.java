package com.practice.euler;

import java.util.Arrays;

/**
 * Problem webpage: http://projecteuler.net/problem=21
 */
public class AmicableNumbers {

	/**
	 * Sum of all the "proper divisors" for a number
	 * @param num
	 * @return
	 */
	public static int getDivisorsSum(int num) {
		int sum = 0;
		int limit = (int) Math.sqrt(num);
		for (int divisor = 1; divisor <= limit; divisor++) {
			if (num % divisor == 0) {
				sum += divisor;
				sum += num / divisor;	// the corresponding divisor for this divisor
			}
		}
		
		if (limit * limit == num) {
			sum -= limit; // duplicated divisor
		}
		sum -= num; // because we want only proper divisors
		return sum;
	}
	
	public static int sumOfAmicableNumbers(int bound) {
		int sum = 0;		
		int[] divisorsSums = new int[bound+1];
		Arrays.fill(divisorsSums, 1);
		
		for (int num = 2; num <= bound; num++) {
			int divisorsSum = 0;
			if (divisorsSums[num] > 1) {
				divisorsSum = divisorsSums[num];
			} else {
				divisorsSum = getDivisorsSum(num);
				divisorsSums[num] = divisorsSum;
			}
			
			if (divisorsSum > bound) continue;
			
			int oppDivisorSum = 0;
			if (divisorsSums[divisorsSum] > 1) {
				oppDivisorSum = divisorsSums[divisorsSum];
			} else {
				oppDivisorSum = getDivisorsSum(divisorsSum);
				divisorsSums[divisorsSum] = oppDivisorSum;
			}			
			
			if (oppDivisorSum == num && (num != divisorsSum)) {
				sum += num;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(getDivisorsSum(25));
		System.out.println("Sum: " + sumOfAmicableNumbers(10000));
	}

}
