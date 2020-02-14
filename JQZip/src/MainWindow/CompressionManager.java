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

    public void write(String outputFileName, byte[] data) {
        this.compressor.write(outputFileName, data);
    }

}