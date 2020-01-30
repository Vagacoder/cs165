package example8;

import java.awt.*;
import java.awt.event.*;

public class CounterAnonymousInner extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = -2642765822956739624L;
    private TextField display;
    private Button countBtn;
    private int count;

    public CounterAnonymousInner(){
        this.setLayout(new FlowLayout());
        this.add(new Label("Count: "));
        this.display = new TextField("0", 10);
        this.display.setEditable(false);
        this.add(display);

        this.countBtn = new Button("Add One");
        this.countBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                CounterAnonymousInner.this.count++;
                CounterAnonymousInner.this.display.setText("" + count);
            }
            
        });
        this.add(countBtn);

        this.setTitle("Counter using Anonymous Inner Class");
        this.setSize(400, 300);
        this.addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				CounterAnonymousInner.this.dispose();
				
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
        CounterAnonymousInner cai = new CounterAnonymousInner();
    }
    
}