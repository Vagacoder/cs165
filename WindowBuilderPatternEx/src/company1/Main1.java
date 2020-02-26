package company1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import yourcompany.*;

public class Main1 {

	Display display;
	Shell shell;
	AppWindow win;

	public static void main(String[] args) {

		new Main1();
	}


	public Main1() {

		// The factory method. Allows developer of WindowFactory to change
		// the type of the window factory that is returned w/o changing the public API.
		var builder = AppWindowBuilder.create();

		// Builder method that produces an AppWindow.
		win = builder.buildAppWindow(display, "EZRA!");
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
