package fr.berger.beyondcode.exceptions.dynamicexception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeoutExceptionTest {
	
	TimeoutException to_ex;
	long timeout = 500; // ms
	
	@BeforeEach
	void setup() {
		to_ex = new TimeoutException(timeout); // 500ms of timeout
	}
	
	/**
	 * The goal of this test is to have a time out exception, that is why the "catch" is associated to a good thing,
	 * and the end of the "try" to a bad thing.
	 */
	@Test
	void test_timeout() throws Exception {
		// Start the timeout (if there is a timeoutexception, this is NOT normal)
		to_ex.start();
		
		// Update the timeout exception (if there is a timeoutexception, it IS normal)
		boolean exceptionCaught = false;
		try {
			long startTime = System.currentTimeMillis();
			
			while (System.currentTimeMillis() <= startTime + timeout + 1) {
				to_ex.update();
			}
		} catch (TimeoutException ex) {
			exceptionCaught = true;
		}
		
		if (!exceptionCaught)
			throw new Exception("Timeout did not show up!");
		
		// Now, the following test must not throw any exception
		to_ex.start();
		long startTime = System.currentTimeMillis();
		
		while (System.currentTimeMillis() < startTime + timeout - 1) {
			to_ex.update();
		}
	}
}