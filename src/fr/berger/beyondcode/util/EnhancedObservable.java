package fr.berger.beyondcode.util;

import org.jetbrains.annotations.Nullable;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Observable;

public abstract class EnhancedObservable extends Observable implements Serializable {
	
	protected void snap(@Nullable Object... objects) {
		setChanged();
		notifyObservers(objects);
	}
	protected void snap(@Nullable Object object) {
		setChanged();
		notifyObservers(object);
	}
	protected void snap() {
		setChanged();
		notifyObservers();
	}
}
