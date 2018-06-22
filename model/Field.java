package model;

public class Field {
	private int fID;
	private String fName;
	/**
	 * @param fID
	 * @param fName
	 */
	public Field(int fID, String fName) {
		super();
		this.fID = fID;
		this.fName = fName;
	}
	public int getfID() {
		return fID;
	}
	public String getfName() {
		return fName;
	}
}