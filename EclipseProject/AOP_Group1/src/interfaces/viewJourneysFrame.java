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

import mainFeatures.Container;
import mainFeatures.Journey;

public class viewJourneysFrame extends JFrame {

	private static final long serialVersionUID = -4338084907384207123L;
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
            "JourneyID" , "Origin", "Destination", "Content Type"
        };
	
	
	
	public viewJourneysFrame(Container container) {
		setTitle("Container's journeys");
		wipeData();
		loadData(container);
		
		
		
		if (loadedData != null) {
			
			
        	Object[][] tableData = new Object[loadedData.length][4];
        	for ( int i = 0; i < loadedData.length; i++ ){
        	    tableData[i][0] = loadedData[i];
        	    tableData[i][1] = ((Journey) loadedData[i]).getOrigin();
        	    tableData[i][2] = ((Journey) loadedData[i]).getDestination();
        	    tableData[i][3] = ((Journey) loadedData[i]).getContentType();
        	}
        	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {
        		
				private static final long serialVersionUID = -7277101885619369315L;

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
                       int row = table.getSelectedRow();
                       Journey journey = (Journey) (table.getValueAt(row, 0)); 
                       viewMeasureFrame.showMeasures(journey);
                       
                      }
        		}
        		}
        	);
        	
        	JScrollPane js = new JScrollPane(table);

        	add(js);
		
		
		}
		setLocationRelativeTo(null);
		pack();
	
		
	}
	

	public static void showJourneys(Container container) {
		
		viewJourneysFrame window = new viewJourneysFrame(container);
		window.setVisible(true);
		
		
		
	}

}
