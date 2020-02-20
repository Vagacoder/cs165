package Components;

import java.util.ArrayList;
import java.util.LinkedList;

import Commands.ArithmeticCommand;
import Commands.ICommand;
import Logs.ILog;

public class Processor {

  private DisplayPanel display;
  private LogManager logManger;
  private LinkedList<ICommand> commands;

  private String operand1;
  private String operand2;
  private String operator;

  public Processor(DisplayPanel display) {
    this.display = display;
    this.commands = new LinkedList<>();
    this.logManger = new LogManager();
    this.operand1 = "0";
    this.operand2 = "";
    this.operator = "";
  }

  public void takeOperand(String newOperand){
    if (this.operator.equals("")) {
      this.operand1 += newOperand;
    } else {
      this.operand2 += newOperand;
    }
    updateDisplay();
  }

  public void takeOperator(String operator){
    if (this.operator.equals("")) {
      this.operator = operator;
    }
    updateDisplay();
  }

  public void clearAll(){
    this.operand1 = "0";
    this.operand2 = "";
    this.operator = "";
    updateDisplay();
  }

  public void executeCommand(){
    executeCommand(new ArithmeticCommand(this.operand1, this.operator, this.operand2, 
      this.display));
  }


  public void executeCommand(ICommand command) {
    this.operand1 = command.execute();
    this.operand2 = "";
    this.operator = "";
    this.commands.push(command);
    this.logManger.addLog(convertCommandToLog(command));
  }

  private String convertCommandToLog(ICommand command){
    return command.getOperand1() + command.getOperator() + command.getOperand2();
  }


  // // * Handle digits and decimal point
  // public void executeDigitCommand(DigitCommand command) {

  //   String newOperand = command.getDigit();
  //   if (this.operator.equals("")) {
  //     this.operand1 += newOperand;
  //   } else {
  //     this.operand2 += newOperand;
  //   }
  //   updateDisplay();
  // }

  // // * Handle AC (all clear)
  // public void executeAcCommand() {
  //   this.operand1 = "0";
  //   this.operand2 = "";
  //   this.operator = "";
  //   // updateDisplay();
  // }

  // // * Handle arithmetic operation (+, -, *, /)
  // public void executeArithmeticCommand(ArithmeticCommand command){
  //     if (this.operator.equals("")) {
  //       this.operator = command.getOperator();
  //     }
  //   // updateDisplay();
  // }


  private void updateDisplay() {
    String data = this.operand1 + " " + this.operator + " " + this.operand2;
    this.display.updateResultLabel(data);
  }



}