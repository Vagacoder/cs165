package explorer_12;

import org.eclipse.jface.action.*;
import org.eclipse.jface.resource.*;
import org.eclipse.jface.window.*;

public class ExitAction extends Action {
	ApplicationWindow window;

	public ExitAction(ApplicationWindow w) {
		window = w;
		setText("E&xit@Ctrl+W");
		setToolTipText("Exit the application");
		setImageDescriptor(ImageDescriptor.createFromURL(Util.newURL("file:icons/close.png")));
	}


	public void run() {
		window.close();
	}
}
