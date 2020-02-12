package explorer_12;

import static explorer_12.Util.*;

import java.io.*;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.*;

public class FileTreeLabelProvider extends LabelProvider {

	public String getText(Object element) {
		return ((File) element).getName();
	}


	public Image getImage(Object element) {
		File file = (File) element;

		if (file.isDirectory())
			return getImageRegistry().get("folder");
		else
			return getImageRegistry().get("file");
	}
}