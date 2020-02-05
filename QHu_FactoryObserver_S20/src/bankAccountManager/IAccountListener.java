package bankAccountManager;

public interface IAccountListener {

    public void updateAccount(IAccountManager source);

    public void updateMessage(IAccountManager source);
    
    public void updateTransaction(IAccountManager source);
}