package fr.berger.beyondcode.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IrregularTest {
	
	/**
	 * Just a test for <c>java.util.Random</c>.
	 * @see java.util.Random
	 */
	@Test
	void test_JavaRandom() {
		Random r = new Random(System.currentTimeMillis());
		int min = -10, max = 30;
		
		for (int i = 0; i < 100; i++) {
			System.out.println("test_JavaRandom> " + ((Math.abs(r.nextInt()) % (max + 1 - min)) + min));
		}
	}
	
	@Test
	void test_range() {
		int min = 0, max = 10;
		for (int i = 0; i < 1000; i++) {
			int r = (int) Irregular.range(int.class, min, true, max, true);
			System.out.println("test_range> [" + i + "]: " + r);
			Assertions.assertTrue(min <= r && r <= max);
		}
		
		for (int i = 0; i < 1000; i++) {
			int r = (int) Irregular.range(int.class, min, false, max, true);
			System.out.println("test_range> [" + i + "]: " + r);
			Assertions.assertTrue(min < r && r <= max);
		}
		
		for (int i = 0; i < 1000; i++) {
			int r = (int) Irregular.range(int.class, min, true, max, false);
			System.out.println("test_range> [" + i + "]: " + r);
			Assertions.assertTrue(min <= r && r < max);
		}
		
		for (int i = 0; i < 1000; i++) {
			int r = (int) Irregular.range(int.class, min, false, max, false);
			System.out.println("test_range> [" + i + "]: " + r);
			Assertions.assertTrue(min < r && r < max);
		}
	}
	
	@Test
	void test_rangeType() {
		System.out.println("test_rangeType> rangeInt = " + Irregular.rangeInt(0, true, 10, true));
		System.out.println("test_rangeType> rangeShort = " + Irregular.rangeShort((short) 0, true, (short) 10, true));
		System.out.println("test_rangeType> rangeByte = " + Irregular.rangeByte((byte) 0, true, (byte) 10, true));
		System.out.println("test_rangeType> rangeLong = " + Irregular.rangeLong(0L, true, 10L, true));
		System.out.println("test_rangeType> rangeChar = " + Irregular.rangeChar((char) 32, true, (char) 126, true));
		System.out.println("test_rangeType> rangeBoolean = " + Irregular.rangeBoolean());
		System.out.println("test_rangeType> rangeFloat = " + Irregular.rangeFloat(0f, true, 10f, true));
		System.out.println("test_rangeType> rangeDouble = " + Irregular.rangeDouble(0d, true, 10d, true));
		System.out.println("test_rangeType> rangeString = " + Irregular.rangeString(10, 20, true, false));
	}
}