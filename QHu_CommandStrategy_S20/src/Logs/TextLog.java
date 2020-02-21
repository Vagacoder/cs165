package Logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import Commands.ICommand;

public class TextLog implements ILog {

    @Override
    public void write(List<ICommand> logs) {
        String textLog = "";
        for (ICommand log : logs) {
            textLog += (log.getOperand1() + "\n");
            System.out.println(log);
            System.out.println(textLog);
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