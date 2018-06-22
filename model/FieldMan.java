package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FieldMan {
	private ArrayList<Field> fields;
	
	public FieldMan(){
		DbMan db = new DbMan();
		try {
			this.fields = db.getFields();
		} catch (SQLException e) {
			this.fields = new ArrayList<>();
		}
	}
	
	public ArrayList<Field> getFields(){
		return this.fields;
	}
}