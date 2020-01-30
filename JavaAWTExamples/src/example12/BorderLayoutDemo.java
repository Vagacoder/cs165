package example12;

import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends Frame{

    private Button btn1, btn2, btn3, btn4, btn5;

    public BorderLayoutDemo(){
        this.setLayout(new BorderLayout());
        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");
        btn4 = new Button("Button 4");
        btn5 = new Button("Button 5");
        this.add(btn1, BorderLayout.NORTH);
        this.add(btn2, BorderLayout.SOUTH);
        this.add(btn3, BorderLayout.EAST);
        this.add(btn4, BorderLayout.WEST);
        this.add(btn5, BorderLayout.CENTER);
        this.setTitle("Border Layout Demo");
        this.setSize(300, 200);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        this.setVisible(true);
    }


    public static void main(String[] args){
        new BorderLayoutDemo();
    }
}