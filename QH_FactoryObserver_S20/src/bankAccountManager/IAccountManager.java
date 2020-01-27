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

    public abstract void removeSelectedAccount();

    public abstract IAccount getAccount(int index);

    public abstract ArrayList<IAccount> getAllAccouts();

    public abstract ArrayList<IAccount> getAllAccountsByType(String acctType);

    public abstract void setSelectedAccount(int index);

    public abstract void deposite(int amountInCent);

    public abstract void withdraw(int amountInCent);

}