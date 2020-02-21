package Logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class XmlLog implements ILog {

    @Override
    public void write(List<String> logs) {
        String xmlLog = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xmlLog += "<logs>\n";

        for (String log : logs) {
            xmlLog += "<command>";
            xmlLog += (log);
            xmlLog += "</command>\n";
        }

        xmlLog += "</logs>\n";

        File outFile = new File("log.xml");
        OutputStream out;
        try {
            out = new FileOutputStream(outFile);
            byte[] data = xmlLog.getBytes();
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}