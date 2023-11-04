package Lab7;

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
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<>();
		for (int i = 0; i < words.size(); i++) {
			WordCount wc = new WordCount(words.get(i), count(words.get(i)));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}
		return result;
	}

	private int count(String string) {
		int result = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(string)) {
				result++;
			}
		}
		return result;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result = new HashSet<>();
		List<WordCount> list = new ArrayList<>(getWordCounts());
		for (WordCount wordCount : list) {
			if (wordCount.getCount() == 1) {
				result.add(wordCount.getWord());

			}
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		return new HashSet<String>(words);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		List<WordCount> list = new ArrayList<>(getWordCounts());
		Set<WordCount> result = new TreeSet<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				// TODO Auto-generated method stub
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		for (WordCount wordCount : list) {
			result.add(wordCount);
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		List<WordCount> list = new ArrayList<>(getWordCounts());
		Set<WordCount> result = new TreeSet<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				// TODO Auto-generated method stub
				if(o1.getCount()!=o2.getCount()) {
					return -(o1.getCount()- o2.getCount());
				}else {
					return	o1.getWord().compareTo(o2.getWord());
				}
			}
		});
		for (WordCount wordCount : list) {
			result.add(wordCount);
		}
		return result;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> result= new HashSet<>();
		for (int i = 0; i < words.size(); i++) {
			if(words.get(i).charAt(0)!= pattern.charAt(0)) {
				result.add(words.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MyWordCount mwc = new MyWordCount();
//		System.out.println(mwc.getWordCounts());
//		System.out.println(mwc.getUniqueWords());
//		System.out.println(mwc.getDistinctWords());
//		System.out.println(mwc.printWordCounts());
//		System.out.println(mwc.exportWordCountsByOccurence());
		System.out.println(mwc.filterWords("D"));
	}
}
