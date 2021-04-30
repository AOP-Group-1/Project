package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.AvailableContainerController;
import mainFeatures.Client;
import mainFeatures.Container;

public class AvailableContainerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public AvailableContainerFrame() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(310, 230));
		setTitle("showing available containers");
		//setLayout(new GridBagLayout());
		
		AvaibleContainersTableModel.wipeData();
		AvaibleContainersTableModel.loadData();
		add(new JScrollPane(AvaibleContainersTableModel.Table()), BorderLayout.CENTER);
		setVisible(true);
		
		
	}
	
	public static void showAvailableContainers() {
		AvailableContainerFrame window = new AvailableContainerFrame();
		window.setVisible(true);
		
	}
	
	
	
}



class AvaibleContainersTableModel {
	
	
	
	
	static Object[] loadedData;
	static List<Container> tempStorage = new ArrayList<Container>();
	
	public static void loadData() {
		tempStorage = AvailableContainerController.availableContainers();
		if (tempStorage != null)
				loadedData = tempStorage.toArray();
	}
	
	public static void wipeData() {
		
		tempStorage = new ArrayList<Container>();
		loadedData = null;
	}
	
	static String[] columns = new String[] {
            "Available Containers"
        };
         

        
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