package company2;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import yourcompany.*;

public class Main2 {

	Display display;
	Shell shell;
	AppWindow win;

	public static void main(String[] args) {

		new Main2();
	}


	public Main2() {

		// The factory method. This time we are requesting windows with multiple panes.
		var builder = AppWindowBuilder.create("Multipane");

		// Builder method that produces an AppWindow.
		win = builder.buildAppWindow(display, "BETTER THAN EZRA!");
		shell = win.getShell();
		shell.open();

		run();
		close();
	}


	public void run() {
		display = shell.getDisplay();
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
	}


	/*
	 * Free the allocated resources.
	 */
	public void close() {
		if (shell != null && !shell.isDisposed())
			shell.dispose();
	}

}
