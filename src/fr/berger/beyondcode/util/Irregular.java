package fr.berger.beyondcode.util;

import java.util.Random;

public class Irregular {
	
	private Irregular() { }
	
	public static <T> Object range(Class<T> clazz, int min, boolean minIncluded, int max, boolean maxIncluded) {
		if (!minIncluded)
			min++;
		
		if (!maxIncluded)
			max--;
		
		if (min > max)
			throw new IllegalArgumentException("min must be lesser than max");
		
		if (min == max)
			return null;
		
		Object random = null;
		
		if (clazz.isAssignableFrom(int.class) || clazz.isAssignableFrom(Integer.class))
			random = new Random(System.currentTimeMillis()).nextInt() % (max + 1 - min) + min;
		
		
		return random;
	}
}
