package sbccdraw.drawshapes;

import java.awt.*;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class Square extends DrawShape {
	public Square() {
	}

	public String getName() {
		return "Square";
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2f));

		int w = boundsBox.width;
		int h = boundsBox.height;

		// Make the square's width and height equal to the smaller of the two
		if (w > h)
			w = h;
		if (h > w)
			h = w;

		// Fill the square
		if (filled == true) {
			g.setColor(fillColor);
			g.fillRect(boundsBox.x, boundsBox.y, w, h);
		}

		// Draw the rectangle
		g.setColor(borderColor);
		g.drawRect(boundsBox.x, boundsBox.y, w, h);
	}

}
