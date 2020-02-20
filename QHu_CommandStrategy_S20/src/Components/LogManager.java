package Components;

import java.util.ArrayList;

public class LogManager {

    private ArrayList<String> logs;

    public LogManager(){
        this.logs = new ArrayList<>();
    }

    public void addLog(String log){
        this.logs.add(log);
    }

    public String getTextLog(){
        String result = "";
        for (String log: logs){
            result += (log + "\n");
        }
        return result;
    }

    public String getXMLlog(){
        String result = "";
        // TODO: implement XML format log

        return result;
    }

}