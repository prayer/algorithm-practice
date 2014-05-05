package com.practice.leetcode;

/**
 * http://oj.leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

	public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(' || c == '{' || c == '[') {
        		stack[top++] = c;
        		continue;
        	}
        	
        	if (c == ')') {
        		if (top == 0 || stack[top-1] != '(') return false;
        		else top--;
        	} 
        	if (c == '}') {
        		if (top == 0 || stack[top-1] != '{') return false;
        		else top--;
        	}
        	if (c == ']') {
        		if (top == 0 || stack[top-1] != '[') return false;
        		else top--;
        	}
        }
        return top == 0;
    }
	
	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(new ValidParentheses().isValid(s));
		
		s = "([)]";
		System.out.println(new ValidParentheses().isValid(s));
	}

}
