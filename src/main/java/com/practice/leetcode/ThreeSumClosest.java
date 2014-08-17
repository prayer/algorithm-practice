package com.practice.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		int currSum = Integer.MAX_VALUE;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			if (num[i] > target && currSum < Integer.MAX_VALUE) break;
			if (i > 0 && num[i] == num[i - 1]) continue;

			int begin = i + 1;
			int end = num.length - 1;
			while (begin < end) {
				int sum = num[i] + num[begin] + num[end];
				if (Math.abs(sum - target) < minDiff) {
					currSum = sum;
					minDiff = Math.abs(sum - target);
				}				
				
				if (sum < target) {
					begin++;
					while (begin < end && num[begin] == num[begin - 1]) begin++;
				} else {
					end--;
					while (begin < end && num[end] == num[end + 1]) end--;
				}				
			}
		}
		return currSum;
	}

	public static void main(String[] args) {
		int[] num = new int[]{-1, 2, 1, -4};
		System.out.println(new ThreeSumClosest().threeSumClosest(num, 1));
	}

}
