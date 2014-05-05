package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * From http://oj.leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder2 {
	
	private static void addAncestor(String childWord, String ancestor, HashMap<String, HashSet<String>> ancestorMap) {
		if (ancestorMap.get(childWord) == null) {
			HashSet<String> ancestors = new HashSet<>();
			ancestors.add(ancestor);
			ancestorMap.put(childWord, ancestors);
		} else {
			ancestorMap.get(childWord).add(ancestor);
		}
	}

	private static HashMap<String, HashSet<String>> prepare(String start, String end, HashSet<String> dict) {
        HashSet<String> usedWords = new HashSet<>();	// <word, level> which level means the level on a BFS tree
        HashSet<String> levelUsedWords = new HashSet<>();
        HashMap<String, HashSet<String>> ancestorMap = new HashMap<>();
        LinkedList<String> bfsQueue = new LinkedList<>();
        
        usedWords.add(start);
        ancestorMap.put(start, null);
        bfsQueue.add(start);
		
        int levelSize = 1;
        boolean isFinalLevel = false;
		while (!bfsQueue.isEmpty()) {
			String currWord = bfsQueue.poll();
			levelSize--;
						
			for (int i = 0; i < currWord.length(); i++) {
				boolean found = false;
				char[] charArray = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == currWord.charAt(i)) continue; // don't check currWord again
					
					charArray[i] = c;
					String childWord = new String(charArray);					
					
					if (childWord.equals(end)) {
						found = true;
						isFinalLevel = true;
						addAncestor(childWord, currWord, ancestorMap);
						break;	// 
					}					
					
					if (!dict.contains(childWord)) continue;
					if (usedWords.contains(childWord)) continue;
										
					levelUsedWords.add(childWord);
					addAncestor(childWord, currWord, ancestorMap);
				}
				if (found) break; // no need to check all the currWord's children left
			}
			
			if (levelSize == 0) {
				if (isFinalLevel) break;
				for (String word : levelUsedWords) {
					usedWords.add(word);
					bfsQueue.add(word);
				}
				levelUsedWords.clear();
				levelSize = bfsQueue.size();				
			}
		}
		
		return ancestorMap;
	}
	
	private static void genResult(String word, HashMap<String, HashSet<String>> ancestorMap, 
			Stack<String> tempPath, ArrayList<ArrayList<String>> result) {
		if (ancestorMap.get(word) == null) { // reach the start word
			ArrayList<String> path = new ArrayList<>();
			for (int i = tempPath.size()-1; i >= 0; i--) path.add(tempPath.get(i));
			result.add(path);
			return;
		}
		
		HashSet<String> ancestors = ancestorMap.get(word);
		for (String ancestor : ancestors) {
			tempPath.push(ancestor);
			genResult(ancestor, ancestorMap, tempPath, result);
			tempPath.pop();
		}
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		HashMap<String, HashSet<String>> ancestorMap = prepare(start, end, dict);
		//System.out.println(ancestorMap);
		if (ancestorMap.size() <= 1) return result;
		
		Stack<String> tempPath = new Stack<String>();
		tempPath.add(end);
		genResult(end, ancestorMap, tempPath, result);
		return result;
    }

	public static void main(String[] args) {
		// case 1
		String start = "hit";
		String end = "cog";
		String[] words = new String[]{"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		for (String word : words) dict.add(word);
		System.out.println(new WordLadder2().findLadders(start, end, dict));
		
		// case 2
		start = "red";
		end = "tax";
		words = new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
		dict.clear();
		for (String word : words) dict.add(word);
		System.out.println(new WordLadder2().findLadders(start, end, dict));
		System.out.println();
		
		long startTime = System.currentTimeMillis();
		start = "nape";
		end = "mild";
		words = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		dict.clear();
		for (String word : words) dict.add(word);
		System.out.println(new WordLadder2().findLadders(start, end, dict));
		long endTime = System.currentTimeMillis();
		System.out.println("Timing: " + (endTime - startTime));
	}

}
