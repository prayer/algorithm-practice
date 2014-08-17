package com.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * From http://oj.leetcode.com/problems/word-ladder/
 */
public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start.equals(end)) return 1;
		
        HashMap<String, Integer> wordMap = new HashMap<>();	// <word, level> which level means the level on a BFS tree
        LinkedList<String> bfsQueue = new LinkedList<>();
        wordMap.put(start, 1);
        bfsQueue.add(start);
		
		while (!bfsQueue.isEmpty()) {
			String currWord = bfsQueue.poll();
			
			// get all its children
			int currLevel = wordMap.get(currWord);
			System.out.println("curr: " + currWord + " " + currLevel);
			for (int i = 0; i < currWord.length(); i++) {
				char[] charArray = currWord.toCharArray();
				for (int j = 0; j < 26; j++) {
					char c = (char)('a' + j);
					if (c == currWord.charAt(i)) continue; // don't check currWord again
					
					charArray[i] = c;
					String childWord = new String(charArray);
					if (childWord.equals(end)) return currLevel + 1;
					if (!dict.contains(childWord)) continue;
					if (wordMap.containsKey(childWord)) continue; // already checked
					wordMap.put(childWord, currLevel + 1);
					bfsQueue.add(childWord);
				}
			}
		}
		
		return 0;
    }
	
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] words = new String[]{"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		for (String word : words) dict.add(word);
		System.out.println(new WordLadder().ladderLength(start, end, dict));
		
	}

}
