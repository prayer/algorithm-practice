package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * http://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIP {
	
	private static void recur(String left, Stack<String> ip, ArrayList<String> result) {
		if (ip.size() == 4) {
			if (left.length() > 0) return;
			StringBuilder ipStr = new StringBuilder();
			for (String s : ip) {
				ipStr.append(s).append(".");
			}
			result.add(ipStr.substring(0, ipStr.length()-1).toString());
			return;
		}
		
		int maxLen = Math.min(3, left.length());
		for (int i = 1; i <= maxLen; i++) {
			String partStr = left.substring(0, i);
			if (partStr.charAt(0) == '0' && partStr.length() > 1) break;
			Integer partInt = Integer.parseInt(partStr);
			if (partInt > 255) continue;
			
			ip.push(String.valueOf(partStr));
			recur(left.substring(i), ip, result);
			ip.pop();
		}
	}
	
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<>();
		recur(s, new Stack<String>(), result);
		return result;
    }
	
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(new RestoreIP().restoreIpAddresses(s));
		
		s = "010010";
		System.out.println(new RestoreIP().restoreIpAddresses(s));
	}

}
