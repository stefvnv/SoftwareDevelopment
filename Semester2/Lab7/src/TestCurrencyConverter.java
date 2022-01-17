import java.util.Scanner;

//write a test class to convert to this base currency from Euro
public class TestCurrencyConverter {
    public static void main(String[] args) {
        boolean convert = true;
        double amount;

        Scanner input = new Scanner(System.in);

        //Creates a new instance of CurrencyConverter
        CurrencyConverter currency = new CurrencyConverter();

        //While convert is true
        while (convert){
            System.out.println("Enter amount to be converted(€): ");

            //Stores users input into 'amount' if it's a number and prints converted 'amount'
            if (input.hasNextDouble()) {
                amount = input.nextDouble();
                System.out.println("€" + amount + " EUR converted to USD is $" + currency.convertEURtoUSD(amount));

                //otherwise, prints error message and asks for user input
            }else{
                System.out.println("Error: Amount must be numerical.");
                input.next();
            }

            System.out.println("\nWould you like to use the converter again? Y/N?");

            //Sets 'convert' to false if user enters 'N'
            if (input.next().equalsIgnoreCase("N")) {
                convert = false;
            }
        }
    }
}