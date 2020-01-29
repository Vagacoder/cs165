package bankAccountManager;

import java.util.ArrayList;
import bankAccount.IAccount;

public abstract class IAccountManager {

    public abstract void addAccountListener(IAccountListener listener);

    public abstract void removeAccountListener(IAccountListener listener);

    public abstract void fireAccountUpdated();
    
    public abstract void fireMessageUpdated();

    public abstract String getFeedbackMessage();

    public abstract void addAccount(IAccount account);

    public abstract void removeSelectedAccount(int indexOfAccount);

    public abstract IAccount getAccount(int index);

    public abstract ArrayList<IAccount> getAllAccouts();

    public abstract ArrayList<IAccount> getAllAccountsByType(String acctType);

    public abstract void deposite(int indexOfAccount, int amountInCent);

    public abstract void withdraw(int indexOfAccount, int amountInCent);

}