//2. Extend the CurrencyConverter class to become MultipleCurrencyConverter

public class MultipleCurrencyConverter extends CurrencyConverter implements BaseCurrency{
    private final double baseCurrency;
    private double amountUSD;
    private double amountEUR;
    private double amountCNY;
    private double amountGBP;

    public MultipleCurrencyConverter(){this.baseCurrency = USD;}


    /**
     * Converts USD to EUR
     */
    public  double convertUSDtoEUR(double d) {
        return Math.round((d * EUR) * 100.00) / 100.00;
    }


    /**
     * Converts USD to CNY
     */
    public  double convertUSDtoCNY(double d) {
        return Math.round((d * CNY) * 100.00) / 100.00;
    }


    /**
     * Converts USD to GBP
     */
    public double convertUSDtoGBP(double d) {
        return Math.round((d * GBP) * 100.00) / 100.00;
    }


    /**
     * Converts EUR to CNY
     */
    public double convertEURtoCNY(double d) {
        return Math.round(((convertEURtoUSD(d)) * CNY) * 100.00) / 100.00;
    }


    /**
     * Converts EUR to GBP
     */
    public double convertEURtoGBP(double d) {
        return Math.round(((convertEURtoUSD(d)) * GBP) * 100.00) / 100.00;
    }


    /**
     * Converts CNY to USD
     */
    public double convertCNYtoUSD(double d) {
        return Math.round((d / CNY) * 100.00) / 100.00;
    }


    /**
     * Converts CNY to EUR
     */
    public double convertCNYtoEUR(double d) {
        return Math.round(((convertCNYtoUSD(d)) * EUR) * 100.00) / 100.00;
    }


    /**
     * Converts CNY to GBP
     */
    public double convertCNYtoGBP(double d) {
        return Math.round(((convertCNYtoUSD(d)) * GBP) * 100.00) / 100.00;
    }


    /**
     * Converts GBP to USD
     */
    public double convertGBPtoUSD(double d) {
        return Math.round((d / GBP) * 100.00) / 100.00;
    }


    /**
     * Converts GBP to EUR
     */
    public double convertGBPtoEUR(double d) {
        return Math.round(((convertGBPtoUSD(d)) * EUR) * 100.00) / 100.00;
    }


    /**
     * Converts GBP to CNY
     */
    public double convertGBPtoCNY(double d) {
        return Math.round(((convertGBPtoUSD(d)) * CNY) * 100.00) / 100.00;
    }


    public double getAmountUSD() {
        return amountUSD;
    }


    public void setAmountUSD(double amountUSD) {
        this.amountUSD = amountUSD;
    }


    public double getAmountEUR() {
        return amountEUR;
    }


    public void setAmountEUR(double amountEUR) {
        this.amountEUR = amountEUR;
    }


    public double getAmountCNY() {
        return amountCNY;
    }


    public void setAmountCNY(double amountCNY) {
        this.amountCNY = amountCNY;
    }


    public double getAmountGBP() {
        return amountGBP;
    }


    public void setAmountGBP(double amountGBP) {
        this.amountGBP = amountGBP;
    }
}
