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
            String thisLog = String.format("operator: %s, operand1: %s, operand2: %s", 
                log.getOperator(), 
                log.getOperand1(), 
                log.getOperand2());
            textLog += (thisLog + "\n");
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