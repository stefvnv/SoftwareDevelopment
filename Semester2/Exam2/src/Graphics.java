import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/*** Question 2
 * Graphics 2D
 * 30/03/22
 * ------------------
 * Stefana Chiritescu
 * A00282343
 */


public class Graphics extends JFrame implements ActionListener {

    //Creates a canvas and button
    private static final CanvasPanel canvas = new CanvasPanel();
    private final JButton resetButton = new JButton("Reset");


    /**
     * Sets GUI title, size, layout and sets resizeable to false
     * Stops program from running after window is closed
     */
    public Graphics() {
        this.setTitle("Graphics");
        this.setSize(800, 800);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * Initializes the GUI
     */
    public void init() {

        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 800;
        c.ipady = 700;

        //Sets grid position and adds the canvas to GUI
        c.gridx = 0;
        c.gridy = 0;
        this.add(canvas, c);

        //Sets grid position and adds reset button to GUI
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 40;
        c.ipady = 10;
        this.add(resetButton, c);

        //Adds action listener to button
        resetButton.addActionListener(this);

        //Sets visibility of GUI to true
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Check if reset button has been clicked
        if (e.getSource() == resetButton) {
            //CanvasPanel.drawShape(g);
        }
    }

    /**
     * Listens for mouse and mouse input drops random shape, removing the previous one
     * Changes colour of shape when shape is clicked
     */
    static class CanvasPanel extends JPanel implements MouseListener, MouseInputListener {

        //Initializes Colour array
        private final Color[] colors = {Color.green, Color.magenta, Color.cyan, Color.black};

        ///Initializes variables
        private Shape shape = new Rectangle2D.Double(0, 0, 0, 0);
        private int colorTracker = 0;
        private boolean pressed = false;


        /**
         * Adds mouse listener, mouse motion listener
         * Sets background colour and preferred size
         */
        public CanvasPanel() {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.setBackground(Color.pink);
            this.setPreferredSize(new Dimension(800, 800));
        }


        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            drawShape(g);

            //Sets colour in array using 'colourTracker' and fills shape
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(colors[colorTracker]);
            g2d.fill(shape);
        }


        /**
         * Draws the shape
         */
        public void drawShape(java.awt.Graphics g) {
            //casts g to Graphics2D
            Graphics2D g2d = (Graphics2D) g;

            //Sets paint to black and fills shape
            g2d.setPaint(Color.green);
            shape = new Ellipse2D.Double(canvas.getWidth() / 2, canvas.getHeight() / 2, 50, 50);
            g2d.fill(shape);
        }


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            //Sets 'pressed' to true when shape is clicked
            if (shape.contains(e.getPoint())) {
                pressed = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            //Sets pressed to false and repaints
            pressed = false;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            int xx = e.getX();
            int yy = e.getY();

            int prevX = 0;
            int prevY = 0;

            if (pressed) {

                //Y-axis (up and down)
                //Changes colour of clicked shape and repaints
                if (yy > prevY) {
                    if (shape.contains(e.getPoint())) {
                        colorTracker = (colorTracker + 1) % colors.length;

                        double w = shape.getBounds().getWidth();
                        double h = shape.getBounds().getHeight();
                        double x = e.getX() + (w);
                        double y = e.getY() + (h);

                        shape = new Rectangle2D.Double(x, y, w, h);
                    }
                    repaint();

                }

                //X-axis (Left and right)
                if (xx > prevX) {
                    //shape = new Ellipse2D.Double(e.getWidth() - 20, e.getY() - 20, 60, 60);
                    //prevX = xx;
                }
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public static void main(String[] args) {
        new Graphics().init();
    }
}

