import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

//1. Create a GUI with a canvas, this canvas implements a mouseactionlistener to gather points on the screen. Create a draw button to connect these points
public class Points extends JFrame implements ActionListener {

    //Creates GridBagConstraints and insets for GridBagLayout
    GridBagConstraints gbc = new GridBagConstraints();
    final Insets insets = new Insets(4, 4, 4, 4);

    //Creates drawing panel and button
    private final DrawingPanel drawing_panel = new DrawingPanel();
    private final JButton button_draw = new JButton("Draw");

    //Initializes variable
    private boolean draw = false;


    /**
     * Sets GUI title, size and layout
     * Sets background colour of drawing area
     */
    public Points() {
        this.setTitle("Points");
        this.setSize(800, 800);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Background colour
        this.drawing_panel.setBackground(new Color(200, 160, 180));
    }


    /**
     * Initializes the GUI
     */
    public void init() {

        //Sets x padding for GridBagLayout and fills horizontally
        gbc.ipadx = 700;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Sets positions and widths for button and drawing panel
        gbc.insets = insets;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        this.add(button_draw, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 700;
        gbc.gridwidth = 2;
        this.add(drawing_panel, gbc);

        //Adds action listener to button
        button_draw.addActionListener(this);

        //Sets visibility of GUI to true
        this.setVisible(true);
    }


    /**
     * Listens for mouse and draws lines in between points on drawing panel
     */
    class DrawingPanel extends JPanel implements MouseListener {

        //Creates array list to store points
        private final ArrayList<Point> points = new ArrayList();


        /**
         * Adds mouse listener and sets background colour
         */
        public DrawingPanel() {
            this.addMouseListener(this);
            this.setBackground(Color.pink);
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            //If there are points on the drawing panel
            if (points.size() > 0) {
                //Draws line/s between points on drawing panel if draw is true
                if (draw) {
                    for (int i = 0; i < points.size() - 1; i++) {
                        g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
                    }
                    //Draws line/s between points on drawing panel
                    g.drawLine(points.get(0).x, points.get(0).y,
                            points.get(points.size() - 1).x,
                            points.get(points.size() - 1).y);
                }
                //Sets draw to false
                draw = false;
            }
            //Sets color and shape for current point
            for (Point p : points) {
                g.setColor(Color.green);
                g.fillOval(p.x - 5, p.y - 5, 10, 10);
            }
        }


        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            //Adds new point to 'points' array at x and y coordinates of mouse and repaints
            points.add(new Point(e.getX(), e.getY()));
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    /**
     * Point constructor
     */
    static class Point {
        int x, y;

        /**
         * @param x co-ordinate
         * @param y co-ordinate
         */
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Draws and repaints if there are more than one point on drawing panel
        if (drawing_panel.points.size() > 1) {
            draw = true;
            drawing_panel.repaint();
        }
    }

    public static void main(String[] args) {
        new Points().init();
    }
}