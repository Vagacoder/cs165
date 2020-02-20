package Commands;

public interface ICommand{

    public abstract String execute();

    public abstract String getOperand1();

    public abstract String getOperand2();

    public abstract String getOperator();
}