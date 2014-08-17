package com.practice.codechef.easy;

import java.util.Scanner;

/**
 * These are for the program practices on codechef: http://www.codechef.com/problems/easy
 * All the classes is named by the "program code" 
 * @author Prayer
 *
 */
public class TEST {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		while (num != 42) {
			System.out.println(num);
			num = input.nextInt();			
		}
		input.close();
	}

}
