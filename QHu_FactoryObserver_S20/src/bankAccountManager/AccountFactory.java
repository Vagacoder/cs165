package bankAccountManager;

import bankAccount.*;

public class AccountFactory extends CreateAccount {

    @Override
    public IAccount createAccount(String accountType) throws Exception {
        Class accountClass = Class.forName("bankAccount." + accountType + "Account");
        IAccount accountInstance = (IAccount) accountClass.getDeclaredConstructor().newInstance();
        return accountInstance;
    }

}