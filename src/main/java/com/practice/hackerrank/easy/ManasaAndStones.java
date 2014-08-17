package com.practice.hackerrank.easy;

import java.util.Scanner;

public class ManasaAndStones {

	static String solve(int n, int a, int b) {
		if (a > b) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		StringBuilder result = new StringBuilder();
		long lastNum = a * (n - 1);
		result.append(lastNum);
		if (a == b) return result.toString();
		
		for (int i = 1; i < n; i++) {
			lastNum += (b - a);
			result.append(" ").append(lastNum);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		while (0 < total--) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(solve(n, a, b));
		}
		scanner.close();
	}

}
