package example7;

import java.awt.*;
import java.awt.event.*;

public class CounterNamedInnerClass extends Frame{


    private TextField display;
    private Button countBtn;
    private int count = 0;

    public CounterNamedInnerClass(){
        this.setLayout(new FlowLayout());
        this.add(new Label("Counter: "));
        this.display = new TextField("0", 10);
        this.display.setEditable(false);
        this.add(display);

        countBtn = new Button("Add One");
        countBtn.addActionListener(new BtnListener());
        this.add(countBtn);

        this.setTitle("Counter using Named Inner Class");
        this.setSize(300, 200);
        this.addWindowListener(new WinListener());
        this.setVisible(true);
    }

    class BtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            CounterNamedInnerClass.this.display.setText("" + count);
        } 
    }

    class WinListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowClosing(WindowEvent e) {
            CounterNamedInnerClass.this.dispose();

        }

        @Override
        public void windowClosed(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowIconified(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowActivated(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            // TODO Auto-generated method stub

        }
        
    }

    public static void main(String[] args){
        CounterNamedInnerClass cni = new CounterNamedInnerClass();
    }
}