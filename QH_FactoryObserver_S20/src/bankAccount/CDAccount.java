package bankAccount;

import java.util.ArrayList;
import java.util.Date;

public class CDAccount extends IAccount {

    private ArrayList<Transaction> transactions;
    // constructors
    public CDAccount() {
        this.acctType = "CD";
        this.transactions = new ArrayList<>();
    }

    public CDAccount(int startBalanceInCent) {
        this();
        this.balanceInCent = startBalanceInCent;
    }

    public CDAccount(String accountName) {
        this();
        this.acctName = accountName;
    }

    public CDAccount(String accountName, int startBalanceInCent) {
        this(accountName);
        this.balanceInCent = startBalanceInCent;
    }

    @Override
    public String getAcctName() {
        return this.acctName;
    }

    @Override
    public String getAcctType() {
        return this.acctType;
    }

    @Override
    public int getBalanceInCent() {
        return this.balanceInCent;
    }

    @Override
    public void deposit(int amountInCent) {
        this.balanceInCent += amountInCent;
        Transaction newTrans = new Transaction(amountInCent, new Date(), this.balanceInCent, "DEPOSIT");
        this.transactions.add(newTrans);
    }

    @Override
    public void withdraw(int amountInCent) {
        if (this.balanceInCent >= amountInCent) {
            this.balanceInCent -= amountInCent;
            Transaction newTrans = new Transaction(amountInCent, new Date(), this.balanceInCent, "WITHDRAW");
            this.transactions.add(newTrans);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

}