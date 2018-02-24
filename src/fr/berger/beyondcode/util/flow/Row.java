package fr.berger.beyondcode.util.flow;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Row extends ArrayList<Object> {
	
	public Row(@Nullable Object... objects) {
		if (objects != null) {
			for (Object object : objects) {
				if (object != null)
					add(object);
			}
		}
	}
	
	/* OVERRIDE */
	
	@Override
	public boolean add(@NotNull Object o) {
		if (o != null)
			return super.add(o);
		else
			return false;
	}
}
