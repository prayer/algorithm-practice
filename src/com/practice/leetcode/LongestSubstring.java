package com.practice.leetcode;

import java.util.Arrays;

/**
 * http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 */
public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];	// store the index of the chars which already occurred       
        
        int maxLen = 0;
        int iter = 0;
        while (iter < s.length()) {
        	 Arrays.fill(chars, -1);
        	 int subIter = iter;
        	 while (subIter < s.length()) {
        		 if (chars[s.charAt(subIter)] >= 0) {	// duplicated
        			 break;
        		 }
        		 chars[s.charAt(subIter)] = subIter;	// remember the index
        		 subIter++;
        	 }
        	 maxLen = Math.max(maxLen, (subIter - iter));
        	 
        	 if (subIter >= s.length()) {
        		 break;
        	 }        	 
        	 iter = chars[s.charAt(subIter)] + 1;	// restore the index
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcdd"));
		System.out.println(lengthOfLongestSubstring("xabadef"));
		System.out.println(lengthOfLongestSubstring("bbbb"));
	}

}
