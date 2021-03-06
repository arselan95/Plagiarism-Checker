user: 009523553 (Alvi, Arselan)
1.CheckPlagiarism.java 

use: HashTable - put,contains, get methods

-> //explain algorithm
	1. parsing of one document from the corpus file.
	- We use a linkedList implementation of a queue and when we split the document based on the entered matching sequence
	  we add that subarray into the queue and remove the first element from that subarray.
	 for example if we have a document- 1:The dog runs up and down.
	- lets say enterred sequence is 3, so we add "the dog runs" to the queue and then remove "the" , and then add "dog runs up"
	  and remove "dog" , and so on. We take the advantage of the Queue FIFO operation for parsing.
	- We successfully parse it in O(n) time as we use only one for loop and other operations are O(1) inside the loop.

	2. putting a set of Documents to hashTable
	- We make a HashTable<Queue<String>,Integer> in which, Queue<String> is the key which is also one single document from the
	  corpus file. We put set of documents in HashTable.

	3. check for Plagiarism
	- We get the text(String) from the target file and we iterate through all the documents in the hashtable simultaneously
	  using the contains key operation O(1) ,and check if the text from target file is plaguarized or not.

-> prove worst case 
	- In this case, we use HashTables because HashTable updates a random element in O(1) time.
	- We use put(), contains(), and get() methods of HashTables and they have O(1) performance.
	- Moreover, we also manage the collision by using an LinkedList implementation of Queue and
	  using that queue as a key in the HashTable. Hence, there are no collisions in the HashTable
	  and linkedList manages the collisions. 
	- As we manage the collisions we can gurantee that the average case for basic operations that we
	  use in the program should be BigTheta(n+m) where n is for that one for loop when we parse and m is the number of words in target file.
	
	-> This algorithm's worst case would be that if the target file has everything matching from the corpus file, but that worst case would still be O(n+m) where m is the number of words
	   in corpus file.

-> The commented lines in main method are for the command line arguments
