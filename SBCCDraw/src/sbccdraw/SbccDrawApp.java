package sbccdraw;

import javax.swing.*;

/**
 * Application launcher - just gets things going.
 * 
 * @author Stephen Strenn
 * @version 1.0
 */

public class SbccDrawApp {
	boolean packFrame = false;

	// Construct the application
	public SbccDrawApp() {
		SbccDrawFrame frame = new SbccDrawFrame();
		frame.setVisible(true);
	}

	// Main method
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new SbccDrawApp();
	}
}