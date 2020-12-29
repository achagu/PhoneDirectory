# PhoneDirectory
Option to initialize a phone directory and search the contacts for each character typed

# Run the following commands to initialize phone directory and search for contacts for each character typed
java -jar phoneDirectory.jar

#Sample Input and Output

Enter the No of phone contacts you wish to add  
7  
Enter the contact names  
rick test  
rik  
ronald te  
tesf  
tadf  
bgs  
zef  
Enter 'add' and in the next line enter the contact name to add the contact  
By default search will be performed on the contacts with that prefix  
Type exit to exit the console  
rid  
Contacts with prefix r [rick test, rik, ronald te]  
Contacts with prefix ri [rick test, rik]  
No Contacts found for prefix rid  
add  
rid  
rid  
Contacts with prefix r [rick test, rid, rik, ronald te]  
Contacts with prefix ri [rick test, rid, rik]  
Contacts with prefix rid [rid]  

Explanation: In the initial search contact "rid" is not present but after adding "rid" with "add rid" command and searching for String "rid", we get "rid" in the result.
