package pramp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/*
 * Implement a document scanning function wordCountEngine, 
 * which receives a string document and returns a list of all unique words in it 
 * and their number of occurrences, sorted by the number of occurrences in a descending order. 
 * Assume that all letters are in english alphabet. 
 * You function should be case-insensitive, so for instance, 
 * the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) 
and use whitespaces to separate words.

Analyze the time and space complexities of your solution. 
Try to optimize for time while keeping a polynomial space complexity.
 */
// SOLUTION 

/*
 Let document consist of of N words where M of them are unique (M ≤ N). 
 The solution consists of two steps: 1) parsing the string according to the criteria described 
 in the problem and counting the number of occurrences of each word. 2) sorting the [word, occurrence] pairs 
 by the number of words’ occurrences in a descending order.

Step 1: we tokenize document into words by using whitespaces as delimiters.

For each word, we clean it from all non-alphabetic characters (digits, punctuation etc) 
and convert it to lowercase to make counting case-insensitive. 
In this part, you should be leveraging whatever parsing capabilities your programming language of choice
 is providing. There is really no point of implementing functions that already exist.

As for counting, We’ll use a Map (Hash Table) to store words and their corresponding occurrences.
 A map is optimal in this case because it allows us find, store and update operations in O(1) time complexity.

Step 2: as for the sorting part, rather than sorting the entries in the map directly, 
which takes O(M⋅log(M)) - where M is number of unique words in document - 
a better solution will be to place words into an array of string arrays indexed by the occurrence number 
and then iterate through the array in the reverse order. This is similar to a Bucket Sort. 
The proposed solution trades off a bit of space for performance, 
which may be a reasonable trade under certain circumstances.
 */
public class WordCountEngine {
	public static String[][] wordCountEngine(String document) {
		document = document.toLowerCase();
		String[] doc = document.split("[^a-zA-Z0-9]+");
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		
		String w = null;
	   for (int i = 0; i < doc.length; i++) {
		   w = doc[i];
		   if(h.get(w) != null) {
			   h.put(w, h.get(w) + 1);
		   }
		   else {
			   h.put(w, 1);
		   }
	   }
	   
	   String[][] out = new String[h.size()][2];
	   int j = 0;
	   Set<String> set = h.keySet();
	   Iterator it = set.iterator();
	   while (it.hasNext()) {
		   String key = (String) it.next();
		   String[] cur = new String[2];
		   cur[0] = key;
		   cur[1] = h.get(key) + "";
		   out[j++] = cur;
		   it.remove();
	   }
	   return out; 
	   //  but has to be sorted in descending order
	  }
	public static void main(String[] args) {
		String d = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
		String[][] res = wordCountEngine(d);
		System.out.println(res);
	}
}
