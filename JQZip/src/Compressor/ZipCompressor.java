package Compressor;

import java.nio.file.*;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.zip.*;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

public class ZipCompressor implements ICompressor{

    @Override
    public void write(String filename, byte[] data) {
        // TODO Auto-generated method stub

        ZipArchiveEntry entry = new ZipArchiveEntry(filename);
        entry.setSize(data.length);
        


        Path path = Paths.get(filename);
        try{
        Files.write(path, data);
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}