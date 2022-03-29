import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

/*** Question 1
 * Graphical User Interface - GUI
 * ------------------
 * Stefana Chiritescu
 * A00282343
 */

public class GUI extends JFrame implements ActionListener, ChangeListener, WindowListener {

    //Initialized tabbed pane, table, panels, combobox, text pane, buttons, labels and text fields
    private final JTabbedPane tabbedPane = new JTabbedPane();

    private final JTable table = new JTable();

    private final JPanel p1 = new JPanel();
    private final JPanel p2 = new JPanel();
    private final JPanel p3 = new JPanel();

    private JComboBox<String> choices;

    private final JTextPane textArea = new JTextPane();

    private final JButton addButton = new JButton("Add");
    private final JButton removeButton = new JButton("Remove");

    private final JLabel surnameLabel = new JLabel("Surname:");
    private final JLabel firstnameLabel = new JLabel("First name:");
    private final JLabel addressLabel = new JLabel("Address:");
    private final JLabel partyLabel = new JLabel("Party:");
    private final JLabel leaLabel = new JLabel("Local Electoral Area:");

    private final JTextField surnameText = new JTextField(12);
    private final JTextField firstnameText = new JTextField(12);
    private final JTextField addressText = new JTextField(12);
    private final JTextField partyText = new JTextField(12);
    private final JTextField leaText = new JTextField(12);

    private ReadCSV csv;

    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("GUI");
        this.setSize(750, 750);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setResizable(false);

        this.textArea.setBackground(new Color(200,160,180));
        this.table.setBackground(new Color(200,160,180));
        this.p3.setBackground(new Color(200,160,180));
    }

    public void init() {

        File selectedFile = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        int result = fileChooser.showOpenDialog(this.getContentPane());

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

        }

        csv = new ReadCSV(selectedFile);

        DefaultComboBoxModel<String> options = new DefaultComboBoxModel<>();
        choices = new JComboBox<>(options);


        for (LocalEleStat stat : csv.getStats()) {

            String area = stat.getLocalElectoralArea();

            if (options.getIndexOf(area) == -1) {
                options.addElement(area);
            }
        }

        choices.addActionListener(this);

        //___________________________________________
        // Panel 1

        p1.setLayout(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 5, 0, 5);

        c.gridx = 0;
        c.gridy = 0;

        c.fill = GridBagConstraints.HORIZONTAL;

        p1.add(choices, c);

        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        p1.add(textArea, c);

        String area = (String) choices.getSelectedItem();
        setArea(area);

        //___________________________________________
        // Panel 2

        p2.setLayout(new GridBagLayout());

        c = new GridBagConstraints();

        updateTable();

        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.9;

        p2.add(scrollPane, c);

        c.fill = GridBagConstraints.NONE;

        c.gridy = 1;
        c.weighty = .1;

        p2.add(removeButton, c);

        removeButton.addActionListener(this);

        //___________________________________________
        // Panel 3

        p3.setLayout(new GridBagLayout());


        GridBagConstraints d = new GridBagConstraints();

        d.insets = new Insets(0, 5, 0, 5);

        d.fill = GridBagConstraints.HORIZONTAL;

        d.gridx = 0;
        d.gridy = 0;

        p3.add(surnameLabel, d);

        d.gridx = 1;
        d.gridy = 0;
        p3.add(surnameText, d);

        d.gridx = 0;
        d.gridy = 1;
        p3.add(firstnameLabel, d);

        d.gridx = 1;
        d.gridy = 1;
        p3.add(firstnameText, d);

        d.gridx = 0;
        d.gridy = 2;
        p3.add(addressLabel, d);

        d.gridx = 1;
        d.gridy = 2;
        p3.add(addressText, d);

        d.gridx = 0;
        d.gridy = 3;
        p3.add(partyLabel, d);

        d.gridx = 1;
        d.gridy = 3;
        p3.add(partyText, d);

        d.gridx = 0;
        d.gridy = 4;
        p3.add(leaLabel, d);

        d.gridx = 1;
        d.gridy = 4;
        p3.add(leaText, d);

        d.gridx = 0;
        d.gridy = 5;
        d.gridwidth = 2;
        p3.add(addButton, d);

        d.fill = GridBagConstraints.BOTH;
        d.weightx = 1.0;
        d.weighty = 1.0;


        //---------------------------------


        tabbedPane.add("Select Area", p1);
        tabbedPane.add("View All", p2);
        tabbedPane.add("Add New", p3);

        tabbedPane.addChangeListener(this);

        this.add(tabbedPane, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void updateTable() {
        String[] cols = csv.getHeadings();

        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (LocalEleStat stat : csv.getStats()) {
            model.addRow(new Object[]{
                    stat.getNo(),
                    stat.getSurname(),
                    stat.getFirstName(),
                    stat.getAddress(),
                    stat.getParty(),
                    stat.getLocalElectoralArea()
            });
        }
        table.setModel(model);
    }

    public void setArea(String area) {
        textArea.setText(" ");
        StringBuilder display = new StringBuilder("<html><table>");
        for (LocalEleStat stat : csv.getStats()) {
            if (stat.getLocalElectoralArea().equals(area)) {
                display.append(stat.toString());

            }

        }
        display.append("</table></html>");

        textArea.setContentType("text/html");
        textArea.setText(display.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choices) {
            String area = (String) choices.getSelectedItem();
            setArea(area);
        }
        if (e.getSource() == addButton) {
            System.out.println("You are a fish");
        }
        if (e.getSource() == removeButton) {
            String value = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
            csv.removeStat(value);
            updateTable();
        }
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {

        JTabbedPane temp = (JTabbedPane) changeEvent.getSource();

        if (temp.getSelectedIndex() == 0) {
            String area = (String) choices.getSelectedItem();
            setArea(area);
        } else if (temp.getSelectedIndex() == 1) {
            updateTable();
        }
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        csv.writeFile();
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public static void main(String[] args) {
        new GUI().init();
    }
}