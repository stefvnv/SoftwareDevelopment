import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterController{

    private CurrencyConverterGUI view = new CurrencyConverterGUI();
    private MultipleCurrencyConverter model = new MultipleCurrencyConverter();

    public ConverterController(){
        this.view = new CurrencyConverterGUI();
        this.model = new MultipleCurrencyConverter();

        new USDactionAdd();
        new EURactionAdd();
        new CHYactionAdd();
        new GBPactionAdd();

        view.init();
    }


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

            //Calculates USD to EUR, converts to string, outputs to view
            view.setText_eur(Double.toString(model.convertUSDtoEUR(parse)));
            view.setText_cny(Double.toString(model.convertUSDtoCNY(parse)));
            view.setText_gbp(Double.toString(model.convertUSDtoGBP(parse)));
        }
    }

    class EURactionAdd implements ActionListener {

        public EURactionAdd(){
            view.actionAddEUR(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from USD textbox
            String content = view.getText_eur();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountEUR(parse);

            //Calculates USD to EUR, converts to string, outputs to view
            view.setText_usd(Double.toString(model.convertEURtoUSD(parse)));
            view.setText_cny(Double.toString(model.convertEURtoCNY(parse)));
            view.setText_gbp(Double.toString(model.convertEURtoGBP(parse)));
        }

    }

    class CHYactionAdd implements ActionListener {

        public CHYactionAdd(){
            view.actionAddCHY(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from USD textbox
            String content = view.getText_cny();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountCNY(parse);

            //Calculates USD to EUR, converts to string, outputs to view
            view.setText_usd(Double.toString(model.convertCNYtoUSD(parse)));
            view.setText_eur(Double.toString(model.convertCNYtoEUR(parse)));
            view.setText_gbp(Double.toString(model.convertCNYtoGBP(parse)));
        }
    }


    class GBPactionAdd implements ActionListener {

        public GBPactionAdd(){
            view.actionAddGBP(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gets text from USD textbox
            String content = view.getText_gbp();

            //Converts text to double
            double parse = Double.parseDouble(content);

            //Saves the converted number to the model
            model.setAmountGBP(parse);

            //Calculates USD to EUR, converts to string, outputs to view
            view.setText_usd(Double.toString(model.convertGBPtoUSD(parse)));
            view.setText_eur(Double.toString(model.convertGBPtoEUR(parse)));
            view.setText_cny(Double.toString(model.convertGBPtoCNY(parse)));
        }
    }

    public static void main(String[] args) {
        //Initializes a new GUI
        new ConverterController();
    }
}