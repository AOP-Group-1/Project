package mainFeatures;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

//This class provides the necessary layer to access the database.
//This class only provides Read and Update operations to the database as those are the only necessary operations.
public class DBConnection {
	//Database address and database admin credentials.
	private static String address="jdbc:mysql://localhost:3306/Journey";
	private static String username="admin";
	private static String password="admin";
	private Connection conn=null;
	
	
	//DBConnection Constructor that returns a DBConnection object.
	public DBConnection() {
		try {
			this.conn=DriverManager.getConnection(address,username, password);
		}catch(Exception ex) {
			
		}
		
	}
	
	
	//Returns a Connection object of the java.sql.Connection class.
	public Connection getConnection() {
		return this.conn;
	}
	
	
	//Close the Connection of a DBConnection object.
	public void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Reads from the database and returns a ResultSet.
	//This method takes as parameter a string that conforms to SELECT statement syntax.
	public ResultSet read(String sql) {
		try {
			Statement s;
			s = this.conn.createStatement();
			return s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	//Update records in the database. 
	//This method takes as parameter a string that conforms to UPDATE statement syntax.
	public void update(String sql) {
		try {
			Statement s;
			s = this.conn.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
