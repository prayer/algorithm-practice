package com.practice.leetcode;

public class SearchRotatedSortedArray {

	private static int recur(int[] A, int begin, int end, int target) {
		if (begin >= end) return -1;
		
		int mid = (begin + end) / 2;
		int pivot = A[mid];		
		if (target == pivot) {
			return mid;
		} 
		
		if (pivot >= A[begin]) { // left half
			if (target < pivot && target >= A[begin]) return recur(A, begin, mid, target);
			else return recur(A, mid+1, end, target);
		} else {
			if (target > pivot && target < A[begin]) return recur(A, mid+1, end, target);
			else return recur(A, begin, mid, target);
		}
	}
	
	public int search(int[] A, int target) {
		return recur(A, 0, A.length, target);
    }
	
	public static void main(String[] args) {
		int[] A = new int[]{4, 5, 6, 7, 0, 1, 2};
		System.out.println(new SearchRotatedSortedArray().search(A, 12));
	}

}
