package fr.berger.beyondcode.exceptions;

import fr.berger.beyondcode.annotations.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class ZeroValueException extends RuntimeException {
	
	public ZeroValueException(@NotNull @NotEmpty String message) {
		super(message);
	}
	public ZeroValueException(int value) {
		this(value + " is not zero.");
	}
	public ZeroValueException() {
		super();
	}
}
