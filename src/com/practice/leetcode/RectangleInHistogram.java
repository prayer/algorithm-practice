package com.practice.leetcode;

import java.util.Stack;

/**
 * http://oj.leetcode.com/problems/largest-rectangle-in-histogram/ 
 * 
 * Refer to: 
 * http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * http://blog.csdn.net/abcbc/article/details/8943485
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 */
public class RectangleInHistogram {


	public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
               
        Stack<Integer> indexes = new Stack<Integer>();
        int maxArea = 0;
        int index = 0;
        while (index < height.length) {
        	int nextBar = height[index];
        	if (indexes.empty() || nextBar > height[indexes.peek()]) {
        		indexes.push(index++);
        		continue;
        	}
        	// current bar is shorter than the highest bar in the stack, 
        	// begin to calculate all the areas 
        	int currHeight = height[indexes.pop()];
        	// if is empty, means this bar is the shortest bar before index
        	// else, it means the width will be the part between index and the previous bar 
        	// which the shorter than the current one
        	int width = indexes.empty()? index : index - indexes.peek() - 1;
        	maxArea = Math.max(maxArea, currHeight * width);
        }
        
        // clean up all the bars left in the stack
        while (!indexes.empty()) {
        	int currHeight = height[indexes.pop()];
        	int width = indexes.empty()? index : index - indexes.peek() - 1;
        	maxArea = Math.max(maxArea, currHeight * width);
        }
        
        return maxArea;
    }
	
	public static void main(String[] args) {
		// case 1
		int[] height = new int[]{2,1,5,6,2,3};
		System.out.println(new RectangleInHistogram().largestRectangleArea(height));

		// case 2
		height = new int[]{2,1,3,4,2,3};
		System.out.println(new RectangleInHistogram().largestRectangleArea(height));
	}

}
