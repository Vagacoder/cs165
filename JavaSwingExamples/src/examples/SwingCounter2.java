package examples;

/*
* This class is an example of java.Swing components
* 1. Add a JPanel to ContentPane (java.awt.Container) of Frame
* 2. Add other components (JLabel, JButton) to JPanel
*/

import java.awt.event.*;
import javax.swing.*;

public class SwingCounter2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -3350786851899502867L;
    private JPanel mainPanel;
    private int count;

    public SwingCounter2() {

        mainPanel = new JPanel();
        this.getContentPane().add(mainPanel);

        mainPanel.add(new JLabel("Count: "));
        JTextField display = new JTextField("0", 10);
        display.setEditable(false);
        mainPanel.add(display);

        JButton addBtn = new JButton("Add One");
        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("" + ++count);
            }
        });
        mainPanel.add(addBtn);

        this.setTitle("Swing Example 2");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        // * Run the GUI codes in the Event-dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingCounter2();
            }
        });
    }
}
