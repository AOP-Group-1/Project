package dataLoaders;

import java.sql.ResultSet;

import Supplementary.DBConnection;

public class ContainerLoader {
	public static String prepareStatement (String OwnerID) {
		String sql = String.format("select " + "* from container"  + " where " + "Ownerid = \"%s\" ;", OwnerID);
		return sql;
	}
	
	public static ResultSet searchForContainer (String OwnerID) {
		DBConnection db = new DBConnection();
		String sql = prepareStatement(OwnerID);
		ResultSet rs = db.read(sql);
		return rs;
	}
	
}
