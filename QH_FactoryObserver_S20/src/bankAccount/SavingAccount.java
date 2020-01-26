package bankAccount;

public class SavingAccount extends IAccount {

    // constructors
    public SavingAccount() {
        this.acctType = "Saving";
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