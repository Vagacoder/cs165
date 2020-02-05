package bankAccount;

import java.util.ArrayList;

public abstract class IAccount {

    protected String acctName;

    protected String acctType;

    protected int balanceInCent;

    public abstract String getAcctName();

    public abstract String getAcctType();

    public abstract int getBalanceInCent();

    public abstract void deposit(int amountInCent);

    public abstract void withdraw(int amountInCent);

    public abstract ArrayList<Transaction> getTransactions();

}
