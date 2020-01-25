package sbccdraw;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import sbccdraw.drawshapes.*;

/**
 * DrawPanel handles user interaction on the drawing canvas (i.e. it is the drawing canvas).
 * 
 */

@SuppressWarnings("serial")
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * The dimension of the offscreen drawing image
	 */
	private Dimension offScreenDimension;

	/**
	 * Offscreen image used to eliminate flashing
	 */
	private Image offScreenImage;

	/**
	 * A graphics object for the offscreen Image
	 */
	private Graphics2D offScreenGraphics;

	/**
	 * Saves the coordinates of the mousePressed point
	 */
	private Point anchorPoint;

	/**
	 * Class name of the current shape (sans sbccdraw.drawshapes)
	 */
	private String curShapeClassName;

	/**
	 * The current shape
	 */
	private DrawShape curShape;

	/**
	 * A list of shapes on the drawing panel
	 */
	private ArrayList<DrawShape> shapeList;

	/**
	 * The DrawShape factory
	 */
	private DrawShapeFactory shapeFactory;

	/**
	 * The current fill color
	 */
	private Color fillColor;

	/**
	 * The current border color
	 */
	private Color borderColor;

	/**
	 * Notes if fill is on
	 */
	private boolean filled;


	/**
	 * Initialize the draw panel.
	 */
	public DrawPanel() {
		init();
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Non-JBuilder initialization
	 */
	private void init() {
		shapeList = new ArrayList<DrawShape>(10); // Create the shapeList vector
		anchorPoint = new Point(0, 0); // Create a new point

		// Enable this panel to receive mouse events
		addMouseListener(this);
		addMouseMotionListener(this);
	}


	/**
	 * Sets the DrawShapeFactory that this DrawPanel will use when asking for new DrawShapes to be made.
	 * 
	 * @param shapeFactory
	 *            The new DrawShapeFactory to use.
	 */
	public void setShapeFactory(DrawShapeFactory shapeFactory) {
		this.shapeFactory = shapeFactory;
	}


	/**
	 * Sets the new fill color to use for shapes.
	 * 
	 * @param fillColor
	 *            The new fill color.
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}


	/**
	 * Returns the current fill color.
	 */
	public Color getFillColor() {
		return fillColor;
	}


	/**
	 * Sets a new border color.
	 * 
	 * @param borderColor
	 *            The new border color.
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}


	/**
	 * Returns the border color.
	 */
	public Color getBorderColor() {
		return borderColor;
	}


	/**
	 * Returns the fill state (true = on, false = off).
	 */
	public boolean isFilled() {
		return filled;
	}


	/**
	 * Sets the fill state (true = on, false = off).
	 * 
	 * @param filled
	 *            The new fill state.
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}


	/**
	 * Sets the current draw shape name
	 * 
	 * @param shapeName
	 *            The new draw shape name
	 */
	public void setDrawShapeName(String shapeName) {
		curShapeClassName = shapeName;
	}


	/**
	 * Clears the drawing panel of DrawShapes.
	 */
	public void clearPanel() {
		while (shapeList.size() > 0) {
			shapeList.get(0).removeControl(this);
			shapeList.remove(0);
		}
		repaint();
	}


	/**
	 * Simply calls update() to draw all of the shapes in shapeList.
	 * 
	 * @param g
	 *            This applet's graphics context
	 */
	@Override
	public void paintComponent(Graphics g) {
		update(g);
	}


	/**
	 * Redraws all of the shapes in shapeList. First, an offscreen graphics object is created. All of the shapes in
	 * shapeList are drawn on the offscreen graphics object. The offscreen graphics object is then drawn to the applet's
	 * graphics object.
	 * 
	 * @param g
	 *            This applet's graphics context
	 */
	@Override
	public void update(Graphics g) {
		clearOffScreenGraphicsBuffer();

		// draw all shapes in the shape list onto the offscreen image
		for (DrawShape shape : shapeList)
			shape.draw(offScreenGraphics);

		// paint the offscreen image to the on-screen panel
		g.drawImage(offScreenImage, 0, 0, this);
	}


	private void clearOffScreenGraphicsBuffer() {
		// get the width and height dimensions of the applet's drawing area
		Dimension d = getSize();

		// create an off-screen graphics drawing environment if none existed
		// or if the user resized the applet drawing area to a different size
		if ((offScreenGraphics == null) || (d.width != offScreenDimension.width)
				|| (d.height != offScreenDimension.height)) {
			offScreenDimension = d;
			offScreenImage = createImage(d.width, d.height);
			offScreenGraphics = (Graphics2D) offScreenImage.getGraphics();
			offScreenGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}

		// erase the previous image
		offScreenGraphics.setColor(getBackground());
		offScreenGraphics.fillRect(0, 0, d.width, d.height);
	}


	/** we must implement all unused mouse event methods using blank */
	/** methods in order to satisfy the compiler that we have implemented */
	/** the entire MouseListener and MouseMotionListener interfaces */
	@Override
	public void mouseEntered(MouseEvent event) {
	}


	@Override
	public void mouseExited(MouseEvent event) {
	}


	@Override
	public void mouseClicked(MouseEvent event) {
	}


	@Override
	public void mouseMoved(MouseEvent event) {
	}


	/**
	 * Handles the mousePressed event. A new shape is created based on the current shape, color, and fill settings. The
	 * new shape is added to the shapeList.
	 * 
	 * @param event
	 */
	@Override
	public void mousePressed(MouseEvent event) {
		curShape = addShape(curShapeClassName, event.getX(), event.getY(), 0, 0, fillColor, borderColor);

		// save the mouse down (x,y) coordinates as the anchorPoint
		anchorPoint.x = event.getX();
		anchorPoint.y = event.getY();
	}


	/**
	 * Handles the mouseDragged event. The bounding box of the current shape is reset, the shape is normalized, and the
	 * applet is repainted.
	 * 
	 * @param event
	 *            Holds the MouseEvent information
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		// retrieve the boundsBox rectangle
		DragRect dragRect = curShape.getBoundsBox();

		// reset the shape's bounding box
		dragRect.setBounds(anchorPoint.x, anchorPoint.y, event.getX() - anchorPoint.x, event.getY() - anchorPoint.y);

		// make sure the dragRect has (x,y) as its top-left corner, and has
		// a positive width and height
		dragRect.normalize();

		repaint(); // repaint the panel
	} // end mouseDragged


	/**
	 * Handles the mouseReleased event by repainting the applet
	 * 
	 * @param event
	 *            Holds the MouseEvent information
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		repaint(); // repaint the panel
	}


	/**
	 * Adds a shape with the given parameters to the drawing panel.
	 * 
	 * @param shapeType
	 *            Type of shape to add.
	 * @param x
	 *            X position of the top left corner
	 * @param y
	 *            Y position of the top left corner
	 * @param w
	 *            Shape width
	 * @param h
	 *            Shape height
	 * @param fill
	 *            Shape fill color
	 * @param border
	 *            Shape border color
	 * @return The new DrawShape
	 */
	public DrawShape addShape(String shapeType, int x, int y, int w, int h, Color fill, Color border) {

		DrawShape newShape = null;
		try {
			newShape = shapeFactory.createDrawShape(shapeType);
			newShape.setFillColor(fill);
			newShape.setFilled(filled);
			newShape.setBorderColor(border);

			// let the shape's boundsBox be an empty DragRect
			DragRect dr = new DragRect();
			dr.setBounds(x, y, w, h);
			newShape.setBoundsBox(dr);

			// Give the shape the opportunity to add itself to the panel
			// (typically used for Swing-derived classes).
			newShape.addControl(this);

			// append the new shape to end of the shapeList
			shapeList.add(newShape);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return newShape;
	}


	/**
	 * JBuilder GUI init
	 * 
	 * @throws Exception
	 */
	private void jbInit() throws Exception {
		this.setBackground(Color.white);
		this.setLayout(null);
	}

}