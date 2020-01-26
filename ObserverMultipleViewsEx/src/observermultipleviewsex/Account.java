package observermultipleviewsex;

import java.util.*;

public class Account {

	private double balance;
	/**
	 * Holds list of those to notify when the BalanceChanged event is fired.
	 */
	private ArrayList<BalanceChangedListener> balanceChangedListeners = new ArrayList<BalanceChangedListener>();


	public Account(double balance) {
		this.balance = balance;
	}


	public final double getBalance() {
		return balance;
	}


	public final void setBalance(double balance) {
		this.balance = balance;
	}


	/**
	 * Allows an observer to register for BalanceChanged events.
	 */
	public void addBalanceChangedListener(BalanceChangedListener listener) {
		balanceChangedListeners.add(listener);
	}


	/**
	 * Allows an observer to unregister for BalanceChanged events.
	 */
	public void removeBalanceChangedListener(BalanceChangedListener listener) {
		balanceChangedListeners.remove(listener);
	}


	/**
	 * Iterates through all listeners, informing them that a BalanceChanged event has occurred.
	 */
	private void fireBalanceChanged() {
		for (BalanceChangedListener listener : balanceChangedListeners)
			listener.balanceChanged(this);
	}


	public void deposit(double amount) {
		balance += amount;
		fireBalanceChanged(); // Inform observers that the balance has changed.
	}


	public void withdraw(double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
			fireBalanceChanged(); // Inform observers that the balance has changed.
		}
	}
}
