package example12;

import java.awt.*;
import java.awt.event.*;

public class SubPanel extends Frame{

    private Button[] numbers;
    private Button hash, star;
    private TextField display;

    public SubPanel(){

        Panel displayPanel = new Panel(new FlowLayout());
        this.display = new TextField("0", 20);
        displayPanel.add(this.display);

        Panel numbersPanel = new Panel(new GridLayout(4,3));

        numbers = new Button[10];
        for(int i = 0; i < 10; i ++){
            this.numbers[i] = new Button((i+1) + "");
            numbersPanel.add(this.numbers[i]);
        }
        this.star = new Button("*");
        this.hash = new Button("#");
        numbersPanel.add(star);
        numbersPanel.add(hash);

        this.setLayout(new  BorderLayout());
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(numbersPanel,BorderLayout.SOUTH);


        this.setTitle("Sub Panel Demo");
        this.setSize(300, 200);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        this.setVisible(true);
    }


    public static void main(String[] args){
        new SubPanel();
    }
}