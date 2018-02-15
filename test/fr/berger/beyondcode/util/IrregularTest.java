package fr.berger.beyondcode.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IrregularTest {
	
	@Test
	void test_range() {
		System.out.println("test_range> " + Irregular.range(int.class, 0, true, 10, true));
	}
}