package sbccdraw.drawshapes;

import java.awt.*;

import javax.swing.*;

import sbccdraw.*;

abstract public class DrawShape {

	/**
	 * The name of this type of DrawShape.
	 */
	protected String name;

	/**
	 * Notes if this shape has a fill color.
	 */
	protected boolean filled;

	/**
	 * Reference to the shape's bounding box.
	 */
	protected DragRect boundsBox;

	/**
	 * The shape's border color.
	 */
	protected Color borderColor;

	/**
	 * The shape's fill color.
	 */
	protected Color fillColor;


	/**
	 * Called when the shape needs to draw itself
	 */
	abstract public void draw(Graphics g);


	/**
	 * Returns the name of this DrawShape, without package information. For example,
	 * "Oval", or "Rectangle"
	 */
	abstract public String getName();


	/**
	  * 
	  */
	public boolean isFilled() {
		return filled;
	}


	/**
	 * Turns color fill on or off
	 * 
	 * @param filled
	 *            If true, this shape will be filled with FillColor
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}


	/**
	 * Returns a reference to the shape's bounding box.
	 */
	public DragRect getBoundsBox() {
		return boundsBox;
	}


	/**
	 * Sets this shape's bounding box.
	 * 
	 * @param boundsBox
	 *            A reference to the bounding box.
	 */
	public void setBoundsBox(DragRect boundsBox) {
		this.boundsBox = boundsBox;
	}


	/**
	 * Returns the current border color.
	 */
	public Color getBorderColor() {
		return borderColor;
	}


	/**
	 * Sets the border color.
	 * 
	 * @param borderColor
	 *            The new border color.
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}


	/**
	 * Returns the current fill color.
	 */
	public Color getFillColor() {
		return fillColor;
	}


	/**
	 * Sets a new fill color.
	 * 
	 * @param fillColor
	 *            The new fill color.
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}


	/**
	 * This method is called by the drawing panel, providing this shape an
	 * opportunity to add itself to the panel. Useful for, among other things,
	 * adding Swing-based controls to the drawing panel.
	 * 
	 * @param panel
	 *            The drawing panel.
	 */
	public void addControl(JPanel panel) {
	}


	/**
	 * This method is called by the drawing panel, providing this shape an
	 * opportunity to remove itself from the panel. Useful for, among other things,
	 * removing Swing-based controls from the drawing panel.
	 * 
	 * @param panel
	 *            The drawing panel.
	 */
	public void removeControl(JPanel panel) {
	}
}
