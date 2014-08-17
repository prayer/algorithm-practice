package com.practice.hackerrank.moderate;

import java.util.Scanner;

public class StockMaximize {

	static int solve(int[] array) {
		int profit = 0;
		int[] maxArr = new int[array.length];
		maxArr[array.length-1] = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			maxArr[i] = Math.max(maxArr[i+1], array[i]);
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			profit += Math.max(0, maxArr[i + 1] - array[i]);
		}
		return profit;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		while (0 < total--) {
			int len = scanner.nextInt();
			int[] array = new int[len];
			for (int i = 0; i < len; i++) {
                array[i] = scanner.nextInt();
            }
			System.out.println(solve(array));
		}
		scanner.close();
	}

}
