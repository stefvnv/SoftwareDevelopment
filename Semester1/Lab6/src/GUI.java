import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3. Create a GUI for Creating a new Building that changes based on the type selected
public class GUI extends JFrame implements ActionListener {

    //Creates buttons, building, house, apartment and office panels
    private JPanel panel_buttons = new JPanel();
    private JPanel panel_building = new JPanel();
    private JPanel panel_house = new JPanel();
    private JPanel panel_apartment = new JPanel();
    private JPanel panel_office = new JPanel();

    //Creates house, apartment and office buttons
    private JButton button_house = new JButton("Select: House");
    private JButton button_apartment = new JButton("<html>Select: Apartment<br> Block</html>");
    private JButton button_office = new JButton("<html>Select: Office<br> Block</html>");

    //Creates walls and roof labels (used for all building types)
    private JLabel label_walls = new JLabel("Walls: ");
    private JLabel label_roof = new JLabel("Roof: ");

    private JLabel label_rooms = new JLabel("Rooms: ");
    private JLabel label_unit = new JLabel("Unit: ");
    private JLabel label_cubicle = new JLabel("Cubicle: ");


    /**
     * Sets GUI title, size and makes a grid layout
     */
    public GUI() {
        this.setTitle("Building GUI");
        this.setSize(400,400);
        this.setLayout(new GridLayout(5, 0));
    }

    /**
     * Initializes the GUI
     */
    public void init() {

        //Adds panels to GUI
        this.add(panel_buttons);
        this.add(panel_building);
        this.add(panel_house);
        this.add(panel_apartment);
        this.add(panel_office);

        //Sets layout for each panel using a Grid Layout
        panel_buttons.setLayout(new GridLayout(1, 3));
        panel_building.setLayout(new GridLayout(2, 0));
        panel_house.setLayout(new GridLayout(1, 0));
        panel_apartment.setLayout(new GridLayout(1, 0));
        panel_office.setLayout(new GridLayout(1, 0));

        //Adds Action Listener to each button
        button_house.addActionListener(this);
        button_apartment.addActionListener(this);
        button_office.addActionListener(this);

        //Adds all buttons to buttons panel and sets visibility to true
        panel_buttons.add(button_house);
        panel_buttons.add(button_apartment);
        panel_buttons.add(button_office);
        panel_buttons.setVisible(true);

        //Adds walls and roof labels to building panel and sets visibility to true
        panel_building.add(label_walls);
        panel_building.add(label_roof);
        panel_building.setVisible(true);

        //Adds rooms label to house panel and sets visibility to false
        panel_house.add(label_rooms);
        panel_house.setVisible(false);

        //Adds unit label to apartment panel and sets visibility to false
        panel_apartment.add(label_unit);
        panel_apartment.setVisible(false);

        //Adds cubicle label to office panel and sets visibility to false
        panel_office.add(label_cubicle);
        panel_office.setVisible(false);

        //Sets visibility of the GUI to true
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //Initializes a new GUI
        new GUI().init();
    }

    /**
     * Panel visibility action listeners
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_house){
            panel_apartment.setVisible(false);
            panel_office.setVisible(false);
            panel_house.setVisible(true);
        }
        else if(e.getSource() == button_apartment){
            panel_house.setVisible(false);
            panel_office.setVisible(false);
            panel_apartment.setVisible(true);
        }
        else if(e.getSource() == button_office){
            panel_house.setVisible(false);
            panel_apartment.setVisible(false);
            panel_office.setVisible(true);
        }
    }
}