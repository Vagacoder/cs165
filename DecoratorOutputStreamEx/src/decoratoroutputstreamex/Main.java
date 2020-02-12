package decoratoroutputstreamex;

import static sbcc.Core.*;

import java.io.*;
import java.util.zip.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * 
 * @author your_name_here
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		String[] words = { "Unlightening", "Hiberdating", "Destinesia", "Textpectation", "Columbusing", "Youniverse",
				"Carcolepsy", "Ambitchous", "Unkeyboardinated", "Afterclap", "Beerboarding", "Nerdjacking", "Nomonym",
				"Dudevorce", "Nonversation", "Cellfish", "Chairdrobe" };
		var file = new File("words.txt.gzip");

		// @formatter:off
		
		var os = 
				new EncryptedOutputStream(
				new AnnotatedOutputStream(
				new GZIPOutputStream(
				new BufferedOutputStream(
				new FileOutputStream(file)))));
		
		// @formatter:on

		os.write(join(words, lineSeparator()).getBytes());
		os.close();
	}

}
