package interfaces;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

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
            "Containers | OwnerID" //"Name", "Hourly Rate", "Part Time"
        };
         
        //actual data for the table in a 2d array
	
//        static Object[][] data = new Object[][] {
//            {1, "John", 40.0, false },
//            {2, "Rambo", 70.0, false },
//            {3, "Zorro", 60.0, true },
//        };
        
        public static Component Table(){
        	if (loadedData != null) {
	        	Object[][] tableData = new Object[loadedData.length][1];
	        	for ( int i = 0; i < loadedData.length; i++ ){
	        	    tableData[i][0] = loadedData[i];
	        	}
	        	JTable tblInventory = new JTable(tableData,columns);
	        	tblInventory.setAutoscrolls(true);
	        	return tblInventory;
        	
        	}
        	return new JTable();
        }
}