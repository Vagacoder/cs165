package Commands;


public class UndoCommand implements ICommand{

    @Override
    public String execute() {
        return "undo";
    }

    @Override
    public String getOperand1() {
        return "";
    }

    @Override
    public String getOperand2() {
        return "";
    }

    @Override
    public String getOperator() {
        return "undo";
    }



}