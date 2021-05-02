package interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dataLoaders.JourneyUpdater;
import mainFeatures.Client;
import mainFeatures.Container;
import mainFeatures.Journey;

public class updateJourneyFrame extends JFrame {
	
	static List<Journey> tempStorage = new ArrayList<Journey>();
	


	static String[] columns = new String[] {
			"JourneyID", "Container ID","Client ID", "Origin","Desination", "Content Type" , "Company" , " Complete"
	};


	public static Object[] loadClients() {
		tempStorage = new ArrayList<Journey>();
		Object[] loadedData = null;
		
		//search for containers instead, and load the journeys through that
		// like in ClientController
		
		ResultSet rs = Journey.searchForJourney(null,null,null,null,null,null,null,null,null,"false");
		
		
		
		
		try {
			while (rs.next()) {
				
				
				String containerID = rs.getString("containerid");
				String ownerID = rs.getString("Clientid");
				String journeyID = rs.getString("journeyid");
				String journeyOrigin = rs.getString("Origin");
				String journeyDestination = rs.getString("Destination");
				String journeyContentType = rs.getString("Content_Type");
				String journeyName = rs.getString("Company");
				
				Client placeHolderClient = new Client(); 
				placeHolderClient.replaceID(ownerID);
				Container placeHolderContainer = new Container(placeHolderClient,containerID);
				
				
				// replace the new journey's ID with journeyID
				// load completion
				Journey j = new Journey(placeHolderContainer,journeyOrigin, 
						journeyDestination, journeyContentType, journeyName);
				j.replaceID(journeyID);
				
				tempStorage.add(j);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!tempStorage.isEmpty()) {
			loadedData = tempStorage.toArray();
		}
		
		return loadedData;
		
				
	}
	
	public updateJourneyFrame() {
		setTitle("Update Journey");

		Object[] loadedData = loadClients();
		
		Object[][] tableData = new Object[loadedData.length][8];
    	for ( int i = 0; i < loadedData.length; i++ ){
    	    tableData[i][0] = ((Journey) loadedData[i]).getJourneyID();
    	    tableData[i][1] = ((Journey) loadedData[i]).getContainerID();
    	    tableData[i][2] = ((Journey) loadedData[i]).getClientID();
    	    tableData[i][3] = ((Journey) loadedData[i]).getOrigin();
    	    tableData[i][4] = ((Journey) loadedData[i]).getDestination();
    	    tableData[i][5] = ((Journey) loadedData[i]).getContentType();
    	    tableData[i][6] = ((Journey) loadedData[i]).getCompany();
    	    tableData[i][7] = ((Journey) loadedData[i]).getComplete();

    	}
    	
    	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {
    		
    		@Override
    		public boolean isCellEditable(int row, int column) {
    			return false;
    		}
    	};
    	
    	JTable table = new JTable(tableData,columns);
		table.setModel(tableModel);

    	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
    	
    	
		JScrollPane js = new JScrollPane(table);
		
		//https://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
		

		JTextField updatedLocationField = new JTextField(10);		
		
		//
		
		JButton btnConfirm = new JButton("Update Journeys");
		//btnLogout.setBounds(670, 540, 120, 30);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Get integer in the nContainerField (remove "-") 
				//for all selected clients:
				//add a container with their ID to the database.
				int row = table.getSelectedRow();
				if (table.getRowCount() > 0) {
			        if (table.getSelectedRowCount() == 1) {
			        	int selectedRow = table.getSelectedRow();
			        	
			        	String journeyID = table.getValueAt(selectedRow,0).toString();
			        	String containerID =  table.getValueAt(selectedRow,1).toString();
						String ownerID =  table.getValueAt(selectedRow,2).toString();
						String journeyOrigin =  table.getValueAt(selectedRow,3).toString();
						String journeyDestination =  table.getValueAt(selectedRow,4).toString();
						String journeyContentType =  table.getValueAt(selectedRow,5).toString();
						String journeyName =  table.getValueAt(selectedRow,6).toString();
						String journeyComplete =  table.getValueAt(selectedRow,7).toString();
			        	
						
						
			        	
						if (updatedLocationField.getText().isBlank()) {
							JourneyUpdater.UpdateCompletionJourney(journeyID);
						}
						else {
								String updatedLocation = updatedLocationField.getText();
						//update database such that selected journey's destination is changed to currentLocation
						// then create a new journey with old destination as destination, and updatedLocation as origin
						
						
					//https://stackoverflow.com/a/27287881 
					 	
	
					        	
							//journe.UpdateJourneyLocation(JourneyID,String updatedLocation); // will update database
					        	
					        	Client placeHolderClient = new Client(); 
								placeHolderClient.replaceID(ownerID);
								Container placeHolderContainer = new Container(placeHolderClient,containerID);
								Journey j = new Journey(placeHolderContainer,updatedLocation, 
										journeyDestination, journeyContentType, journeyName);
					            j.registerJourney();	
								
					            JourneyUpdater.UpdateLocationJourney(journeyID, updatedLocation);
					            
					            dispose();
					            showUpdateJourneyFrame();
					            
					            
					            }
					        }
					    }
				//Journey journey = (Journey) (table.getValueAt(row, 0)); 
				}
				
			});
		
		JLabel updatedLocationLabel= new JLabel("Enter updated location");
		
		JPanel panel = new JPanel(new BorderLayout());
		add(panel, BorderLayout.SOUTH);
		panel.add(btnConfirm,BorderLayout.EAST);
		panel.add(updatedLocationLabel, BorderLayout.CENTER);
		panel.add(updatedLocationField,BorderLayout.WEST);
		
    	add(js);
    	pack();
		
    	
		
	}
	
	
	
	
	
	
	public static void showUpdateJourneyFrame() {
		
		updateJourneyFrame window = new updateJourneyFrame();
		window.setVisible(true);
		
		
	}
	

}
