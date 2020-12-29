package com.phonedirectory.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.phonedirectory.PhoneDirectory;

public class TestPhoneDirectory {

	private PhoneDirectory phoneDirectory;
	
	@Before
	public void setupBeforeEachTestCase() {
		phoneDirectory = new PhoneDirectory();
	}
	
	@Test
	public void TestSearchContactWithValidNames() {
		phoneDirectory.addContact("rick test");
		phoneDirectory.addContact("rik");
		phoneDirectory.addContact("ronald te");
		phoneDirectory.addContact("tesf");
		phoneDirectory.addContact("tadf");
		phoneDirectory.addContact("bgs");
		phoneDirectory.addContact("zef");
		Map<String,List<String>> result = phoneDirectory.getContactsWithPrefix("rid");
		List<String> contactNamesWithPrefixR= new ArrayList<String>(Arrays.asList("rick test","rik","ronald te"));
		List<String> contactNamesWithPrefixRI = new ArrayList<String>(Arrays.asList("rick test","rik"));
		List<String> contactNamesWithPrefixRID = new ArrayList<String>(Arrays.asList("No Contacts"));
		Assert.assertTrue(isEqualList(result.get("r"),contactNamesWithPrefixR));
		Assert.assertTrue(isEqualList(result.get("ri"),contactNamesWithPrefixRI));
		Assert.assertTrue(isEqualList(result.get("rid"),contactNamesWithPrefixRID));
	}
	
	@Test
	public void TestSearchWithSomeInvalidContactNames() {
		phoneDirectory.addContact("rick test");
		phoneDirectory.addContact("rik%2");
		phoneDirectory.addContact("ron#@ald te");
		phoneDirectory.addContact("ris");
		phoneDirectory.addContact("rtu");
		phoneDirectory.addContact("rid");
		phoneDirectory.addContact("tesf");
		phoneDirectory.addContact("tadf");
		phoneDirectory.addContact("bgs");
		phoneDirectory.addContact("zef");
		Map<String,List<String>> result = phoneDirectory.getContactsWithPrefix("rid");
		List<String> contactNamesWithPrefixR= new ArrayList<String>(Arrays.asList("rick test","ris","rtu","rid"));
		List<String> contactNamesWithPrefixRI = new ArrayList<String>(Arrays.asList("rick test","ris","rid"));
		List<String> contactNamesWithPrefixRID = new ArrayList<String>(Arrays.asList("rid"));
		Assert.assertTrue(isEqualList(result.get("r"),contactNamesWithPrefixR));
		Assert.assertTrue(isEqualList(result.get("ri"),contactNamesWithPrefixRI));
		Assert.assertTrue(isEqualList(result.get("rid"),contactNamesWithPrefixRID));
	}
	
	
	
	private boolean isEqualList(List<String> l1,List<String> l2) {
		return l1.containsAll(l2) && l2.containsAll(l1);
	}
}
