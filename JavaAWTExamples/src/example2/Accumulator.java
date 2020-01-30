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

        
        // This is how to close AWT window/frame
        // Solution 1 : using WindowAdapter =========================
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        // ==========================================================

        // Solution 2: Outer window listener ========================
            // this.addWindowListener(new closeListener(this));
        // ===========================================================

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

class closeListener implements WindowListener{

    private Frame frame;

    public closeListener(Frame frame){
        this.frame = frame;
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Closing!");
        frame.dispose();
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        // TODO Auto-generated method stub

    }
    
}