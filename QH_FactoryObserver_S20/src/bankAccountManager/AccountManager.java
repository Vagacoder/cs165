package bankAccountManager;

import java.util.ArrayList;
import static sbcc.Core.*;

import bankAccount.IAccount;

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
  public String getFeedbackMessage() {
    return this.feedbackMessage;
  }

  @Override
  public void addAccount(IAccount account) {
    this.accountList.add(account);
    this.selectedAccountIndex = -1;
    println("System warning: Account added!");
    this.feedbackMessage = "A new acount: " + account.getAcctType() + 
      " is added successfully.";
  }

  @Override
  public void removeSelectedAccount(int indexOfAccount) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0 && this.selectedAccountIndex < this.accountList.size()) {
      IAccount removedAcct = this.accountList.remove(this.selectedAccountIndex);
      this.selectedAccountIndex = -1;
      println("System warning: Account removed!");
      this.feedbackMessage = "A account: " + removedAcct.getAcctType() + 
        " is removed successfully.";
    } else {
      println("System warning: Please select an account!");
      this.feedbackMessage = "Warning: Please select an account!";
    }
    this.fireAccountUpdated();
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
  public ArrayList<IAccount> getAllAccouts() {
    return this.accountList;
  }

  private void setSelectedAccount(int index) {
    this.selectedAccountIndex = index;
  }

  @Override
  public void deposite(int indexOfAccount, int amountInCent) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0) {
      IAccount selectedAcct = this.accountList.get(this.selectedAccountIndex);
      selectedAcct.deposite(amountInCent);
      int dollars = amountInCent /10;
      int cents = amountInCent % 10;
      this.feedbackMessage = "$"+ dollars + "." + cents + " is deposited to " + 
        (this.selectedAccountIndex + 1) + " - " + selectedAcct.getAcctType();
    } else {
      println("System warning: Please select an account!");
      this.feedbackMessage = "Warning: Please select an account!";
    }
    this.fireAccountUpdated();
  }

  @Override
  public void withdraw(int indexOfAccount, int amountInCent) {
    this.setSelectedAccount(indexOfAccount);
    if (this.selectedAccountIndex >= 0) {
      IAccount selectedAcct = this.accountList.get(this.selectedAccountIndex);
      if (selectedAcct.getBalanceInCent() >= amountInCent) {
        selectedAcct.withdraw(amountInCent);
        int dollars = amountInCent /10;
        int cents = amountInCent % 10;
        this.feedbackMessage = "$"+ dollars + "." + cents + " is withdrawed from " + 
          (this.selectedAccountIndex + 1) + " - " + selectedAcct.getAcctType();
      } else {
        println("System warning: Not enough money!");
        this.feedbackMessage = "Error: Not enough money in this account!";
      }
    } else {
      println("System warning: Please select an account!");
      this.feedbackMessage = "Warning: Please select an account!";
    }
    this.fireAccountUpdated();
  }

}