package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import javax.swing.table.DefaultTableModel;
import mainFeatures.Journey;
import mainFeatures.MeasureLog;

public class viewMeasureFrame extends JFrame {

	private static final long serialVersionUID = 4708633126856793271L;
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
		
		setTitle("Journey's measures");
		
		
		if (loadedData != null) {
			
			
        	Object[][] tableData = new Object[loadedData.length][4];
        	for ( int i = 0; i < loadedData.length; i++ ){
        	    tableData[i][0] = ((MeasureLog) loadedData[i]).getMeasure("temperature");
        	    tableData[i][1] = ((MeasureLog) loadedData[i]).getMeasure("humidity");
        	    tableData[i][2] = ((MeasureLog) loadedData[i]).getMeasure("pressure");
        	    tableData[i][3] = ((MeasureLog) loadedData[i]).getTime();

        	    
        	}
        	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {

				private static final long serialVersionUID = -4962169973390096627L;

				@Override
        		public boolean isCellEditable(int row, int column) {
        			return false;
        		}
        	};
        	
        	JTable table = new JTable(tableData,columns);
    		table.setModel(tableModel);

        	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        	
        	
        	JScrollPane js = new JScrollPane(table);

        	add(js);
		
		
		}
		setLocationRelativeTo(null);
		pack();
		
		
		
	}

	public static void showMeasures(Journey journey) {
		viewMeasureFrame window = new viewMeasureFrame(journey);
		window.setVisible(true);
		
		
	}
	
	
	
}
