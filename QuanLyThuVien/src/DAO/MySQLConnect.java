package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLConnect {
	private String hostName = "localhost";
	private String database = "quanlybanhang";
	private String url = "jdbc:mysql://" + hostName + ":3306/" + database;
	private String userName = "root", passWord = "";

	public MySQLConnect(String database, String url, String userName, String passWord) {
		super();
		this.database = database;
		this.url = url;
		this.userName = userName;
		this.passWord = passWord;
	}

	public MySQLConnect(String database) {
		super();
		this.database = database;
	}

	public MySQLConnect() {
		super();

	}

	public Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, passWord);

			return conn;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean executeUpdate(String sql) {
		try {
			Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

}
