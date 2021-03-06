

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.*;

public class CheckPlagiarism {

	String s;
	static String value;
	static Scanner in;

	// create Plagiarism checker which takes a string
	public CheckPlagiarism(String s) {
		this.s = value;
	}

	// get the Corpus file
	public static void getCorpusFile() {
		try {
			in = new Scanner(new File("corpus.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// get the target file
	public static void getTargetFile() {
		Scanner sc = null;
		String target = " ";
		try {
			sc = new Scanner(new File("target.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			target = target + sc.nextLine() + " ";
		}
		value = target;
	}

	public void parse(int x) {
		// get corpus file
		getCorpusFile();
		// array in which we add documents after splitting of corpus file
		String[] words = null;
		int corpusNumber;
		// HashTable in which queue<String> is the document based on the entered
		// matching sequence
		Hashtable<Queue<String>, Integer> corpusTable = new Hashtable<>();
		String temp;
		/*
		 * parsing the corpus file and putting it into a hashtable that will be
		 * used to compare with the input/target string to check plagiarizing
		 */
		while (in.hasNextLine()) {
			temp = in.nextLine().toLowerCase();
			temp = temp.replaceAll("\\. ", " ");
			temp = temp.replaceAll("\"", "");
			words = temp.split(":|\\s");
			corpusNumber = Integer.parseInt(words[0]);
			Queue<String> queue = new LinkedList<String>();
			for (int i = 1; i < words.length; i++) {
				// add split array to the queue
				queue.add(words[i]);

				if (i >= x) {
					Queue<String> matchqueue = new LinkedList<String>(queue);
					corpusTable.put(matchqueue, corpusNumber);
					queue.remove();

				}

			}
		}

		String[] input = value.toLowerCase().split("\\s");

		boolean check = false;
		Queue<String> inputqueue = new LinkedList<String>();
		for (int i = 0; i < input.length; i++) {
			inputqueue.add(input[i]);
			// System.out.println(inputQueue.toString());
			// System.out.println("added");
			if (i + 1 >= x) {
				if (corpusTable.containsKey(inputqueue)) {
					System.out.println("Plagiarized from " + corpusTable.get(inputqueue));
					check = true;
				}
				inputqueue.remove();
				// System.out.println("removed");
			}
			if (i == input.length - 1) {
				if (check == false) {
					System.out.println("Not Plagiarized");
				}

			}
		}
	}

	public static void main(String[] args) {

		// get Corpus
	//	String corpusFile = args[0];
		//if (corpusFile.equalsIgnoreCase("corpus.txt")) {
			getCorpusFile();

		//} else {
		//	System.out.println("enter correct corpus name");
		//}

		// get Target
		//String targetFile = args[1];
		//if (targetFile.equalsIgnoreCase("target.txt")) {
			getTargetFile();
	//	} else {
			//System.out.println("enter correct target name");
		//}

		// get match sequence
		//int matchSequence = Integer.parseInt(args[2]);
		// value="the dog runs\nPLEASE BLESS MY grades\nmy name is arselan ";
		CheckPlagiarism p = new CheckPlagiarism(value);
		p.parse(4);

	}
}
