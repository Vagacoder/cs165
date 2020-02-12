package undolinesex;

import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

	private DrawPanel panel;

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		new MainWindow().setVisible(true);
	}


	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("cs165_logo_icon.png"));

		JPanel toolbar = new JPanel();
		getContentPane().add(toolbar, BorderLayout.NORTH);

		JButton redButton = new JButton("RED");
		redButton.addActionListener(e -> panel.executeCommand(new DrawRedLineCommand(panel.redX(), panel.getHeight())));

		redButton.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		redButton.setBorderPainted(false);
		redButton.setOpaque(true);
		redButton.setFocusable(false);
		redButton.setDoubleBuffered(true);
		redButton.setForeground(new Color(165, 42, 42));
		redButton.setBackground(new Color(255, 255, 255));

		toolbar.add(redButton);

		JButton btnBlue = new JButton("BLUE");
		btnBlue.addActionListener(e -> panel.executeCommand(new DrawBlueLineCommand(panel.blueX(), panel.getHeight())));

		btnBlue.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnBlue.setBorderPainted(false);
		btnBlue.setOpaque(true);
		btnBlue.setFocusable(false);
		btnBlue.setDoubleBuffered(true);
		btnBlue.setForeground(new Color(0, 0, 205));
		btnBlue.setBackground(new Color(255, 255, 255));

		toolbar.add(btnBlue);

		JButton undoButton = new JButton("UNDO");
		undoButton.addActionListener(e -> panel.executeCommand(new UndoCommand()));

		undoButton.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		undoButton.setBorderPainted(false);
		undoButton.setOpaque(true);
		undoButton.setFocusable(false);
		undoButton.setDoubleBuffered(true);
		undoButton.setForeground(new Color(51, 51, 51));
		undoButton.setBackground(new Color(255, 255, 255));

		toolbar.add(undoButton);

		panel = new DrawPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);

	}

}
