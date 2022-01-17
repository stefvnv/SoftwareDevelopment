/**
 * Q2 GUI's
 * --------
 * CurrencyExchange by Stefana Chiritescu
 * A00282343
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintWriter;

//i. Create a GUI to calculate the currency exchange between Yuan(RMB) and Euro
public class CurrencyExchange extends JFrame implements ActionListener, WindowListener {

    private String output = "";

    private final Container contentPane = this.getContentPane();

    private final JLabel eLabel = new JLabel("€:");
    private final JLabel dLabel = new JLabel("¥:");

    private final JTextField eArea = new JTextField(10);
    private final JTextField dArea = new JTextField(10);

    private double cValue, fValue;

    public CurrencyExchange() {
        this.setSize(400,100);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        this.setTitle("Currency Exchange");
    }

    public void init() {
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(0,1,0,1);

        gbc.gridx = 1;
        gbc.gridy = 1;

        contentPane.add(eLabel, gbc);

        gbc.gridx = 2;

        contentPane.add(dLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 1;
        gbc.gridy = 2;

        contentPane.add(eArea, gbc);

        gbc.gridx = 2;

        contentPane.add(dArea, gbc);

        eArea.addActionListener(this);

        dArea.addActionListener(this);

        this.setVisible(true);
    }

    //Current exchange rates as of 5:20pm, 11/18/2021
    public double exchange(double d, char c) {
        if (c == '€') {
            double ans =  Math.round((d * 7.2572621) * 100.00) / 100.00;
            output = "€" + d + " EUR converted to CNY is ¥" + ans;
            return ans;
        }
        else {
            double ans =  Math.round((d * 0.13779301) * 100.00) / 100.00;
            output = "¥" + d + " CNY converted to EUR is €" + ans;
            return ans;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == eArea) {
            cValue = Double.parseDouble(eArea.getText());
            fValue = exchange(cValue, '€');
        }
        else{
            fValue = Double.parseDouble(dArea.getText());
            cValue = exchange(fValue, '¥');
        }

        eArea.setText(""+cValue);
        dArea.setText(""+fValue);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window starting...");
    }

    //ii. Override the close function to save a file on close giving details of the last conversion
    @Override
    public void windowClosing(WindowEvent e) {
        try {
            //Creates file in PrintWriter
            PrintWriter pw = new PrintWriter("fileOnClose.txt");

            //Prints output string into file
            pw.println(output);
            pw.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    //ii. Override the close function to save a file on close giving details of the last conversion
    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    public static void main(String[] args) {
        new CurrencyExchange().init();
    }
}