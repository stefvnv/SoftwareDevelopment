package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Counter3_1 {
	private static int words = 0;
	private static int vowels = 0;

	/**
	 * Reads in 'Jumble.txt' file to File object 'f' Creates scanner with file Feeds
	 * words to 'vowelCounter' Increments 'words' for count Prints words, vowels and
	 * average number of vowels
	 * 
	 * @throws FileNotFoundException If file is not found, throws error
	 */
	public static void reader() throws FileNotFoundException {
		File f = new File("Jumble.txt");

		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String w = sc.next();

			// 2_1. Count the number of vowels in the file
			vowels += String1_1.getVowels(w);

			//3. Print out the words in the file so that words longer than 3 chars will have the first and last letter stay the same but the middle letters jumbled
			jumble(w);

			// 1. Count the number of words in the text file (using java)
			words++;
		}
		System.out.println("\n\nThe number of words in the file is: " + words);
		System.out.println("The number of vowels in the file is: " + vowels);

		// 2_2. Count the number of vowels in the file and the average number of vowels
		// per word
		System.out.println("The average number of vowels per word in the file is: " + (double) vowels / words);
	}

	/**
	 * Takes string, removes periods and commas, converts to character array,
	 * jumbles interior letters if length of word is greater than 3, prints array
	 * 
	 * @param word word
	 */
	public static void jumble(String word) {
		word = word.replace(".", "");
		word = word.replace(",", "");
		word = word.replace("!", "");
		word = word.replace("?", "");
		word = word.replace("'", "");

		char[] letter = word.toCharArray();

		if (letter.length > 3) {
			for (int i = 1; i < word.length() - 1; i++) {
				int random = (int) ((Math.random() * (word.length() - 2)) + 1);

				if (random != i) {
					swap(letter, i, random);
				}
			}
		}

		for (char ch : letter) {
			System.out.print(ch);
		}
		System.out.print(" ");
	}

	/**
	 * Takes two characters from a word and swaps them
	 * 
	 * @param c temporary character
	 * @param i character 1
	 * @param j character 2
	 */
	public static void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

	//Calls 'reader' method
	public static void main(String[] args) throws FileNotFoundException {
		reader();
	}
}
