package bankAccountManager;

import bankAccount.Account;

public abstract class CreateAccount {

    public abstract Account createAccount(String accountType) throws Exception;
}