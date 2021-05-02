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

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import mainFeatures.Client;
import mainFeatures.Container;


public class addContainerFrame extends JFrame {

	private static final long serialVersionUID = -5869922442185246742L;
	static String[] columns = new String[] {
			"Client ID", "Client Name", "Client Email","Address", "Reference Person"
	};
	static List<Client> tempStorage = new ArrayList<Client>();
	
	public static Object[] loadClients() {
		tempStorage = new ArrayList<Client>();
		Object[] loadedData = null;
		
		ResultSet rs = Client.findAllClients();
		
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
			e.printStackTrace();
		}
		
		if (!tempStorage.isEmpty()) {
			loadedData = tempStorage.toArray();
		}
		
		return loadedData;
		
				
	}
	
	
	public addContainerFrame() {
		setTitle("Add Containers");
		Object[] loadedData = loadClients();
		
		Object[][] tableData = new Object[loadedData.length][5];
    	for ( int i = 0; i < loadedData.length; i++ ){
    	    tableData[i][0] = ((Client) loadedData[i]).getID();
    	    tableData[i][1] = ((Client) loadedData[i]).getName();
    	    tableData[i][2] = ((Client) loadedData[i]).getEmail();
    	    tableData[i][3] = ((Client) loadedData[i]).getAddress();
    	    tableData[i][4] = ((Client) loadedData[i]).getRefPer();
    	}
    	
    	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {

			private static final long serialVersionUID = -2347600245455810714L;

			@Override
    		public boolean isCellEditable(int row, int column) {
    			return false;
    		}
    	};
    	
    	JTable table = new JTable(tableData,columns);
		table.setModel(tableModel);

    	table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
    	
    	
		JScrollPane js = new JScrollPane(table);
		
		//https://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
		//Allow only integers to be entered:
		

		NumberField nContainerField = new NumberField(4);		
		

		
		JButton btnConfirm = new JButton("Confirm");
		
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
                
				if (nContainerField.getText().isBlank()) {
					
					
				}
				else {
					String strNumContainers = nContainerField.getText();
					strNumContainers.replaceAll("-", "");
					
					int numContainers = Integer.parseInt(strNumContainers);
					
				//credits to: https://stackoverflow.com/a/27287881 
				    if (table.getRowCount() > 0) {
				        if (table.getSelectedRowCount() > 0) {
				            int selectedRow[] = table.getSelectedRows();
				            for (int i : selectedRow) {
				            	String clientId = (table.getValueAt(i, 0).toString());
				                Client placeHolderClient = new Client();
				                placeHolderClient.replaceID(clientId);
				                for (int j = 0; j < numContainers; j++) {
				                	Container newContainer = new Container(placeHolderClient);
				                	newContainer.registerContainer();
				                }
				            	
				            	
				            }
				        }
				    }
				
				}
				
			}
		});
		
		JLabel nContainerLabel= new JLabel("Number of containers to add");
		
		JPanel panel = new JPanel(new BorderLayout());
		add(panel, BorderLayout.SOUTH);
		panel.add(btnConfirm,BorderLayout.EAST);
		panel.add(nContainerLabel,BorderLayout.CENTER);
		panel.add(nContainerField,BorderLayout.WEST);
		
    	add(js);
    	pack();
	
    	
    	
	
		
		
		
	}
	
	
	public static void showAddContainerFrame() {
		addContainerFrame window = new addContainerFrame();
		window.setVisible(true);
		
		
	}
	
	
	
}



