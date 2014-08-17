package com.practice.leetcode;

import java.util.Arrays;

/**
 * http://oj.leetcode.com/problems/interleaving-string/
 *
 */
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
        String target = s3; // rename
        if (s1.length() == 0) return s2.equals(target);
        if (s2.length() == 0) return s1.equals(target);
        if (s1.length() + s2.length() != target.length()) return false;
        
        boolean[][] table = new boolean[s1.length()+1][s2.length()+1];
        table[1][0] = table[0][1] = false;
        if (s1.charAt(0) == target.charAt(0)) table[1][0] = true;
        if (s2.charAt(0) == target.charAt(0)) table[0][1] = true;
        for (int i = 1; i < s1.length(); i++) {
        	if (s1.charAt(i) == target.charAt(i)) table[i+1][0] = table[i][0];
        	else table[i+1][0] = false;
        }
        for (int j = 1; j < s2.length(); j++) {
        	if (s2.charAt(j) == target.charAt(j)) table[0][j+1] = table[0][j];
        	else table[0][j+1] = false;
        }
        
        for (int i = 0; i < s1.length(); i++) {
        	for (int j = 0; j < s2.length(); j++) {
        		int index = i + j + 1;
        		if (s1.charAt(i) == target.charAt(index) && s2.charAt(j) == target.charAt(index)) {
        			table[i+1][j+1] = table[i][j+1] || table[i+1][j];
        		} else if (s1.charAt(i) == target.charAt(index)) {
        			table[i+1][j+1] = table[i][j+1];
        		} else if (s2.charAt(j) == target.charAt(index)) {
        			table[i+1][j+1] = table[i+1][j];
        		} else {
        			table[i+1][j+1] = false;
        		}        		
        	}
        }
        /*
        for (int i = 0; i <= s1.length(); i++) {
        	System.out.println(Arrays.toString(table[i]));
        }
        */
        return table[s1.length()][s2.length()];
    }
		
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
		
		s3 = "aadbbbaccc";
		System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
		
		s1 = "a";
		s2 = "";
		s3 = "a";
		System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
	}

}
