import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/*** Question 1
 * Graphical User Interface - LocalEleStat
 * ------------------
 * Stefana Chiritescu
 * A00282343
 */

public class LocalEleStat {

    private final String no, surname, firstName, party, localElectoralArea;
    private final Address address;

    //Constructor
    public LocalEleStat(String s) {
        try {
            Scanner sc = new Scanner(s);

            sc.useDelimiter("\"");

            //Splits string array on commas
            String[] part1 = sc.next().split(",");
            address = new Address(sc.next());
            String[] part3 = sc.next().split(",");

            no = part1[0];
            surname = encode(part1[1]);
            firstName = encode(part1[2]);

            party = encode(part3[1]);
            localElectoralArea = part3[2];
        } catch (Exception e) {
            //ignore exceptions
            throw new IllegalArgumentException("Doesn't fit");
        }
    }

    /**
     * Sets encoding to UTF_8
     */
    private String encode(String s) {
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(s);
        return StandardCharsets.UTF_8.decode(buffer).toString();
    }

    /**
     * Formats strings
     */
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s", no, surname, firstName, party, localElectoralArea);
    }

    @Override
    public String toString() {
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", (surname + "," + firstName), party, localElectoralArea);
    }

    public String getNo() {
        return no;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getParty() {
        return party;
    }

    public String getLocalElectoralArea() {
        return localElectoralArea;
    }

    public Address getAddress() {
        return address;
    }

    static class Address {
        String[] lines;

        public Address(String s) {
            lines = s.split(",");
        }

        @Override
        public String toString() {
            return Arrays.toString(lines);
        }
    }
}