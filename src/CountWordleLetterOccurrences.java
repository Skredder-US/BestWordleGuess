import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * The Wordle words list has 10663 words! 
 * 
 * Finds the most coincident word in the Wordle words list.
 * 
 * 		eg. : "Sores" is the most coincident word when only considering same
 * 			  letters in the same location
 * 
 * results: "sanes" (doesn't seem right -- because i dunno if wordle solutions
 * are plural.) but with a score of 74405 it wins!
 * 
 *  Note: NO solutions are plural... will need to remove those words from list!
 */
public class CountWordleLetterOccurrences {

	public static void main(String[] args) throws FileNotFoundException {
		// Iterate through the list and count each letter in each index
		Scanner listScan = new Scanner(new File("src/Wordle Word List.txt"));
		
		int[][] letterAndLocationCount = new int[5][26]; // 5 indices, 26 letters
		int[] letterCount = new int[26];
		while (listScan.hasNext()) {
			String curWord = listScan.next();
			
			for (int i = 0; i < curWord.length(); i++) { 
				int letterIndex = curWord.charAt(i) - 'a';
				letterAndLocationCount[i][letterIndex]++;
				letterCount[letterIndex]++;
			}
		}
		
		// Reiterate through the list and find the most coicident Wordle word
		
		// quick redo of File and rescan b/c easy
		listScan = new Scanner(new File("src/Wordle Word List.txt"));
		
		String bestWord = "";
		int scoreMax = 0;
		while (listScan.hasNext()) {
			String curWord = listScan.next();
			
			// sum the occurrence counts for the letters in this word at each
			// index
			int curScore = 0;
			for (int i = 0; i < curWord.length(); i++) {
				int letterIndex = curWord.charAt(i) - 'a';
				
				curScore += 5 * letterAndLocationCount[i][letterIndex];
				curScore += letterCount[letterIndex];
			}
			
			// set this as best word if occurrence counts is largest.
			if (curScore > scoreMax) {
				bestWord = curWord;
				scoreMax = curScore;
			}
		}
		
		// Print results
		System.out.println(bestWord + ": " + scoreMax);
	}

}
