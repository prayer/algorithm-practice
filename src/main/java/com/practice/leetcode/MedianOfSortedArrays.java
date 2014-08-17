package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 */
public class MedianOfSortedArrays {

	public static int findKthNum(int k, int[] A, int offsetA, int m, int[] B, int offsetB, int n) {
		if (m > n) return findKthNum(k, B, offsetB, n, A, offsetA, m);
		if (m == 0) return B[k-1];
		if (k == 1) return Math.min(A[offsetA], B[offsetB]);
		
		//System.out.printf("%d, %d, %d, %d, %d\n", k, offsetA, m, offsetB, n);
		int partA = Math.min(k/2, m);	// first part of A
		int partB = k - partA; // first part of B
		if (A[offsetA + partA - 1] < B[offsetB + partB - 1]) { // remove the first part of A[]
			return findKthNum(k - partA, A, offsetA + partA, m - partA, B, offsetB, n);
		} else {
			return findKthNum(k - partB, A, offsetA, m, B, offsetB + partB, n - partB);
		}
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int total = A.length + B.length;
		if (total % 2 == 0) {
			int k1 = findKthNum(total/2, A, 0, A.length, B, 0, B.length);
			int k2 = findKthNum(total/2 + 1, A, 0, A.length, B, 0, B.length);
			return (double)(k1 + k2) / 2;
		} else {
			return findKthNum(total/2 + 1, A, 0, A.length, B, 0, B.length);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 3, 7};
		int[] b = new int[]{5, 11, 12, 15};
		System.out.print(new MedianOfSortedArrays().findMedianSortedArrays(a, b));

	}

}
