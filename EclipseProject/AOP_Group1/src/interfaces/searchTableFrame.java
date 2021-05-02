package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import mainFeatures.Client;

public class searchTableFrame extends JFrame {

	private static final long serialVersionUID = -6753972059963193857L;
	static List<Client> tempStorage = new ArrayList<Client>();
	static String[] columns = new String[] {
			 "Client ID", "Client Name", "Client Email","Address", "Reference Person"
	};
	
	
	public static Object[] loadClients(ResultSet filteredClientsRS) {
		tempStorage = new ArrayList<Client>();
		Object[] loadedData = null;
		
		ResultSet rs = filteredClientsRS;
		
		try {
			while (rs.next()) {
				Client newClient = new Client();
				newClient.setName(rs.getString("Name"));
				newClient.setEmail(rs.getString("Email"));
				newClient.setAddress(rs.getString("Address"));
				newClient.setRefPer(rs.getString("Reference_Person"));
				newClient.replaceID(rs.getString("Clientid"));
				tempStorage.add(newClient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!tempStorage.isEmpty()) {
			loadedData = tempStorage.toArray();
		}
		
		return loadedData ;
				}
	
	
	searchTableFrame(ResultSet filteredClientsRS) {
		
		
		Object[] loadedData = loadClients(filteredClientsRS);
		Object[][] tableData = null;
		
		DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {

			private static final long serialVersionUID = 6912517705964795747L;

			@Override
    		public boolean isCellEditable(int row, int column) {
    			return false;
    		}
		};
	
		JTable table = new JTable(tableData,columns);
		
		if (loadedData != null) {
			tableData = new Object[loadedData.length][5];
	    	for ( int i = 0; i < loadedData.length; i++ ){
	    	    tableData[i][0] = ((Client) loadedData[i]).getID();
	    	    tableData[i][1] = ((Client) loadedData[i]).getName();
	    	    tableData[i][2] = ((Client) loadedData[i]).getEmail();
	    	    tableData[i][3] = ((Client) loadedData[i]).getAddress();
	    	    tableData[i][4] = ((Client) loadedData[i]).getRefPer();
	    	}
	    	
	    	tableModel = new DefaultTableModel(tableData,columns) {
	    		

				private static final long serialVersionUID = 2239784487050071339L;

				@Override
	    		public boolean isCellEditable(int row, int column) {
	    			return false;
	    		}
	    	};
	    	
	    	table = new JTable(tableData,columns); 
    	}

		
		table.setModel(tableModel);

    	table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
    	JScrollPane js = new JScrollPane(table);
    	
    	add(js);
    	pack();
	}
	
	
	
	
	
	public static void showSearchTableFrame(ResultSet filteredClientsRS) {
		searchTableFrame window = new searchTableFrame(filteredClientsRS);
		window.setVisible(true);
		
		
	}
	

}
