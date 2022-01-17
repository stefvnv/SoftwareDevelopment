import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterController{
    private CurrencyConverterGUI view = new CurrencyConverterGUI();
    private MultipleCurrencyConverter model = new MultipleCurrencyConverter();

    /**
     * Controls and connects the model and view together
     */
    public ConverterController(){
        this.view = new CurrencyConverterGUI();
        this.model = new MultipleCurrencyConverter();

        //Creates event listeners
        new USDactionAdd();
        new EURactionAdd();
        new CNYactionAdd();
        new GBPactionAdd();

        //Initializes GUI
        view.init();
    }


    /**
     * USD action listener
     */
    class USDactionAdd implements ActionListener {
        public USDactionAdd(){
            view.actionAddUSD(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from USD textbox
            String content = view.getText_usd();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountUSD(parse);

            //Calculates USD to EUR, CNY and GBP, converts to string, outputs to view
            view.setText_eur(Double.toString(model.convertUSDtoEUR(parse)));
            view.setText_cny(Double.toString(model.convertUSDtoCNY(parse)));
            view.setText_gbp(Double.toString(model.convertUSDtoGBP(parse)));
        }
    }


    /**
     * EUR action listener
     */
    class EURactionAdd implements ActionListener {
        public EURactionAdd(){
            view.actionAddEUR(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from EUR textbox
            String content = view.getText_eur();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountEUR(parse);

            //Calculates EUR to USD, CNY and GBP, converts to string, outputs to view
            view.setText_usd(Double.toString(model.convertEURtoUSD(parse)));
            view.setText_cny(Double.toString(model.convertEURtoCNY(parse)));
            view.setText_gbp(Double.toString(model.convertEURtoGBP(parse)));
        }
    }


    /**
     * CNY action listener
     */
    class CNYactionAdd implements ActionListener {
        public CNYactionAdd(){
            view.actionAddCHY(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from CNY textbox
            String content = view.getText_cny();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountCNY(parse);

            //Calculates CNY to USD, EUR and GBP, converts to string, outputs to view
            view.setText_usd(Double.toString(model.convertCNYtoUSD(parse)));
            view.setText_eur(Double.toString(model.convertCNYtoEUR(parse)));
            view.setText_gbp(Double.toString(model.convertCNYtoGBP(parse)));
        }
    }


    /**
     * GBP action listener
     */
    class GBPactionAdd implements ActionListener {
        public GBPactionAdd(){
            view.actionAddGBP(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from GBP textbox
            String content = view.getText_gbp();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountGBP(parse);

            //Calculates GBP to USD, EUR and CNY, converts to string, outputs to view
            view.setText_usd(Double.toString(model.convertGBPtoUSD(parse)));
            view.setText_eur(Double.toString(model.convertGBPtoEUR(parse)));
            view.setText_cny(Double.toString(model.convertGBPtoCNY(parse)));
        }
    }

    public static void main(String[] args) {
        //Initializes a new controller
        new ConverterController();
    }
}