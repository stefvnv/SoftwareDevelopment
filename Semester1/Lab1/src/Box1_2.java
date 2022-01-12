//2. A class Box complete with getter,setter and constructor  methods, it should have dimensions, name, status(full/empty)
public class Box1_2 {

    private String Box1_2Name;
    private int w, h, d;
    private boolean full = false;

    /**
     * Assign 'Box1_2Name' variable new string,
     *  assign integer values for w, h, d
     */
    public Box1_2() {
        Box1_2Name = "Cardboard";
        w = 1;
        h = 2;
        d = 3;
    }

    /**
     *
     * @param boxLab1_2Name boxLab1_2Name
     * @param w width
     * @param h height
     * @param d depth
     * @param full assign 'full' to boolean variable
     */
    public Box1_2(String boxLab1_2Name, int w, int h, int d, boolean full) {
        this.Box1_2Name = boxLab1_2Name;
        this.full = full;
        this.w = w;
        this.d = d;
        this.h = h;
    }

    /**
     * Calculates area by multiplying width, height and depth
     * @return area
     */
    public int getArea() {
        return w * h * d;
    }

    /**
     * Returns 'Box1_2Name', area of box and boolean into a string
     * @return Box1_2Name, area method, full boolean
     */
    public String toString() {
        return "Box name: " + Box1_2Name + "\nBox area is: " + this.getArea() + "\nStatus of box(full/empty): " + full;
    }

    //Assign values to 'Box1_2Name' and prints it
    public static void main(String[] args) {
        Box1_2 b = new Box1_2("plastic", 10, 10, 10, false);
        System.out.println(b);
    }
}