package Compressor;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.*;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

public class Bzip2Compressor implements ICompressor {

    @Override
    public void write(String filename, byte[] data) throws Exception {
        OutputStream out = Files.newOutputStream(Paths.get(filename + ".bz2"));
        BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
        BZip2CompressorOutputStream bzOut = new BZip2CompressorOutputStream(bufferedOut);
        bzOut.write(data);
        bzOut.close();
    }


}