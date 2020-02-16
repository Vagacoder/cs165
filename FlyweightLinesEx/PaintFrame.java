import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PaintFrame() {
        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        pane.add(panel, BorderLayout.CENTER);
        this.setBounds(10,10, 300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        Graphics g = panel.getGraphics();
        Line line = LineFactory.getLine(Color.RED);
        line.draw(g, 20, 10, 100, 80);
        line.draw(g, 30, 10, 110, 80);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
    }
}