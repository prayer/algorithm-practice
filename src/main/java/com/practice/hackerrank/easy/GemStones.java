package com.practice.hackerrank.easy;

import java.util.Arrays;
import java.util.Scanner;

public class GemStones {

	public static void main(String[] args) {		
		boolean[] charSet = new boolean[26];
		Arrays.fill(charSet, true);
		
		boolean[] currCharSet = new boolean[26];
		Arrays.fill(currCharSet, false);
		
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		while (0 < total--) {
			String stone = scanner.next();
			for (int i = 0; i < stone.length(); i++) {
				char c = stone.charAt(i);
				currCharSet[c - 'a'] = true;
			}
			for (int i = 0 ; i < 26; i++) {
				charSet[i] = charSet[i] && currCharSet[i];
			}
			Arrays.fill(currCharSet, false);
		}
		scanner.close();
		
		int eleCount = 0;
		for (int i = 0; i < 26; i++) {
			if (charSet[i] == true) eleCount++;
		}
		System.out.println(eleCount);
	}
}
