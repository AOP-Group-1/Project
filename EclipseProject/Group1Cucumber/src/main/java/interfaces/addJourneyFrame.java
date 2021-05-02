package interfaces;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ClientController;
import controller.ClientEditController;
import grid.Grid;
import mainFeatures.Client;
import mainFeatures.Container;
import mainFeatures.Journey;

public class addJourneyFrame extends JFrame {



	    private static JTextField origin;
	    private static JTextField destination;
	    private static JTextField contentType;
	    
//	    private String origin;
//		private String destination;
//		private String contentType;
//		private String company;
//		private String currentLocation;
//		private String journeyComplete;
//		private ResultSet travelHistory;
//		private ResultSet allJourneys;
	    
	    
	    public addJourneyFrame() {
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(new Dimension(310, 230));
			setTitle("Add Journey");
			setLayout(new GridBagLayout());
			
			List<JTextField> textFields = new ArrayList<JTextField>();
			List<String> textFieldNames = new ArrayList<String>();
			origin = new JTextField(20);
			destination = new JTextField(20);
			contentType = new JTextField(20);
			textFields.add(origin);
			textFields.add(destination);
			textFields.add(contentType);
//			
			JPanel panel = new JPanel();
//			

			//buttons
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AvailableContainerFrame.showAvailableContainers();
					setVisible(true);
					dispose();
				}
			});
			
			
			JButton btnConfirm = new JButton("Confirm");
			//btnLogout.setBounds(670, 540, 120, 30);
			btnConfirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean allFilled = true;
					
					Client currentClient = ClientController.getClient();
					for (int i = 0 ; i < textFields.size() ; i++) {
						JTextField txt = new JTextField();
						txt = textFields.get(i);
						allFilled = allFilled && !(txt.getText().isBlank());
					}
					if (allFilled) {
						List<Container> containerList = new ArrayList<Container>();
						JTable table = AvaibleContainersTableModel.Table();
						int nRows = table.getModel().getRowCount();
						System.out.println("n of rows: " + nRows);
						for (int i = 0; i < nRows; i++) {
							if ((boolean) table.getValueAt(i, 1)) {
								containerList.add((Container) table.getValueAt(i, 0)); //add the selected containers to the list
							}
						}
						for (Container container : containerList) {				
							//(Container container, String origin, String destination, String contentType,
							//String company)
							Journey j = new Journey(container, origin.getText(), destination.getText(), contentType.getText(), currentClient.getName());
							j.registerJourney();
							System.out.println("addJourneyFrame: " + container);
							System.out.println(container.notOnJourney());
							container.addJourney(j);
							currentClient.addContainer(container);
						}
						
						
						
					}
					else 
						JOptionPane.showMessageDialog(panel, "Please fill out all fields <3", "Journey error", JOptionPane.ERROR_MESSAGE);
						return;

					
					
				}
			});
			
			add(new JLabel("Origin :"), Grid.constraint(0, 0, 5));
			add(origin,Grid.constraint(1, 0, 5));
			add(new JLabel("Destination:"), Grid.constraint(0, 1, 5));
			add(destination,Grid.constraint(1, 1, 5));
			add(new JLabel("contentType:"), Grid.constraint(0, 2, 5));
			add(contentType,Grid.constraint(1, 2, 5));
			add(panel);
			add(btnBack,Grid.constraint(-1, 6, 5));
			add(btnConfirm, Grid.constraint(1, 6, 5));
			
			toFront();
			setLocationRelativeTo(null);
			pack();
			
	    }
	    
	    
		public static void openAddJourneyWindow() {
			addJourneyFrame window = new addJourneyFrame();
			
			window.setVisible(true);
			
		}
	    
}
