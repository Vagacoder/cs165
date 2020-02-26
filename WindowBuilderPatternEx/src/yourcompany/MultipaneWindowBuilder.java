package yourcompany;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MultipaneWindowBuilder extends AppWindowBuilder {

	public Composite addClientArea(AppWindow win) {
		var clientArea = new SashForm(win.getShell(), SWT.HORIZONTAL);
		win.setClientArea(clientArea);
		var data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL
				| GridData.GRAB_VERTICAL);
		clientArea.setLayoutData(data);
		clientArea.setLayout(new RowLayout());

		var child1 = new Composite(clientArea, SWT.NONE);
		child1.setLayout(new FillLayout());
		new Text(child1, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL).setText("Pane1");

		var child2 = new Composite(clientArea, SWT.NONE);
		child2.setLayout(new FillLayout());
		new Text(child2, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL).setText("Pane2");

		clientArea.setWeights(new int[] { 45, 45 });

		return clientArea;
	}
}
