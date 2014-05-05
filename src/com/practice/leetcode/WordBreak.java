package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://oj.leetcode.com/problems/word-break/
 *
 */
public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s.length() == 0) return false;
		
        boolean[] table = new boolean[s.length()+1];	//table[i] means if s[0, i) can be broke into words
        Arrays.fill(table, false);
        
        for (int i = 1; i <= s.length(); i++) {
        	if (dict.contains(s.substring(0, i))) {
        		table[i] = true;
        		continue;
        	}
        	for (int j = 1; j < i; j++) {
        		if (table[j] == false) continue;
        		if (dict.contains(s.substring(j, i))) {
        			table[i] = true;
        			break;
        		}        		
        	}
        }
        
        return table[s.length()];
    }
	
	public static void main(String[] args) {
		// case 1
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s, dict));
	}

}
