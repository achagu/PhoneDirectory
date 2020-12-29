package com.phonedirectory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String str) {
		
		int len = str.length();
		TrieNode iter = root;
		for(int i=0;i<len;i++) {
			TrieNode nextNode = iter.getChild().get(str.charAt(i));
			if(nextNode == null) {
				nextNode = new TrieNode();
				iter.getChild().put(str.charAt(i),nextNode);
			}
			iter = nextNode;
			if(i == len-1) {
				iter.setIsLastCharacter(true);
			}
			
		}
	}
	
	public void getContactsUtil(TrieNode node,String prefix,List<String> contactsWithPrefix) {
		
		if(node.isLastCharacter()) {
			contactsWithPrefix.add(prefix);
		}
		for(Map.Entry<Character, TrieNode> entry : node.getChild().entrySet()) {
			getContactsUtil(entry.getValue(), prefix + entry.getKey(), contactsWithPrefix);
		}
	}
	
	public Map<String,List<String>> getContacts(String str) {
		TrieNode prevNode = root;
		String prefix = "";
		TrieNode currNode;
		int i;
		Map<String,List<String>> contactsForEachPrefix = new LinkedHashMap<String,List<String>>();
		List<String> contactsWithPrefix;
		for(i=0;i<str.length();i++) {
			prefix = prefix + str.charAt(i);
			currNode = prevNode.getChild().get(str.charAt(i));
			if(currNode == null) {
				i++;
				contactsWithPrefix = new ArrayList<String>();
				contactsWithPrefix.add("No Contacts");
				contactsForEachPrefix.put(prefix,contactsWithPrefix );
				System.out.println("No Contacts found for prefix " + prefix);
				break;
			}
			contactsWithPrefix = new ArrayList<String>();
			getContactsUtil(currNode, prefix, contactsWithPrefix);
			System.out.println("Contacts with prefix " + prefix +  " " + contactsWithPrefix);
			contactsForEachPrefix.put(prefix,contactsWithPrefix );
			prevNode = currNode;
		}
		for(int j=i;j<str.length();j++) {
			prefix = prefix + str.charAt(j);
			contactsWithPrefix = new ArrayList<String>();
			contactsWithPrefix.add("No Contacts");
			contactsForEachPrefix.put(prefix,contactsWithPrefix );
			System.out.println("No Contacts found for prefix " + prefix);
		}
		return contactsForEachPrefix;
	}
}
