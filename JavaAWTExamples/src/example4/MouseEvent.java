package example4;

/*

*/

import java.awt.*;
import java.awt.event.*;

public class MouseEvent extends Frame implements MouseListener, WindowListener {

    private TextField displayMx;
    private TextField displayMy;

    public MouseEvent() {
        this.setLayout(new FlowLayout());

        this.add(new Label("X-Click: "));

        this.displayMx = new TextField(10);
        this.displayMx.setEditable(false);
        this.add(displayMx);

        this.displayMy = new TextField(10);
        this.displayMy.setEditable(false);
        this.add(displayMy);

        this.addMouseListener(this);
        this.addWindowListener(this);
        this.setTitle("Mouse Event Demo");
        this.setSize(400, 300);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.displayMx.setText("" + x);
        this.displayMy.setText("" + y);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        MouseEvent me = new MouseEvent();
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