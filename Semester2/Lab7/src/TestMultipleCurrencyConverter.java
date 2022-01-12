import java.util.Scanner;

public class TestMultipleCurrencyConverter {

    /**
     *
     */
    public static void converter(){
        Scanner input = new Scanner(System.in);

        boolean convert = true;

        while(convert){
            System.out.println("Enter the currency to convert from (USD/EUR/CNY/GBP): ");
            String from = input.next();

            System.out.println("Enter the currency to convert to (USD/EUR/CNY/GBP): ");
            String to = input.next();

            System.out.println("Enter amount to convert: ");
            double amount = 0;

            if (input.hasNextDouble()) {
                amount = input.nextDouble();
            }else{
                System.out.println("Error: Amount must be numerical.");
                converter();
            }

            if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("EUR")) {
                System.out.println(MultipleCurrencyConverter.convertUSDtoEUR(amount));
            } else if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("CNY")) {
                System.out.println(MultipleCurrencyConverter.convertUSDtoCNY(amount));
            } else if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("GBP")) {
                System.out.println(MultipleCurrencyConverter.convertUSDtoGBP(amount));
            } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("USD")) {
                System.out.println(MultipleCurrencyConverter.convertEURtoUSD(amount));
            } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("CNY")) {
                System.out.println(MultipleCurrencyConverter.convertEURtoCNY(amount));
            } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("GBP")) {
                System.out.println(MultipleCurrencyConverter.convertEURtoGBP(amount));
            } else if (from.equalsIgnoreCase("CNY") && to.equalsIgnoreCase("USD")) {
                System.out.println(MultipleCurrencyConverter.convertCNYtoUSD(amount));
            } else if (from.equalsIgnoreCase("CNY") && to.equalsIgnoreCase("EUR")) {
                System.out.println(MultipleCurrencyConverter.convertCNYtoEUR(amount));
            } else if (from.equalsIgnoreCase("CNY") && to.equalsIgnoreCase("GBP")) {
                System.out.println(MultipleCurrencyConverter.convertCNYtoGBP(amount));
            } else if (from.equalsIgnoreCase("GBP") && to.equalsIgnoreCase("USD")) {
                System.out.println(MultipleCurrencyConverter.convertGBPtoUSD(amount));
            } else if (from.equalsIgnoreCase("GBP") && to.equalsIgnoreCase("EUR")) {
                System.out.println(MultipleCurrencyConverter.convertGBPtoEUR(amount));
            } else if (from.equalsIgnoreCase("GBP") && to.equalsIgnoreCase("CNY")) {
                System.out.println(MultipleCurrencyConverter.convertGBPtoCNY(amount));
            } else {
                System.out.println("Error: Enter USD/EUR/CNY/GBP only.");
                converter();
            }

            System.out.println("Would you like to use the converter again? Y/N?");
            if(input.next().equalsIgnoreCase("N")) {
                convert = false;
            }
        }
    }

    public static void main(String[] args) {
        converter();
    }
}
