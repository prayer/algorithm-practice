package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/valid-palindrome/
 * @author Prayer
 *
 */
public class ValidPalindrome {
	
	private static boolean isAlphanumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}
	
	private static char toLowerCase(char c) {
		if (c >= 'a' && c <= 'z') return c;
		if (c >= 'A' && c <= 'Z') return (char)(c - 'A' + 'a');
		return c;
	}

	// with no extra space needed
	public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int begin = 0;
        int end = s.length()-1;
        while (begin < end) {
        	while ((begin < end) && !isAlphanumeric(s.charAt(begin))) {begin++;}
        	if (begin > end) return false;
        	if (begin == end) return true;
        	
        	while (!isAlphanumeric(s.charAt(end))) {end--;}        	
        	if (toLowerCase(s.charAt(begin)) != toLowerCase(s.charAt(end))) return false;       	
        	begin++;
        	end--;
        }        
        return true;
    }
	
	public static void main(String[] args) {
		//System.out.println(toLowerCase('Z'));
		
		System.out.println(isPalindrome("a"));
		System.out.println(isPalindrome("a.."));
		System.out.println(isPalindrome(".,.;"));
		System.out.println(isPalindrome(",,a"));
		System.out.println(isPalindrome("a...a..."));
		System.out.println(isPalindrome("a...b...a..."));
		System.out.println(isPalindrome("a...b...c..."));
	}

}
