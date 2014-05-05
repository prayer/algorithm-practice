package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i])) {
				int left = target - numbers[i];
				map.put(left, i);
				continue;
			}
			int index = map.get(numbers[i]);
			return new int[]{index+1, i+1};
		}
		return new int[2];
    }
	
	public static void main(String[] args) {
		int[] array = new int[]{2, 7, 11, 15};
		int target = 18;
		System.out.println(Arrays.toString(twoSum(array, target)));

	}

}
