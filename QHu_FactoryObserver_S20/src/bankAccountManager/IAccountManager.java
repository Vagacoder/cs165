package bankAccountManager;

import java.util.ArrayList;

import javax.swing.JFrame;

import bankAccount.IAccount;
import bankAccount.Transaction;

public abstract class IAccountManager {

    public abstract void addAccountListener(IAccountListener listener);

    public abstract void removeAccountListener(IAccountListener listener);

    public abstract void fireAccountUpdated();
    
    public abstract void fireMessageUpdated();

    public abstract void fireTransactionUpdated();

    public abstract String getFeedbackMessage();

    public abstract void addAccount(IAccount account);

    public abstract void removeSelectedAccount(JFrame mainWindow, int indexOfAccount);

    public abstract IAccount getAccount(int index);

    public abstract ArrayList<IAccount> getAllAccounts();

    public abstract ArrayList<IAccount> getAllAccountsByType(String acctType);

    public abstract void deposit(int indexOfAccount, int amountInCent);

    public abstract void withdraw(int indexOfAccount, int amountInCent);

    public abstract ArrayList<Transaction> getTransactions();

    public abstract void showAcctTransactions(int indexOfAccount);

}