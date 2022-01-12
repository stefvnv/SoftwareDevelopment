//1. Create a class CurrencyConverter which implements an Interface BaseCurrency(USD)
public class CurrencyConverter implements BaseCurrency {
    private double baseCurrency;

    public CurrencyConverter(){
        this.baseCurrency = USD;
    }

    public CurrencyConverter(double c){
        this.baseCurrency = c;
    }

    public static double convertEURtoUSD(double d) {
        return Math.round((d / EUR) * 100.00) / 100.00;
    }
}
