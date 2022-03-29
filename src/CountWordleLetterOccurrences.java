import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The Wordle words list has 10663 words! 
 * 
 * Counts occurrences of each letter at each of the five letter positions 
 * of all Wordle words then finds which word has the most common letters 
 * for each position
 * 
 * 		eg. : SARES are the most common letters for each index (position) but
 * 			  is not a word. Maybe "Safes" is the word with the most common 
 * 			  letters in each index. 
 * 
 * results: "Sores"! (I could of guessed that!) with 9983 coincident letters
 * 
 * Notes: i realized this is only for green (perfect match) letters, not letters
 * that are yellow (in the word, not in this location.) will do next.
 */
public class CountWordleLetterOccurrences {

	public static void main(String[] args) throws FileNotFoundException {
		// Iterate through the list and count each letter in each index
		Scanner listScan = new Scanner(new File("src/Wordle Word List.txt"));
		
		int[][] letterOccurrenceCounts = new int[5][26]; // 5 indices, 26 letters
		while (listScan.hasNext()) {
			String curWord = listScan.next();
			
			for (int i = 0; i < curWord.length(); i++) { 
				letterOccurrenceCounts[i][curWord.charAt(i) - 'a']++;
			}
		}
		
		// Reiterate through the list and find the word with the most common 
		// letters for each position
		
		// quick redo of File and rescan b/c easy
		listScan = new Scanner(new File("src/Wordle Word List.txt"));
		
		String curBestWord = "";
		int curOccurrenceCountMax = 0;
		while (listScan.hasNext()) {
			String curWord = listScan.next();
			
			// sum the occurrence counts for the letters in this word at each
			// index
			int curOccurrenceCountSum = 0;
			for (int i = 0; i < curWord.length(); i++) {
				curOccurrenceCountSum +=
						letterOccurrenceCounts[i][curWord.charAt(i) - 'a'];
			}
			
			// set this as best word if occurrence counts is largest.
			if (curOccurrenceCountSum > curOccurrenceCountMax) {
				curBestWord = curWord;
				curOccurrenceCountMax = curOccurrenceCountSum;
			}
		}
		
		// Print results
		System.out.println(curBestWord + ": " + curOccurrenceCountMax);
	}

}
