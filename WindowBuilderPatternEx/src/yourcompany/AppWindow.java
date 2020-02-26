package yourcompany;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;

abstract public class AppWindow {

	protected Shell shell;
	protected ToolBar toolbar;
	protected Menu menu;
	protected Composite clientArea;
	protected Composite statusBar;

	public Shell getShell() {
		return shell;
	}


	public void setShell(Shell shell) {
		this.shell = shell;
	}


	public ToolBar getToolbar() {
		return toolbar;
	}


	public void setToolbar(ToolBar toolbar) {
		this.toolbar = toolbar;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public Composite getClientArea() {
		return clientArea;
	}


	public void setClientArea(Composite clientArea) {
		this.clientArea = clientArea;
	}


	public Composite getStatusBar() {
		return statusBar;
	}


	public void setStatusBar(Composite statusBar) {
		this.statusBar = statusBar;
	}

}
