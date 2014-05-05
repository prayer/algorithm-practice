package com.practice.leetcode;

import java.util.ArrayList;

/**
 * http://oj.leetcode.com/problems/permutations/
 *
 */
public class Permutations {

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void recur(int[] num, int n, ArrayList<ArrayList<Integer>> list) {
		if (n == 0) {
			ArrayList<Integer> permutation = new ArrayList<Integer>();
			for (int number : num) permutation.add(number);
			list.add(permutation);
			return;
		}
		
		for (int i = 0; i <= n; i++) {			
			swap(num, i, n);
			recur(num, n-1, list);
			swap(num, i, n);
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (num.length == 0) return result;
		
		recur(num, num.length-1, result);		
		return result;
    }

	public static void main(String[] args) {
		int[] num = new int[]{1, 2, 3};
		System.out.println(new Permutations().permute(num));
	}

}
