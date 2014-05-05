package com.practice.leetcode;

/**
 * http://oj.leetcode.com/problems/gas-station/
 *
 */
public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalLeft = 0;
        int localLeft = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
        	totalLeft += (gas[i] - cost[i]);
        	localLeft += (gas[i] - cost[i]);
        	if (localLeft < 0) {
        		localLeft = 0;
        		startIndex = i + 1; 
        	}
        }
        if (totalLeft < 0) return -1;
        return startIndex;
    }
	
	public static int canCompleteCircuit2(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
        	if (gas[start] < cost[start]) continue;
        	
        	int left = gas[start] - cost[start];
        	int iter = (start + 1) % gas.length;
        	while (iter != start) {        		
        		int curr = left + gas[iter];
        		left = curr - cost[iter % cost.length];
        		if (left < 0) break;	// not enough to goto next station
        		iter = (iter + 1) % gas.length;
        	}
        	
        	if (iter == start) return start; // came back, found the circuit
        }
		
		return -1;
    }
	
	public static void main(String[] args) {
		int[] gas = new int[]{5, 7, 3};
		int[] cost = new int[]{6, 4, 4};
		System.out.println(canCompleteCircuit(gas, cost));
		
		gas = new int[]{5, 4, 3};
		cost = new int[]{6, 4, 4};
		System.out.println(canCompleteCircuit(gas, cost));
		
		
		int[][] t = new int[2][3];
		System.out.println(t.length);
	}

}
