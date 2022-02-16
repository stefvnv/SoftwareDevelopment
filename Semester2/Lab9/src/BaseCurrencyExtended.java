public interface BaseCurrencyExtended extends BaseCurrency{

    double EUR = CurrencyConverterJsoup.converter("USD", "EUR");
    double CNY = CurrencyConverterJsoup.converter("USD", "CNY");
    double GBP = CurrencyConverterJsoup.converter("USD", "GBP");
}
