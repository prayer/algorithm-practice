package com.practice.hackerrank.easy;

import java.util.Scanner;

public class SolveMeFirst {

	public static int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int result = add(num1, num2);
		System.out.println(result);
		scanner.close();
	}

}
