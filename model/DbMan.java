package model;

import java.sql.*;

public class DbMan {
	Connection con;
	
	public DbMan(){
		con = null;
	    try {
			Class.forName("org.sqlite.JDBC");
			con = (Connection) DriverManager.getConnection("jdbc:sqlite:se_projet.db");
			this.createTables();
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createTables() throws SQLException{
		Statement stmt = null;
		stmt = con.createStatement();
		//Create table field
		String sql = "CREATE TABLE IF NOT EXISTS `fields` "
				+ "( `fid` INTEGER PRIMARY KEY AUTOINCREMENT ,"
				+ "`fname` VARCHAR(200) NOT NULL) ";
		stmt.executeUpdate(sql);
		
		//Create table bookings
		sql = " CREATE TABLE IF NOT EXISTS `bookings` "
				+ "( `bid` INTEGER PRIMARY KEY AUTOINCREMENT , "
				+"`fid` INTEGER NOT NULL , "
				+ "`date` DATE NOT NULL , " 
				+ "`time` INTEGER NOT NULL , "
				+ "`phone_number` INTEGER NOT NULL)";
		stmt.executeUpdate(sql);
		stmt.close();
	}
}
