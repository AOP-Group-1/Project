import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	private static String address="jdbc:mysql://localhost:3306/logistic";
	private static String username="admin";
	private static String password="admin";
	private Connection conn=null;
	public DBConnection() {
		try {
			this.conn=DriverManager.getConnection(address,username, password);
		}catch(Exception ex) {
			System.out.println("Exception");
		}
		
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	public void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet read(String sql) {
		try {
			Statement s;
			s = this.conn.createStatement();
			return s.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void update(String sql) {
		try {
			Statement s;
			s = this.conn.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
