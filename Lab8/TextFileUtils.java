package Lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextFileUtils {
	// read the content of a text file
	public static void readText(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int i=0;
		while (true) {
			
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				System.out.println(tokens.nextToken()+" "+i++);
				if (!tokens.hasMoreTokens()) {
					i=-i;
					System.out.println(" "+i++);
					
				}
			}
		}
		reader.close();
	}

	public static void main(String[] args) {
		try {
			readText("src/lab8_data/short.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
