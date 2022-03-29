import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The Wordle words list has 10663 words! 
 * 
 * Counts occurrences of each letter at each of the five letter positions 
 * of all Wordle words. 
 * 
 * 		eg. : hello has 1 h at 0th index (continue for all words in list) 
 * 
 * Results: SARES are most common letters for each index.
 * 
 * next we find the best matching word (a real word, not "SARES")
 */
public class CountWordleLetterOccurrences {

	public static void main(String[] args) throws FileNotFoundException {
		// Iterate through the list and count each letter in each index
		Scanner listScan = new Scanner(
				new File("src/Wordle Word List.txt"));
		
		int[][] letterOccurrenceCounts = new int[5][26]; // 5 indices, 26 letters
		while (listScan.hasNext()) {
			String curWord = listScan.next();
			
			for (int i = 0; i < 5; i++) { // all words are 5 letters
				letterOccurrenceCounts[i][curWord.charAt(i) - 'a']++;
			}
		}
		
		// Print results
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < letterOccurrenceCounts.length; i++) {
			for (int j = 0; j < letterOccurrenceCounts[i].length; j++) {
				System.out.print(letterOccurrenceCounts[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
