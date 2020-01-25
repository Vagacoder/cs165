package bankAccount;

public class CDAccount extends Account {

    // constructors
    public CDAccount() {
        this.acctType = "CD";
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
    public void deposite(int amountInCent) {
        this.balanceInCent += amountInCent;
    }

    @Override
    public void withdraw(int amountInCent) {
        if (this.balanceInCent >= amountInCent) {
            this.balanceInCent -= amountInCent;
        } else {
            throw new IllegalArgumentException();
        }
    }

}