package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * http://oj.leetcode.com/problems/3sum/
 */
public class ThreeSum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 if (num.length < 3) return result;
		 
		 Arrays.sort(num);
		 System.out.println(Arrays.toString(num));
		 for (int i = 0; i < num.length-2; i++) {
			 if (num[i] > 0) break;
			 if (i > 0 && num[i] == num[i-1]) continue;
			 
			 int target = 0 - num[i];
			 int begin = i + 1;
			 int end = num.length - 1;
			 while (begin < end && (num[i] + num[begin]) <= 0) {
				 if ((num[begin] + num[end]) == target) {
					 ArrayList<Integer> triplet = new ArrayList<>();
					 triplet.add(num[i]);
					 triplet.add(num[begin]);
					 triplet.add(num[end]);
					 result.add(triplet);
					 begin++;
					 end--;
					 while (begin < end && num[end] == num[end + 1]) end--;	 
					 while (begin < end && num[begin] == num[begin - 1]) begin++;
					 continue;
				 }
				 if ((num[begin] + num[end]) < target) begin++;
				 else end--;
			 }
		 }
		 
		 return result;
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{-1, 0, 1, 2, -1, -4};
		System.out.println(new ThreeSum().threeSum(num));
	}

}
