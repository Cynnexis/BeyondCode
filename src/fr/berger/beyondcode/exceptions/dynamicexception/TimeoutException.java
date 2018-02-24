package fr.berger.beyondcode.exceptions.dynamicexception;

import fr.berger.beyondcode.annotations.Positive;

import java.sql.Time;

public class TimeoutException extends DynamicException {
	
	/**
	 * Length of time in millis before timeout (ex: 3000ms)
	 */
	@Positive(strictly = true)
	private long length;
	
	/**
	 * The time in millis of the computer calculated from <c>start()</c> until timeout
	 */
	@Positive(strictly = false)
	private long timeout;
	
	/**
	 * The time in millis of the computer since <c>start()</c>
	 */
	@Positive(strictly = false)
	private long time_start;
	
	private boolean enabled;
	
	public TimeoutException(long length, boolean enabled) {
		setLength(length);
		setTimeout(0);
		setTimeStart(0);
		setEnabled(enabled);
	}
	public TimeoutException(long length) {
		this(length, false);
	}
	
	public void start() throws TimeoutException {
		long current = System.currentTimeMillis();
		setTimeout(current + getLength());
		setTimeStart(current);
		setEnabled(true);
		
		update();
	}
	
	public void update() throws TimeoutException {
		if (isEnabled()) {
			long current = System.currentTimeMillis();
			if (current > getTimeout())
				throw this;
		}
	}
	
	public void stop() throws TimeoutException {
		update();
		
		setEnabled(false);
	}
	
	/* GETTERS & SETTERS */
	
	// TODO: Add annotation '@Positive' for parameters and return type
	// TODO: Check the value of each parameters
	
	public long getLength() {
		return length;
	}
	
	public void setLength(long length) {
		this.length = length;
	}
	
	public long getTimeout() {
		return timeout;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	public long getTimeStart() {
		return time_start;
	}
	
	protected void setTimeStart(long timeStart) {
		this.time_start = timeStart;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	protected void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
