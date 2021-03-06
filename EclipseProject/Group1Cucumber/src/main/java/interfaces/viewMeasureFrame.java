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
import mainFeatures.MeasureLog;

public class viewMeasureFrame extends JFrame {

	
	static Object[] loadedData = new Object[]{};
	static List<MeasureLog> tempStorage = new ArrayList<MeasureLog>();
	
	
	static void wipeData() {
		
		tempStorage = new ArrayList<MeasureLog>();
		loadedData = null;
	}
	
	static void loadData(Journey journey) {
		if (journey.getMeasure() != null) {
			for (MeasureLog ml : journey.getMeasure()) {
				if (ml != null) {
					tempStorage.add(ml);
					System.out.println("measureframe: measure added");
				}
			}
		} 	
		if (tempStorage != null)
			loadedData = tempStorage.toArray();	
			//loadedData = tempStorage.toArray(new MeasureLog());
	}
	
	static String[] columns = new String[] {
            "Temperature", "Humidity", "Pressure","Time"
        };
	
	
	
	public viewMeasureFrame(Journey journey) {
		wipeData();
		loadData(journey);
		
		
		
		if (loadedData != null) {
			
			
        	Object[][] tableData = new Object[loadedData.length][4];
        	for ( int i = 0; i < loadedData.length; i++ ){
        	    tableData[i][0] = ((MeasureLog) loadedData[i]).getMeasure("temperature");
        	    tableData[i][1] = ((MeasureLog) loadedData[i]).getMeasure("humidity");
        	    tableData[i][2] = ((MeasureLog) loadedData[i]).getMeasure("pressure");
        	    tableData[i][3] = ((MeasureLog) loadedData[i]).getTime();

        	    
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
        	
//        	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//        		@Override
//        		public void valueChanged(ListSelectionEvent arg0) {
//        			if (!arg0.getValueIsAdjusting()) {
//                       System.out.println("TEST!");
//                       int row = table.getSelectedRow();
//                       Journey journey = (Journey) (table.getValueAt(row, 0)); 
//                       // set selected cell as de-selected so it can be clicked again
//                       viewMeasureFrame.showMeasures(journey);
//                       
//                      }
//        			
//        			System.out.println("test");
//        			// call frame with new table:
//        			//
//        			
//        			
//        		}
//        		}
//        	);
        	
        	
        	JScrollPane js = new JScrollPane(table);

        	add(js);
		
		
		}
		pack();
		
		
		
	}

	public static void showMeasures(Journey journey) {
		// TODO Auto-generated method stub
		

		viewMeasureFrame window = new viewMeasureFrame(journey);
		window.setVisible(true);
		
		
	}
	
	
	
}
