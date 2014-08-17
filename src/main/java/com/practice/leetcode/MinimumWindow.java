package com.practice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * http://oj.leetcode.com/problems/minimum-window-substring/
 *
 */
public class MinimumWindow {

	private static boolean check(int[] needCounts, int[] charCounts, String T) {
		for (int i = 0; i < T.length(); i++) {
			if (charCounts[T.charAt(i) - 'A'] < needCounts[T.charAt(i) - 'A']) return false;
		}
		return true;
	}
	
	public String minWindow(String S, String T) {        
        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] needCounts = new int['z' - 'A' + 1];
        int[] currCounts = new int['z' - 'A' + 1];	// make T be able to be looked up in O(1)
        Arrays.fill(currCounts, -1);
        Arrays.fill(needCounts, 0);
        for (int i = 0; i < T.length(); i++) {
        	currCounts[T.charAt(i) - 'A'] = 0;
        	needCounts[T.charAt(i) - 'A']++;
        }
        
        LinkedList<Integer> queue = new LinkedList<>(); // as the sliding window		
        boolean isChecked = false;
        for (int iter = 0; iter < S.length(); iter++) {
        	char c = S.charAt(iter);
        	if (currCounts[c - 'A'] == -1) continue;
        	
        	queue.add(iter);
        	currCounts[c - 'A']++;        	
        	if (isChecked == false && check(needCounts, currCounts, T) == false) continue;
        	else isChecked = true;
        	
        	char head = S.charAt(queue.getFirst());
        	while (currCounts[head - 'A'] > needCounts[head - 'A']) {
        		queue.pollFirst();
        		currCounts[head - 'A']--;
        		head = S.charAt(queue.getFirst());
        	}
        	int windowLen = queue.getLast() - queue.getFirst() + 1;
        	if (windowLen < minLength) {
        		minLength = windowLen;
        		//System.out.println("Queue: " + queue);
        		minStr = S.substring(queue.getFirst(), queue.getLast()+1);
        		if (minLength == T.length()) return minStr;
        	}
        }
        
        return minStr;
    }
	
	public static void main(String[] args) {
		System.out.println(new MinimumWindow().minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(new MinimumWindow().minWindow("a", "a"));
		System.out.println(new MinimumWindow().minWindow("a", "aa"));
		System.out.println(new MinimumWindow().minWindow("abaac", "aa"));
		System.out.println(new MinimumWindow().minWindow("bba", "ab"));
	}

}
