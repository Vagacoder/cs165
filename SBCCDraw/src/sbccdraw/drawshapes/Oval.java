package sbccdraw.drawshapes;

import java.awt.*;

/**
 * Oval DrawShape. Supports anti-aliasing.
 * 
 * @author Stephen Strenn
 * @version 1.0
 */
public class Oval extends DrawShape {

	/**
	 * Returns the class name.
	 */
	public String getName() {
		return "Oval";
	}


	/**
	 * Draws the oval in the given graphics context.
	 * 
	 * @param g The graphics context
	 */
	public void draw(Graphics g) {
		// Setup the rendering hints
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(hints);

		// Fill the oval
		if (filled == true) {
			g2d.setColor(fillColor);
			g2d.fillOval(boundsBox.x, boundsBox.y, boundsBox.width, boundsBox.height);
		}

		// Draw the oval
		g2d.setColor(borderColor);
		g2d.drawOval(boundsBox.x, boundsBox.y, boundsBox.width, boundsBox.height);
	}

}
