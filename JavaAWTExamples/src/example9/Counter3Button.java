package example9;

import java.awt.*;
import java.awt.event.*;

public class Counter3Button extends Frame{

    private TextField display;
    private Button countUp, countDown, reset;
    private int count;

    public Counter3Button(){
        this.setLayout(new FlowLayout());

        this.display = new TextField("0", 10);
        this.display.setEditable(false);
        this.add(display);

        this.countUp = new Button("Add One");
        this.countDown = new Button("Subtract One");
        this.reset = new Button("Reset");
        this.countUp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("" + ++count);
            }
            
        });
        this.countDown.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("" + --count);
            }

        }); 
        this.reset.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {        
                count = 0;
                display.setText("" + count);
            }

        });

        this.add(countUp);
        this.add(countDown);
        this.add(reset);


        this.setTitle("Counter with 3 Buttons");
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

    public static void main(String[] args){

        Counter3Button c3 = new Counter3Button();
    }
}