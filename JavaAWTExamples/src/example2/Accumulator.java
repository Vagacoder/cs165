package example2;

import java.awt.*;
import java.awt.event.*;


public class Accumulator extends Frame implements ActionListener{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Label inputLabel;
    private Label outputLabel;
    private TextField inputText;
    private TextField outputText;
    private int sum = 0;

    public Accumulator (){

        this.setLayout(new FlowLayout());
        this.inputLabel = new Label("Enter an Integer: ");
        this.add(this.inputLabel);
 
        this.inputText = new TextField(10);
        this.inputText.addActionListener(this);
        this.add(this.inputText);

        this.outputLabel = new Label("The Accumulated Sum is: ");
        this.add(this.outputLabel);

        this.outputText = new TextField(10);
        this.outputText.setEditable(false);
        this.add(this.outputText);

        this.setTitle("Accumulator using AWT");
        this.setSize(350,120);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
        int number = Integer.parseInt(this.inputText.getText());
        this.sum += number;
        this.outputText.setText(""+this.sum);
        }catch(Exception ex){
            this.outputText.setText("Wrong input!");
        }
    }

    public static void main(String[] args){
        new Accumulator();

    }

}