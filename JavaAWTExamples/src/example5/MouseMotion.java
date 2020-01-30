package example5;

/*

*/

import java.awt.*;
import java.awt.event.*;

public class MouseMotion extends Frame implements MouseListener, MouseMotionListener, WindowListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private TextField mouseClickX;
    private TextField mouseClickY;
    private TextField mousePositionX;
    private TextField mousePositionY;

    public MouseMotion(){
        this.setLayout(new FlowLayout());

        this.add(new Label("Click X: "));
        this.mouseClickX = new TextField(10);
        this.mouseClickX.setEditable(false);
        this.add(this.mouseClickX);
        this.add(new Label("Click Y: "));
        this.mouseClickY = new TextField(10);
        this.mouseClickY.setEditable(false);
        this.add(this.mouseClickY);

        this.add(new Label("Position X: "));
        this.mousePositionX = new TextField(10);
        this.mousePositionX.setEditable(false);
        this.add(this.mousePositionX);
        this.add(new Label("Position Y: "));
        this.mousePositionY = new TextField(10);
        this.mousePositionY.setEditable(false);
        this.add(this.mousePositionY);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addWindowListener(this);

        this.setTitle("Mouse Motion Demo");
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MouseMotion mm = new MouseMotion();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.mouseClickX.setText("" + x);
        this.mouseClickY.setText("" + y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.mousePositionX.setText("" + x);
        this.mousePositionY.setText("" + y);
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