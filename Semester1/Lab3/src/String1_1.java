package src;//1. Create an application which will read a word from the command line, using a method(s) will analyse the string and state its length, number of vowels, first letter and last letter.
import java.util.Scanner;

public class String1_1 {
    public static int vowels = 0;

    /**
     * Initialize 'vowels' variable, read and convert upper case letters as lower case letters,
     *  increase 'vowels' variable by +1 if vowel is present,
     *  print 'vowels'
     * @param s word
     */
    public static int getVowels(String s) {
        int count = 0;
        s = s.toLowerCase();

        for(char c : s.toCharArray()){
            if (c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' ){
                count++;
            }
        }
        return count;
    }

    /**
     * Calls 'getVowels' method,
     *  prints input(word), prints length of word,
     *  prints first character of input, prints last character of input
     * @param s word
     */
    public static void getStringDetails(String s) {
        getVowels(s);
        System.out.println("The word entered is: " +s + "\n");
        System.out.println("The length of the word is: " + s.length());
        System.out.println("The number of vowels in the word is: " + vowels);
        System.out.println("The first letter of the word is: " + s.charAt(0));
        System.out.println("The last letter of the word is: " + s.charAt(s.length()-1));
    }

    //Ask for input and call getStringDetails method
    public static void main(String[] args) {
        System.out.println("Enter a word: ");
        Scanner sc = new Scanner(System.in);

        if(sc.hasNext()){
            getStringDetails(sc.next());
        }
    }
}
