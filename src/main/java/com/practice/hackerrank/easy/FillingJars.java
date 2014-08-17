package com.practice.hackerrank.easy;

import java.util.Scanner;

public class FillingJars {

	static long solve(int i, int j, int k) {
		return k * (j - i + 1);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int jars = scanner.nextInt();
		long candies = 0;
		int total = scanner.nextInt();
		while (0 < total--) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			int k = scanner.nextInt();
			candies += solve(i, j, k);
		}
		System.out.println(candies / jars);
		scanner.close();
	}

}
