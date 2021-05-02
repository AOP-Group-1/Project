package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Login.clientLogin;
import controller.ClientController;
import mainFeatures.Client;
import mainFeatures.Container;


public class clientInterface extends JFrame{
	private static final long serialVersionUID = 1L;

	private JTable tblInventory;
	private JLabel lblSession;
	
	
	private Client currentClient;


	
	
	public clientInterface() {
				
		
				
				//loads all the client info by using the client log-in name
				ClientController.clientLoader();
				currentClient = ClientController.getClient();
				
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setTitle("Client Interface");
				setPreferredSize(new Dimension(800, 600));
				
				
				
				// loads the containers
				
				// wipe away the memory of previous logged in user
				// here or at logout button
				
				
				// buttons
				JButton btnContainers = new JButton("Containers");
				btnContainers.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						ClientController.clientLoader(); //attempt
						myTableModel.wipeData();
						myTableModel.loadData(currentClient);
						
						
						//Reload this data after having added a journey
						
						JTable table = myTableModel.Table();
						
						JScrollPane jsPane = new JScrollPane(table);
						add(jsPane, BorderLayout.CENTER);
						table.setFillsViewportHeight(true);
												
						//add(newTable,BorderLayout.CENTER);
						
//						repaint();
//						revalidate();
						pack();
						setVisible(true);
						//
					}
				});
				
				

				//Should not be able to open multiple "add journey" windows at once
				
				JButton btnAddJourney = new JButton("Add Journey");
				btnAddJourney.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//show available containers
						AvaibleContainersTableModel.wipeData(); 
						AvaibleContainersTableModel.loadData();
						AvailableContainerFrame.showAvailableContainers();
						setVisible(true);
						
						
//						//addJourneyFrame.openAddJourneyWindow();
						//setVisible(true);
						//Add checks to see if origin and destination are actual countries
					}
				});
				
				JButton btnAEditInfo = new JButton("Edit Information");
				btnAEditInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						editUserInfoFrame.showEditUserFrame();
						setVisible(true);
						// pop-up window with 5 buttons to edit basic user info
						// Name, Password, Email, Address, Reference Person
						// click a button, text field appears
						
					}
				});
				
				
				JButton btnLogout = new JButton("Logout");
				//btnLogout.setBounds(670, 540, 120, 30);
				btnLogout.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","EXIT",JOptionPane.YES_NO_OPTION);
			
						if (confirmed == JOptionPane.YES_OPTION) {
							myTableModel.wipeData();
							clientLogin.clientLogin();
							dispose();
						}
						else if (confirmed == JOptionPane.NO_OPTION){
							//remove(confirmed);
						}
					   
						
					}
				});
				
		      
				
				// toolbar
				lblSession = new JLabel();
				lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
				
				
				// find some way to update this when confirm button is clicked.
				lblSession.setText("<html>" + currentClient.getName() + "<i>(" +" Client" + ")</i></html>");
				JToolBar toolbar = new JToolBar();
				toolbar.add(btnContainers, BorderLayout.CENTER);
				toolbar.add(btnAddJourney);
				toolbar.add(btnAEditInfo);
				//toolbar.add(Box.createHorizontalGlue());
				toolbar.add(lblSession);
				add(toolbar, BorderLayout.NORTH);
				
				
				JPanel bottomPanel = new JPanel(new BorderLayout());
				add(bottomPanel, BorderLayout.SOUTH);
			    bottomPanel.add(btnLogout, BorderLayout.EAST);
				

				
				
//				// table
//				tblInventory = new JTable();
//				tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//					@Override
//					public void valueChanged(ListSelectionEvent e) {
//						
//						
//					}
//				
//				});
//				add(new JScrollPane(tblInventory), BorderLayout.CENTER);
//				
				pack();
				setLocationRelativeTo(null);
			}
			
			public void setTableModel(TableModel model) {
				tblInventory.setModel(model);
			}
			
			
			public static void clientInterface() {
				clientInterface clientI = new clientInterface();
				clientI.setVisible(true);
				
				
			}
	
	}
