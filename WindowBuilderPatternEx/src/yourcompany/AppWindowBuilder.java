package yourcompany;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class AppWindowBuilder {

	/**
	 * Factory method that returns an AppWindowBuilder.
	 * 
	 * @param winType
	 * @return
	 */
	public static AppWindowBuilder create(String winType) {
		switch (winType) {
		case "Default":
			return new AppWindowBuilder();

		case "Dialog":
			return new DialogWindowBuilder();

		case "Multipane":
			return new MultipaneWindowBuilder();

		default:
			return new AppWindowBuilder();
		}
	}


	public static AppWindowBuilder create() {
		return create("");
	}


	/**
	 * This is the builder method. Note how the AppWindow is built up step by step. Also note that methods are used to
	 * add the window parts, rather than just updating the instance variables of the AppWindow. Methods can be
	 * overridden, so the details of how each step is performed can be changed by subclasses of this builder.
	 * 
	 * @param display SWT display that the AppWindow will be displayed in.
	 * @param caption Title for the AppWindow.
	 * @return An AppWindow
	 */

	public AppWindow buildAppWindow(Display display, String caption) {

		var win = createBaseWindow(display, caption); // step 1
		addMenu(win); // step 2
		addToolbar(win); // step 3
		addClientArea(win); // step 4
		return win;

	}


	public AppWindow createBaseWindow(Display display, String caption) {
		var defaultWindow = new DefaultAppWindow(display, caption);
		return defaultWindow;
	}


	public Menu addMenu(AppWindow win) {
		var shell = win.getShell();
		var menuBar = new Menu(shell, SWT.BAR);

		var fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");

		var fileMenu = new Menu(win.getShell(), SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);

		var fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
		fileSaveItem.setText("&Save");

		var fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("E&xit");
		fileExitItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				win.getShell().dispose();
			}


			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		shell.setMenuBar(menuBar);

		return menuBar;
	}


	public ToolBar addToolbar(AppWindow win) {
		var tb = new ToolBar(win.getShell(), SWT.FLAT);
		var data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		tb.setLayoutData(data);
		for (int i = 0; i < 20; i++) {
			ToolItem item = new ToolItem(tb, SWT.PUSH);
			item.setImage(new Image(win.getShell().getDisplay(), "eclipse.png"));
		}
		tb.pack();
		return tb;
	}


	public Composite addClientArea(AppWindow win) {
		var clientArea = new Composite(win.getShell(), SWT.BORDER);
		win.setClientArea(clientArea);
		var data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL
				| GridData.GRAB_VERTICAL);
		clientArea.setLayoutData(data);
		clientArea.setLayout(new FillLayout());

		var child1 = new Composite(clientArea, SWT.NONE);
		child1.setLayout(new FillLayout());
		new Text(child1, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL).setText("Pane1");

		return clientArea;
	}

}
