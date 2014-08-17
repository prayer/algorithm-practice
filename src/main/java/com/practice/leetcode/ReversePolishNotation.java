package com.practice.leetcode;

import java.util.Stack;

/**
 * http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 */
public class ReversePolishNotation {

	private static final String[] OPERATORS = new String[]{"+", "-", "*", "/"};
	
	private static boolean isNumber(String str) {
		for (String op : OPERATORS) {
			if (str.equals(op)) return false;
		}
		return true;
	}
	
	private static Integer calculate(Integer left, Integer right, String op) {
		if (op.equals("+")) return left + right;
		if (op.equals("-")) return left - right;
		if (op.equals("*")) return left * right;
		return left / right;
	}
		
	public int evalRPN(String[] tokens) {
		if (tokens.length == 0) return 0;
		
        Stack<Integer> stack = new Stack<Integer>();
		for (String exp : tokens) {
        	if (isNumber(exp)) {
        		stack.push(Integer.parseInt(exp));
        		continue;
        	}
        	// handle operator
        	Integer right = stack.pop();
        	Integer left = stack.pop();
        	Integer result = calculate(left, right, exp);
        	stack.push(result);
        }
		return stack.pop();
    }
	
	public static void main(String[] args) {
		String[] tokens = new String[]{"2", "1", "+", "3", "*"};
		System.out.println(new ReversePolishNotation().evalRPN(tokens));
		
		tokens = new String[]{"4", "13", "5", "/", "+"};
		System.out.println(new ReversePolishNotation().evalRPN(tokens));
	}

}
