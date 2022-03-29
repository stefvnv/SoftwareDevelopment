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

    //Initializes tabbed pane, table, panels, combobox, text pane, buttons, labels, text fields and ReadCSV
    private final JTabbedPane tabbedPane = new JTabbedPane();

    private final JTable table = new JTable();

    private final JPanel p1 = new JPanel();
    private final JPanel p2 = new JPanel();
    private final JPanel p3 = new JPanel();

    private JComboBox<String> choices;

    private final JTextPane textArea = new JTextPane();

    private final JButton addButton = new JButton("Add");
    private final JButton removeButton = new JButton("Remove");


    private final JLabel noLabel = new JLabel("Number:");
    private final JLabel surnameLabel = new JLabel("Surname:");
    private final JLabel firstnameLabel = new JLabel("First name:");
    private final JLabel addressLabel = new JLabel("Address:");
    private final JLabel partyLabel = new JLabel("Party:");
    private final JLabel leaLabel = new JLabel("Local Electoral Area:");

    private final JTextField noText = new JTextField(4);
    private final JTextField surnameText = new JTextField(12);
    private final JTextField firstnameText = new JTextField(12);
    private final JTextField addressText = new JTextField(12);
    private final JTextField partyText = new JTextField(12);
    private final JTextField leaText = new JTextField(12);

    private ReadCSV csv;

    /**
     * Sets GUI title, size, layout and sets resizeable to false
     * Adds colour to textboxes and labels
     */
    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("GUI");
        this.setSize(750, 750);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setResizable(false);

        //Colours
        this.textArea.setBackground(new Color(200, 160, 180));
        this.table.setBackground(new Color(200, 160, 180));
        this.p3.setBackground(new Color(200, 160, 180));
    }

    /**
     * Initializes the GUI
     */
    public void init() {

        //Creates file chooser and sets path to current directory
        File selectedFile = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        int result = fileChooser.showOpenDialog(this.getContentPane());

        //Opens selected file
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        //Sets selected file as csv
        csv = new ReadCSV(selectedFile);

        //Creates a combobox
        DefaultComboBoxModel<String> options = new DefaultComboBoxModel<>();
        choices = new JComboBox<>(options);

        //Populates combobox headings with local electoral areas
        for (LocalEleStat stat : csv.getStats()) {
            String area = stat.getLocalElectoralArea();

            if (options.getIndexOf(area) == -1) {
                options.addElement(area);
            }
        }
        choices.addActionListener(this);


        //Adds appropriate items to each panel and sets panels using gridbag layout

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
        addButton.addActionListener(this);
        p3.setLayout(new GridBagLayout());

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        p3.add(noLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        p3.add(noText, c);

        c.gridx = 0;
        c.gridy = 1;
        p3.add(surnameLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        p3.add(surnameText, c);

        c.gridx = 0;
        c.gridy = 2;
        p3.add(firstnameLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        p3.add(firstnameText, c);

        c.gridx = 0;
        c.gridy = 3;
        p3.add(addressLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        p3.add(addressText, c);

        c.gridx = 0;
        c.gridy = 4;
        p3.add(partyLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        p3.add(partyText, c);

        c.gridx = 0;
        c.gridy = 5;
        p3.add(leaLabel, c);

        c.gridx = 1;
        c.gridy = 5;
        p3.add(leaText, c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        p3.add(addButton, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;


        //Add panels to tabbed pane and sets visibility to true
        tabbedPane.add("Select Area", p1);
        tabbedPane.add("View All", p2);
        tabbedPane.add("Add New", p3);
        tabbedPane.addChangeListener(this);

        this.add(tabbedPane, BorderLayout.CENTER);
        this.setVisible(true);
    }


    /**
     * Repopulates table by re-reading arraylist
     */
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


    /**
     * Sets area by populating it with arraylist
     */
    public void setArea(String area) {
        textArea.setText(" ");
        StringBuilder display = new StringBuilder("<html><table>");
        for (LocalEleStat stat : csv.getStats()) {
            if (stat.getLocalElectoralArea().equals(area)) {
                display.append(stat);
            }
        }
        display.append("</table></html>");

        textArea.setContentType("text/html");
        textArea.setText(display.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Sets area to selected choices
        if (e.getSource() == choices) {
            String area = (String) choices.getSelectedItem();
            setArea(area);
        }

        //Gets text from input boxes and adds to csv when addButton is clicked
        if (e.getSource() == addButton) {
            csv.addStat(new LocalEleStat(noText.getText() + "," + surnameText.getText() + "," +
                    firstnameText.getText() + ",\"" + addressText.getText() + "\"," + partyText.getText() + "," +
                    leaText.getText() + ",,,,,"));
            System.out.println(firstnameText.getText() + surnameText.getText() + " was added to candidate list.");
        }

        //Removes selected candidate that was clicked on table from csv when removeButton is clicked
        if (e.getSource() == removeButton) {
            String value = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
            csv.removeStat(value);
            System.out.println(firstnameText.getText() + surnameText.getText() + " was added to candidate list.");
            updateTable();
        }
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {

        JTabbedPane temp = (JTabbedPane) changeEvent.getSource();

        //Checks if a tab is selected and updates the tab
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

        //Calls writeFile method from ReadCSV Class
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

        //Creates an instance of the GUI
        new GUI().init();

    }
}