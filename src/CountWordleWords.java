import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Count all valid Wordle words to check it reads them all. (probably also
 * prints the last read one.)  	
 * Result: 10663 words (it reads them all)
 */
public class CountWordleWords {

	public static void main(String[] args) throws FileNotFoundException {
		// Iterate through the list and count each word then print last word
		Scanner listScan = new Scanner(
				new File("src/Wordle Word List.txt"));
		
		String word = "none";
		int numWords = 0;
		while (listScan.hasNext()) {
			word = listScan.next();
			numWords++;
		}
		System.out.println(numWords);
	}

}
