package example6;

/*abstract
*/

import java.awt.*;
import java.awt.event.*;

public class KeyEvent extends Frame implements KeyListener, WindowListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TextField input;
    private TextArea display;

    public KeyEvent() {

        this.setLayout(new FlowLayout());
        this.add(new Label("Enter text: "));
        this.input = new TextField(10);
        this.add(input);
        this.add(new Label("Message:"));
        this.display = new TextArea(5, 40);
        this.display.setEditable(false);
        this.add(display);

        this.input.addKeyListener(this);
        this.addWindowListener(this);

        this.setTitle("Key Event Demo");
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        KeyEvent ke = new KeyEvent();
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.display.setText(this.input.getText());
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();

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
}