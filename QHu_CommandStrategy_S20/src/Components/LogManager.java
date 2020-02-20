package Components;

import java.util.ArrayList;
import Logs.ILog;

public class LogManager {

    private ArrayList<String> logs;
    private String logType;

    public LogManager(){
        this.logs = new ArrayList<>();
        this.logType = "text";
    }

    public void addLog(String log){
        this.logs.add(log);
    }

    public void saveLog(){

    }
}