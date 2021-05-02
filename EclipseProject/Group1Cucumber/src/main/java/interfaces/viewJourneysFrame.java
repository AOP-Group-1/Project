package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import mainFeatures.Client;
import mainFeatures.Container;
import mainFeatures.Journey;

public class viewJourneysFrame extends JFrame {
	
	
	static Object[] loadedData;
	static List<Object> tempStorage = new ArrayList<Object>();
	
	
	static void wipeData() {
		
		tempStorage = new ArrayList<Object>();
		loadedData = null;
	}
	
	static void loadData(Container container) {
		if (container.getJourneys() != null) {
			for (Journey journey : container.getJourneys()) {
				if (journey != null) {
					tempStorage.add(journey);
				}
			}
		} 	
		if (tempStorage != null)
				loadedData = tempStorage.toArray();
	}
	
	static String[] columns = new String[] {
            "JourneyID"
        };
	
	
	
	public viewJourneysFrame(Container container) {
		//List<Journey> jl = container.getJourneys();
		wipeData();
		loadData(container);
		
		
		
		if (loadedData != null) {
			
			
        	Object[][] tableData = new Object[loadedData.length][1];
        	for ( int i = 0; i < loadedData.length; i++ ){
        	    tableData[i][0] = loadedData[i];
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
        	
        	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        		@Override
        		public void valueChanged(ListSelectionEvent arg0) {
        			if (!arg0.getValueIsAdjusting()) {
                       System.out.println("viewJourneyFrame " + "TEST!");
                       int row = table.getSelectedRow();
                       Journey journey = (Journey) (table.getValueAt(row, 0)); 
                       // set selected cell as de-selected so it can be clicked again
                       viewMeasureFrame.showMeasures(journey);
                       
                      }
        			
        			System.out.println("test");
        			// call frame with new table:
        			//
        			
        			
        		}
        		}
        	);
        	
        	JScrollPane js = new JScrollPane(table);

        	add(js);
		
		
		}
		pack();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public static void showJourneys(Container container) {
		
		viewJourneysFrame window = new viewJourneysFrame(container);
		window.setVisible(true);
		
		
		
	}

}
