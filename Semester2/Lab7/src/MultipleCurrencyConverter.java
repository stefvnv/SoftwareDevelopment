//2. Extend the CurrencyConverter class to become MultipleCurrencyConverter

public class MultipleCurrencyConverter extends CurrencyConverter implements BaseCurrency{
    private double baseCurrency, amountUSD, amountEUR, amountCNY, amountGBP;

    public MultipleCurrencyConverter(){this.baseCurrency = USD;}


    public static double convertUSDtoEUR(double d) {
        return Math.round((d * EUR) * 100.00) / 100.00;
    }

    public static double convertUSDtoCNY(double d) {
        return Math.round((d * CNY) * 100.00) / 100.00;
    }

    public static double convertUSDtoGBP(double d) {
        return Math.round((d * GBP) * 100.00) / 100.00;
    }

    public static double convertEURtoUSD(double d) {
        return Math.round((d / EUR) * 100.00) / 100.00;
    }

    public static double convertEURtoCNY(double d) {
        return Math.round(((convertEURtoUSD(d)) * CNY) * 100.00) / 100.00;
    }

    public static double convertEURtoGBP(double d) {
        return Math.round(((convertEURtoUSD(d)) * GBP) * 100.00) / 100.00;
    }

    public static double convertCNYtoUSD(double d) {
        return Math.round((d / CNY) * 100.00) / 100.00;
    }

    public static double convertCNYtoEUR(double d) {
        return Math.round(((convertCNYtoUSD(d)) * EUR) * 100.00) / 100.00;
    }

    public static double convertCNYtoGBP(double d) {
        return Math.round(((convertCNYtoUSD(d)) * GBP) * 100.00) / 100.00;
    }

    public static double convertGBPtoUSD(double d) {
        return Math.round((d / GBP) * 100.00) / 100.00;
    }

    public static double convertGBPtoEUR(double d) {
        return Math.round(((convertGBPtoUSD(d)) * EUR) * 100.00) / 100.00;
    }

    public static double convertGBPtoCNY(double d) {
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
