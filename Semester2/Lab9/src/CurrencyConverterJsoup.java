import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;

public class CurrencyConverterJsoup {

    /**
     * Converts from one currency to another using Jsoup
     */
    public static double converter(String from, String to) {
        try {
            double amount = 1;
            Document doc = Jsoup.connect(String.format("https://www.xe.com/currencyconverter/convert/?Amount=%f&From=%s&To=%s", amount, from, to)).get();

            //Creates list of p elements
            Elements elements = doc.select("p");

            //Finds BigRate class inside elements
            for (Element element : elements) {
                String classes = element.className();

                //Scans for and returns the double if found in 'result__BigRate', scanner used to parse
                if (classes.contains("result__BigRate")) {
                    Scanner scan = new Scanner(element.text());
                    return scan.nextDouble();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}