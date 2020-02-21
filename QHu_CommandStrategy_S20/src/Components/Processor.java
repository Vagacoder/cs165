package Components;

import java.util.Stack;

import Commands.ArithmeticCommand;
import Commands.ICommand;

public class Processor {

  private DisplayPanel display;
  private LogManager logManger;
  private Stack<ICommand> commands;

  private String operand1;
  private String operand2;
  private String operator;

  public Processor(DisplayPanel display, LogManager logManager) {
    this.display = display;
    this.commands = new Stack<>();
    this.logManger = logManager;
    this.operand1 = "0";
    this.operand2 = "";
    this.operator = "";
  }

  public void takeOperand(String newOperand) {
    if (this.operator.equals("")) {
      if (this.operand1.equals("0") && !newOperand.equals(".")) {
        this.operand1 = newOperand;
      } else {
        this.operand1 += newOperand;
      }
    } else {
      if (this.operand2.equals("") && newOperand.equals(".")) {
      } else {
        this.operand2 += newOperand;
      }
    }
    updateDisplay();
  }

  public void takeOperator(String operator) {
    if (this.operator.equals("")) {
      this.operator = operator;
    }
    updateDisplay();
  }

  public void clearAll() {
    this.operand1 = "0";
    this.operand2 = "";
    this.operator = "";
    updateDisplay();
  }

  public void undo() {
    if (!commands.isEmpty()) {
      commands.pop();
      this.logManger.addLog("undo");
      if (!commands.isEmpty()) {
        executeCommand(commands.pop());
      } else {
        clearAll();
      }
    }
  }

  public void executeEquation() {
    executeCommand(new ArithmeticCommand(this.operand1, this.operator, this.operand2, this.display));
  }

  public void executeCommand(ICommand command) {
    this.operand1 = command.execute();
    this.operand2 = "";
    this.operator = "";
    this.commands.push(command);
    this.logManger.addLog(command);
    System.out.println(convertCommandToLog(command));
  }

  private String convertCommandToLog(ICommand command) {
    return command.getOperand1() + command.getOperator() + command.getOperand2();
  }

  private void updateDisplay() {
    String data = this.operand1 + " " + this.operator + " " + this.operand2;
    this.display.updateResultLabel(data);
  }

}