import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//3. Extend the functionality of part 2, create an Arraylist of random shapes once the player is above the shape pressing space will eliminate the shape, the application ends when all shapes are consumed
public class PlayerB extends JFrame implements KeyListener {

    private final CanvasPanel canvas = new CanvasPanel();


    /**
     *
     */
    public PlayerB() {
        this.setSize(800, 800);
        this.setTitle("PlayerA");
        this.addKeyListener(this);
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
        if (e.getKeyCode() == 68) {
            canvas.stepRight();
        } else if (e.getKeyCode() == 65) {
            canvas.stepLeft();
        } else if (e.getKeyCode() == 87) {
            canvas.stepUp();
        }else if (e.getKeyCode() == 83) {
            canvas.stepDown();
        }
    }

    static class CanvasPanel extends JPanel {

        private int xPos;
        private int yPos;
        private final int xStep;
        private final int yStep;


        public CanvasPanel() {
            this.setBackground(Color.pink);

            xPos = 30;
            yPos = 20;
            xStep = 50;
            yStep = 50;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawShapes(g);
        }


        public void drawShapes(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(Color.black);

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHints(rh);

            g2d.fillOval(xPos, yPos, 50, 50);
        }


        /**
         *
         */
        public void stepLeft() {
            xPos = xPos - xStep;
            repaint();
        }


        /**
         *
         */
        public void stepRight() {
            xPos = xPos + xStep;
            repaint();
        }


        /**
         *
         */
        public void stepUp() {
            yPos = yPos - yStep;
            repaint();
        }


        /**
         *
         */
        public void stepDown() {
            yPos = yPos + yStep;
            repaint();
        }
    }

    public static void main(String[] args) {
        new PlayerB().init();
    }
}
