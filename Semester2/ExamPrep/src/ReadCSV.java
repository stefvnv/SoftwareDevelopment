import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*** Question 1
 * Graphical User Interface - ReadCSV
 * ------------------
 * Stefana Chiritescu
 * A00282343
 */

public class ReadCSV {

    private final ArrayList<LocalEleStat> stats = new ArrayList<>();
    private String[] headings;

    public ReadCSV(File f) {
        try {

            Scanner sc = new Scanner(f);

            //Skips first heading and adds second row to headings
            sc.nextLine();
            headings = sc.nextLine().split(",");

            while (sc.hasNextLine()) {
                try {
                    stats.add(new LocalEleStat(sc.nextLine()));
                } catch (IllegalArgumentException ex) {
                    //Do nothing
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LocalEleStat> getStats() {
        return stats;
    }

    public String[] getHeadings() {
        return headings;
    }

    public void addStat(LocalEleStat s) {
        stats.add(s);
    }


    /**
     * Removes local electoral stat
     */
    public void removeStat(String s) {
        int i = -1;
        for (LocalEleStat stat : stats) {
            if (stat.getNo().equals(s)) {
                i = stats.indexOf(stat);
                break;
            }
        }
        if (i != -1)
            stats.remove(i);
    }

    /**
     * Creates output file
     */
    public void writeFile() {
        try {
            File f = new File("output" + (int) ((Math.random() * 1000)) + ".csv");
            System.out.println("File " + f + " created successfully.");

            f.createNewFile();
            PrintWriter pw = new PrintWriter(f);

            for (LocalEleStat stat : stats) {
                pw.println(stat.toCSV());
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}