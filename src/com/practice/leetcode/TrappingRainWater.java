package com.practice.leetcode;

/**
 * http://oj.leetcode.com/problems/trapping-rain-water/
 *
 */
public class TrappingRainWater {

	public int trap(int[] A) {
		if (A.length < 3) return 0;
		
		int[] rightMax = new int[A.length];
		rightMax[A.length - 1] = A[A.length - 1]; // store the max value from Ai(including Ai itself)
		for (int i = A.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], A[i]);
		}
		
		// scan from left to right
		int area = 0;
		int leftMax = A[0];
		for (int i = 1; i < A.length - 1; i++) {
			leftMax = Math.max(leftMax, A[i-1]);
			int height = Math.min(leftMax, rightMax[i+1]);
			if (height > A[i]) area += (height - A[i]);
		}
		return area;
    }
	
	public static void main(String[] args) {
		int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(A));
	}

}
