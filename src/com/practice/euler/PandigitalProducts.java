package com.practice.euler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem webpage: http://projecteuler.net/problem=32
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital
 */
public class PandigitalProducts {

	private static boolean checkDigits(int number, boolean[] digits) {
		while (number > 0) {
			int digit = number % 10;
			number /= 10;
			if (digits[digit] == true) {
				return false; // already exist
			}
			digits[digit] = true;
		}
		return true;
	}
	
	private static boolean isPandigital(int multiplicand, int multiplier, int product) {
		boolean[] digits = new boolean[10]; 
		Arrays.fill(digits, false);
		digits[0] = true;	// only 1 ~ 9 digits
		if (checkDigits(multiplicand, digits) 
				&& checkDigits(multiplier, digits) 
				&& checkDigits(product, digits)) {
			// no duplicated digits, then check if all the digits are set
			for (boolean d : digits) {
				if (d == false) {// missing
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		// for 9 digits, only 1-4-4 and 2-3-4 are the possible structures
		Set<Integer> products = new HashSet<Integer>();
		
		// 1-4-4
		for (int i = 1; i < 10; i++) {
			for (int j = 1111; j < 10000; j++) {
				int prod = i * j;
				if (prod > 9999) continue;
				if (isPandigital(i, j, prod)) {
					System.out.println(i + " " + j + " " + prod);
					products.add(prod);
				}
			}
		}
		
		// 2-3-4
		for (int i = 11; i < 100; i++) {
			for (int j = 111; j < 1000; j++) {
				int prod = i * j;
				if (prod > 9999) continue;
				if (isPandigital(i, j, prod)) {
					System.out.println(i + " " + j + " " + prod);
					products.add(prod);
				}
			}
		}
		
		int sum = 0;
		for (Integer prod : products) {
			sum += prod;
		}
		System.out.println(sum);
	}

}
