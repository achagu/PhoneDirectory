package com.phonedirectory;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	private Map<Character,TrieNode> child;
	private boolean isLastCharacter;
	
	public TrieNode() {
		child = new HashMap<Character, TrieNode>();
		isLastCharacter = false;
	}
	
	public Map<Character,TrieNode> getChild(){
		return child;
	}
	
	public void setIsLastCharacter(boolean isLastCharacter) {
		this.isLastCharacter = isLastCharacter;
	}
	
	public boolean isLastCharacter() {
		return isLastCharacter;
	}

}
