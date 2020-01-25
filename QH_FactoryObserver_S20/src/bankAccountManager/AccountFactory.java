package bankAccountManager;

import bankAccount.Account;

public class AccountFactory extends CreateAccount {

    @Override
    public Account createAccount(String accountType) throws Exception {
        Class accountClass = Class.forName(accountType + "Account");
        Account accountInstance = (Account) accountClass.getDeclaredConstructor().newInstance();
        return accountInstance;
    }

}