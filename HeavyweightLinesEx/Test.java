import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static java.lang.System.*;
import static sbcc.Core.*;

public class Test extends JFrame {

	private static final Color colors[] = { Color.red, Color.blue, Color.yellow, Color.orange, Color.black,
			Color.white };

	private static final int WINDOW_WIDTH = 600, WINDOW_HEIGHT = 600, NUMBER_OF_LINES = 1000;

	public Test() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		JButton button = new JButton("draw lines");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.SOUTH);
		setBounds(20, 20, WINDOW_WIDTH, WINDOW_HEIGHT);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Graphics g = panel.getGraphics();

				long beforeTime = nanoTime();

				var lines = new ArrayList<Line>();
				for (int i = 0; i < NUMBER_OF_LINES; ++i) {
					var color = getRandomColor();
					var line = new Line(color, getRandomX(), getRandomY(), getRandomX(), getRandomY());
					println("Created " + color + " line (object number " + (i + 1) + ")");
					lines.add(line);
					line.draw(g);
				}

				long afterTime = nanoTime();

				double dSecs = ((double) afterTime - (double) beforeTime) / 1.0e9;
				println();
				println(dSecs + " seconds");
			}
		});
	}


	public static void main(String[] args) {
		Test test = new Test();
		test.show();
	}


	private int getRandomX() {
		return (int) (Math.random() * WINDOW_WIDTH);
	}


	private int getRandomY() {
		return (int) (Math.random() * WINDOW_HEIGHT);
	}


	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}
}