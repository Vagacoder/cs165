package sbccdraw;

/**
 * This class contains fields that hold rectangle information and methods for setting the fields.
 * 
 * @author Stephen Strenn
 * @version 1.0
 */
public class DrawRect {

	/**
	 * X coord of upper left corner
	 */
	public int x;
	/**
	 * Y coord of upper left corner
	 */
	public int y;
	/**
	 * rectangle width in pixels
	 */
	public int width;
	/**
	 * rectangle height in pixels
	 */
	public int height;

	/**
	 * Constructor for a rect of size 0,0 at location 0,0
	 */
	public DrawRect() {
		x = y = width = height = 0; // set size and location to 0,0
	}

	/**
	 * Constructor for a rectangle of the given size and location
	 * 
	 * @param x
	 *            X coord of upper left corner
	 * @param y
	 *            Y coord of upper left corner
	 * @param width
	 *            Rectangle width in pixels
	 * @param height
	 *            Rectangle height in pixels
	 */
	public DrawRect(int x, int y, int width, int height) {
		this.x = x; // Use this.x to differentiate between the
		this.y = y; // parameter x and the class field named x
		this.width = width;
		this.height = height;
	}

	/**
	 * (Re)sets the rectangle's size and location.
	 * 
	 * @param x
	 *            X coord of upper left corner
	 * @param y
	 *            Y coord of upper left corner
	 * @param width
	 *            Rectangle width in pixels
	 * @param height
	 *            Rectangle height in pixels
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.x = x; // Use this.x to differentiate between the
		this.y = y; // parameter x and the class field named x
		this.width = width;
		this.height = height;
	}

}
