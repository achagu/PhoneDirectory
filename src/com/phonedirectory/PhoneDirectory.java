package com.phonedirectory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneDirectory {
	
	private Trie trie;
	
	public PhoneDirectory() {
		trie = new Trie();
	}
	
	//Returns true if the contact is added to the trie
	//Else false
	public boolean addContact(String contact) {
		if(isValidContactName(contact)) {
			trie.insert(contact.toLowerCase());
			return true;
		}
		return false;
	}
	
	public Map<String,List<String>> getContactsWithPrefix(String prefix) {
		return trie.getContacts(prefix);
	}
	
	public boolean isValidContactName(String str) { 
        return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z ]*$"))); 
    }
	
	public boolean isInteger(String str) {
		return str.matches("\\d+");
	}

	public static void main(String[] args) {
		
		PhoneDirectory phoneDirectory = new PhoneDirectory();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the No of phone contacts you wish to add");
		boolean isValidNum=false;
		int numOfContacts=0;
		String numContactsString;
		while(!isValidNum) {
			numContactsString  = scan.nextLine().trim();
			if(phoneDirectory.isInteger(numContactsString)) {
				numOfContacts = Integer.parseInt(numContactsString);
				isValidNum=true;
			}else {
				System.out.println("Please enter valid number for No of contacts");
			}
		}
		System.out.println("Enter the contact names");
		String contact;
		List<String> invalidContactNames = new ArrayList<String>();
		for(int i=0;i<numOfContacts;i++) {
			contact = scan.nextLine();
			if(!phoneDirectory.addContact(contact)) {
				invalidContactNames.add(contact);
			}
		}
		if(!invalidContactNames.isEmpty()) {
			System.out.println("There are some invalid contact names like " + invalidContactNames);
			System.out.println("Please Enter add to add valid contact name");
		}
		
		System.out.println("Enter 'add' and in the next line enter the contact name to add the contact");
		System.out.println("By default search will be performed on the contacts with that prefix");
		System.out.println("Type exit to exit the console");
		while(true) {
			String str= scan.nextLine();
			if(str.equalsIgnoreCase("add")) {
				phoneDirectory.addContact(scan.nextLine());
			}else if(str.equalsIgnoreCase("exit")){
				break;
			}else {
				phoneDirectory.getContactsWithPrefix(str);
			}
			
		}
		scan.close();
	}

}