package com.practice.hackerrank.moderate;

import java.util.Scanner;

public class Encryption {
	
	static String encrypt(String sentence) {
		StringBuilder result = new StringBuilder();
		
		int len = sentence.length();
		int cols = (int)(Math.ceil(Math.sqrt(len * 1.0)));
		for (int start = 0; start < cols; start++) {
			for (int i = start; i < len; i += cols) {
				result.append(sentence.charAt(i));
			}
			result.append(" ");
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.next();
		
		String encrypted = encrypt(sentence);
		System.out.println(encrypted);
		
		scanner.close();
	}

}
