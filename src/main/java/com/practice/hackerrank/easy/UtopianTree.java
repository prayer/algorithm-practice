package com.practice.hackerrank.easy;

import java.util.Scanner;

public class UtopianTree {

	static int height(int cycles) {
		int years = cycles / 2;
		int reminder = cycles % 2;
		
		int length = 1;
		for (int i = 0; i < years; i++) {
			length = 2 * length + 1;
		}
		
		if (reminder == 1) {
			length *= 2;
		}
		return length;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		while (0 < total--) {
			int cycles = scanner.nextInt();
			System.out.println(height(cycles));
		}	
		
		scanner.close();
	}

}
