package bankAccountManager;

import java.util.ArrayList;

public abstract class AccountManager {

    private ArrayList<AccountListener> accountListeners = new ArrayList<>();

    public abstract void addAccountListener(AccountListener listener);

    public abstract void removeAccountListener(AccountListener listener);

    public abstract void fireAccountUpdated();

}