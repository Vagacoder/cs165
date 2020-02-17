package Compressor;

public interface ICompressor{
    public void write(String filename, byte[] data) throws Exception;
}