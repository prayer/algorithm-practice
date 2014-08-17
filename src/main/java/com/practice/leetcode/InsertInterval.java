package com.practice.leetcode;

import java.util.ArrayList;

/**
 * From http://oj.leetcode.com/problems/insert-interval/
 * 
 */

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}

public class InsertInterval {

	/**
	 * 1.Non-overlapping  2.Sorted by start time
	 */
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}

		// find where to insert
		int iter = 0;
		while (iter < intervals.size()) {
			Interval currInterval = intervals.get(iter);
			if (currInterval.end >= newInterval.start) break;
			result.add(currInterval);
			iter++;
		}
		if (iter == intervals.size()) { // just add at the end
			result.add(newInterval);
			return result;
		}
		
		// merge
		Interval mergedInterval = new Interval(newInterval.start, newInterval.end);
		
		Interval currInterval = intervals.get(iter);
		if (currInterval.start < newInterval.start) {
			mergedInterval.start = currInterval.start;
		}
		while (iter < intervals.size()) {
			currInterval = intervals.get(iter);
			if (currInterval.end > newInterval.end) {
				if (currInterval.start <= newInterval.end) {
					mergedInterval.end = currInterval.end;
					iter++;	// go to the next interval;
				}
				break;
			}
			iter++;
		}
		result.add(mergedInterval);
		
		// add the left intervals
		while (iter < intervals.size()) {
			result.add(intervals.get(iter++));
		}

		return result;
	}

	public static void main(String[] args) {
		// case 1
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(6, 9));
		Interval newInterval = new Interval(2, 5);
		ArrayList<Interval> result = insert(intervals, newInterval);
		System.out.println(result.toString());

		// case 2
		intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		newInterval = new Interval(4, 9);
		result = insert(intervals, newInterval);
		System.out.println(result.toString());
	}

}
