//3. Create a GUI which can update a display for all currencies based on the input of an amount in any currency field

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends JFrame{

    private JLabel label_usd = new JLabel("$", SwingConstants.CENTER);
    private JLabel label_eur = new JLabel("€", SwingConstants.CENTER);
    private JLabel label_cny = new JLabel("¥", SwingConstants.CENTER);
    private JLabel label_gbp = new JLabel("£", SwingConstants.CENTER);

    private JTextField text_usd = new JTextField();
    private JTextField text_eur = new JTextField();
    private JTextField text_cny = new JTextField();
    private JTextField text_gbp = new JTextField();


    public CurrencyConverterGUI(){
        this.setTitle("Currency Converter");
        this.setSize(300,100);
        this.setLayout(new GridLayout(2, 4));
        this.setResizable(false);

        //Colours
        this.getContentPane().setBackground(new Color(70,70,70));
        this.text_usd.setBackground(new Color(200,160,180));
        this.text_eur.setBackground(new Color(200,160,180));
        this.text_cny.setBackground(new Color(200,160,180));
        this.text_gbp.setBackground(new Color(200,160,180));

        this.label_usd.setForeground(new Color(200,200,200));
        this.label_eur.setForeground(new Color(200,200,200));
        this.label_cny.setForeground(new Color(200,200,200));
        this.label_gbp.setForeground(new Color(200,200,200));
    }

    public void init(){
        this.add(label_usd);
        this.add(label_eur);
        this.add(label_cny);
        this.add(label_gbp);

        this.add(text_usd);
        this.add(text_eur);
        this.add(text_cny);
        this.add(text_gbp);

        this.setVisible(true);
    }


    public void actionAddUSD(ActionListener d){
        text_usd.addActionListener(d);

    }

    public void actionAddEUR(ActionListener e){
        text_eur.addActionListener(e);

    }

    public void actionAddCHY(ActionListener c){
        text_cny.addActionListener(c);

    }

    public void actionAddGBP(ActionListener p){
        text_gbp.addActionListener(p);

    }




    public String getText_usd() {
        return text_usd.getText();
    }

    public void setText_usd(String text) {
        text_usd.setText(text);
    }

    public String getText_eur() {
        return text_eur.getText();
    }

    public void setText_eur(String text) {
        text_eur.setText(text);
    }

    public String getText_cny() {
        return text_cny.getText();
    }

    public void setText_cny(String text) {
        text_cny.setText(text);
    }

    public String getText_gbp() {
        return text_gbp.getText();
    }

    public void setText_gbp(String text) {
        text_gbp.setText(text);
    }
}