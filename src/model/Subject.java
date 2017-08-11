package model;

import java.util.Observer;

public interface Subject {
	public void register(Observer o);
	public void unregister(Observer o);
	public void notifyObserver();
}
