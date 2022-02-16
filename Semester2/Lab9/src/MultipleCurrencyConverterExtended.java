public class MultipleCurrencyConverterExtended extends MultipleCurrencyConverter implements BaseCurrencyExtended{

    public MultipleCurrencyConverterExtended(){}
    /**
     * Converts USD to EUR
     */
    @Override
    public  double convertUSDtoEUR(double d) {
        return Math.round((d * BaseCurrencyExtended.EUR) * 100.00) / 100.00;
    }


    /**
     * Converts USD to CNY
     */
    @Override
    public  double convertUSDtoCNY(double d) {
        return Math.round((d * BaseCurrencyExtended.CNY) * 100.00) / 100.00;
    }


    /**
     * Converts USD to GBP
     */
    @Override
    public double convertUSDtoGBP(double d) {
        return Math.round((d * BaseCurrencyExtended.GBP) * 100.00) / 100.00;
    }


    /**
     * Converts EUR to CNY
     */
    @Override
    public double convertEURtoCNY(double d) {
        return Math.round(((convertEURtoUSD(d)) * BaseCurrencyExtended.CNY) * 100.00) / 100.00;
    }


    /**
     * Converts EUR to GBP
     */
    @Override
    public double convertEURtoGBP(double d) {
        return Math.round(((convertEURtoUSD(d)) * BaseCurrencyExtended.GBP) * 100.00) / 100.00;
    }


    /**
     * Converts CNY to USD
     */
    @Override
    public double convertCNYtoUSD(double d) {
        return Math.round((d / BaseCurrencyExtended.CNY) * 100.00) / 100.00;
    }


    /**
     * Converts CNY to EUR
     */
    @Override
    public double convertCNYtoEUR(double d) {
        return Math.round(((convertCNYtoUSD(d)) * BaseCurrencyExtended.EUR) * 100.00) / 100.00;
    }


    /**
     * Converts CNY to GBP
     */
    @Override
    public double convertCNYtoGBP(double d) {
        return Math.round(((convertCNYtoUSD(d)) * BaseCurrencyExtended.GBP) * 100.00) / 100.00;
    }


    /**
     * Converts GBP to USD
     */
    @Override
    public double convertGBPtoUSD(double d) {
        return Math.round((d / BaseCurrencyExtended.GBP) * 100.00) / 100.00;
    }


    /**
     * Converts GBP to EUR
     */
    @Override
    public double convertGBPtoEUR(double d) {
        return Math.round(((convertGBPtoUSD(d)) * BaseCurrencyExtended.EUR) * 100.00) / 100.00;
    }


    /**
     * Converts GBP to CNY
     */
    @Override
    public double convertGBPtoCNY(double d) {
        return Math.round(((convertGBPtoUSD(d)) * BaseCurrencyExtended.CNY) * 100.00) / 100.00;
    }
}
