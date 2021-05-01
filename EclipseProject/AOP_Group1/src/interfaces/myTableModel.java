package interfaces;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mainFeatures.Client;
import mainFeatures.Container;

public class myTableModel {
	
	
	
	
	static Object[] loadedData;
	static List<Object> tempStorage = new ArrayList<Object>();
	
	static void loadData(Client client) {
		if (client.getContainers() != null) {
			for (Container container : client.getContainers()) {
				if (container != null) {
					tempStorage.add(container);
					
				}
			}
		} 	
		if (tempStorage != null)
				loadedData = tempStorage.toArray();
	}
	
	static void wipeData() {
		
		tempStorage = new ArrayList<Object>();
		loadedData = null;
	}
	
	static String[] columns = new String[] {
            "Containers | OwnerID"
        };
         
	//new section
	
	
	//
	
        
    public static JTable Table(){
    	if (loadedData != null) {
        	Object[][] tableData = new Object[loadedData.length][1];
        	for ( int i = 0; i < loadedData.length; i++ ){
        	    tableData[i][0] = loadedData[i];
        	}

        	JTable tblInventory = new JTable(tableData,columns);
        	tblInventory.setRowSelectionAllowed(true);
        	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {
        		
        	 	@Override
        	    public boolean isCellEditable(int row, int column) {
        	      return false;
        	    }
        		

            	};
        	tblInventory.setModel(tableModel);
        	
        	
        	tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        	tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        		@Override
        		public void valueChanged(ListSelectionEvent arg0) {
        			if (!arg0.getValueIsAdjusting()) {
                       System.out.println("TEST!");
                       int row = tblInventory.getSelectedRow();
                       Container container = (Container) (tblInventory.getValueAt(row, 0)); 
                       // set selected cell as de-selected so it can be clicked again
                       viewJourneysFrame.showJourneys(container);
                       
                      }
        			
        			System.out.println("test");
        			// call frame with new table:
        			//
        			
        			
        		}
        		}
        	);

        	tblInventory.setAutoscrolls(true);
        	tblInventory.revalidate();
        	tblInventory.repaint();
        	return tblInventory;
    	
    	}
    	return new JTable();
    }
}