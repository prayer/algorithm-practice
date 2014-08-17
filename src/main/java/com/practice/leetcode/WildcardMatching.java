package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/wildcard-matching/
 *
 */
public class WildcardMatching {
	
	/**
	 * Recursive approach, could not pass the large set
	 */
	private static boolean isMatchRecur(String s, String p, int sIter, int pIter) {
		while (sIter < s.length() && pIter < p.length()) {
			char pChar = p.charAt(pIter);
			char sChar = s.charAt(sIter);
			if (pChar == '?') {
				sIter++;
				pIter++;
				continue;
			}			
			/*
			 * Most complicated case: 
			 * If we found "*", then the left of the pattern could be able to match from any place in s from sIter.
			 * The approach is a little bit slow and should be optimized.
			 */
			if (pChar == '*') {				
				while (pIter < p.length() && p.charAt(pIter) == '*') pIter++; // ignore continuous '*', they can be treated as one
				if (pIter == p.length()) return true;	// match to the end	
				
				for (int i = sIter; i < s.length(); i++) {
					if (isMatchRecur(s, p, i, pIter)) return true;
				}
				return false;
			}			
			
			// No wildcard character
			if (pChar != sChar) return false;
			sIter++;
			pIter++;		
		}
		
		if (sIter < s.length() || pIter < p.length()) return false;
		return true;
	}
	
	/**
	 * Iterative approach
	 */
	private static boolean isMatchIter(String s, String p) {
		int sIter = 0;
		int pIter = 0;
		int sStart = -1;
		int pStart = -1;
		
		while (sIter < s.length()) {
			if (pIter == p.length()) {
				if (pStart == -1) return false;
				sIter = ++sStart;
				pIter = pStart;
			}
			
			char pChar = p.charAt(pIter);
			char sChar = s.charAt(sIter);
			if (pChar == '?' || pChar == sChar) {
				sIter++;
				pIter++;	
			} else if (pChar == '*') {				
				while (pIter < p.length() && p.charAt(pIter) == '*') pIter++; // ignore continuous '*', they can be treated as one
				if (pIter == p.length()) return true;	// match to the end	
				sStart = sIter;
				pStart = pIter;				
			} else if (pChar != sChar && pStart > -1) {
				sIter = ++sStart;
				pIter = pStart;
			} else {
				//System.out.println(sIter + " : " + pIter);
				return false;
			}
		}
		
		while (pIter < p.length()) {
			if (p.charAt(pIter++) != '*') return false;
		}
		return true;
	}
	
	/**
	 * DP approach
	 */
	/*
	private static boolean isMatchDP(String s, String p) {
		int strLen = s.length();
		int ptnLen = p.length();
		
		int nonStarCount = 0;
		for (int i = 0; i < ptnLen; i++) if (p.charAt(i) != '*') nonStarCount++;
		if (nonStarCount > strLen) return false;
		
		boolean[][] table = new boolean[ptnLen][strLen];
		
	}*/

	public boolean isMatch(String s, String p) {
		//return isMatchRecur(s, p, 0, 0);
		return isMatchIter(s, p);
    }
	
	public static void main(String[] args) {
		
		System.out.println(new WildcardMatching().isMatch("aa", "*"));
		System.out.println(new WildcardMatching().isMatch("aa", "aa"));
		System.out.println(new WildcardMatching().isMatch("aa", "a"));
		System.out.println(new WildcardMatching().isMatch("ab", "?b"));
		System.out.println(new WildcardMatching().isMatch("abcd", "?*"));
		System.out.println(new WildcardMatching().isMatch("", "?*"));
		System.out.println(new WildcardMatching().isMatch("abcdefg", "a*d*fg"));
		
		System.out.println(new WildcardMatching().isMatch("abbbb", "?*b**"));
		
		System.out.println(new WildcardMatching().isMatch("baabbaaabaaaabbaabababbbababaabbbbaabaabbabbbabbba", "*b*a**b*bb*bb*a*aa*a**a"));
		
		
		// Could not pass this case with recursive approach
		System.out.println(new WildcardMatching().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", 
				"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
	}

}
