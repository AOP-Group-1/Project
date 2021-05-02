package interfaces;


import java.util.ArrayList;
import java.util.List;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
         

        
    public static JTable Table(){
    	if (loadedData != null) {
        	Object[][] tableData = new Object[loadedData.length][1];
        	for ( int i = 0; i < loadedData.length; i++ ){
        	    tableData[i][0] = loadedData[i];
        	}

        	JTable tblInventory = new JTable(tableData,columns);
        	tblInventory.setRowSelectionAllowed(true);
        	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {
   
				private static final long serialVersionUID = 5471130245209346703L;

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
                       int row = tblInventory.getSelectedRow();
                       Container container = (Container) (tblInventory.getValueAt(row, 0)); 
                       viewJourneysFrame.showJourneys(container);
                       
                      }
	
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