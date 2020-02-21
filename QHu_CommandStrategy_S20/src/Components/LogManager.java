package Components;

import java.util.ArrayList;

import Commands.ICommand;
import Logs.ILog;

public class LogManager {

    private ArrayList<ICommand> logs;

    public LogManager(){
        this.logs = new ArrayList<>();
    }

    public void addLog(ICommand log){
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