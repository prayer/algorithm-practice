package com.practice.facebook;

import java.util.Scanner;

/**
 * Facebook hiring sample test
 */
public class Practice {

	public static void main(String[] args) {
		// input
		Scanner input = new Scanner(System.in);
		int numCount = input.nextInt();	// read input count
		int[] nums = new int[numCount];
		int pos = 0;
		while (input.hasNext()) {
			nums[pos++] = input.nextInt();
		}
		input.close();
		
		// real job
		int diff = nums[1] - nums[0];
		int i = 2;
		for (; i < nums.length; i++) {
			if ((nums[i] - nums[i-1]) == diff) break;
		}
		if (i == nums.length) {
			System.out.println(nums[0] + diff / 2);
			return;
		}
		
		for (i = 1; i < nums.length; i++) {
			if ((nums[i] - nums[i-1]) != diff) {
				System.out.println(nums[i-1] + diff);
				return;
			}
		}
	}

}
