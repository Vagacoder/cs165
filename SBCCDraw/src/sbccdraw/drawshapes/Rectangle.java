package sbccdraw.drawshapes;

import java.awt.*;

/**
 * Rectangle DrawShape.
 * 
 * @author Stephen Strenn
 * @version 1.0
 */
public class Rectangle extends DrawShape {

	public String getName() {
		return "Rectangle";
	}


	/**
	 * Draws the rectangle in the given graphics context.
	 * 
	 * @param g
	 *            The graphics context
	 */
	public void draw(Graphics g) {
		// Fill the rectangle
		if (filled == true) {
			g.setColor(fillColor);
			g.fillRect(boundsBox.x, boundsBox.y, boundsBox.width, boundsBox.height);
		}

		// Draw the rectangle
		g.setColor(borderColor);
		g.drawRect(boundsBox.x, boundsBox.y, boundsBox.width, boundsBox.height);
	}

}