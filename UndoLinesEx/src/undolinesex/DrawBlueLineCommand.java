package undolinesex;

import java.awt.*;

import javax.swing.*;

public class DrawBlueLineCommand extends DrawLineCommand {

	public DrawBlueLineCommand(int x, int height) {
		super(x, height);
	}


	@Override
	public void execute(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.blue);
		g2.setStroke(new BasicStroke(10f));
		g.drawLine(x, 0, x - 30, height);
	}

}
