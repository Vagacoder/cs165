package yourcompany;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class DefaultAppWindow extends AppWindow {

	public DefaultAppWindow(Display display, String caption) {

		shell = new Shell(display);
		shell.setText(caption);
		shell.setImage(new Image(display, "eclipse.png"));
		var layout = new GridLayout();
		layout.numColumns = 1;
		shell.setLayout(layout);
		shell.setSize(1920, 1080);
	}

}
