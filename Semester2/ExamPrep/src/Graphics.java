import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/*** Question 2
 * Graphics 2D
 * ------------------
 * Stefana Chiritescu
 * A00282343
 */


public class Graphics extends JFrame implements ActionListener {

    //Creates a canvas
    private final CanvasPanel canvas = new CanvasPanel();


    /**
     * Sets GUI title, size, layout and sets resizeable to false
     * Stops program from running after window is closed
     */
    public Graphics() {
        this.setTitle("Shapes - A");
        this.setSize(800, 800);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * Initializes the GUI
     */
    public void init() {

        //Adds the canvas to GUI
        this.add(canvas);

        //Sets visibility of GUI to true
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }


    /**
     * Listens for mouse and mouse input drops random shape, removing the previous one
     * Changes colour of shape when shape is clicked
     */
    static class CanvasPanel extends JPanel implements MouseListener, MouseInputListener {

        //Initializes Colour array
        private final Color[] colors = {Color.green, Color.magenta, Color.cyan, Color.black};

        ///Initializes variables
        private Shape shape = new Rectangle2D.Double(-100, -100, 50, 50);
        private int currentShape = 1;
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


        /**
         * Changes shape to a random of four shapes
         */
        public void changeShape() {
            Random rand = new Random();
            currentShape = rand.nextInt(5 - 1) + 1;
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //Sets colour in array using 'colourTracker' and fills shape
            g2d.setColor(colors[colorTracker]);
            g2d.fill(shape);
        }


        @Override
        public void mouseClicked(MouseEvent e) {

            //Changes colour of clicked shape and repaints
            if (shape.contains(e.getPoint())) {
                colorTracker = (colorTracker + 1) % colors.length;
                repaint();
            }
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

            //Sets shape to one of four shapes and calls 'changeShape' method when pressed variable is false
            if (!pressed) {
                if (currentShape == 1) {
                    shape = new Ellipse2D.Double(e.getX() - 20, e.getY() - 20, 40, 40);
                    changeShape();
                } else if (currentShape == 2) {
                    shape = new Rectangle2D.Double(e.getX() - 20, e.getY() - 20, 60, 40);
                    changeShape();
                } else if (currentShape == 3) {
                    shape = new Ellipse2D.Double(e.getX() - 20, e.getY() - 20, 40, 70);
                    changeShape();
                } else if (currentShape == 4) {
                    shape = new Rectangle2D.Double(e.getX() - 20, e.getY() - 20, 40, 40);
                    changeShape();
                }
            }
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
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public static void main(String[] args) {
        new Graphics().init();
    }
}

