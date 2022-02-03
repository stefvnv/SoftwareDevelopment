import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

//3. Create a GUI with a canvas, multiple shapes can be dropped using buttons to select colour and shape, each dropped shape must be movable around the canvas
public class ShapesB extends JFrame implements ActionListener {

    GridBagConstraints gbc = new GridBagConstraints();

    //Creates colour and shape labels
    private final JLabel label_colour = new JLabel("Colour", SwingConstants.CENTER);
    private final JLabel label_shape = new JLabel("Shape", SwingConstants.CENTER);

    private final JButton button_green = new JButton("GREEN");
    private final JButton button_magenta = new JButton("MAGENTA");
    private final JButton button_cyan = new JButton("CYAN");
    private final JButton button_black = new JButton("BLACK");

    private final JButton button_square = new JButton("SQUARE");
    private final JButton button_circle = new JButton("CIRCLE");
    private final JButton button_rectangle = new JButton("RECTANGLE");
    private final JButton button_oval = new JButton("OVAL");

    //Creates a canvas
    private final CanvasPanel canvas = new CanvasPanel();


    /**
     * Sets GUI title, size, layout and sets resizeable to false
     * Stops program from running after window is closed
     */
    public ShapesB() {
        this.setTitle("Shapes - B");
        this.setSize(980, 800);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Colours
        this.button_green.setBackground(new Color(60, 200, 30));
        this.button_magenta.setBackground(new Color(180, 40, 180));
        this.button_cyan.setBackground(new Color(90, 220, 230));
        this.button_black.setBackground(new Color(0, 0, 0));
        this.button_green.setForeground(new Color(255, 255, 255));
        this.button_magenta.setForeground(new Color(255, 255, 255));
        this.button_cyan.setForeground(new Color(255, 255, 255));
        this.button_black.setForeground(new Color(255, 255, 255));

        //Fonts
        this.label_colour.setFont(new Font("TimesRoman", Font.BOLD, 28));
        this.label_shape.setFont(new Font("TimesRoman", Font.BOLD, 28));
    }


    /**
     * Initializes the GUI
     */
    public void init() {

        //Adds panels and canvas to GUI
        gbc.ipadx = 140;

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(button_green, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(button_magenta, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(button_cyan, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add(button_black, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(button_square, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(button_circle, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        this.add(button_rectangle, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        this.add(button_oval, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_colour, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_shape, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipady = 600;
        gbc.gridwidth = 4;
        this.add(canvas, gbc);

        //Adds Action Listener to each button
        button_green.addActionListener(this);
        button_magenta.addActionListener(this);
        button_cyan.addActionListener(this);
        button_black.addActionListener(this);
        button_square.addActionListener(this);
        button_circle.addActionListener(this);
        button_rectangle.addActionListener(this);
        button_oval.addActionListener(this);

        //Sets visibility of GUI to true
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_green) {
            canvas.changeColour(1);
        }
        if (e.getSource() == button_magenta) {
            canvas.changeColour(2);
        }
        if (e.getSource() == button_cyan) {
            canvas.changeColour(3);
        }
        if (e.getSource() == button_black) {
            canvas.changeColour(4);
        }


        if (e.getSource() == button_square) {
            canvas.changeShape(2);

        }
        if (e.getSource() == button_circle) {
            canvas.changeShape(1);

        }
        if (e.getSource() == button_rectangle) {
            canvas.changeShape(4);

        }
        if (e.getSource() == button_oval) {
            canvas.changeShape(3);

        }
    }

    class CanvasPanel extends JPanel implements MouseListener, MouseInputListener {

        private ArrayList<Shape> shapes = new ArrayList<>();
        private ArrayList<Color> colours = new ArrayList<>();
        private boolean pressed = false;

        private int activeShape = -1;
        private int currentShape = 1;
        private int currentColour = 1;

        private Color[] colors = {Color.green, Color.magenta, Color.cyan, Color.black};
        private int colorTracker = 0;


        public CanvasPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.pink);
            setPreferredSize(new Dimension(800, 800));
        }

        public void changeShape(int s) {
            currentShape = s;
        }

        public void changeColour(int c) {
            currentShape = c;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(colors[colorTracker]);

            for(Shape s : shapes){
                g2d.fill(s);
            }
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            for (Shape shape : shapes) {
                if (shape.contains(e.getPoint())) {
                    //colorTracker = (colorTracker + 1) % colors.length;
                    repaint();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            for (int i = 0; i < shapes.size(); i++) {
                Shape shape = shapes.get(i);

                if (shape.contains(e.getPoint())) {
                    activeShape = i;
                    pressed = true;
                    break;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            //Sets shape to one of four shapes assigned to numbers (1-4) when pressed variable is false
            if (!pressed) {
                if (currentShape == 1) {
                    shapes.add(new Ellipse2D.Double(e.getX() - 20, e.getY() - 20, 40, 40));
                }else if (currentShape == 2) {
                    shapes.add(new Rectangle2D.Double(e.getX() - 20, e.getY() - 20, 40, 40));
                }else if (currentShape == 3) {
                    shapes.add(new Oval(e.getX() - 20, e.getY() - 20, 60, 40));
                }else {
                    shapes.add(new Rectang(e.getX() - 20, e.getY() - 20, 40, 60));
                }
            }
            pressed = false;
            activeShape = -1;
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
        if (pressed){
            Shape s = shapes.get(activeShape);

            if (s instanceof Oval) {
                shapes.set(activeShape, new Oval(e.getX() - 20, e.getY() - 20, 60, 40));
            }else if (s instanceof Rectang) {
                shapes.set(activeShape, new Rectang(e.getX() - 20, e.getY() - 20, 40, 60));
            }else if (s instanceof Ellipse2D) {
                shapes.set(activeShape, new Ellipse2D.Double(e.getX() - 20, e.getY() - 20, 40, 40));
            }else if (s instanceof Rectangle2D) {
                shapes.set(activeShape, new Rectangle2D.Double(e.getX() - 20, e.getY() - 20, 40, 40));
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}

    class Oval extends Ellipse2D.Double{
        public Oval(int one, int two, int three, int four) {
            super(one, two, three, four);
        }
    }

    class Rectang extends Rectangle2D.Double{
        public Rectang(int one, int two, int three, int four){
            super(one, two, three, four);
        }
    }

    public static void main(String[] args) {
        new ShapesB().init();
    }
}
