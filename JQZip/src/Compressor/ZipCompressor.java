package Compressor;

// import java.io.BufferedOutputStream;
import java.io.File;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

public class ZipCompressor implements ICompressor {

    @Override
    public void write(String filename, byte[] data) throws Exception {
            ArchiveOutputStream out = new ZipArchiveOutputStream(
                new File(filename+".zip"));
            ZipArchiveEntry entry = new ZipArchiveEntry(filename);
            out.putArchiveEntry(entry);
            // BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
            out.write(data);
            out.closeArchiveEntry();
            out.close();
    }
}