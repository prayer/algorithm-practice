package com.practice.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * http://oj.leetcode.com/problems/reverse-words-in-a-string/
 *
 */
public class ReverseWords {

	public static String reverse(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = temp;
		}
		return new String(chars);
	}
	
	public String reverseWords(String s) {
        Scanner scanner = new Scanner(s);
        Stack<String> stack = new Stack<>();
        while (scanner.hasNext()) stack.push(scanner.next());
        scanner.close();
        
        StringBuilder buf = new StringBuilder();
        while (stack.isEmpty() != true) buf.append(stack.pop() + " ");
        return buf.toString().trim();
    }
	
	
	public static void main(String[] args) {
		String s = "hello world    my dear  friends";
		System.out.println(new ReverseWords().reverseWords(s));
		
		s = " abc    ";
		System.out.println(new ReverseWords().reverseWords(s));
	}

}
