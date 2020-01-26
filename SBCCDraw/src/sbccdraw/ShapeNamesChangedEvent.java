package sbccdraw;

import sbccdraw.drawshapes.*;

public class ShapeNamesChangedEvent extends java.util.EventObject {
	public ShapeNamesChangedEvent(DrawShapeFactory source) {
		super(source);
	}


	public DrawShapeFactory getSource() {
		return (DrawShapeFactory) this.source;
	}
}