package example12;

import java.awt.*;
import java.awt.event.*;

public class FlowLayoutDemo extends Frame{
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    public FlowLayoutDemo(){
        this.setLayout(new FlowLayout());
        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");
        btn4 = new Button("Button 4");
        btn5 = new Button("Button 5");
        btn6 = new Button("Button 6");
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.setTitle("Flow Layout Demo");
        this.setSize(300, 400);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        this.setVisible(true);
    }

    public static void main(String[] args){

        new FlowLayoutDemo();
        
    }
}