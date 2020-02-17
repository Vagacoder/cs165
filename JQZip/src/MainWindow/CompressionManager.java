package MainWindow;

import Compressor.ICompressor;

public class CompressionManager {

    private ICompressor compressor;

    public CompressionManager() {

    }

    public void setCompressAlogrithm(String algo) throws Exception {
        Class compressorClass = Class.forName("Compressor." +algo + "Compressor");
        this.compressor = (ICompressor) compressorClass.getDeclaredConstructor()
            .newInstance();
    }

    public void write(String fileName, byte[] data) throws Exception {
        this.compressor.write(fileName, data);
    }

}