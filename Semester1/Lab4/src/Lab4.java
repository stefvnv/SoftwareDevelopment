import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4 {
    static int numPrint = 5;
    static int numFiles = 5;
    static int counter = 0;

    //Creates an array File 'fa' and array Print Writer 'pw'
    static File[] fa = new File[numFiles];
    static PrintWriter[] pw = new PrintWriter[numFiles];

    /**
     * Stores every 5th word into a 5 different txt files
     */
    public static void splitter() {
        try {
            //2.1 Create an array of 5 files
            for (int i = 0; i < numFiles; i++) {
                fa[i] = new File("file" + i + ".txt");
                pw[i] = new PrintWriter(fa[i]);
            }

            //1.1 Read in from last week's text file
            Scanner sc = new Scanner(new File("Jumble.txt"));

            while (sc.hasNext()) {
                String word = sc.next();

                //2.2 put one fifth of the words from the text file in each file
                if (counter % numPrint == 0) {
                    System.out.println(word);
                }
                //1.2 print out every 5th word
                pw[counter % numFiles].println(word);
                counter++;
            }
            for (int i = 0; i < numFiles; i++) {
                //Ends print writer
                pw[i].close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 3. Randomly swap the contents of all files, finally printing the statistics for each of the files
     */
    public static void swapper() {
        String[] contents = new String[numFiles];
        Scanner[] scans = new Scanner[numFiles];

        //Reads array of files into an array of scanners, then into an array of strings
        for (int i = 0; i < numFiles; i++) {
            try {
                scans[i] = new Scanner(fa[i]);

                while (scans[i].hasNext()) {
                    if (contents[i] == null) {
                        contents[i] = scans[i].next() + " ";
                    } else {
                        contents[i] += scans[i].next() + " ";
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            //Jumbles the contents array
            Counter3_1.jumble(contents);

            //Prints array to files
            for (int i = 0; i < numFiles; i++) {
                System.out.println("\nFile " + i + ": ");
                PrintWriter pw = new PrintWriter("file" + i + ".txt");
                pw.println(contents[i]);
                pw.close();
                Counter3_1.reader(new File("file" + i + ".txt"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Calls 'splitter' and 'swapper' methods
        splitter();
        swapper();
    }
}