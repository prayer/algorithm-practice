package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/longest-palindromic-substring/
 * @author Prayer
 *
 */
public class LongestPalindrome {

	/**
	 * Find the longest palindromic substring in str
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if (str.length() == 0) return str;
		
		String longestStr = str.substring(0, 1);
		int maxLength = 1;
		for (int i = 1; i < str.length(); i++) {
			int j = 0;
			while ((i-j >= 0) && (i+j < str.length()) && (str.charAt(i-j) == str.charAt(i+j))) {
				j++;
			}
			int currLen = 2 * j - 1;
			if (currLen > maxLength) {
				maxLength = currLen;
				longestStr = str.substring(i-j+1, i+j);
			}
		}
		
		// find the palindrome string with odd length
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) != str.charAt(i+1)) continue;			
			int j = i;
			int k = i+1;
			while ((j >= 0) && (k < str.length()) && (str.charAt(j) == str.charAt(k))) {
				j--;
				k++;
			}
			int currLen = k - j - 1;
			if (currLen > maxLength) {				
				maxLength = currLen;
				longestStr = str.substring(j+1, k);
			}
		}		
		return longestStr;
	}
	
	public static void main(String[] args) {
		String str = "bb";
		System.out.println(getString(str));
		
		str = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
		System.out.println(str.substring(147, 155));
		System.out.println(getString(str));

	}

}
