package Logs;

import java.util.List;

import Commands.ICommand;

public interface ILog{

    void write(List<ICommand> logs);

}