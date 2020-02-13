package MainWindow;

import Compressor.Compressor;
import Compressor.ZipCompressor;

public class CompressionManager{

    
    private Compressor compressor;

    public CompressionManager(){

    }

    public void setCompressAlogrithm(String algo){
        //TODO: parse algo, dynamically loading compressor class;
        compressor = new ZipCompressor();
    }

    public void write(String outputFileName, byte[] data){
        this.compressor.write(outputFileName, data);
    }


}