//1. Create a class CurrencyConverter which implements an Interface BaseCurrency(USD)
public class CurrencyConverter implements BaseCurrency {

    /**
     * Empty constructor
     */
    public CurrencyConverter(){}


    /**
     * Converts EUR to USD
     */
    public double convertEURtoUSD(double d) {
        return Math.round((d / EUR) * 100.00) / 100.00;
    }
}
