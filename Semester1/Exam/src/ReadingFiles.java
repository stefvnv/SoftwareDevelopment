/*** Q1 Reading Files
 * ReadingFiles
 * ----------------
 * ReadingFiles by Stefana Chiritescu
 * A00282343
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFiles {

    private static ParkStat[] stat;

    //i. Create a custom class and store all entries in a data structure
    public static void reader() throws FileNotFoundException {
        File f = new File("parks.csv");

        int count = 0;

        Scanner sc = new Scanner(f);
        Scanner scCount = new Scanner(f);

        //skip first line
        if (sc.hasNext()){
            sc.nextLine();
            scCount.nextLine();
        }

        while (scCount.hasNext()){
            count++;
            scCount.nextLine();
        }

        String[] rows = new String[count];
        ParkStat[] fa = new ParkStat[count];

        for (int i = 0; i < count; i++){
            rows[i] = sc.nextLine();

            fa[i] = new ParkStat(rows[i]);
        }
        stat = fa;
    }

    public static void swap(ParkStat[] a, int i, int j) {
        ParkStat temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(ParkStat [] a) {
        for (int i = 0; i < a.length -1; i++) {
            int l = i;

            for (int j = i+1; j < a.length; j++) {
                if (a[j].compareTo(a [l])< 1) {
                    l = j;
                }
            }
            swap(a, i, l);
        }
    }


    public static void main(String[] args) {
        try{
            reader();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //ii. Sort the Parks by name and print out
        System.out.println("Sorted by name: \n--------------");
        ParkStat.setSortingMethod(1);
        sort(stat);

        for (ParkStat parkStat : stat) {
            System.out.println(parkStat);
        }

        //iii. Sort the Parks by type(walk, playground etc.)
        System.out.println("\nSorted by types: \n-------------");
        ParkStat.setSortingMethod(2);
        sort(stat);

        for (ParkStat parkStat : stat) {
            System.out.println(parkStat.toString());
        }

        //and print out the number of Parks of each type
        System.out.println("\nNumber of parks of each type: \n-----------------------------");

        for (int i = 0; i < 1; i++){
            System.out.println(stat[i].toStringPrinter());
        }
    }
}
