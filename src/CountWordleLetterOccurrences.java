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
		
		// print results
		System.out.println(Arrays.toString(letterCount));
		
//		// Reiterate through the list and find the word with the most common 
//		// letters for each position
//		
//		// quick redo of File and rescan b/c easy
//		listScan = new Scanner(new File("src/Wordle Word List.txt"));
//		
//		String curBestWord = "";
//		int curOccurrenceCountMax = 0;
//		while (listScan.hasNext()) {
//			String curWord = listScan.next();
//			
//			// sum the occurrence counts for the letters in this word at each
//			// index
//			int curOccurrenceCountSum = 0;
//			for (int i = 0; i < curWord.length(); i++) {
//				curOccurrenceCountSum +=
//						letterAndLocationCount[i][curWord.charAt(i) - 'a'];
//			}
//			
//			// set this as best word if occurrence counts is largest.
//			if (curOccurrenceCountSum > curOccurrenceCountMax) {
//				curBestWord = curWord;
//				curOccurrenceCountMax = curOccurrenceCountSum;
//			}
//		}
//		
//		// Print results
//		System.out.println(curBestWord + ": " + curOccurrenceCountMax);
	}

}
