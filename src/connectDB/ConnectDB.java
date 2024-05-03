package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLBH";
		String username = "sa";
		String password = "Kkkkkkk@6";
//		String url = "jdbc:sqlserver://localhost:1433;databasename=QLBH;integratedSecurity=true;";
		try {
			con = DriverManager.getConnection(url, username, password);
//          con = DriverManager.getConnection(url);
			System.out.println("OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public Connection getConnection() {
		return con;
	}
}
