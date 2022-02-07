import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class PlayerA extends JFrame implements KeyListener {

    private final CanvasPanel canvas = new CanvasPanel();


    public PlayerA() {
        setSize(800, 800);
        setTitle("PlayerA");
        addKeyListener(this);
    }

    public void init() {
        add(canvas);
        setVisible(true);
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
            canvas.moveRight();
        } else if (e.getKeyCode() == 65) {
            canvas.moveLeft();
        } else if (e.getKeyCode() == 87) {
            canvas.stepUp();
        }else if (e.getKeyCode() == 83) {
            canvas.stepDown();
        }
    }

    static class CanvasPanel extends JPanel {

        private int xPos, yPos, xStep, yStep;


        public CanvasPanel() {
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

            g2d.setPaint(Color.red);

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);

            g2d.fillRect(xPos, yPos, 50, 50);
        }

        public void moveLeft() {
            xPos = xPos - xStep;
            repaint();
        }

        public void moveRight() {
            xPos = xPos + xStep;
            repaint();
        }

        public void stepUp() {
            yPos = yPos - yStep;
            repaint();
        }

        public void stepDown() {
            yPos = yPos + yStep;
            repaint();
        }
    }

    public static void main(String[] args) {
        new PlayerA().init();
    }
}
