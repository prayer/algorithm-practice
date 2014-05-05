package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * http://oj.leetcode.com/problems/word-break-ii/
 * Need to output all the possible sentences, so use the DFS approach
 */
public class WordBreak2 {

	private int minWordLen = Integer.MAX_VALUE;
	private int maxWordLen = Integer.MIN_VALUE;
	
	private void wordBreakRecur(String s, Set<String> dict, Stack<String> words, List<String> sentences) {
		if (s.length() == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(words.peek());
			for (int i = words.size()-2; i >= 0; i--) {
				sb.append(" ");
				sb.append(words.get(i));
			}
			sentences.add(sb.toString());
			return;
		}
		
		for (int len = minWordLen; len <= Math.min(maxWordLen, s.length()); len++) {
			String subStr = s.substring(s.length()-len);
			if (dict.contains(subStr)) {
				words.push(subStr);
				wordBreakRecur(s.substring(0, s.length()-len), dict, words, sentences);
				words.pop();
			}
		}
	}
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {	
		ArrayList<String> sentences = new ArrayList<>();
		if (s.length() == 0) return sentences;
        
        // max and min word length
		for (String word : dict) {
			minWordLen = Math.min(minWordLen, word.length());
			maxWordLen = Math.max(maxWordLen, word.length());
		}
		
        wordBreakRecur(s, dict, new Stack<String>(), sentences);
        return sentences;
    }
	
	public static void main(String[] args) {
		// case 1
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		//System.out.println(new WordBreak2().wordBreak(s, dict));

		// case 2
		s = "catsanddog";
		dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		System.out.println(new WordBreak2().wordBreak(s, dict));
	}

}
