package Lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import Lab7.Utils;

public class MyWordCountApp {
//	 public static final String fileName = "src/lab8_data/hamlet.txt";
	public static final String fileName = "src/lab8_data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File("src/lab8_data/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			map.put(word,map.getOrDefault(word, 0)+1);
		}
		System.out.println(map.toString());
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
		System.out.println(map.toString());
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String, Integer> tree = new TreeMap<>(map);
		System.out.println(tree.toString());
	}

	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp mwc = new MyWordCountApp();
		mwc.loadData();
//		mwc.printWordCounts();		
		mwc.printWordCountsAlphabet();
	}
}
