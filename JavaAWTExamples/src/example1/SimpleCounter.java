package example1;

import java.awt.*;
import java.awt.event.*;

public class SimpleCounter extends Frame implements ActionListener, KeyListener {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Label counterLabel;
  private TextField counterInput;
  private Button counterBtn;
  private Button closeBtn;
  private int count;

  public SimpleCounter() {
    this.count = 0;

    this.setLayout(new FlowLayout());
    this.counterLabel = new Label("Counter");
    this.add(this.counterLabel);

    this.counterInput = new TextField(this.count + "", 10);
    this.counterInput.setEditable(false);
    this.add(this.counterInput);

    this.counterBtn = new Button("Count!");
    this.closeBtn = new Button("Close!");
    this.add(this.counterBtn);
    this.add(this.closeBtn);

    
    this.counterBtn.addActionListener(this);
    this.counterBtn.addKeyListener(this);
    this.closeBtn.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        dispose();
      }
    });
    this.counterInput.addKeyListener(this);
    this.counterLabel.addKeyListener(this);
    this.setTitle("Simple Counter using AWT");
    this.setSize(250, 100);

    this.setVisible(true);
    this.addWindowListener(new WindowListener(){

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
        dispose();
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
      
    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.count++;
    this.counterInput.setText(this.count + "");
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyCode());
    if (e.getKeyCode() == 10){
      this.actionPerformed(null);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  public static void main(String[] args) {

    SimpleCounter ct = new SimpleCounter();
  }

}