package database;

import java.sql.*;

public class Connect {
	private final String DATABASE = "stellarfest";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String HOST = "localhost:3306";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s",HOST,DATABASE);
	
	private Connection con;
	private Statement st;
	private static Connect instance;
	public ResultSet rs;
	public ResultSetMetaData rsm;
	
	private Connect() {
		try {
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public static Connect getInstance() {
		if (instance == null) {
			return new Connect();
		}
		return instance;
	}
	
	public ResultSet execQuery(String query) {
		try {
			rs = st.executeQuery(query);
			rsm = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void execUpdate(String query) { 
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
