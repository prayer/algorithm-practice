package com.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

	private int[][] table = null;
	
	private static boolean isPalindrome(String str, int start, int end) {
		while (start < end) if (str.charAt(start++) != str.charAt(end--)) return false;
		return true;
	}
	
	private void recur(String str, int startPos, LinkedList<String> stack, ArrayList<ArrayList<String>> result) {
		if (startPos == str.length()) {
			ArrayList<String> arr = new ArrayList<>();
			for (String s : stack) arr.add(s);
			result.add(arr);
			return;
		}
		
		for (int i = startPos; i < str.length(); i++) {
			if (table[startPos][i] == 0) continue;
			if (table[startPos][i] == -1 && isPalindrome(str, startPos, i) == false) {
				table[startPos][i] = 0; // not a palindrome
				continue;
			} else {
				table[startPos][i] = 1; // is palindrome
				stack.add(str.substring(startPos, i+1));
				recur(str, i+1, stack, result);
				stack.removeLast();
			}
		}
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (s.length() == 0) return result;
		
		table = new int[s.length()][s.length()];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (i == j) table[i][j] = 1; // single character
				else table[i][j] = -1; // not checked yet
			}
		}
		recur(s, 0, new LinkedList<String>(), result);
		return result;
    }
	
	public static void main(String[] args) {
		String s = "aab";
		System.out.println(new PalindromePartitioning().partition(s));
		
		s = "abacdcee";
		System.out.println(new PalindromePartitioning().partition(s));
	}

}
