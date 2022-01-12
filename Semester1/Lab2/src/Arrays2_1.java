public class Arrays2_1 {

    //1. Create a method which reads in an array of chars and finds the index of a certain letter
    /**
     *
     * @param ca character array
     * @param c character
     * @return Index of the matching character in array
     *  if not found, returns -1
     */
    public static int findIndex(char [] ca, char c) {
        for(int i = 0; i < ca.length; i++) {
            if(ca[i] == c) {
                return i;
            }
        }
        return -1;
    }

    //2. Create a method similar to that in part 1 which finds the index in a 2D array
    /**
     *
     * @param ca character array
     * @param c character
     * @return Index of the matching character in 2D array
     *  if not found, returns
     */
    public static int[] findIndex(char [][] ca, char c) {
        int []  returnInt = {-1,-1};

        for (int i = 0; i < ca.length; i++) {
            int rT = findIndex(ca[i], c);

            if(rT != -1) {
                returnInt[0] = i;
                returnInt[1] = rT;
                return returnInt;
            }
        }
        return returnInt;
    }

    //3. Using the methods above, create an application which takes in two words and joins them on a matching char
    /**
     * Takes a 2D character array and two strings, find the index of the first common character
     * Finds the offset needed to achieve the desired format for printing the intersection
     * @param c character
     * @param s string 1
     * @param t string 2
     */
    public static void crossword(char[][] c, String s, String t) {
        int down = 0;
        int across = 0;

        for(char letter : t.toCharArray()) {
            across++;
            down = findIndex(s.toCharArray(), letter);

            if (down != -1) {
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            c[i][across - 1] = s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            c[down][i] = t.charAt(i);
        }
    }

    /**
     * Declares the array, invokes the Crossword method and prints the result
     */
    public static void template() {

        char [][] cArr = new char[6][6];
        crossword(cArr, "Donkey", "Monkey");

        for (char[] chars : cArr) {
            for (int j = 0; j < cArr[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    //Calls 'template' method
    public static void main(String[] args) {
        template();
    }
}
