package example10;

import java.awt.*;
import java.awt.event.*;

import org.w3c.dom.css.Counter;

public class CounterOneListener extends Frame{

    private TextField display;
    private Button countUp, countDown, reset;
    private int count;

    public CounterOneListener(){
        this.setLayout(new FlowLayout());
        BtnListener l = new BtnListener();
        
        this.display = new TextField("0", 10);
        this.display.setEditable(false);
        this.add(display);
        this.countUp = new Button("Add One");
        this.countUp.addActionListener(l);
        this.countDown = new Button("Subtract One");
        this.countDown.addActionListener(l);
        this.reset = new Button("Reset");
        this.reset.addActionListener(l);

        this.add(countUp);
        this.add(countDown);
        this.add(reset);

        this.setTitle("Counter using one Listener");
        this.setSize(400, 300);
        this.addWindowListener(new WindowListener(){

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
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
            
        });
        this.setVisible(true);
    
    }

    private class BtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // Button target = (Button) e.getSource();
            String btnName = e.getActionCommand();
            if(btnName.equals("Add One")){
                count++;
            } else if (btnName.equals("Subtract One")){
                count--;
            }else if (btnName.equals("Reset")){
                count = 0;
            } else {

            }
            display.setText("" + count);
        }
        
    }

    public static void main(String[] args){
        CounterOneListener c1l = new CounterOneListener();
    }
}