package fr.berger.beyondcode.exceptions;

import fr.berger.beyondcode.annotations.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class NonNegativeValueException extends RuntimeException {
	
	public NonNegativeValueException(@NotNull @NotEmpty String message) {
		super(message);
	}
	public NonNegativeValueException(int value) {
		this(value + " is not a negative value.");
	}
	public NonNegativeValueException() {
		super();
	}
}
