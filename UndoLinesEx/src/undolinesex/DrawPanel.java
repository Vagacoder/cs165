package undolinesex;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class DrawPanel extends JPanel {

	Stack<DrawLineCommand> commands = new Stack<>();

	public void executeCommand(Command c) {

		if (c instanceof DrawLineCommand)
			executeDrawLineCommand((DrawLineCommand) c);

		else if (c instanceof UndoCommand && !commands.empty())
			executeUndo();

	}


	private void executeDrawLineCommand(DrawLineCommand c) {
		c.execute(getGraphics());
		commands.push(c);
	}


	private void executeUndo() {
		commands.pop();
		repaint();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (var cmd : commands)
			cmd.execute(g);
	}


	// Compute the location where the next red line should be drawn
	public int redX() {
		int redX = -30;

		for (var cmd : commands)
			if (cmd instanceof DrawRedLineCommand)
				if (cmd.x > redX)
					redX = cmd.x;

		return redX + 30;
	}


	// Compute the location where the next blue line should be drawn
	public int blueX() {
		int blueX = (int) getSize().getWidth() + 30;

		for (var cmd : commands)
			if (cmd instanceof DrawBlueLineCommand)
				if (cmd.x < blueX)
					blueX = cmd.x;

		return blueX - 30;
	}

}
