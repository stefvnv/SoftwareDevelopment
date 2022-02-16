import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

//2. Create a circle(player) on a canvas, allow the player to move with wasd keys
public class PlayerA extends JFrame implements KeyListener {

    //Creates canvas
    protected final CanvasPanel canvas = new CanvasPanel();


    /**
     * Sets GUI title, size and adds key listener
     * Stops program from running after window is closed
     */
    public PlayerA() {
        this.setTitle("PlayerA");
        this.setSize(800, 800);
        this.addKeyListener(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * Initializes the GUI
     */
    public void init() {
        this.add(canvas);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //When a key is clicked, calls appropriate method
        if (e.getKeyCode() == 68) {
            canvas.stepRight();
        } else if (e.getKeyCode() == 65) {
            canvas.stepLeft();
        } else if (e.getKeyCode() == 87) {
            canvas.stepUp();
        } else if (e.getKeyCode() == 83) {
            canvas.stepDown();
        }
    }

    /**
     * Moves player on canvas according to user input
     */
    static class CanvasPanel extends JPanel {

        //Declares/initializes variables
        private int xPos = 30;
        private int yPos = 20;
        private final int xStep = 50;
        private final int yStep = 50;
        Ellipse2D.Double player = new Ellipse2D.Double(xPos, yPos, 50, 50);


        /**
         * Constructor
         * Sets background colour
         */
        public CanvasPanel() {
            this.setBackground(Color.pink);
        }


        @Override
        public void paintComponent(Graphics g) {

            //Initializes paintComponent and calls 'drawShapes'
            super.paintComponent(g);
            drawShape(g);
        }


        /**
         * Draws the player
         */
        public void drawShape(Graphics g) {

            //casts g to Graphics2D
            Graphics2D g2d = (Graphics2D) g;

            //Sets paint to black and fills 'player'
            g2d.setPaint(Color.black);
            player = new Ellipse2D.Double(xPos, yPos, 50, 50);
            g2d.fill(player);
        }


        /**
         * Steps left
         */
        public void stepLeft() {
            xPos = xPos - xStep;
            repaint();
        }


        /**
         * Steps right
         */
        public void stepRight() {
            xPos = xPos + xStep;
            repaint();
        }


        /**
         * Steps up
         */
        public void stepUp() {
            yPos = yPos - yStep;
            repaint();
        }


        /**
         * Steps down
         */
        public void stepDown() {
            yPos = yPos + yStep;
            repaint();
        }
    }

    public static void main(String[] args) {
        new PlayerA().init();
    }
}
