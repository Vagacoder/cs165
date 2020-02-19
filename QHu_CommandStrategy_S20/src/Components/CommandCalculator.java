package Components;

/*
* CS165 Assignment: Command and Strategy, Calculator

* SRS:
1. Must support at least +, -, *, /.
2. Commands that have been executed can be undone, with unlimited levels of undo.
3. The log maintains a list of commands that have been executed.
4. Must use the Command design pattern to support undo-ing and logging of operations.
5. Must be able to write the log to a file in the following formats: plain text 
    or XML (you choose the element names).
6. Must use the Strategy design pattern to encapsulate each log-file-saving algorithm 
    in separate classes that implement a common interface.

STARTER PROJECT:  
You are welcome to use the Swing-based CalculatorStarter project.  
It's got buttons and menu items with predefined event handlers.  
But note that this is just an option - you can use any framework or language you 
like as long as it meets the requirements described above.

* Task
1. UML ... done
2. Project skeleton ... 
3. GUI
4. Basic arithmetic command
5. Test
6. Extension of commands

*/


import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class CommandCalculator extends JFrame {

	private static final long serialVersionUID = 1951338852754249783L;

	private JPanel panel;
	private JButton oneButton;
	private JLabel resultLabel;
	private DisplayPanel display;

	private JButton clearButton;
	private JButton btnUndo;
	private JButton plusMinusButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	private JButton divideButton;
	private JButton multiplyButton;
	private JButton sixButton;
	private JButton fiveButton;
	private JButton fourButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton plusButton;
	private JButton equalsButton;
	private JButton periodButton;
	private JButton zeroButton;
	private JMenuItem quitMenuItem;
	private JSeparator separator;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		new CommandCalculator().setVisible(true);
	}


	public CommandCalculator() {
		this.panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		this.oneButton = new JButton("1");
		oneButton.setBorderPainted(false);
		oneButton.setOpaque(true);
		oneButton.setFocusable(false);
		oneButton.setDoubleBuffered(true);
		oneButton.setFont(new Font("Arial", Font.PLAIN, 48));
		oneButton.setForeground(new Color(51, 51, 51));
		oneButton.setBackground(new Color(255, 255, 255));
		oneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_oneButton_actionPerformed(e);
			}

		});
		oneButton.setBounds(10, 432, 96, 96);
		panel.add(oneButton);

		// * Display Panel
		// this.resultLabel = new JLabel("0");
		// resultLabel.setBorder(new EmptyBorder(3, 8, 0, 40));
		// resultLabel.setBackground(new Color(51, 51, 51));
		// resultLabel.setOpaque(true);
		// resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		// resultLabel.setForeground(new Color(255, 255, 255));
		// resultLabel.setFont(new Font("Arial", Font.PLAIN, 72));
		// resultLabel.setBounds(0, 0, 443, 96);
		// panel.add(resultLabel);
		this.display = new DisplayPanel();
		this.display.setBounds(0, 0, 443, 96);
		panel.add(display);

		twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_twoButton_actionPerformed(e);
			}
		});
		twoButton.setBorderPainted(false);
		twoButton.setOpaque(true);
		twoButton.setForeground(new Color(51, 51, 51));
		twoButton.setFont(new Font("Arial", Font.PLAIN, 48));
		twoButton.setFocusable(false);
		twoButton.setDoubleBuffered(true);
		twoButton.setBackground(Color.WHITE);
		twoButton.setBounds(118, 432, 96, 96);
		panel.add(twoButton);

		this.plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_plusButton_actionPerformed(e);
			}
		});
		plusButton.setBorderPainted(false);
		plusButton.setOpaque(true);
		plusButton.setForeground(new Color(51, 51, 51));
		plusButton.setFont(new Font("Arial", Font.PLAIN, 48));
		plusButton.setFocusable(false);
		plusButton.setDoubleBuffered(true);
		plusButton.setBackground(new Color(255, 204, 0));
		plusButton.setBounds(334, 432, 96, 96);
		panel.add(plusButton);

		this.threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_threeButton_actionPerformed(e);
			}
		});
		threeButton.setBorderPainted(false);
		threeButton.setOpaque(true);
		threeButton.setForeground(new Color(51, 51, 51));
		threeButton.setFont(new Font("Arial", Font.PLAIN, 48));
		threeButton.setFocusable(false);
		threeButton.setDoubleBuffered(true);
		threeButton.setBackground(Color.WHITE);
		threeButton.setBounds(226, 432, 96, 96);
		panel.add(threeButton);

		this.zeroButton = new JButton(" 0");
		zeroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_zeroButton_actionPerformed(e);
			}
		});
		zeroButton.setHorizontalAlignment(SwingConstants.LEFT);
		zeroButton.setBorderPainted(false);
		zeroButton.setOpaque(true);
		zeroButton.setForeground(new Color(51, 51, 51));
		zeroButton.setFont(new Font("Arial", Font.PLAIN, 48));
		zeroButton.setFocusable(false);
		zeroButton.setDoubleBuffered(true);
		zeroButton.setBackground(Color.WHITE);
		zeroButton.setBounds(16, 540, 198, 96);
		panel.add(zeroButton);

		this.multiplyButton = new JButton("x");
		multiplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_multiplyButton_actionPerformed(e);
			}
		});
		multiplyButton.setBorderPainted(false);
		multiplyButton.setOpaque(true);
		multiplyButton.setForeground(new Color(51, 51, 51));
		multiplyButton.setFont(new Font("Arial", Font.PLAIN, 48));
		multiplyButton.setFocusable(false);
		multiplyButton.setDoubleBuffered(true);
		multiplyButton.setBackground(new Color(255, 204, 0));
		multiplyButton.setBounds(334, 216, 96, 96);
		panel.add(multiplyButton);

		periodButton = new JButton(".");
		periodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_periodButton_actionPerformed(e);
			}
		});
		periodButton.setBorderPainted(false);
		periodButton.setOpaque(true);
		periodButton.setForeground(new Color(51, 51, 51));
		periodButton.setFont(new Font("Arial", Font.PLAIN, 48));
		periodButton.setFocusable(false);
		periodButton.setDoubleBuffered(true);
		periodButton.setBackground(Color.WHITE);
		periodButton.setBounds(226, 540, 96, 96);
		panel.add(periodButton);

		equalsButton = new JButton("=");
		equalsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_equalsButton_actionPerformed(e);
			}
		});
		equalsButton.setBorderPainted(false);
		equalsButton.setOpaque(true);
		equalsButton.setForeground(new Color(51, 51, 51));
		equalsButton.setFont(new Font("Arial", Font.PLAIN, 48));
		equalsButton.setFocusable(false);
		equalsButton.setDoubleBuffered(true);
		equalsButton.setBackground(new Color(255, 204, 0));
		equalsButton.setBounds(334, 540, 96, 96);
		panel.add(equalsButton);

		sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_sixButton_actionPerformed(e);
			}
		});
		sixButton.setBorderPainted(false);
		sixButton.setOpaque(true);
		sixButton.setForeground(new Color(51, 51, 51));
		sixButton.setFont(new Font("Arial", Font.PLAIN, 48));
		sixButton.setFocusable(false);
		sixButton.setDoubleBuffered(true);
		sixButton.setBackground(Color.WHITE);
		sixButton.setBounds(226, 324, 96, 96);
		panel.add(sixButton);

		fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_fiveButton_actionPerformed(e);
			}
		});
		fiveButton.setBorderPainted(false);
		fiveButton.setOpaque(true);
		fiveButton.setForeground(new Color(51, 51, 51));
		fiveButton.setFont(new Font("Arial", Font.PLAIN, 48));
		fiveButton.setFocusable(false);
		fiveButton.setDoubleBuffered(true);
		fiveButton.setBackground(Color.WHITE);
		fiveButton.setBounds(118, 324, 96, 96);
		panel.add(fiveButton);

		fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_fourButton_actionPerformed(e);
			}
		});
		fourButton.setBorderPainted(false);
		fourButton.setOpaque(true);
		fourButton.setForeground(new Color(51, 51, 51));
		fourButton.setFont(new Font("Arial", Font.PLAIN, 48));
		fourButton.setFocusable(false);
		fourButton.setDoubleBuffered(true);
		fourButton.setBackground(Color.WHITE);
		fourButton.setBounds(10, 324, 96, 96);
		panel.add(fourButton);

		sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_sevenButton_actionPerformed(e);
			}
		});
		sevenButton.setBorderPainted(false);
		sevenButton.setOpaque(true);
		sevenButton.setForeground(new Color(51, 51, 51));
		sevenButton.setFont(new Font("Arial", Font.PLAIN, 48));
		sevenButton.setFocusable(false);
		sevenButton.setDoubleBuffered(true);
		sevenButton.setBackground(Color.WHITE);
		sevenButton.setBounds(10, 216, 96, 96);
		panel.add(sevenButton);

		eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_eightButton_actionPerformed(e);
			}
		});
		eightButton.setBorderPainted(false);
		eightButton.setOpaque(true);
		eightButton.setForeground(new Color(51, 51, 51));
		eightButton.setFont(new Font("Arial", Font.PLAIN, 48));
		eightButton.setFocusable(false);
		eightButton.setDoubleBuffered(true);
		eightButton.setBackground(Color.WHITE);
		eightButton.setBounds(118, 216, 96, 96);
		panel.add(eightButton);

		nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_nineButton_actionPerformed(e);
			}
		});
		nineButton.setBorderPainted(false);
		nineButton.setOpaque(true);
		nineButton.setForeground(new Color(51, 51, 51));
		nineButton.setFont(new Font("Arial", Font.PLAIN, 48));
		nineButton.setFocusable(false);
		nineButton.setDoubleBuffered(true);
		nineButton.setBackground(Color.WHITE);
		nineButton.setBounds(226, 216, 96, 96);
		panel.add(nineButton);

		divideButton = new JButton("\u00f7");
		divideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_divideButton_actionPerformed(e);
			}
		});
		divideButton.setBorderPainted(false);
		divideButton.setOpaque(true);
		divideButton.setForeground(new Color(51, 51, 51));
		divideButton.setFont(new Font("Arial", Font.PLAIN, 48));
		divideButton.setFocusable(false);
		divideButton.setDoubleBuffered(true);
		divideButton.setBackground(new Color(255, 204, 0));
		divideButton.setBounds(334, 108, 96, 96);
		panel.add(divideButton);

		clearButton = new JButton("ac");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_clearButton_actionPerformed(e);
			}
		});
		clearButton.setBorderPainted(false);
		clearButton.setOpaque(true);
		clearButton.setForeground(new Color(51, 51, 51));
		clearButton.setFont(new Font("Arial", Font.PLAIN, 26));
		clearButton.setFocusable(false);
		clearButton.setDoubleBuffered(true);
		clearButton.setBackground(new Color(255, 255, 255));
		clearButton.setBounds(10, 108, 96, 96);
		panel.add(clearButton);

		btnUndo = new JButton("undo");
		btnUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnUndo_actionPerformed(e);
			}
		});
		btnUndo.setBorderPainted(false);
		btnUndo.setOpaque(true);
		btnUndo.setForeground(new Color(51, 51, 51));
		btnUndo.setFont(new Font("Arial", Font.PLAIN, 26));
		btnUndo.setFocusable(false);
		btnUndo.setDoubleBuffered(true);
		btnUndo.setBackground(new Color(255, 255, 255));
		btnUndo.setBounds(118, 108, 96, 96);
		panel.add(btnUndo);

		plusMinusButton = new JButton("\u00b1");
		plusMinusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_plusMinusButton_actionPerformed(e);
			}
		});
		plusMinusButton.setBorderPainted(false);
		plusMinusButton.setOpaque(true);
		plusMinusButton.setForeground(new Color(51, 51, 51));
		plusMinusButton.setFont(new Font("Arial", Font.PLAIN, 48));
		plusMinusButton.setFocusable(false);
		plusMinusButton.setDoubleBuffered(true);
		plusMinusButton.setBackground(new Color(255, 255, 255));
		plusMinusButton.setBounds(226, 108, 96, 96);
		panel.add(plusMinusButton);

		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_subtractButton_actionPerformed(e);
			}
		});
		subtractButton.setOpaque(true);
		subtractButton.setForeground(UIManager.getColor("Button.foreground"));
		subtractButton.setFont(new Font("Arial", Font.PLAIN, 48));
		subtractButton.setFocusable(false);
		subtractButton.setDoubleBuffered(true);
		subtractButton.setBorderPainted(false);
		subtractButton.setBackground(new Color(255, 204, 0));
		subtractButton.setBounds(334, 324, 96, 96);
		panel.add(subtractButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnFile);

		JMenuItem saveAsXmlMenuItem = new JMenuItem("Save as XML");
		saveAsXmlMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_saveAsXmlMenuItem_actionPerformed(e);
			}
		});
		saveAsXmlMenuItem.setMnemonic('x');

		saveAsXmlMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
		mnFile.add(saveAsXmlMenuItem);

		JMenuItem saveAsTextMenuItem = new JMenuItem("Save as TXT");
		saveAsTextMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_saveAsTextMenuItem_actionPerformed(e);
			}
		});
		saveAsTextMenuItem.setMnemonic('t');
		saveAsTextMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
		mnFile.add(saveAsTextMenuItem);

		separator = new JSeparator();
		mnFile.add(separator);

		quitMenuItem = new JMenuItem("Quit");
		quitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_quitMenuItem_actionPerformed(e);
			}
		});
		quitMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
		quitMenuItem.setMnemonic('Q');
		mnFile.add(quitMenuItem);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(443, 700);

	}


	protected void do_saveAsXmlMenuItem_actionPerformed(ActionEvent e) {
		println("Save as XML");
	}


	protected void do_saveAsTextMenuItem_actionPerformed(ActionEvent e) {
		println("Save as text");
	}


	protected void do_quitMenuItem_actionPerformed(ActionEvent e) {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}


	protected void do_oneButton_actionPerformed(ActionEvent e) {
		println("1 clicked");
	}


	protected void do_zeroButton_actionPerformed(ActionEvent e) {
		println("0 clicked");
	}


	protected void do_twoButton_actionPerformed(ActionEvent e) {
		println("2 clicked");
	}


	protected void do_threeButton_actionPerformed(ActionEvent e) {
		println("3 clicked");
	}


	protected void do_fourButton_actionPerformed(ActionEvent e) {
		println("4 clicked");
	}


	protected void do_fiveButton_actionPerformed(ActionEvent e) {
		println("5 clicked");
	}


	protected void do_sixButton_actionPerformed(ActionEvent e) {
		println("6 clicked");
	}


	protected void do_sevenButton_actionPerformed(ActionEvent e) {
		println("7 clicked");
	}


	protected void do_eightButton_actionPerformed(ActionEvent e) {
		println("8 clicked");
	}


	protected void do_nineButton_actionPerformed(ActionEvent e) {
		println("9 clicked");
	}


	protected void do_clearButton_actionPerformed(ActionEvent e) {
		println("ac clicked");
	}


	protected void do_btnUndo_actionPerformed(ActionEvent e) {
		println("undo clicked");
	}


	protected void do_plusMinusButton_actionPerformed(ActionEvent e) {
		println("\u00b1 clicked");
	}


	protected void do_divideButton_actionPerformed(ActionEvent e) {
		println("\u00f7 clicked");
	}


	protected void do_multiplyButton_actionPerformed(ActionEvent e) {
		println("x clicked");
	}


	protected void do_subtractButton_actionPerformed(ActionEvent e) {
		println("- clicked");
	}


	protected void do_plusButton_actionPerformed(ActionEvent e) {
		println("+ clicked");

	}


	protected void do_equalsButton_actionPerformed(ActionEvent e) {
		println("= clicked");
	}


	protected void do_periodButton_actionPerformed(ActionEvent e) {
		println(". clicked");
	}
}
