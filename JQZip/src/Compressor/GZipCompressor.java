package Compressor;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.*;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

public class GZipCompressor implements ICompressor {

    @Override
    public void write(String filename, byte[] data) throws Exception {
            OutputStream out = Files.newOutputStream(Paths.get(filename + ".gz"));
            BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
            GzipCompressorOutputStream gzOut = new GzipCompressorOutputStream(bufferedOut);
            gzOut.write(data);
            gzOut.close();
    }
}