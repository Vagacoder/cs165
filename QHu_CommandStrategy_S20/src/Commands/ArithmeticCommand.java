package Commands;

import Components.DisplayPanel;

public class ArithmeticCommand implements ICommand {

    protected String operand1;
    protected String operator;
    protected String operand2;
    private DisplayPanel display;

    public ArithmeticCommand(String operand1, String operator, String operand2, 
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
        double o2 = Double.parseDouble(operand2);
        if(operator.equals("+")){
            result = (o1 + o2) + "";
        } else if(operator.equals("-")){
            result = (o1 - o2) + "";
        } else if(operator.equals("x")){
            result = (o1 * o2) + "";
        } else if(operator.equals("\u00f7")){
            result = (o1 / o2) + "";
        } else {
            result = "Error";
        }

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