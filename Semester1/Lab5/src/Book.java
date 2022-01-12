//2. Create a class Book which validates the arguments to be non-null
public class Book implements Comparable<Book> {

    private String title, author;
    private double price;

    private static int sortingMethod = 1;

    //Constructor with all arguments
    public Book(String title, String author, double price) {
        if (title == null || author == null || price == 0) {
            throw new IllegalArgumentException("String cannot be null");
        }
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Sort method using compareTo
     */
    public static void sort(Book[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int l = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[l]) < 1) {
                    l = j;
                }
            }
            Counter3_1.swap(a, i, l);
        }
    }

    /**
     * Sets the sorting method to be used by compareTo
     */
    public static void setSortingMethod(int i) {
        sortingMethod = i;
    }

    /**
     * Overridden compareTo method,
     * Compares Book objects by title, author or price
     */
    @Override
    public int compareTo(Book o) {

        if (sortingMethod == 1) {
            if (o.title.compareTo(this.title) < 1) {
                return 1;
            }
            return 0;
        } else if (sortingMethod == 2) {
            if (o.author.compareTo(this.author) < 1) {
                return 1;
            }
            return 0;
        } else {
            if (o.price < this.price) {
                return 1;
            }
            return 0;
        }
    }

    /**
     * Object reference to String
     */
    public String toString() {
        return "Title: " + title + " Author: " + author + " Price: " + price;
    }
}