package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * http://oj.leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) return result;
        
        Collections.sort(intervals, new Comparator<Interval>() {
        	@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start == o2.start) return -(o1.end - o2.end);
				else return o1.start - o2.start;
			}        	
		});
        
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
        	Interval curr = result.get(result.size() - 1);
        	Interval next = intervals.get(i);
        	
        	if (next.start > curr.end) {
        		result.add(next);
        		continue;
        	}
        	
        	// start to merge
        	if (next.end <= curr.end) continue;
        	else curr.end = next.end;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
