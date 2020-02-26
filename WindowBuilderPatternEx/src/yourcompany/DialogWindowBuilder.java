package yourcompany;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class DialogWindowBuilder extends AppWindowBuilder {

	public ToolBar addToolbar(AppWindow win) {
		return null;
	}


	public Menu addMenu(AppWindow win) {
		return null;
	}


	public Composite addClientArea(AppWindow win) {
		var clientArea = new Composite(win.getShell(), 0);
		win.setClientArea(clientArea);
		var data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL
				| GridData.GRAB_VERTICAL);
		clientArea.setLayoutData(data);

		var layout = new GridLayout();
		layout.numColumns = 4;
		clientArea.setLayout(layout);

		var label = new Label(clientArea, SWT.NONE);
		label.setText("Simple Dialog");
		label.setAlignment(SWT.CENTER);
		data = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL);
		data.horizontalSpan = 4;
		data.verticalAlignment = GridData.CENTER;
		data.horizontalAlignment = GridData.CENTER;
		label.setLayoutData(data);

		var btn = new Button(clientArea, SWT.PUSH);
		btn.setText("      OK      ");
		data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		data.horizontalSpan = 4;
		data.horizontalAlignment = GridData.END;
		btn.setLayoutData(data);

		return clientArea;
	}
}
