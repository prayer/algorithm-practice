package com.practice.euler;

/**
 * Problem webpage: http://projecteuler.net/problem=30
 * 
 * This is somehow similar to this problem: http://mathworld.wolfram.com/NarcissisticNumber.html
 */
public class DigitFifthPowers {

	public static void main(String[] args) {
		int result = 0;
		 
		for (int i = 2; i < 355000; i++) {	// Maximum is 6*95 = 354294
		    int sumOfPowers = 0;
		    int number = i;
		    while (number > 0) {
		        int d = number % 10;
		        number /= 10;
		 
		        int temp = d;
		        for(int j = 1; j < 5; j++){
		            temp *= d;
		        }
		        sumOfPowers += temp;
		    }
		 
		    if (sumOfPowers == i) {
		    	System.out.println(i);
		        result += i;
		    }
		}
		
		System.out.println("Result: " + result);
	}

}
