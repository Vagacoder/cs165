package bankAccount;

import java.util.ArrayList;
import java.util.Date;

public class SavingAccount extends IAccount {

    private ArrayList<Transaction> transactions;
    // constructors
    public SavingAccount() {
        this.acctType = "Saving";
        this.transactions = new ArrayList<>();
    }

    public SavingAccount(int startBalanceInCent) {
        this();
        this.balanceInCent = startBalanceInCent;
    }

    public SavingAccount(String accountName) {
        this();
        this.acctName = accountName;
    }

    public SavingAccount(String accountName, int startBalanceInCent) {
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