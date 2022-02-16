import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;

public class CurrencyConverterJsoup {

    public static double converter(String from, String to) {
        try {
            double amount = 1;
            Document doc = Jsoup.connect(String.format("https://www.xe.com/currencyconverter/convert/?Amount=%f&From=%s&To=%s", amount, from, to)).get();

            Elements elements = doc.select("p");
            for (Element element : elements) {
                String classes = element.className();
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