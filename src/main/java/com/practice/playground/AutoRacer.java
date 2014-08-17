package com.practice.playground;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is for RocketFuel online test
 * 
 * @author Prayer
 *
 */
public class AutoRacer {
	
	private static int BUCKET_SIZE = 50;
	
	static class RacingLog {
		public long time; // start/end time
		public long racer; // racer id
		
		public RacingLog(long time, long racer) {
			this.time = time;
			this.racer = racer;
		}
	}
	
	static class StartLog extends RacingLog {
		public int isOccured; //
		public StartLog(long time, long racer, int isOccured) {
			super(time, racer);
			this.isOccured = isOccured;
		}
	}
	
	static class EndLog extends RacingLog {
		public int score; // final score
		public EndLog(long time, long racer) {
			super(time, racer);
			score = 0;
		}
	}
	
	static class RacingLogComparator implements Comparator<RacingLog> {
		@Override
		public int compare(RacingLog o1, RacingLog o2) {
			if (o1.time == o2.time) return 0;
			return ((o1.time - o2.time) < 0)? -1 : 1;
		}		
	}
	
	static void computingScores(ArrayList<StartLog> startLogArr, ArrayList<EndLog> endLogArr) {
		int logCount = startLogArr.size();
		
		Collections.sort(startLogArr, new RacingLogComparator());
		Collections.sort(endLogArr, new RacingLogComparator());
		
		HashMap<Long, Integer> racerIdxMap = new HashMap<>(); // for looking up the start time of a racer
		for (int i = 0; i < logCount; i++) {
			StartLog log = startLogArr.get(i);
			racerIdxMap.put(log.racer, i);
		}		
		
		/*
		 * Divide into buckets to improve the performance while calculating scores
		 */
		int totalBuckets = logCount / BUCKET_SIZE + 1;
		long[] bucketScores = new long[totalBuckets];
		Arrays.fill(bucketScores, 0);
		
		/*
		 * After this step, we will know: For every racer "r" with end time "e", 
		 * there are how many racers finished earlier than "e" are started later than "r".
		 * We can get this because the startLogs and endLogs are sorted in ascending order.
		 */		
		for (int i = 0; i < logCount; i++) {
			EndLog endLog = endLogArr.get(i);
			int startIdx = racerIdxMap.get(endLog.racer);
			startLogArr.get(startIdx).isOccured = 1;
			
			int bucketNo = startIdx / BUCKET_SIZE;
			bucketScores[bucketNo]++; // update bucket score
			
			// start calculating score for current racer
			int endIdx = Math.min(BUCKET_SIZE * (bucketNo + 1), logCount);
			for (int j = startIdx+1; j < endIdx; j++) {
				endLog.score += startLogArr.get(j).isOccured;
			}
			int startBucketIdx = bucketNo + 1;
			for (int j = startBucketIdx; j < totalBuckets; j++) {
				endLog.score += bucketScores[j];
			}
		}
	}	
	
	static void sortingResult(ArrayList<EndLog> endLogArr) {
		Collections.sort(endLogArr, new Comparator<EndLog>() {
			@Override
			public int compare(EndLog o1, EndLog o2) {
				if (o1.score < o2.score) return -1;
				if (o1.score > o2.score) return 1;
				return (o1.racer - o2.racer) < 0 ? -1 : 1;
			}			
		});
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		ArrayList<StartLog> startLogArr = new ArrayList<>(total);
		ArrayList<EndLog> endLogArr = new ArrayList<>(total);
		
		while (0 < total--) {
			long racer = scanner.nextLong();
			long start = scanner.nextLong();
			long end = scanner.nextLong();
			StartLog startLog = new StartLog(start, racer, 0);
			EndLog endLog = new EndLog(end, racer);
			startLogArr.add(startLog);
			endLogArr.add(endLog);
		}
		scanner.close();
		
		computingScores(startLogArr, endLogArr);
		sortingResult(endLogArr);
		
		// printing
		for (EndLog log : endLogArr) {
			System.out.println(log.racer + " " + log.score);
		}
    }
}
