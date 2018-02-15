package fr.berger.beyondcode.debug;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugTest {
	
	@BeforeEach
	void setUp() {
		Debug.setDebug(true);
		Debug.setPrintFunctionName(true);
	}
	
	@Test
	void getCurrentFunctionName() {
		functionTest(0, "", null);
	}
	
	@SuppressWarnings("SameParameterValue")
	private void functionTest(int n, String test, Object obj) {
		Debug.println("This is a print test");
	}
}