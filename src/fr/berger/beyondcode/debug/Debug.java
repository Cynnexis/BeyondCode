package fr.berger.beyondcode.debug;

import fr.berger.beyondcode.annotations.Positive;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;

public class Debug {
	
	private static boolean debug;
	private static boolean printFunctionName = true;
	
	private Debug() { }
	
	public static void print(String text) {
		display(text, false);
	}
	public static void print(int text) {
		display(Integer.toString(text), false);
	}
	public static void print(byte text) {
		display(Byte.toString(text), false);
	}
	public static void print(boolean text) {
		display(Boolean.toString(text), false);
	}
	public static void print(short text) {
		display(Short.toString(text), false);
	}
	public static void print(long text) {
		display(Long.toString(text), false);
	}
	public static void print(float text) {
		display(Float.toString(text), false);
	}
	public static void print(double text) {
		display(Double.toString(text), false);
	}
	public static void print(Object text) {
		display(text.toString(), false);
	}
	
	
	public static void println(String text) {
		display(text, true);
	}
	public static void println(int text) {
		display(Integer.toString(text), true);
	}
	public static void println(byte text) {
		display(Byte.toString(text), true);
	}
	public static void println(boolean text) {
		display(Boolean.toString(text), true);
	}
	public static void println(short text) {
		display(Short.toString(text), true);
	}
	public static void println(long text) {
		display(Long.toString(text), true);
	}
	public static void println(float text) {
		display(Float.toString(text), true);
	}
	public static void println(double text) {
		display(Double.toString(text), true);
	}
	public static void println(Object text) {
		display(text.toString(), true);
	}
	
	private static void display(String msg, boolean ln) {
		if (isDebug()) {
			String message = "";
			
			if (isPrintFunctionName())
				message = getCurrentFunctionName(3) + "> ";
			
			message += msg;
			
			if (ln)
				System.out.println(message);
			else
				System.out.print(message);
		}
	}
	
	public static void test() {
		System.out.println("Thread.currentThread().getStackTrace()> ");
		for (StackTraceElement e : Thread.currentThread().getStackTrace())
			System.out.println(e.toString());
		
		System.out.println();
		
		System.out.println("Current method: " + Thread.currentThread().getStackTrace()[2]);
	}
	
	/**
	 * Try to get the name of the function where this method is called.
	 * @return The name of the method (in its package).
	 */
	public static String getCurrentFunctionName(@Positive(strictly = false) int level) {
		if (Thread.currentThread().getStackTrace().length >= level + 2)
			return Thread.currentThread().getStackTrace()[level + 1].toString();
		
		return Thread.currentThread().getStackTrace()[Thread.currentThread().getStackTrace().length-1].toString();
	}
	/**
	 * Try to get the name of the function where this method is called.
	 * @return The name of the method (in its package).
	 */
	public static String getCurrentFunctionName() {
		if (Thread.currentThread().getStackTrace().length >= 3)
			return Thread.currentThread().getStackTrace()[2].toString();
		
		return Thread.currentThread().getStackTrace()[Thread.currentThread().getStackTrace().length-1].toString();
	}
	
	/**
	 * Return the name of the function where this method is called, without the package and class name before.
	 * @return
	 */
	public static String getCurrentFunctionSimpleName(int level) {
		if (Thread.currentThread().getStackTrace().length >= level + 2)
			return Thread.currentThread().getStackTrace()[level + 1].getMethodName();
		
		return Thread.currentThread().getStackTrace()[Thread.currentThread().getStackTrace().length-1].getMethodName();
	}
	/**
	 * Return the name of the function where this method is called, without the package and class name before.
	 * @return
	 */
	public static String getCurrentFunctionSimpleName() {
		if (Thread.currentThread().getStackTrace().length >= 3)
			return Thread.currentThread().getStackTrace()[2].getMethodName();
		
		return Thread.currentThread().getStackTrace()[Thread.currentThread().getStackTrace().length-1].getMethodName();
	}
	
	/* GETTER & SETTER */
	
	@Contract(pure = true)
	public static boolean isDebug() {
		return debug;
	}
	
	public synchronized static void setDebug(boolean isDebug) {
		Debug.debug = isDebug;
	}
	
	@Contract(pure = true)
	public static boolean isPrintFunctionName() {
		return printFunctionName;
	}
	
	public synchronized static void setPrintFunctionName(boolean printFunctionName) {
		Debug.printFunctionName = printFunctionName;
	}
}
