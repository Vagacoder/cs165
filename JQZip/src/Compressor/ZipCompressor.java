package Compressor;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.*;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

public class ZipCompressor implements ICompressor {

    @Override
    public void write(String outputFilename, byte[] data) {
        // TODO: implement output stream

        try{
            ArchiveOutputStream out = new ZipArchiveOutputStream(new File(outputFilename+".zip"));
            ZipArchiveEntry entry = new ZipArchiveEntry(outputFilename);
            out.putArchiveEntry(entry);
            out.write(data);
            out.closeArchiveEntry();
            out.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}