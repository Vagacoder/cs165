package bankAccountManager;

import java.util.ArrayList;

public class AccountManager extends IAccountManager{

    private ArrayList<IAccountListener> accountListeners = new ArrayList<>();

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
        for (IAccountListener listener : this.accountListeners){
            listener.updateAccount(this);
        }

    }

    
}