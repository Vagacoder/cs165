package counterStarter;

import java.util.ArrayList;

public class MyCounter {

	private ArrayList<CountChangedListener> countChangedListeners = new ArrayList<>();

	public void addCountChangedListener(CountChangedListener listener) {
		countChangedListeners.add(listener);
	}


	public void removeCountChangedListener(CountChangedListener listener) {
		countChangedListeners.remove(listener);
	}


	private void fireCountChanged() {
		for (var listener : countChangedListeners)
			listener.countChanged(this);
	}

	int count = 0;

	public void increment() {
		this.count++;
		this.fireCountChanged();
	}

}
