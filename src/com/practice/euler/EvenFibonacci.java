package com.practice.euler;

/**
 * @author Prayer
 * 
 * Find the sum of the even-valued fibonacci numbers
 * Problem webpage: http://projecteuler.net/problem=2
 */
public class EvenFibonacci {

	public static long sumOfEvenFibonacci(int upperBound) {
		long sum = 0;
		
		int odd1 = 1;
		int odd2 = 1;
		int even = odd1 + odd2;
		while (even < upperBound) {
			sum += even;
			odd1 = odd2 + even;
			odd2 = even + odd1;
			even = odd1 + odd2;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Sum is: " + sumOfEvenFibonacci(4000000));
	}

}
