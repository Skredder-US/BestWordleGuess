import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * by Taylor Juve
 * 
 * 6741 non-plural wordle words out of 10663 total.
 */
public class WordleBestGuess {

	public static void main(String[] args) throws FileNotFoundException {
		// Locally store all non-plural Wordle words
		Set<String> words = new HashSet<String>();
			// .txt file should stay a space separated list of Wordle words
		Scanner wordsScan = new Scanner(new File("src/Wordle Word List.txt"));
		while (wordsScan.hasNext()) {
			String word = wordsScan.next();
			if (!word.endsWith("s")) {
				words.add(word);
			}
		}
		
		System.out.println(words.size());
	}

}
