package com.practice.leetcode;

import java.util.Arrays;

/**
 * http://oj.leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

	public static int numDecodings(String s) {
		if (s.length() == 0) return 0;
		
        int[] table = new int[s.length()+1];
        Arrays.fill(table, 0);
        table[s.length()] = 1;
        table[s.length()-1] = (s.charAt(s.length()-1) == '0' ? 0 : 1);        
        
        for (int i = s.length()-2; i >= 0; i--) {
        	if (s.charAt(i) == '0') {
        		table[i] = 0;
        		continue;
        	}
        	
        	table[i] = table[i+1];
        	int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
        	if (num >= 10 && num <= 26) {
        		table[i] += table[i+2];
        	}
        }
        return table[0];
    }
	
	public static void main(String[] args) {
		//System.out.println((int)'A');
		System.out.println(numDecodings("321"));
	}

}
