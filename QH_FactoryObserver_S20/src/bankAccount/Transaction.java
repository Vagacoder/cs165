package bankAccount;

import java.util.Date;

public class Transaction {

    private int amountInCent;
    private Date date;
    private int balanceAfter;
    private String operation;

    public Transaction(int amountInCent, Date date, int balanceAfter, String operation){
        this.amountInCent = amountInCent;
        this.date = date;
        this.balanceAfter = balanceAfter;
        this.operation = operation;
    }

    public int getAmountInCent(){
        return this.amountInCent;
    }
    public Date getDate(){
        return this.date;
    }
    public int getBalanceAfter(){
        return this.balanceAfter;
    }
    public String getOperation(){
        return this.operation;
    }
}