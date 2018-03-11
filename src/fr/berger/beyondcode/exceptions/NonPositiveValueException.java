package fr.berger.beyondcode.exceptions;

import fr.berger.beyondcode.annotations.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class NonPositiveValueException extends RuntimeException {
	
	public NonPositiveValueException(@NotNull @NotEmpty String message) {
		super(message);
	}
	public NonPositiveValueException(int value) {
		this(value + " is not a positive value.");
	}
	public NonPositiveValueException() {
		super();
	}
}
