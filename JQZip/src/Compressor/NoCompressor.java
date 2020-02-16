package Compressor;

/*
* This class does not compress file, just copy file.
*/

import java.nio.file.*;

public class NoCompressor implements ICompressor {

    @Override
    public void write(String outputFilename, byte[] data) {
        Path path = Paths.get(outputFilename);
        try {
            Files.write(path, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}