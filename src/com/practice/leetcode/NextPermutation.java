package com.practice.leetcode;

import java.util.Arrays;

/**
 * http://oj.leetcode.com/problems/next-permutation/
 *
 */
public class NextPermutation {

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void reverse(int[] array, int start, int end) {
		int mid = (start + end) / 2;
		for (int i = 0; i <= (mid - start); i++) swap(array, start+i, end-i);
	}
	
	public void nextPermutation(int[] num) {
        if (num.length == 1) return;
        
        int i = num.length - 1;
        while (i > 0 && num[i-1] >= num[i]) i--;
        if (i == 0) {// all in ascending order
        	reverse(num, 0, num.length-1);
        	return;
        }
        
        int j = num.length - 1;
        while (num[j] <= num[i-1]) j--;
        swap(num, i-1, j);
        reverse(num, i, num.length-1);
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{2, 1, 3};
		new NextPermutation().nextPermutation(num);
		System.out.println(Arrays.toString(num));
		
		num = new int[]{3, 5, 4, 2, 1};
		new NextPermutation().nextPermutation(num);
		System.out.println(Arrays.toString(num));
		
		num = new int[]{1,1,5};
		new NextPermutation().nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}

}
