package com.practice.hackerrank.easy;

import java.util.Scanner;

public class HalloweenParty {

	static long solve(long k) {
		if (k % 2 == 0) {
			return k * k / 2;
		} else {
			return (k / 2) * (k / 2 + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		while (0 < total--) {
			int k = scanner.nextInt();
			System.out.println(solve(k));
		}
		scanner.close();
	}
}
