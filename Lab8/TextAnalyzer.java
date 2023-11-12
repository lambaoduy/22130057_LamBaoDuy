package Lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		// TODO
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int i = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (tokens.hasMoreTokens()) {
					add(word, i);
				} else {
					add(word, -i);

				}
				i++;

			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if(!map.containsKey(word)) {
			List<Integer> list= new ArrayList<Integer>();
			list.add(position);
			map.put(word, (ArrayList<Integer>) list);
		}else {
			ArrayList<Integer> list = map.get(word);
			list.add(position);
			map.put(word, list);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		// TODO
		TreeMap<String, ArrayList<Integer>> tree= new TreeMap<String, ArrayList<Integer>>(map);
		System.out.println(tree.toString());
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		// TODO
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		// TODO
		int max=0;
		String result="";
		Set<String> set = map.keySet();
		for (String string : set) {
			if(map.get(string).size()>max) {
				max= map.get(string).size();
				result=string;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		TextAnalyzer textFile = new TextAnalyzer();
		textFile.load("src/lab8_data/short.txt");
		System.out.println(textFile.map.toString());
//		System.out.println(textFile.mostFrequentWord());
		textFile.displayWords();
	}

}
