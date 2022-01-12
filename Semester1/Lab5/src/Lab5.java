import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//1. Read into an array the values from the lab3.txt file. and print out each value in sorted order
public class Lab5 {

    /**
     * Takes string and removes symbols
     */
    public static String cleaner(String word){
        word = word.replace(".", "");
        word = word.replace(",", "");
        word = word.replace("!", "");
        word = word.replace("?", "");
        word = word.replace("'", "");
        return word;
    }

    /**
     * Goes through the length of a string and makes the shortest length string 'i'
     *  Prints result
     */
    public static void sort(String [] input) {
        for(int i = 0; i < input.length - 1; i++) {
            int leastIndex = i;

            for(int j = i + 1; j < input.length; j++) {
                if(input[j].compareToIgnoreCase(input[leastIndex]) < 0) {
                    leastIndex = j;
                }
            }
            if (leastIndex != i) {
                //1.4 reuse the method for swapping
                Counter3_1_5.swap(input, i, leastIndex);
            }
        }
        for(String i : input) {
            System.out.println(i);
        }
    }

    /**
     * Takes contents of file, cleans and splits file to string array, passes to sort
     */
    public static void split(){
        String contents = "";

        try {
            Scanner sc = new Scanner(new File("Jumble.txt"));

            while (sc.hasNext()) {
                contents += sc.next() + " ";
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        contents = cleaner(contents);
        String [] txt = contents.trim().split("\\s+");
        sort(txt);
    }


    /**
     * Outputs sorted Book array
     */
    public static void output(String s, int i, Book [] b) {
        System.out.println("Sorting On " + s );

        Book.setSortingMethod(i);
        Book.sort(b);

        for(Book book : b) {
            System.out.println(book);
        }
        System.out.println();
    }

    //Calls 'split' method and creates Book objects to output
    public static void main(String[] args) {
        System.out.println("Print Values in Sorted Order\n----------------------------");
        split();

        System.out.println("\n\nSort an Array of Books\n----------------------");

        //3. Using the Comparable interface sort an array of Books. Allow change the sort method
        Book [] b = new Book[3];

        b[0] = new Book("Big Java: Late Objects", "Cay Horstmann", 169.99);
        b[1] = new Book("Java: The Complete Reference", "Herbert Schildt", 51.99);
        b[2] = new Book("Effective Java", "Joshua Bloch", 49.99);

        output("Title", 1, b);
        output("Author", 2, b);
        output("Price", 3, b);
    }
}
