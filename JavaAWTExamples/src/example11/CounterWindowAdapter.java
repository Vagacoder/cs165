package example11;

import java.awt.*;
import java.awt.event.*;

public class CounterWindowAdapter extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = -4507675711044228356L;
    private TextField display;
    private Button countUp;
    private int count;

    public CounterWindowAdapter() {
        this.setLayout(new FlowLayout());

        this.display = new TextField("0", 10);
        this.display.setEditable(false);
        this.add(display);
        this.countUp = new Button("Add One");
        this.countUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("" + ++count);
            }

        });

        this.add(countUp);

        this.setTitle("Counter using one Listener");
        this.setSize(400, 300);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing ...");
                dispose();
            }
        });
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CounterWindowAdapter();

    }
}