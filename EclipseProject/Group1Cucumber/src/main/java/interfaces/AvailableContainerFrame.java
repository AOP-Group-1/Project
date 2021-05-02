package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.AvailableContainerController;
import mainFeatures.Client;
import mainFeatures.Container;

public class AvailableContainerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	//https://stackoverflow.com/questions/4765469/how-to-retrieve-jtable-data-as-an-array

	public static Object[][] getTableData (JTable table) {
		if (table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
	    TableModel dtm = table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++) {
	            tableData[i][j] = dtm.getValueAt(i,j);
	    		System.out.println("cell loaded: " + dtm.getValueAt(i, j));
	        }
	    return tableData;
	}
	



	public AvailableContainerFrame() {
		setAlwaysOnTop(true);
		
		setState(java.awt.Frame.NORMAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(310, 230));
		setTitle("showing available containers");

		//buttons

		
		
//		AvaibleContainersTableModel.wipeData(); 
//		AvaibleContainersTableModel.loadData();
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//check if there is any container selected from the table
				setAlwaysOnTop(false);
					
				JTable table = AvaibleContainersTableModel.Table();
				Object[][] tableData = getTableData(table);
				boolean noMarks = false;
				//check if this works
				
				for (Object[] row : tableData) {
					//doesn't accurately check the checkbox BUG
					//System.out.println("availablecontainer" + row[1]);
					noMarks = noMarks || ((boolean) row[1]) ;
//					System.out.println(row[0]);
//					System.out.println(row[1]);
				}
				if (!noMarks) {
					JPanel panel = new JPanel();
					JOptionPane.showMessageDialog(panel, "Please mark at least one container for the journey", "Journey error", JOptionPane.ERROR_MESSAGE);
				}
				else if (noMarks) {
					addJourneyFrame.openAddJourneyWindow();
					
					setVisible(true);
					dispose();
				}
					
				
				
			}
		});
		
		
		add(new JScrollPane(AvaibleContainersTableModel.Table()), BorderLayout.CENTER);
		add(btnConfirm, BorderLayout.SOUTH);
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
		
	}
	

	// "Available containers" is not properly updated / loaded after sending containers on journeys. 
	static AvailableContainerFrame window;
	public static void showAvailableContainers() {
	if (window == null)	{	
		window = new AvailableContainerFrame();
		window.setVisible(true);
	}
	else
		window.setVisible(true);
	
	}
	
	
	
}



class AvaibleContainersTableModel extends DefaultTableModel {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2598668107806950822L;
	
	
	
	static Object[] loadedData;
	static List<Container> tempStorage = new ArrayList<Container>();
	
	public static void loadData() {
		tempStorage = AvailableContainerController.availableContainers();
//		if (tempStorage != null)
		loadedData = tempStorage.toArray();
//		System.out.println("no containers");
	}
	
	public static void wipeData() {
		tempStorage = new ArrayList<Container>();
		loadedData = null;

	}
	
	static String[] columns = new String[] {
            "Available Containers" , "use for shipping"
        };
      
	
// 	@Override
//    public boolean isCellEditable(int row, int column) {
//      return column == 1;
//    }
//	
// 	public AvaibleContainersTableModel() {
// 	      super(columns, 0);
// 	    }
	    
 	
 	static JTable tblInventory;
 	
    public static JTable Table(){ //was a component before
    	//singleton pattern
    	wipeData();
    	loadData();
    	if (tblInventory == null) {
    		
//	    	if (loadedData != null) {
	        	Object[][] tableData = new Object[loadedData.length][2];
	        	for ( int i = 0; i < loadedData.length; i++ ){
	        	    tableData[i][0] = loadedData[i];
	        	    tableData[i][1] = false;
	        	}
	        	tblInventory = new JTable(tableData,columns);
	        	tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        	//AvaibleContainersTableModel tableModel = new AvaibleContainersTableModel();
	        	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {
	        		@Override
	        	    public Class<?> getColumnClass(int columnIndex) {
	        	      Class clas = String.class;
	        	      switch (columnIndex) {
	        	        case 1:
	        	          clas = Boolean.class;
	        	          break;
	        	      }
	        	      return clas;
	        	    }
	        		
	        	};
	        	
	        	tableModel.addTableModelListener(new TableModelListener() {
	        		public void tableChanged(TableModelEvent e) {
	            		int row = e.getFirstRow();
	            		int column = e.getColumn();
	            		System.out.println("(availablecontainers) Clicked");
	//            		System.out.println(tableData[row][1]);
	            		System.out.println(tblInventory.getValueAt(row, column));
	            		
	            		//tblInventory.setValueAt(! (boolean) tblInventory.getValueAt(row, column), row, column);
	            		//tableData[row][1] = (! (boolean) tableData[row][1]);
	            	}
	        		
	        	});
	//        	public void tableChanged(TableModelEvent e) {
	//        		int row = e.getFirstRow();
	//        		System.out.println("Clicked");
	//        		tableData[row][1] = (! (boolean) tableData[row][1]);
	//        	}
	
	        	tblInventory.setModel(tableModel);
	        	tblInventory.setVisible(true);
	        	tblInventory.setAutoscrolls(true);
	        	tblInventory.setDefaultEditor(Object.class, null);
	        	return tblInventory;
	    	
	    	}
//	    	return new JTable(); }
    	else 
    		return tblInventory;
    }
}