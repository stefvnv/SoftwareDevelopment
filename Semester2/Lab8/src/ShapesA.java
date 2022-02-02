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


public class ShapesA extends JFrame implements ActionListener {

    private CanvasPanel canvas = new CanvasPanel();


    public ShapesA() {
        setLayout(new FlowLayout());

        setSize(800,800);
    }

    public void init() {
        add(canvas);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.changeShape();
    }

    class CanvasPanel extends JPanel implements MouseListener, MouseInputListener {

        private Shape shape;
        //private Random shape = new Random();


        private boolean isPressed = false;

        private int activeShape = -1;

        private int currentShape = 1;


        public CanvasPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.GRAY);
            setPreferredSize(new Dimension(700,700));
        }

        public void drawShapes(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.BLUE);

            g2d.fill(shape);
        }

        public void changeShape()
        {
            if (currentShape == 1)
                currentShape = 2;
            else
                currentShape = 1;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            drawShapes(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            if(shape.contains(e.getPoint())) {
                isPressed = true;
            }

            System.out.println("Mouse PRESSED");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(!isPressed) {
                if (currentShape == 1) {
                    shape = (new Ellipse2D.Double(e.getX() -20, e.getY() -20, 40, 40));
                }else{
                    shape = (new Rectangle2D.Double(e.getX() -20, e.getY() -20, 40, 40));
                }
            }

            isPressed = false;

            activeShape = -1;

            repaint();

            System.out.println("Mouse RELEASED");

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(isPressed)
            {
                // s = activeShape;
                if (shape instanceof Ellipse2D)
                {
                    shape = new Ellipse2D.Double(e.getX() - 20, e.getY()- 20, 40,40);
                }
                else {
                    shape = new Rectangle2D.Double(e.getX() - 20, e.getY() - 20, 40, 40);
                }
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //System.out.println("Just Moving");
        }
    }

    public static void main(String[] args) {
        new ShapesA().init();
    }
}
