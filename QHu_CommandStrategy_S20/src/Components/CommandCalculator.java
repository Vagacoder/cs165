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
2. Project skeleton ... done
3. GUI ... done may need improvement
4. Basic arithmetic command ... done
5. Test ... 
6. Extension of commands

*/


import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// import static java.lang.System.*;
// import static org.apache.commons.lang3.StringUtils.*;
// import javax.swing.border.LineBorder;
// import javax.swing.border.EmptyBorder;

public class CommandCalculator extends JFrame {

	private static final long serialVersionUID = 1951338852754249783L;

	private JPanel panel;

	private DisplayPanel display;
	private ButtonPanel buttonPanel;
	private LogManager logManager;

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

		// * Log Manager
		this.logManager = new LogManager();

		// * Display Panel
		this.display = new DisplayPanel();
		this.display.setBounds(0, 0, 450, 96);
		panel.add(display);

		// * Button Panel
		this.buttonPanel = new ButtonPanel(this.display, this.logManager);
		this.buttonPanel.setBounds(0, 100, 450, 800);
		panel.add(buttonPanel);


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
		setSize(450, 910);

	}


	protected void do_saveAsXmlMenuItem_actionPerformed(ActionEvent e) {
		println("Save as XML");
		this.logManager.saveLog("Xml");
	}


	protected void do_saveAsTextMenuItem_actionPerformed(ActionEvent e) {
		println("Save as text");
		this.logManager.saveLog("Text");
	}


	protected void do_quitMenuItem_actionPerformed(ActionEvent e) {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}
