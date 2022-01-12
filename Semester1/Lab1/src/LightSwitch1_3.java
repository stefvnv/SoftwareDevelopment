//3. A class LightSwitch which has a status of on/off, it also has a random chance to blow while it is being switched on. Use the input of plus to turn on the light and minus to turn off the light. You must constantly poll the keyboard for user input. The application ends when the light blows.
import java.util.Scanner;

public class LightSwitch1_3 {
    static boolean working = true;
    static boolean status = false;

    /**
     * Checks if user entered - or +
     *  if - was entered, light will turn off and print the status
     *  if + was entered, light will turn on and print the status
     *
     * Create variable 'random' to give bulb random chance of blowing (turning off)
     * @param input user entry (-/+)
     */
    public static void checkInput(String input) {
        if(status && input.equals("-")){
            status = false;
            System.out.println("The light is off.");
        }
        else if (!status && input.equals("+")) {
            status = true;
            System.out.println("The light is on.");

            int random  = (int) (Math.random() * 20);
            if (random > 10) {
                //Terminates program
                working =  false;
            }
        }
    }

    /**
     * Asks user for input until + or - is entered,
     *  calls 'checkInput' method
     */
    public static void input() {
        System.out.println("Please enter a valid input of + (on) or - (off): ");

        while (working) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNext()) {
                String input = sc.next();
                if(input.equals("+") || input.equals("-")) {
                    checkInput(input);
                }
                else {
                    System.out.println("Please enter a valid input.");
                }
            }
        }
        System.out.println("The bulb has blown.");
    }

    //Calls 'input' method
    public static void main(String[] args) {
        input();
    }
}