package dataLoaders;

import java.sql.ResultSet;

import Supplementary.DBConnection;

public class MeasureLoader {
		public static String prepareStatement (String JourneyID) {
			String sql = String.format("select " + "* from container_status"  + " where " + "journeyid = \"%s\" ;", JourneyID);
			return sql;
		}
		
		public static ResultSet searchForMeasures (String JourneyID) {
			DBConnection db = new DBConnection();
			String sql = prepareStatement(JourneyID);
			ResultSet rs = db.read(sql);
			return rs;
		}
		
}
