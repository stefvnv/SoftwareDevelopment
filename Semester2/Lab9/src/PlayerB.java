import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

//3. Extend the functionality of part 2, create an Arraylist of random shapes once the player is above the shape pressing space will eliminate the shape, the application ends when all shapes are consumed
public class PlayerB extends PlayerA {

    //Creates canvas
    protected final CanvasPanelB canvas = new CanvasPanelB();


    /**
     * Calls super and sets title
     */
    public PlayerB() {
        super();
        this.setTitle("PlayerB");
    }


    /**
     * Initializes the GUI
     */
    public void init() {
        this.add(canvas);
        this.setVisible(true);
        canvas.addShapes();
    }


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
        } else if (e.getKeyCode() == 32) {
            canvas.eliminate();
        }
    }


    /**
     * Moves player on canvas according to user input
     * Eliminates randomly generated shapes when player collides with them and space is clicked
     */
    class CanvasPanelB extends PlayerA.CanvasPanel {

        //Initializes arrays
        private final ArrayList<Shape> shapes = new ArrayList<>();

        //Initialize variables
        Random rand = new Random();


        /**
         * Adds random shapes to array
         */
        public void addShapes() {
            int width = canvas.getWidth();
            int height = canvas.getHeight();

            for (int i = 0; i < 5; i++) {
                shapes.add(new Rectangle2D.Double(rand.nextInt(width - 25), rand.nextInt(height - 25), 50, 50));
                shapes.add(new Ellipse2D.Double(rand.nextInt(width - 25), rand.nextInt(height - 25), 50, 50));
            }
        }


        @Override
        public void paintComponent(Graphics g) {

            //Initializes paintComponent and Graphics2D
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //Sets draw and fill shape
            for (Shape s : shapes) {
                g2d.setColor(Color.black);
                g2d.draw(s);
                g2d.setColor(Color.magenta);
                g2d.fill(s);
            }
            //Sets colour to black and fills 'player'
            g2d.setColor(Color.BLACK);
            g2d.fill(player);
        }


        /**
         * Steps left
         */
        public void stepLeft() {
            super.stepLeft();
        }


        /**
         * Steps right
         */
        public void stepRight() {
            super.stepRight();
        }


        /**
         * Steps up
         */
        public void stepUp() {
            super.stepUp();
        }


        /**
         * Steps down
         */
        public void stepDown() {
            super.stepDown();
        }


        /**
         * Eliminates shape when collision occurs with player
         */
        public void eliminate() {
            try {

                //Removes current shape if it intersects with player
                for (Shape s : shapes) {
                    if (super.player.intersects(s.getBounds2D())) {
                        shapes.remove(s);
                        canvas.repaint();
                    }
                }
            } catch (ConcurrentModificationException ignored) {
            }

            //Exits application if no shapes are left in array
            if (shapes.isEmpty()) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new PlayerB().init();
    }
}