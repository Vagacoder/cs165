package example2;

import java.awt.*;
import java.awt.event.*;


public class Accumulator extends Frame{


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
        this.outputLabel = new Label("The Accumulated Sum is: ");
        this.add(this.outputLabel);
    }

    public static void main(String[] args){


    }
}