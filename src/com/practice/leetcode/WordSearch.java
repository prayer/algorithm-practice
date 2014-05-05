package com.practice.leetcode;

import java.util.HashSet;

/**
 * From http://oj.leetcode.com/problems/word-search/
 *
 */
public class WordSearch {
	
	private static int[] rowDiff = new int[]{-1, 0, 1, 0};
	private static int[] colDiff = new int[]{0, 1, 0, -1};

	private static Integer convert(int row, int col, char[][] board) {
		return Integer.valueOf(row * board[0].length + col);
	}	
	
	private static boolean search(int row, int col, char[][] board, HashSet<Integer> reached, String word) {
		if (word.length() == 0) return true;
		
		char c = word.charAt(0);
		String nextWord = word.substring(1);
		//System.out.println(word + " " + row + " " + col);
		
		for (int i = 0; i < 4; i++) {
			int newRow = row + rowDiff[i];
			int newCol = col + colDiff[i];
			if (newRow < 0 || newRow >= board.length) continue;
			if (newCol < 0 || newCol >= board[0].length) continue;			
			if (board[newRow][newCol] != c) continue;
			
			Integer pos = convert(newRow, newCol, board);
			if (reached.contains(pos)) continue;
			//System.out.println("New: " + newRow + " " + newCol);
			
			reached.add(pos);
			boolean result = search(newRow, newCol, board, reached, nextWord);
			reached.remove(pos);
			if (result == false) continue;
			else return result;
		}
		return false;
	}
	
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0) return true;
		
		HashSet<Integer> reached = new HashSet<>();
		String newWord = word.substring(1);
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			reached.clear();
        			reached.add(convert(i, j, board));
        			boolean result = search(i, j, board, reached, newWord);
        			if (result == false) continue;
        			return result;
        		}
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		char[][] board = new char[][]{"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
		String word = "SEE";
		System.out.println(new WordSearch().exist(board, word));
		
		word = "ABCCED";
		System.out.println(new WordSearch().exist(board, word));
		
		word = "ABCB";
		System.out.println(new WordSearch().exist(board, word));
		
		board = new char[][]{"aa".toCharArray()};
		word = "aaa";
		System.out.println(new WordSearch().exist(board, word));
	}

}
