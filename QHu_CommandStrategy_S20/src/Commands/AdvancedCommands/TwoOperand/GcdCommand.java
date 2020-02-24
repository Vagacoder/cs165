package Commands.AdvancedCommands.TwoOperand;

import Commands.ICommand;
import Components.DisplayPanel;

public class GcdCommand implements ICommand{

    protected String operand1;
    protected String operator;
    protected String operand2;
    private DisplayPanel display;


    public GcdCommand(String operand1, String operator, String operand2, 
    DisplayPanel display){
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
        this.display= display;
    }


    @Override
    public String execute() {
        String result = "";
        int o1 = Integer.parseInt(operand1);
        int o2 = Integer.parseInt(operand2);

        if (o1 > o2){
            result = gcd(o1, o2) + "";
        } else {
            result = gcd(o2, o1) + "";
        }
        this.display.updateResultLabel(result);
        return result;
    }

    private int gcd(int a, int b){
        int r = a % b;
        while (r != 0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
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