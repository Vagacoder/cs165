package bankAccountManager;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import static sbcc.Core.*;

import bankAccount.IAccount;
import bankAccount.Transaction;

public class AccountManager extends IAccountManager {

  private ArrayList<IAccountListener> accountListeners = new ArrayList<>();
  private ArrayList<IAccount> accountList = new ArrayList<>();
  private int selectedAccountIndex = -1;
  private String feedbackMessage = "";

  @Override
  public void addAccountListener(IAccountListener listener) {
    this.accountListeners.add(listener);
  }

  @Override
  public void removeAccountListener(IAccountListener listener) {
    this.accountListeners.remove(listener);
  }

  @Override
  public void fireAccountUpdated() {
    for (IAccountListener listener : this.accountListeners) {
      listener.updateAccount(this);
    }
  }

  @Override
  public void fireMessageUpdated() {
    for (IAccountListener listener : this.accountListeners) {
      listener.updateMessage(this);
    }
  };

  @Override
  public void fireTransactionUpdated() {
    for (IAccountListener listener : this.accountListeners) {
      listener.updateTransaction(this);
    }
  }

  @Override
  public String getFeedbackMessage() {
    return this.feedbackMessage;
  }

  @Override
  public void addAccount(IAccount account) {
    this.accountList.add(account);
    this.selectedAccountIndex = -1;
    println("System warning: Account added!");
    this.feedbackMessage = "A new acount: " + account.getAcctType() + " is added successfully.";
    this.fireMessageUpdated();
  }

  @Override
  public void removeSelectedAccount(JFrame mainWindow, int indexOfAccount) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0 && this.selectedAccountIndex < this.accountList.size()) {
      int userConfirmation = JOptionPane.showConfirmDialog(mainWindow,
          "Are you sure to PERMANENTLY REMOVE this account?", "Warning!", JOptionPane.OK_CANCEL_OPTION);

      if (userConfirmation == 0) {
        IAccount removedAcct = this.accountList.remove(this.selectedAccountIndex);
        this.selectedAccountIndex = -1;
        println("System warning: Account removed!");
        this.feedbackMessage = "A account: " + removedAcct.getAcctType() + " is removed successfully.";
      }
    } else {
      println("System warning: Please select an account!");
      this.feedbackMessage = "Warning: Please select an account!";
    }
    this.fireAccountUpdated();
    this.fireMessageUpdated();
    this.fireTransactionUpdated();
  }

  @Override
  public IAccount getAccount(int index) {
    return this.accountList.get(index);
  }

  @Override
  public ArrayList<IAccount> getAllAccountsByType(String acctType) {
    ArrayList<IAccount> result = new ArrayList<>();
    for (IAccount acct : this.accountList) {
      if (acct.getAcctType().equals(acctType)) {
        result.add(acct);
      }
    }
    return result;
  }

  @Override
  public ArrayList<IAccount> getAllAccounts() {
    return this.accountList;
  }

  private void setSelectedAccount(int index) {
    this.selectedAccountIndex = index;
  }

  @Override
  public void deposit(int indexOfAccount, int amountInCent) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0) {
      IAccount selectedAcct = this.accountList.get(this.selectedAccountIndex);
      selectedAcct.deposit(amountInCent);
      String amount = MainWindowNew.getMoneyString(amountInCent);
      this.feedbackMessage = "$" + amount + " is deposited to " + (this.selectedAccountIndex + 1) + " - "
          + selectedAcct.getAcctType();
    } else {
      println("System warning: Please select an account!");
      this.feedbackMessage = "Warning: Please select an account!";
    }
    this.fireAccountUpdated();
    this.fireMessageUpdated();
    this.fireTransactionUpdated();
  }

  @Override
  public void withdraw(int indexOfAccount, int amountInCent) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0) {
      IAccount selectedAcct = this.accountList.get(this.selectedAccountIndex);
      if (selectedAcct.getBalanceInCent() >= amountInCent) {
        selectedAcct.withdraw(amountInCent);
        int dollars = amountInCent / 10;
        int cents = amountInCent % 10;
        this.feedbackMessage = "$" + dollars + "." + cents + " is withdrawed from " + (this.selectedAccountIndex + 1)
            + " - " + selectedAcct.getAcctType();
      } else {
        println("System warning: Not enough money!");
        this.feedbackMessage = "Error: Not enough money in this account!";
      }
    } else {
      println("System warning: Please select an account!");
      this.feedbackMessage = "Warning: Please select an account!";
    }
    this.fireAccountUpdated();
    this.fireMessageUpdated();
    this.fireTransactionUpdated();
  }

  @Override
  public ArrayList<Transaction> getTransactions() {
    if (this.selectedAccountIndex >= 0) {
      IAccount selectedAcct = this.accountList.get(this.selectedAccountIndex);
      return selectedAcct.getTransactions();
    } else {
      return new ArrayList<Transaction>();
    }

  }

  @Override
  public void showAcctTransactions(int indexOfAccount) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0) {
      this.fireTransactionUpdated();
    } else {
      this.feedbackMessage = "Warning: Please select an account!";
    }
  }

}