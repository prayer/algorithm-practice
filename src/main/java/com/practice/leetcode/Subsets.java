package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 	http://oj.leetcode.com/problems/subsets/
 */
public class Subsets {

	private static void dfs(int[] set, int iter, ArrayList<ArrayList<Integer>> subsets, Stack<Integer> s) {		
		for (int i = iter; i < set.length; i++) {
			s.push(set[i]);
			subsets.add(new ArrayList<Integer>(s));	// remember every changes 
			dfs(set, i+1, subsets, s);
			s.pop();
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();        
        Stack<Integer> s = new Stack<>();
        
        Arrays.sort(S);
        dfs(S, 0, result, s);        
        result.add(new ArrayList<Integer>());
        return result;
    }
	
	public static void main(String[] args) {
		int[] set = new int[]{1, 2, 3};
		System.out.println(new Subsets().subsets(set));
	}

}
