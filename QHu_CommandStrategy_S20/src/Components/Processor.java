package Components;

import java.util.Stack;

import Commands.ArithmeticCommand;
import Commands.ICommand;
import Commands.UndoCommand;

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
        if (newOperand.equals(".") && (this.operand1.contains("."))) {
        } else {
          this.operand1 += newOperand;
        }
      }
    } else {
      if (this.operand2.equals("") && newOperand.equals(".")) {
      } else if (this.operand2.equals("0") && !newOperand.equals(".")) {
        this.operand2 = newOperand;
      } else {
        if (newOperand.equals(".") && (this.operand2.contains("."))) {
        } else {
          this.operand2 += newOperand;
        }
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

  public void changeOperandSign() {
    if (this.operator.equals("")) {
      if (!this.operand1.equals("0")) {
        if (this.operand1.startsWith("-")) {
          this.operand1 = this.operand1.substring(1);
        } else {
          this.operand1 = "-" + operand1;
        }
      }
    } else {
      if (!this.operand2.equals("0") && !this.operand2.equals("")) {
        if (this.operand2.startsWith("-")) {
          this.operand2 = this.operand2.substring(1);
        } else {
          this.operand2 = "-" + operand2;
        }
      }
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
      this.logManger.addLog(new UndoCommand());
      if (!commands.isEmpty()) {
        executeCommand(commands.pop());
      } else {
        clearAll();
      }
    } else {
      clearAll();
    }
  }

  public void executeEquation() {
    executeCommand(new ArithmeticCommand(this.operand1, this.operator, this.operand2, this.display));
  }

  private void executeCommand(ICommand command) {
    this.operand1 = command.execute();
    this.operand2 = "";
    this.operator = "";
    this.commands.push(command);
    this.logManger.addLog(command);
    System.out.println(convertCommandToLog(command));
  }

  public void executeAdvOneOperandCommand(String advComName) {

    if (!this.operand2.equals("") || !this.operator.equals("")) {
      return;
    }

    this.operator = advComName;

    try {
      Class advComClass = Class.forName("Commands.AdvancedCommands." + advComName + "Command");
      Class[] args = new Class[4];
      args[0] = String.class;
      args[1] = String.class;
      args[2] = String.class;
      args[3] = DisplayPanel.class;

      ICommand advCom = (ICommand) advComClass.getDeclaredConstructor(args).newInstance(this.operand1, this.operator,
          this.operand2, this.display);
      executeCommand(advCom);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private String convertCommandToLog(ICommand command) {
    return command.getOperand1() + command.getOperator() + command.getOperand2();
  }

  private void updateDisplay() {
    String data = this.operand1 + " " + this.operator + " " + this.operand2;
    this.display.updateResultLabel(data);
  }

}