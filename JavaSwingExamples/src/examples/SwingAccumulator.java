package examples;

/*
*
*/

import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -4793583580954142734L;
    private int sum = 0;
    private JTextField display;

    public SwingAccumulator() {
        JPanel mainPanel = new JPanel();
        this.getContentPane().add(mainPanel);
        mainPanel.add(new JLabel("Total count"));
        display = new JTextField("0", 10);
        display.setEditable(false);
        mainPanel.add(display);
        JButton addBtn = new JButton("Add One");
        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("" + ++sum);
            }
        });
        addBtn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    display.setText("" + ++sum);
                }
            }
        });
        mainPanel.add(addBtn);

        this.setTitle("Swing Accumulator");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SwingAccumulator();
            }
        });
    }
}
