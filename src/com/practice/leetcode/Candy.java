package com.practice.leetcode;

/**
 * From http://oj.leetcode.com/problems/candy/
 *
 */
public class Candy {

	public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1; // suppose 1 will be enough, will be adjusted later
        for (int i = 1; i < candies.length; i++) {
        	if (ratings[i] > ratings[i-1]) candies[i] = candies[i-1] + 1;
        	else candies[i] = 1;	// 
        }
        
        // adjust, for example: if the ratings is [3, 2, 1], 
        // then the candies we got from last step will be [1, 1 ,1], so is not correct
        int total = candies[candies.length-1]; // adjust from right
        for (int i = ratings.length-2; i >= 0; i--) {
        	if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) candies[i] = candies[i+1] + 1;
        	total += candies[i];
        }
        return total;
    }
	
	public static void main(String[] args) {
	}

}
