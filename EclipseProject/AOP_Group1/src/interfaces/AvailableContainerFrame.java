package interfaces;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JButton;

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

import mainFeatures.Container;

public class AvailableContainerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	// credits to: https://stackoverflow.com/questions/4765469/how-to-retrieve-jtable-data-as-an-array

	public static Object[][] getTableData (JTable table) {

	    TableModel dtm = table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++) {
	            tableData[i][j] = table.getValueAt(i,j);
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
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setAlwaysOnTop(false);
					

				Object[][] tableData = getTableData(AvaibleContainersTableModel.tblInventory); //WORKS
				boolean noMarks = false;

				
				for (Object[] row : tableData) {
					noMarks = noMarks || ((boolean) row[1]) ;

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
	

	static AvailableContainerFrame window;
	public static void showAvailableContainers() {
		
		window = new AvailableContainerFrame();
		window.setVisible(true);

	}
	
	
	
}



class AvaibleContainersTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -2598668107806950822L;
	
	
	
	static List<Container> tempStorage = new ArrayList<Container>();
	static Object[] loadedData = null;
	
	public static void loadData() {
		tempStorage = AvailableContainerController.availableContainers();
		loadedData = tempStorage.toArray();
	}
	
	public static void wipeData() {
		tempStorage = new ArrayList<Container>();
		loadedData = null;

	}
	
	static String[] columns = new String[] {
            "Available Containers" , "use for shipping"
        };
      
	

	    
 	
 	static JTable tblInventory;
 	
    public static JTable Table(){ 

	        	Object[][] tableData = new Object[loadedData.length][2];
	        	for ( int i = 0; i < loadedData.length; i++ ){
	        	    tableData[i][0] = loadedData[i];
	        	    tableData[i][1] = false;
	        	}
	        	tblInventory = new JTable(tableData,columns);
	        	tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        	DefaultTableModel tableModel = new DefaultTableModel(tableData,columns) {

					private static final long serialVersionUID = 3813774263900377905L;

					@Override
	        	    public boolean isCellEditable(int row, int column) {
	        	       return column == 1;
	        	    }
	        		
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
	            	
	            	
            		
	            


	            	}
	        		
	        	});
	
	        	tblInventory.setModel(tableModel);
	        	tblInventory.setVisible(true);
	        	tblInventory.setAutoscrolls(true);
	        	tblInventory.setDefaultEditor(Object.class, null);
	        	return tblInventory;
	    	
	    	}

    	
 }