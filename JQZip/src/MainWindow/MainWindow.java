package MainWindow;

/*
* CS165 Assignment #2: Command & Strategy Patterns

Plan B:
Create a utility program that allows the user to select an input file as well as 
a format for output. 

Output formats include, at a minimum, ZIP, GZIP, and one other 
of your choice (e.g. Jar, Tar, PGP-encrypted, etc.). When the user selects the 
save option, the specified file is output in the specified format. 

Use the Strategy design pattern to encapsulate each file-saving algorithm in 
separate classes that implement a common interface. 

The interface does not need to be fancy, perhaps it just declares one method, say 

    * public void write(String filename, byte[] data);

Verify that your program is working properly by opening your output files in another 
program (e.g. WinRar, which can read most of these formats).  One library you might 
want to consider using is the Apache Commons Compress library, which can handle 
many different compression formats.


SRS: 
1. GUI for software, (try JavaFX); 
1.1. GUI for select input file;
1.2. GUI for select output file;
1.3. GUI for select format;
2. Support multiple output file formats
3. Providing compression and decompression options
4. ...

Task: 
1. finishe UML diagram ... done
2. skeleton the components
3. implement algorithm and Strategy pattern

*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainWindow {

    public static void main(String[] args) throws IOException {

        CompressionManager manager = new CompressionManager();
        File infile = new File("midterm.pdf");
        byte[] data = Files.readAllBytes(infile.toPath());
        
        String outputFileName = "mid.zip";
        manager.write(outputFileName, data);
    
    }
}
