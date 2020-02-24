package Commands.AdvancedCommands.OneOperand;

import Commands.ICommand;
import Components.DisplayPanel;

public class SinCommand implements ICommand {

    protected String operand1;
    protected String operator;
    protected String operand2;
    private DisplayPanel display;

    public SinCommand(String operand1, String operator, String operand2, 
    DisplayPanel display){
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
        this.display= display;
    }

    @Override
    public String execute() {
        String result = "";
        double o1 = Double.parseDouble(operand1);
        result = String.format("%.6f", Math.sin(o1));
        this.display.updateResultLabel(result);
        return result;
    }

    @Override
    public String getOperand1() {
        return this.operand1;
    }

    @Override
    public String getOperand2() {
        return this.operand2;
    }

    @Override
    public String getOperator() {
        return this.operator;
    }
}