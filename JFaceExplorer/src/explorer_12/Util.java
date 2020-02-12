package explorer_12;

import java.net.*;
import static org.eclipse.jface.resource.ImageDescriptor.*;

import org.eclipse.jface.resource.*;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.widgets.*;

public class Util {

	private static ImageRegistry image_registry;
	private static Clipboard clipboard;

	public static URL newURL(String url_name) {
		try {
			return new URL(url_name);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Malformed URL " + url_name, e);
		}
	}


	public static ImageRegistry getImageRegistry() {

		if (image_registry == null) {
			image_registry = new ImageRegistry();

			// Create the two concrete objects.
			image_registry.put("folder", createFromURL(newURL("file:icons/folder.png")));

			image_registry.put("file", createFromURL(newURL("file:icons/file.png")));
		}

		return image_registry;
	}


	public static Clipboard getClipboard() {
		if (clipboard == null) {
			clipboard = new Clipboard(Display.getCurrent());
		}

		return clipboard;
	}
}