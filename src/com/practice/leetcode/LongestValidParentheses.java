package com.practice.leetcode;

import java.util.Stack;

/**
 * From http://oj.leetcode.com/problems/longest-valid-parentheses/
 *
 */
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		if (s.length() < 2) return 0;
		
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
        	if (stack.isEmpty()) {
        		stack.push(i);
        		continue;
        	} 
        	int index = stack.peek();
        	if (s.charAt(index) == '(' && s.charAt(i) == ')') {
        		stack.pop();
        	} else {
        		stack.push(i);
        	}        	
        }
        stack.push(s.length());
        
        int maxLen = stack.get(0);
        for (int i = 1; i < stack.size(); i++) {
        	maxLen = Math.max(maxLen, stack.get(i) - stack.get(i-1) - 1);
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(new LongestValidParentheses().longestValidParentheses(s));
		
		s = "(()";
		System.out.println(new LongestValidParentheses().longestValidParentheses(s));
	}

}
