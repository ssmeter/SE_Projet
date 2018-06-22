package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DbMan {
	Connection con;
	public DbMan(){
		con = null;
	    try {
			Class.forName("org.sqlite.JDBC");
			this.connect();
			con = (Connection) DriverManager.getConnection("jdbc:sqlite:./src/se_projet.db");
			this.createTables();
			this.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void connect() throws SQLException{
		con = (Connection) DriverManager.getConnection("jdbc:sqlite:./src/se_projet.db");
	}
	
	private void disconnect() throws SQLException{
	    con.close();
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
	
	private void addField(String name) throws SQLException{
		//Create table field
		String sql = "INSERT INTO fields (fname) VALUES (?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
	}
	
	public void addBooking(Booking b) throws SQLException{
		this.connect();
		//Create table field
		String sql = "INSERT INTO bookings (fid, date, time, phone_number) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, b.getField());
		preparedStatement.setString(2, b.getDate().toString());
		preparedStatement.setInt(3, b.getTime());
		preparedStatement.setString(4, b.getPhoneNumber());
		preparedStatement.executeUpdate();
		this.disconnect();
	}
	
	public ArrayList<Booking> getBookings(LocalDate d) throws SQLException{
		this.connect();
		String sql = "SELECT * FROM bookings WHERE date=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, d.toString());
		ResultSet rs = preparedStatement.executeQuery(sql);
		ArrayList<Booking> result = new ArrayList<>();
		while(rs.next()){
			result.add(new Booking(rs.getInt("fid"), LocalDate.parse(rs.getString("date")), rs.getString("phone_number"), rs.getInt("time")));
		}
		this.disconnect();
		return result;
	}
	
	
}