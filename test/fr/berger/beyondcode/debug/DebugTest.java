package fr.berger.beyondcode.debug;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugTest {
	
	@BeforeEach
	void setUp() {
		Debug.setDebug(true);
		Debug.setPrintFunctionName(true);
	}
	
	@Test
	void println() {
		functionTest(0, "", null);
	}
	
	@Disabled
	@SuppressWarnings({"SameParameterValue", "unused"})
	private void functionTest(int n, String test, Object obj) {
		Debug.println("This is a print test");
	}
	
	@Test
	void getCurrentFunctionName() {
		System.out.println(Thread.currentThread().getStackTrace()[1].toString());
		System.out.println(Debug.getCurrentFunctionName());
	}
	
	@Test
	void getCurrentFunctionSimpleName() {
		System.out.println(Debug.getCurrentFunctionSimpleName());
	}
}