package observermultipleviewsex;

/**
 * Observers that want to listen for BalanceChanged events must implement this interface,
 * which requires the observer to have a balanceChanged() method.
 */
public interface BalanceChangedListener {
	public void balanceChanged(Account sender);
}