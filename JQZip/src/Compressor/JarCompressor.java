package Compressor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;

public class JarCompressor implements ICompressor{

    @Override
    public void write(String filename, byte[] data) throws Exception {
        
        OutputStream out = new FileOutputStream(new File(filename + ".jar"));
        ArchiveOutputStream jarOut = new JarArchiveOutputStream(out);
        JarArchiveEntry entry = new JarArchiveEntry(filename);
        jarOut.putArchiveEntry(entry);
        jarOut.write(data);
        jarOut.closeArchiveEntry();
        jarOut.close();
    }

}