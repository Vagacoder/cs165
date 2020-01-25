package bankAccount;

public abstract class Account {

    protected String acctName;

    protected String acctType;

    protected int balanceInCent;

    public abstract String getAcctName();

    public abstract String getAcctType();

    public abstract int getBalanceInCent();

    public abstract void deposite(int amountInCent);

    public abstract void withdraw(int amountInCent);

}
