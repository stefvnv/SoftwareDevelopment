/*** Q1 Reading Files
 * ParkStat
 * ----------------
 * FireStationStat by Stefana Chiritescu
 * A00282343
 */

public class ParkStat implements Comparable<ParkStat> {
    private final int id;
    private final String name;
    private final String address;
    private final String website4;
    private final String type;
    private final String muga6;
    private final String longitude7;
    private final String latitude8;

    private static int sortingMethod = 0;

    private static int counterWalk, counterPark, counterMUGA, counterPlayground, counterCemetery;


    public ParkStat(String s) {
        String[] values = s.split(",");

        for (int i = 0; i < values.length; i++){
            values[i] = values[i].replaceAll(",", "");
        }

        this.id = Integer.parseInt(values[0]);
        this.name = values[1];
        this.address = values[2];
        this.website4 = values[3];
        this.type = values[4];
        this.muga6 = values[5];
        this.longitude7 = values[6];
        this.latitude8 = values[7];


        if (this.type.compareTo("Walk") == 0) {
            counterWalk++;
        }
        else if (this.type.compareTo("Park") == 0) {
            counterPark++;
        }
        else if (this.type.compareTo("MUGA") == 0) {
            counterMUGA++;
        }
        else if (this.type.compareTo("Playground") == 0) {
            counterPlayground++;
        }
        else if (this.type.compareTo("Cemetery") == 0) {
            counterCemetery++;
        }
    }


    public String toString() {
        return "ID: " + id + "\nName of Park: " + name + "\nAddress: " + address + "\nWebsite: " + website4
                + "\nType: " + type + "\nMUGA: " + muga6 + "\nLongitude: " + longitude7 + "\nLatitude: " +  latitude8
                + "\n\n";
    }


    public String toStringPrinter() {
        return "Walks: " + counterWalk + "\nParks: " + counterPark + "\nMUGAs: " + counterMUGA
                + "\nPlaygrounds: " + counterPlayground + "\nCemeteries: " + counterCemetery;
    }


    @Override
    public int compareTo(ParkStat o) {
        if (sortingMethod == 1) {
            if (o.name.compareTo(this.name) < 1 ) {
                return 1;
            }
            return 0;
        }
        else if(sortingMethod == 2) {
            if (o.type.compareTo(this.type) < 1) {
                return 1;
            }
            return 0;
        }
        else {
            if (o.address.compareTo(this.address) < 1) {
                return 1;
            }
            return 0;
        }
    }

    public static void setSortingMethod (int i){
        sortingMethod = i;
    }
}