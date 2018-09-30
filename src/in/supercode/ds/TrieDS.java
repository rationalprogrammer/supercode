package in.supercode.ds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Trie data structure
 * https://en.wikipedia.org/wiki/Trie
 * 
 * It is a DB for dictionary.
 * Design your own tries database
 * It is singleton
 * 
 * Difficulty level : Hard
 * 
 * @author Gaurav
 *
 */
public final class TrieDS {
	
	private final Map<Character,Node> topNodesMap;
	private static TrieDS triesDS = new TrieDS(); 
	
	// prevent initialization
	private TrieDS() {
		topNodesMap = new HashMap<>();
		
	}
	
	public static TrieDS instance() {
		return triesDS;
	}
	
	
	// always add in lowercase
	public void addWord(String word) {
		if (word == null || word.trim().length() == 0)
			return;
		
		String w = word.trim().toLowerCase();
		char[] ca = w.toCharArray();
		
		Character top = ca[0];
		
		// find from map, if not then add to the map
		Node n = topNodesMap.get(top);
		if (n == null) {
			
		}
	}
	
	
	
	public static class Node {
		// lowercase
		private char val;
		private List<Node> nextNodes;
		// if the node is the last letter of the word
		boolean isWord;
		
		
	}

}
