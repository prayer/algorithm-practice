package com.practice.leetcode;


/**
 * http://oj.leetcode.com/problems/jump-game/
 *
 */
public class JumpGame {

	public boolean canJump(int[] A) {
        int limit = 0;
        for (int i = 0; i <= limit; i++) {
    		limit = Math.max(limit, i+A[i]);
    		if (limit >= (A.length - 1)) return true;
    	}
        return false;
    }
	
	public static void main(String[] args) {
		int[] A = new int[]{2,3,1,1,4};
		System.out.println(new JumpGame().canJump(A));
		
		A = new int[]{3,2,1,0,4};
		System.out.println(new JumpGame().canJump(A));
	}

}
