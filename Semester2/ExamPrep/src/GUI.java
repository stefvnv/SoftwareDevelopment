import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*** Question 1
 * Graphical User Interface
 * ------------------
 * Stefana Chiritescu
 * A00282343
 */

public class GUI extends JFrame implements ActionListener {

    private JTabbedPane tabbed_pane = new JTabbedPane();
    private JTable table;
    private JScrollPane scroll_pane;

    private JPanel panel_constituency = new JPanel();
    private JPanel panel_edit = new JPanel();
    private JPanel panel_all = new JPanel();

    private JComboBox<String> choices;

    private JTextPane text_area = new JTextPane();

    private JButton add = new JButton("Add");
    private JButton remove = new JButton("Remove");

    private ReadCSV csv;

    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Graphical User Interface");
        this.setSize(750, 750);
    }

    public void init() {
        File selected_file = null;
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setCurrentDirectory(new File("."));

        int result = file_chooser.showOpenDialog(this.getContentPane());


        if (result == JFileChooser.APPROVE_OPTION) {
            selected_file = file_chooser.getSelectedFile();
        }
        csv = new ReadCSV(selected_file);

        DefaultComboBoxModel<String> options = new DefaultComboBoxModel<>();
        choices = new JComboBox<>(options);


        for (LocalEleStat stat : csv.getStats()) {
            String area = stat.getLocalElectoralArea();

            if (options.getIndexOf(area) == -1) {
                options.addElement(area);
            }
        }
        choices.addActionListener(this);


        /*
          Panel 1
          Design a Graphical User Interface program which takes in the “Local Election Dataset” stores it into a data
          structure (ArrayList) and using a dropdown selection box reveals all Candidates from a chosen constituency
         */
        panel_constituency.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 5, 0, 5);

        c.gridx = 0;
        c.gridy = 0;

        panel_constituency.add(choices, c);

        c.gridy = 1;
        panel_constituency.add(text_area, c);

        String area = (String) choices.getSelectedItem();
        setArea(area);


        /*
          Panel 2
          The User should be able to add and remove candidates
         */
        add.addActionListener(this);
        panel_edit.add(add);

        panel_edit.add(remove);


        /*
          Panel 3
          Create a new view (tabbed view) in the GUI to show a list of all Candidates, give the user the ability to sort
          each of the fields (Remember to use the comparable interface)
         */
        String[] cols = csv.getHeadings();

        DefaultTableModel model = new DefaultTableModel(cols, 0);
        int no = 1;

        for (LocalEleStat stat : csv.getStats()) {
            model.addRow(new Object[]{
                    no,
                    stat.getSurname(),
                    stat.getFirstName(),
                    stat.getAddress(),
                    stat.getParty(),
                    stat.getLocalElectoralArea()
            });
            no++;
        }
        table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        scroll_pane = new JScrollPane(table);
        panel_all.add(scroll_pane);

        //--------------------------------------


        tabbed_pane.add("Select Area", panel_constituency);
        tabbed_pane.add("Add/remove candidate", panel_edit);
        tabbed_pane.add("Listed Candidates", panel_all);

        this.add(tabbed_pane);


        this.setVisible(true);
    }


    public void setArea(String area) {
        text_area.setText(" ");
        StringBuilder display = new StringBuilder("<html><table>");
        for (LocalEleStat stat : csv.getStats()) {
            if (stat.getLocalElectoralArea().equals(area)) {
                display.append(stat.toString());
            }
        }
        display.append("</table></html>");

        text_area.setContentType("text/html");
        text_area.setText(display.toString());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choices) {
            String area = (String) choices.getSelectedItem();
            setArea(area);
        }
        if (e.getSource() == add) {
            csv.addStat(new LocalEleStat("1,Rock,Noel,\"69 Pinewood Crescent, Glasnevin North, Dublin 9\",Fine Gael,Artane/Whitehall,,,,,"));
        }
        if (e.getSource() == remove){
            //remove stat
        }
    }

    public static void main(String[] args) {
        new GUI().init();
    }
}
