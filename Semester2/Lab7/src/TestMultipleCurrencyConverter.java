import java.util.Scanner;

public class TestMultipleCurrencyConverter {

    /**
     * Converts USD, EUR, CNY, GBP currencies according to user input
     */
    public static void converter() {
        boolean convert = true;
        double amount = 0;

        Scanner input = new Scanner(System.in);

        //Creates a new instance of MultipleCurrencyConverter
        MultipleCurrencyConverter currency = new MultipleCurrencyConverter();

        //While convert is true
        while (convert) {
            System.out.println("\nEnter the currency to convert from (USD/EUR/CNY/GBP): ");

            //Takes user input and stores it into 'from' variable
            String from = input.next();

            System.out.println("\nEnter the currency to convert to (USD/EUR/CNY/GBP): ");

            //Takes user input and stores it into 'to' variable
            String to = input.next();

            System.out.println("\nEnter amount to convert: ");

            //Stores users input into 'amount' if it's a number
            if (input.hasNextDouble()) {
                amount = input.nextDouble();

                //otherwise, prints error message and calls 'converter' method
            } else {
                System.out.println("\nError: Amount must be numerical.");
                converter();
            }

            //Calls a convert method depending on which currencies user inputs and prints the converted 'amount'
            if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("EUR")) {
                System.out.println("\n€" + currency.convertUSDtoEUR(amount));
            } else if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("CNY")) {
                System.out.println("\n¥" + currency.convertUSDtoCNY(amount));
            } else if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("GBP")) {
                System.out.println("\n£" + currency.convertUSDtoGBP(amount));
            } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("USD")) {
                System.out.println("\n$" + currency.convertEURtoUSD(amount));
            } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("CNY")) {
                System.out.println("\n¥" + currency.convertEURtoCNY(amount));
            } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("GBP")) {
                System.out.println("\n£" + currency.convertEURtoGBP(amount));
            } else if (from.equalsIgnoreCase("CNY") && to.equalsIgnoreCase("USD")) {
                System.out.println("\n$" + currency.convertCNYtoUSD(amount));
            } else if (from.equalsIgnoreCase("CNY") && to.equalsIgnoreCase("EUR")) {
                System.out.println("\n€" + currency.convertCNYtoEUR(amount));
            } else if (from.equalsIgnoreCase("CNY") && to.equalsIgnoreCase("GBP")) {
                System.out.println("\n£" + currency.convertCNYtoGBP(amount));
            } else if (from.equalsIgnoreCase("GBP") && to.equalsIgnoreCase("USD")) {
                System.out.println("\n$" + currency.convertGBPtoUSD(amount));
            } else if (from.equalsIgnoreCase("GBP") && to.equalsIgnoreCase("EUR")) {
                System.out.println("\n€" + currency.convertGBPtoEUR(amount));
            } else if (from.equalsIgnoreCase("GBP") && to.equalsIgnoreCase("CNY")) {
                System.out.println("\n¥" + currency.convertGBPtoCNY(amount));

                //Prints error message if incorrect input is entered and calls 'converter' method
            } else {
                System.out.println("\nError: Enter USD/EUR/CNY/GBP only.");
                converter();
            }
            System.out.println("\nWould you like to use the converter again? Y/N?");

            //Sets 'convert' to false if user enters 'N'
            if (input.next().equalsIgnoreCase("N")) {
                convert = false;
            }
        }
    }

    public static void main(String[] args) {
        converter();
    }
}
