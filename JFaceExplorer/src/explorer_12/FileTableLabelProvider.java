package explorer_12;

import java.io.*;
import static explorer_12.Util.*;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.*;

public class FileTableLabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int column_index) {
		if (column_index == 0) {
			return ((File) element).getName();
		}

		if (column_index == 1) {
			return "" + ((File) element).length();
		}

		return "";
	}


	public void addListener(ILabelProviderListener ilabelproviderlistener) {
	}


	public void dispose() {
	}


	public boolean isLabelProperty(Object obj, String s) {
		return false;
	}


	public void removeListener(ILabelProviderListener ilabelproviderlistener) {
	}


	public Image getColumnImage(Object element, int column_index) {

		if (column_index != 0)
			return null;

		File file = (File) element;

		if (file.isDirectory())
			return getImageRegistry().get("folder");
		else
			return getImageRegistry().get("file");
	}

}
