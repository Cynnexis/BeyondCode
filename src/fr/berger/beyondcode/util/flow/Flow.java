package fr.berger.beyondcode.util.flow;

import fr.berger.beyondcode.annotations.NotEmpty;
import fr.berger.beyondcode.annotations.Positive;
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
	@NotNull
	private RowTemplate columns;
	
	public Flow(@NotNull @NotEmpty String name, @NotNull @NotEmpty String path, @NotNull ArrayList<String> headers, @NotNull RowTemplate columns, @Positive(strictly = false) int initialCapacity) {
		super(initialCapacity);
		
		setName(name);
		setPath(path);
		setHeaders(headers);
		setColumns(columns);
	}
	public Flow(@NotNull @NotEmpty String name, @NotNull @NotEmpty String path, @NotNull ArrayList<String> headers, @NotNull RowTemplate columns) {
		this(name, path, headers, columns, 5);
	}
	public Flow(@NotNull @NotEmpty String name, @NotNull ArrayList<String> headers, @NotNull RowTemplate columns) {
		this(name, "", headers, columns, 5);
	}
	public Flow(@NotNull @NotEmpty String name, @NotNull RowTemplate columns) {
		this(name, "", new ArrayList<>(10), columns, 5);
	}
	public Flow() {
		this("Flow-NoTitle-" + new SimpleDateFormat("ddMMyyyy-HHmmss").format(new Date()),
				"",
				new ArrayList<>(10),
				new RowTemplate(),
				5);
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
		
		if (!path.endsWith(getName() + ".cvs")) {
			if (path.endsWith(getName()))
				path += ".cvs";
			else
				path += getName() + ".cvs";
		}
		
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
	
	public @NotNull RowTemplate getColumns() {
		return columns;
	}
	
	public void setColumns(@NotNull RowTemplate columns) {
		if (columns == null)
			throw new NullPointerException();
		
		this.columns = columns;
	}
	
	/* OVERRIDES */
	
	@Override
	public boolean add(@NotNull Row row) {
		if (row == null)
			throw new NullPointerException();
		
		if (columns.assertRow(row))
			return super.add(row);
		else
			return false;
	}
}
