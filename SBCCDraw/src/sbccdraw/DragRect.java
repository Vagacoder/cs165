package sbccdraw;

/**
 * A DragRect is a DrawRect with the ability to update its X and Y location if the width and/or height is negative.
 * 
 * @author Stephen Strenn
 * @version 1.0
 */
public class DragRect extends DrawRect {

	/**
	 * If the rectangle's width is negative, moves the x-coordinate to the left side and change its width from negative
	 * to positive. Likewise for the height.
	 */
	void normalize() {
		// If the rectangle's width is negative move its x-coordinate to the left side and
		// change its width from negative to positive
		if (width < 0) {
			x += width;
			width = -width;
		}

		// Same for the height
		if (height < 0) {
			y += height;
			height = -height;
		}
	}

}
