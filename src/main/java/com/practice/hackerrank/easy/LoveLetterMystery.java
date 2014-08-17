package com.practice.hackerrank.easy;

import java.util.Scanner;

public class LoveLetterMystery {

	static int operationCount(String word) {
		int len = word.length();
		int count = 0;
		for (int i = 0; i < len / 2; i++) {
			char left = word.charAt(i);
			char right = word.charAt(word.length() - 1 - i);
			count += (Math.abs(left - right));
		}		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		while (0 < total--) {
			String word = scanner.next();
			System.out.println(operationCount(word));
		}
		scanner.close();
	}

}
