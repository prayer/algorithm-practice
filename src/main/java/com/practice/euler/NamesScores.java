package com.practice.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NamesScores {

	private static List<String> loadNames(String fileName) throws IOException {
		List<String> names = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		br.close();
		
		String[] splittedNames = line.split(",");
		for (String name : splittedNames) {
			if (name.length() == 0) continue;
			name = name.substring(1, name.length()-1); // remove quote
			names.add(name);
		}
		
		return names;
	}
	
	private static int getScore(String name) {
		int score = 0;
		for (int i = 0; i < name.length(); i++) {
			score += (name.charAt(i) - 'A' + 1);
		}
		return score;
	}
	
	public static long getTotalScore() throws IOException {
		long score = 0;
		
		List<String> nameList = loadNames("resource/names.txt");
		Collections.sort(nameList);
		
		for (int i = 0; i < nameList.size(); i++) {
			score += getScore(nameList.get(i)) * (i + 1);
		}
		return score;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<String> nameList = loadNames("resource/names.txt");
		System.out.println(nameList.get(0));
		System.out.println(getScore("COLIN"));
		
		System.out.println(getTotalScore());
	}

}
