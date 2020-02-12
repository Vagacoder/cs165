import java.util.HashMap;
import java.awt.Color;
import static sbcc.Core.*;

public class LineFactory {

	private static final HashMap<Color, Line> linesByColor = new HashMap<Color, Line>();

	public static Line getLine(Color color) {
		Line line = linesByColor.get(color);

		if (line == null) {
			line = new Line(color);
			linesByColor.put(color, line);
			println("Created " + color + " line (object number " + linesByColor.size() + ")");
		}
		return line;
	}
}
