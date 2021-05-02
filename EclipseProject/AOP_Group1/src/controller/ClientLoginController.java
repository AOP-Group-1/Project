package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import mainFeatures.Client;

public class ClientLoginController {
	
	
	
	public static String loadPassword(String clientName) {
		ResultSet rs = Client.searchForClient(null, null, clientName, null, null);
			try {
				if (rs.next()) {
					return (rs.getString("Password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "ERROR USER NOT FOUND";
	

		}
}
