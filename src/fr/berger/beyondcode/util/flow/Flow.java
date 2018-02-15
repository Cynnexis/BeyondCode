package fr.berger.beyondcode.util.flow;

import fr.berger.beyondcode.annotations.NotEmpty;
import fr.berger.beyondcode.annotations.Positive;
import fr.berger.beyondcode.exceptions.NonPositiveValueException;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flow extends ArrayList<Row> {
	
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String path;
	@NotNull
	private ArrayList<String> headers;
	@Positive(strictly = false)
	private int numberOfColumns;
	
	public Flow() {
		super(5);
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy-HHmmss");
		
		setName("Flow-NoTitle-" + sdf.format(new Date()));
		setPath(name + ".cvs");
		setHeaders(new ArrayList<>(10));
		setNumberOfColumns(0);
	}
	
	public boolean generateFile() {
		return false;
	}
	
	/* GETTERS & SETTERS */
	
	public @NotNull @NotEmpty String getName() {
		return name;
	}
	
	public void setName(@NotNull @NotEmpty String name) {
		if (name == null)
			throw new NullPointerException();
		
		if (name.equals(""))
			throw new IllegalArgumentException();
		
		this.name = name;
	}
	
	public @NotNull @NotEmpty String getPath() {
		return path;
	}
	
	public void setPath(@NotNull @NotEmpty String path) {
		if (path == null)
			throw new NullPointerException();
		
		if (path.equals(""))
			throw new IllegalArgumentException();
		
		this.path = path;
	}
	
	public @NotNull ArrayList<String> getHeaders() {
		return headers;
	}
	
	public void setHeaders(@NotNull ArrayList<String> headers) {
		if (headers == null)
			throw new NullPointerException();
		
		this.headers = headers;
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public void setNumberOfColumns(int numberOfColumns) {
		if (numberOfColumns < 0)
			throw new NonPositiveValueException();
		
		this.numberOfColumns = numberOfColumns;
	}
}
