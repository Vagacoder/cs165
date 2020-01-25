package sbccdraw.drawshapes;

import java.awt.*;
import java.awt.geom.*;

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

public class Star extends DrawShape {

	public Star() {
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2f));

		int w = boundsBox.width;
		int h = boundsBox.height;

		GeneralPath star = new GeneralPath();

		// set the initial coordinate of the General Path
		star.moveTo((int) (.5 * w + boundsBox.x), (int) (boundsBox.y));
		star.lineTo((int) (.61 * w + boundsBox.x), (int) (.38 * h + boundsBox.y));
		star.lineTo((int) (w + boundsBox.x), (int) (.38 * h + boundsBox.y));
		star.lineTo((int) (.66 * w + boundsBox.x), (int) (.57 * h + boundsBox.y));
		star.lineTo((int) (.75 * w + boundsBox.x), (int) (h + boundsBox.y));
		star.lineTo((int) (.5 * w + boundsBox.x), (int) (.75 * h + boundsBox.y));
		star.lineTo((int) (.25 * w + boundsBox.x), (int) (h + boundsBox.y));
		star.lineTo((int) (.34 * w + boundsBox.x), (int) (.57 * h + boundsBox.y));
		star.lineTo((int) (boundsBox.x), (int) (.38 * h + boundsBox.y));
		star.lineTo((int) (.4 * w + boundsBox.x), (int) (.38 * h + boundsBox.y));

		// close the shape
		star.closePath();

		if (filled == true) {
			g2d.setColor(fillColor);
			g2d.fill(star);
		}

		g2d.setColor(borderColor);
		g2d.draw(star);
	}

	public String getName() {
		return "Star";
	}
}