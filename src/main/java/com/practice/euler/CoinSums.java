package com.practice.euler;

import java.util.Arrays;


/**
 * Problem webpage: http://projecteuler.net/problem=31
 * 
 * And also this problem can refer to http://www.algorithmist.com/index.php/Coin_Change
 *
 */
public class CoinSums {

	private static final int[] COIN_VALUE = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
	
	public static int recur(int left, int index) {
		if (left == 0) {
			return 1;
		}
		if (left < 0) {
			return 0;
		}
		if (index < 0 && left > 0) {
			return 0;
		}
		
		return recur(left - COIN_VALUE[index], index) 
				+ recur(left, index - 1);
	}	
	
	public static int dp1(int target) {
		int coinCount = COIN_VALUE.length;
		int[][] table = new int[coinCount][target+1];
				
		for (int i = 0; i < coinCount; i++) {
			for (int j = 0; j < target+1; j++) {
				if (j == 0) {
					table[i][j] = 1;
				} else if (i == 0) {
					table[i][j] = 1;
				} else if (j < COIN_VALUE[i]) {
					table[i][j] = table[i-1][j];
				} else {
					table[i][j] = table[i-1][j] + table[i][j-COIN_VALUE[i]];
				}
			}
		}
		
		return table[coinCount-1][target];
	}
	
	public static int dp2(int target) {
		int coinCount = COIN_VALUE.length;
		int[] table = new int[target+1];
		Arrays.fill(table, 1);
		
		for (int i = 1; i < coinCount; i++) {
			int coin = COIN_VALUE[i];
			for (int j = coin; j < target+1; j++) {
				table[j] = table[j] + table[j-coin];				
			}
		}		
		return table[target];
	}
	
	
	public static void main(String[] args) {
		int count = recur(200, COIN_VALUE.length-1);
		
		count = dp2(200);
		System.out.println("count: " + count);
	}

}
