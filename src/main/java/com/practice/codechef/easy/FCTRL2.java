package com.practice.codechef.easy;

import java.math.BigInteger;
import java.util.Scanner;

public class FCTRL2 {
	
	public static void main(String[] args) {
		// Generate all the factorials in BigInteger
		BigInteger[] facts = new BigInteger[101];
		facts[1] = BigInteger.ONE;
		for (int i = 2; i < facts.length; i++) {
			facts[i] = facts[i-1].multiply(BigInteger.valueOf(i));
		}		
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();	// read input count
		while (input.hasNext()) {
			num = input.nextInt();	
			System.out.println(facts[num].toString());
		}
		input.close();

	}
}
