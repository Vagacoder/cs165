package bankAccountManager;

import java.util.ArrayList;

public abstract class IAccountManager {

    private ArrayList<IAccountListener> accountListeners = new ArrayList<>();

    public abstract void addAccountListener(IAccountListener listener);

    public abstract void removeAccountListener(IAccountListener listener);

    public abstract void fireAccountUpdated();

}