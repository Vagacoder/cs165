package sbccdraw.drawshapes;

import java.awt.*;

import javax.swing.*;

public class TextShape extends DrawShape {

	JTextArea textArea;


	public TextShape() {
		textArea = new JTextArea();
	}


	@Override
	public void addControl(JPanel panel) {
		textArea.setBounds(new java.awt.Rectangle(boundsBox.x, boundsBox.y, 200, 26));
		textArea.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		textArea.setMargin(new Insets(0, 8, 0, 0));
		textArea.setBackground(fillColor);
		textArea.setForeground(borderColor);
		panel.add(textArea, null);
		panel.repaint();
	}


	@Override
	public void removeControl(JPanel panel) {
		panel.remove(textArea);
	}


	@Override
	public void draw(Graphics g) {
	}


	@Override
	public String getName() {
		return "TextShape";
	}
}