package example3;

/*

*/

import java.awt.*;
import java.awt.event.*;

public class WindowEventDemo extends Frame implements ActionListener, WindowListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private TextField display;
    private Button countBtn;
    private int count = 0;

    public WindowEventDemo() {
        this.setLayout(new FlowLayout());
        this.add(new Label("Counter"));

        this.display = new TextField("0", 10);
        this.display.setEditable(false);
        this.add(this.display);

        this.countBtn = new Button("Count");
        this.add(this.countBtn);

        this.countBtn.addActionListener(this);
        this.addWindowListener(this);

        this.setTitle("WindowEvent Demo");
        this.setSize(400, 300);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.count++;
        this.display.setText("" + this.count);
    }

    @Override
    public void windowOpened(java.awt.event.WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
        this.dispose();
        System.out.println("Window closing ...");
    }

    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        System.out.println("Window closed");

    }

    @Override
    public void windowIconified(java.awt.event.WindowEvent e) {
        System.out.println("Window Iconified");
    }

    @Override
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        System.out.println("Window Deiconified");
    }

    @Override
    public void windowActivated(java.awt.event.WindowEvent e) {
        System.out.println("Window Actived");
    }

    @Override
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        System.out.println("Window Deactived");
    }

    public static void main(String[] args) {
        WindowEventDemo we = new WindowEventDemo();
    }

}