package fr.berger.beyondcode.util.flow;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class RowTemplate extends ArrayList<Class<?>> {
	
	public RowTemplate(@Nullable Class<?>... classes) {
		if (classes != null) {
			for (Class<?> clazz : classes)
				if (clazz != null)
					add(clazz);
		}
	}
	
	public boolean assertRow(@Nullable Row row) {
		if (row == null)
		{
			if (this.size() == 0)
				return true;
			else
				return false;
		}
		
		if (this.size() < row.size())
			return false;
		
		for (int i = 0; i < row.size(); i++) {
			if (!this.get(i).isInstance(row.get(i)))
				return false;
		}
		
		// For the rest of the list in <c>this<c>, check if there are nullable
		for (int i = row.size(); i < this.size(); i++) {
			if (this.get(i).isAssignableFrom(int.class) ||
					this.get(i).isAssignableFrom(byte.class) ||
					this.get(i).isAssignableFrom(short.class) ||
					this.get(i).isAssignableFrom(long.class) ||
					this.get(i).isAssignableFrom(char.class) ||
					this.get(i).isAssignableFrom(boolean.class) ||
					this.get(i).isAssignableFrom(float.class) ||
					this.get(i).isAssignableFrom(double.class))
				return false;
		}
		
		return true;
	}
	
	/* OVERRIDE */
	
	@Override
	public boolean add(@NotNull Class<?> clazz) {
		if (clazz == null)
			throw new NullPointerException();
		
		return super.add(clazz);
	}
}
