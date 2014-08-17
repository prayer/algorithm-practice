package com.practice.hackerrank.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class FindASubstring {

	static int wordCount(String sentence, String word) {
		int count = 0;
		int range = sentence.length() - word.length() + 1;
		
		int pos = 0;
		while (pos < range) {
			int nextPos = sentence.indexOf(word, pos);			
			if (nextPos == -1) break;			
			
			if ((nextPos == 0) || nextPos == (range - 1)) {
				pos = nextPos + 1;
				continue;
			}
			if (Character.isWhitespace(sentence.charAt(nextPos-1)) || 
				Character.isWhitespace(sentence.charAt(nextPos + word.length()))) {
				pos = nextPos + 1;
				continue;
			}
			
			count++;
			pos = nextPos + 1;
		}
		return count;
	}
	
	static int wordCount(ArrayList<String> sentences, String word) {
		int count = 0;
		for (String sentence : sentences) {
			count += wordCount(sentence, word);
			//System.out.println(count);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numSentence = scanner.nextInt();
		//System.out.println(numSentence);
		ArrayList<String> sentences = new ArrayList<>();
		while (0 < numSentence--) {
			scanner.nextLine();
			sentences.add(scanner.nextLine());
		}
		
		int numWord = scanner.nextInt();
		while (0 < numWord--) {
			String word = scanner.next();
			System.out.println(wordCount(sentences, word));
		}
		
		scanner.close();
	}

}
