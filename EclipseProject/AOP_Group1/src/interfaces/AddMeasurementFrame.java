package interfaces;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dataLoaders.JourneyUpdater;
import grid.Grid;
import mainFeatures.Client;
import mainFeatures.Container;
import mainFeatures.Journey;
import mainFeatures.MeasureLog;



public class AddMeasurementFrame extends JFrame {


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

	public AddMeasurementFrame() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		
	    setTitle("Add Measurements");
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
		

		List<JTextField> textFields = new ArrayList<JTextField>();
		NumberField temperature = new NumberField(20);		
		NumberField humidity = new NumberField(20);
		NumberField pressure = new NumberField(20);
		textFields.add(temperature);
		textFields.add(humidity);
		textFields.add(pressure);
		
		JLabel tmpLabel = new JLabel("Temperature: ");
		JLabel hmdLabel = new JLabel("Humidity: ");
		JLabel prsLabel = new JLabel("Pressure: ");
		
		//
		
		JButton btnConfirm = new JButton("Add Measurements");
		//btnLogout.setBounds(670, 540, 120, 30);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Get integer in the nContainerField (remove "-") 
				//for all selected clients:
				//add a container with their ID to the database.
				
				boolean allFilled = true;
				for (int i = 0 ; i < textFields.size() ; i++) {
					JTextField txt = new JTextField();
					txt = textFields.get(i); 
					allFilled = allFilled && !txt.getText().isBlank();
				}
				
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
			        	
						
						
			        	
						if (!allFilled) { //check if any text fields are blank
							//Popup warning here
							JOptionPane.showMessageDialog(panel, "Please fill out all the fields", "Error", JOptionPane.ERROR_MESSAGE);

						}
						else {
								int dataTemperature = Integer.parseInt(temperature.getText());
								int dataHumidity = Integer.parseInt(humidity.getText());
								int dataPressure = Integer.parseInt(pressure.getText());

						//update database such that selected journey's destination is changed to currentLocation
						// then create a new journey with old destination as destination, and updatedLocation as origin
						
						
					//https://stackoverflow.com/a/27287881 
					 	
	
					        	
							//journe.UpdateJourneyLocation(JourneyID,String updatedLocation); // will update database
					        	
					        	Client placeHolderClient = new Client(); 
								placeHolderClient.replaceID(ownerID);
								Container placeHolderContainer = new Container(placeHolderClient,containerID);
								Journey j = new Journey(placeHolderContainer,journeyOrigin, 
										journeyDestination, journeyContentType, journeyName);
								j.replaceID(journeyID);
								MeasureLog ml = new MeasureLog(new int[] {dataTemperature,dataHumidity, dataPressure});
								j.addMeasureJourney(ml);
								ml.registerMeasureLog(j);
								
					            
					            
					            
					            }
					        }
					    }
				//Journey journey = (Journey) (table.getValueAt(row, 0)); 
				}
				
			});
		
		
		
		//JPanel panel = new JPanel(new GridBagLayout());
		add(panel, BorderLayout.SOUTH);
		panel.add(btnConfirm,Grid.constraint(1, 6,5));
		
		panel.add(tmpLabel,Grid.constraint(0, 0, 5));
		panel.add(hmdLabel,Grid.constraint(0, 2, 5));
		panel.add(prsLabel,Grid.constraint(0, 4, 5));
		panel.add(temperature,Grid.constraint(1, 0, 5));
		panel.add(humidity,Grid.constraint(1, 2, 5));
		panel.add(pressure,Grid.constraint(1, 4, 5));
		
		
		add(js);
		pack();
		
		
		
	}






	public static void showAddMeasurementFrame() {
	
	AddMeasurementFrame window = new AddMeasurementFrame();
	window.setVisible(true);
	
	
	}


}

