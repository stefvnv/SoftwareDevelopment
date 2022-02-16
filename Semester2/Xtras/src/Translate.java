import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Translate extends JFrame {

    private CanvasPanel drawingArea = new CanvasPanel();

    public Translate()
    {
        setTitle("Translate Shape");
        setSize(750,750);




    }
    public void init()
    {
        add(drawingArea);
        setVisible(true);
    }

    static class CanvasPanel extends JPanel{

        public CanvasPanel()
        {

        }

        public void doSomething(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setPaint(new Color(150, 150, 150));
            g2d.fillRect(20, 20, 80, 50);
            g2d.translate(150, 50);
            g2d.fillRect(20, 20, 80, 50);

            g2d.dispose();

            super.paintComponent(g);


            g2d = (Graphics2D) g.create();

            g2d.setPaint(new Color(150, 150, 150));
            g2d.fillRect(20, 20, 80, 50);
            g2d.translate(180, -50);
            g2d.rotate(Math.PI/4);
            g2d.fillRect(80, 80, 80, 50);

            g2d.dispose();

            super.paintComponent(g);

            g2d = (Graphics2D) g.create();

            g2d.setColor(new Color(150, 150, 150));
            g2d.fillRect(20, 20, 80, 50);

            AffineTransform tx1 = new AffineTransform();
            tx1.translate(110, 22);
            tx1.scale(0.5, 0.5);

            g2d.setTransform(tx1);
            g2d.fillRect(0, 0, 80, 50);

            AffineTransform tx2 = new AffineTransform();
            tx2.translate(170, 20);
            tx2.scale(1.5, 1.5);

            g2d.setTransform(tx2);
            g2d.fillRect(0, 0, 80, 50);


            //g2d.dispose();

            super.paintComponent(g);

            g2d = (Graphics2D) g.create();

            g2d.setPaint(Color.blue);

            for (int i = 1; i <= 10; i++) {

                float alpha = i * 0.1f;
                AlphaComposite alcom = AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER, alpha);
                g2d.setComposite(alcom);
                g2d.fillRect(50 * i, 20, 40, 40);
            }

        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            doSomething(g);
        }
    }


    public static void main(String[] args) {
        new Translate().init();
    }
}
