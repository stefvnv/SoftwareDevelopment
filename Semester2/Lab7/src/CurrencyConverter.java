//1. Create a class CurrencyConverter which implements an Interface BaseCurrency(USD)
public class CurrencyConverter implements BaseCurrency {
    private final double baseCurrency;


    /**
     *
     */
    public CurrencyConverter(){
        this.baseCurrency = USD;
    }


    /**
     *
     */
    public CurrencyConverter(double c){
        this.baseCurrency = c;
    }


    /**
     * Converts EUR to USD
     */
    public double convertEURtoUSD(double d) {
        return Math.round((d / EUR) * 100.00) / 100.00;
    }
}
