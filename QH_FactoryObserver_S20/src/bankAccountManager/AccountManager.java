package bankAccountManager;

import java.util.ArrayList;
import static sbcc.Core.*;

import bankAccount.IAccount;

public class AccountManager extends IAccountManager {

  private ArrayList<IAccountListener> accountListeners = new ArrayList<>();
  private ArrayList<IAccount> accountList = new ArrayList<>();
  private int selectedAccountIndex = -1;

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
  public void addAccount(IAccount account) {
    this.accountList.add(account);
  }

  @Override
  public void removeSelectedAccount() {
    if (this.selectedAccountIndex >= 0) {
      this.accountList.remove(this.selectedAccountIndex);
      this.selectedAccountIndex = -1;
      println("System warning: Account removed!");
    } else {
      println("System warning: Please select an account!");
    }
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

  @Override
  public void setSelectedAccount(int index) {
    this.selectedAccountIndex = index;
  }

  @Override
  public void deposite(int amountInCent) {
    if (this.selectedAccountIndex >= 0) {
      this.accountList.get(this.selectedAccountIndex).deposite(amountInCent);
    } else {
      println("System warning: Please select an account!");
    }
  }

  @Override
  public void withdraw(int amountInCent) {
    if (this.selectedAccountIndex >= 0) {
      IAccount acct = this.accountList.get(this.selectedAccountIndex);
      if (acct.getBalanceInCent() >= amountInCent) {
        acct.withdraw(amountInCent);
      } else {
        println("System warning: Not enough money!");
      }
    } else {
      println("System warning: Please select an account!");
    }
  };

}