package Compressor;

// import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

public class TarCompressor implements ICompressor {

    @Override
    public void write(String filename, byte[] data) throws Exception {
        OutputStream out = new FileOutputStream(new File(filename + ".tar"));
        ArchiveOutputStream tarOut = new TarArchiveOutputStream(out);
        TarArchiveEntry entry = new TarArchiveEntry(filename);
        entry.setSize(data.length);
        tarOut.putArchiveEntry(entry);
        // BufferedOutputStream bufferedOut = new BufferedOutputStream(tarOut);
        tarOut.write(data);
        tarOut.closeArchiveEntry();
        tarOut.close();
    }

}