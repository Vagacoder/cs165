package examples;

/*
* This class is an example of java.Swing components
* 1. get ContentPane (java.awt.Container) of Frame
* 2. add other Swing components (JLabel, JButton, etc.) to ContentPane.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCounter1 extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 7980211131500329751L;
	private int count = 0;
	private JTextField input;

	public SwingCounter1() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Count: "));
		this.input = new JTextField("0", 10);
		this.input.setEditable(false);
		contentPane.add(input);
		JButton addBtn = new JButton("Add One");
		addBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingCounter1.this.input.setText("" + ++count);
			}

		});
		contentPane.add(addBtn);
		
		this.setTitle("Swing Example 1: Counter");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SwingCounter1();

	}

}
