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
 * @author unascribed
 * @version 1.0
 */

public class RoundRect extends DrawShape {

	public RoundRect() {
	}

	public String getName() {
		return "RoundRect";
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2f));
		if (filled == true) {
			g2d.setColor(fillColor);
			g2d.fillRoundRect(boundsBox.x, boundsBox.y, boundsBox.width, boundsBox.height, 10, 10);
		}
		g2d.setColor(borderColor);
		g2d.drawRoundRect(boundsBox.x, boundsBox.y, boundsBox.width, boundsBox.height, 10, 10);
	}
}