package com.practice.leetcode;

/**
 * http://oj.leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

	public int jump(int[] A) {
        int start = 0;
        int end = 0;
        int steps = 1;
        int[] stepCount = new int[A.length];
        stepCount[0] = 0;
        while (end < A.length - 1) {
        	int newEnd = end;
        	for (int i = start; i <= end; i++) {
        		newEnd = Math.max(newEnd, A[i] + i);
        	}
        	start = end + 1;
        	end = Math.min(A.length - 1, newEnd);
        	for (int i = start; i <= end; i++) stepCount[i] = steps;
        	steps++;
        }
        return stepCount[A.length - 1];
    }

	public static void main(String[] args) {
		int[] A = new int[]{2, 3, 1, 1, 4};
		System.out.println(new JumpGame2().jump(A));
	}

}
