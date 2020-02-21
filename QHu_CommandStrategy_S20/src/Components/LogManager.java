package Components;

import java.util.ArrayList;
import Logs.ILog;

public class LogManager {

    private ArrayList<String> logs;

    public LogManager(){
        this.logs = new ArrayList<>();
    }

    public void addLog(String log){
        this.logs.add(log);
    }

    public void saveLog(String type){
        try{
        Class logClass = Class.forName("Logs." + type + "Log");
        ILog logger = (ILog) logClass.getDeclaredConstructor().newInstance();
        logger.write(this.logs);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}