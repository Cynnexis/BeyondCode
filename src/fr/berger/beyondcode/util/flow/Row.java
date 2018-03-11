package fr.berger.beyondcode.util.flow;

import fr.berger.beyondcode.annotations.NotEmpty;
import fr.berger.beyondcode.annotations.Positive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class Row extends Observable {
	
	private ArrayList<Object> list;
	
	public Row(@NotNull ArrayList<Object> objects) {
		add(objects);
	}
	public Row(@NotNull Object... objects) {
		add(objects);
	}
	public Row() { }
	
	public void snap() {
		setChanged();
		notifyObservers();
	}
	
	/* GETTERS & SETTERS */
	
	@NotNull
	protected ArrayList<Object> getList() {
		if (list == null)
			list = new ArrayList<>();
		
		return list;
	}
	
	protected void setList(@NotNull ArrayList<Object> list) {
		if (list == null)
			throw new NullPointerException();
		
		this.list = list;
		snap();
	}
	
	/* LIST METHOD */
	
	public boolean add(@Nullable Object o) {
		boolean result = getList().add(o);
		
		if (result)
			snap();
		
		return result;
	}
	public boolean add(@NotNull Object... objects) {
		boolean result = getList().addAll(Arrays.asList(objects));
		
		if (result)
			snap();
		
		return result;
	}
	public boolean add(@NotNull ArrayList<Object> objects) {
		boolean result = getList().addAll(objects);
		
		if (result)
			snap();
		
		return result;
	}
	
	public @Nullable Object remove(@Positive int index) {
		Object result = getList().remove(index);
		
		if (result != null)
			snap();
		
		return result;
	}
	public boolean remove(@Nullable Object o) {
		boolean result = getList().remove(o);
		
		if (result)
			snap();
		
		return result;
	}
	
	public Object get(int index) {
		Object result = getList().get(index);
		
		if (result != null)
			snap();
		
		return result;
	}
}
