package bankAccountManager;

import bankAccount.IAccount;

public abstract class CreateAccount {

    public abstract IAccount createAccount(String accountType) throws Exception;
}