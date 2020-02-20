package Logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class TextLog implements ILog {

    @Override
    public void write(List<String> logs) {
        String textLog = "";
        for (String log : logs) {
            textLog += (log + "\n");
        }

        File outFile = new File("log.txt");
        OutputStream out;
        try {
            out = new FileOutputStream(outFile);
            byte[] data = textLog.getBytes();
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}