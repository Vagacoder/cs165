package counterStarter;

import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame implements CountChangedListener {

	private JPanel panel;
	private JButton btnIncrement;
	private JLabel label;
	private MyCounter myCounter;

	public static void main(String[] args) {
		new MainWindow().setVisible(true);
	}


	public MainWindow() {

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 205));
		panel.setFont(new Font("Arial", Font.PLAIN, 18));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnIncrement = new JButton("INCREMENT");
		btnIncrement.setOpaque(true);
		btnIncrement.setFocusPainted(false);
		btnIncrement.setFont(new Font("Arial", Font.PLAIN, 18));
		btnIncrement.setForeground(Color.DARK_GRAY);
		btnIncrement.setBackground(new Color(240, 240, 240));
		btnIncrement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnIncrement_actionPerformed(e);
			}

		});
		btnIncrement.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER)
					do_btnIncrement_actionPerformed(null);
			}
		});

		btnIncrement.setBounds(79, 51, 160, 40);
		panel.add(btnIncrement);

		label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.BOLD, 36));
		label.setBounds(79, 114, 160, 48);
		panel.add(label);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320, 240);

		myCounter = new MyCounter();
		myCounter.addCountChangedListener(this);
	}


	protected void do_btnIncrement_actionPerformed(ActionEvent e) {
		// * Solution 1: none observer, directly update instance variable ======
		// println("Button Clicked");
		// int count = Integer.parseInt(this.label.getText());
		// this.label.setText(++count + "");
		// =====================================================================

		// * Solution 2: Observer pattern ======================================
		this.myCounter.increment();
		// =====================================================================
	}


	@Override
	public void countChanged(MyCounter source) {
		int count = source.count;
		this.label.setText(count + "");
	}

}
