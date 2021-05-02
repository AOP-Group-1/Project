package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import javax.swing.SwingConstants;

import javax.swing.table.TableModel;
import Login.clientLogin;
import controller.ClientController;
import mainFeatures.Client;



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
		
				
				
				// buttons
				JButton btnContainers = new JButton("Containers");
				btnContainers.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						ClientController.clientLoader(); 
						myTableModel.wipeData();
						myTableModel.loadData(currentClient);
						
						
						
						JTable table = myTableModel.Table();
						
						JScrollPane jsPane = new JScrollPane(table);
						add(jsPane, BorderLayout.CENTER);
						table.setFillsViewportHeight(true);
												

						pack();
						setVisible(true);

					}
				});
				
				

				
				JButton btnAddJourney = new JButton("Add Journey");
				btnAddJourney.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//show available containers
						AvaibleContainersTableModel.wipeData(); 
						AvaibleContainersTableModel.loadData();
						AvailableContainerFrame.showAvailableContainers();
						setVisible(true);
						

					}
				});
				
				JButton btnAEditInfo = new JButton("Edit Information");
				btnAEditInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						editUserInfoFrame.showEditUserFrame();
						setVisible(true);

						
					}
				});
				
				
				JButton btnLogout = new JButton("Logout");

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

						}
					   
						
					}
				});
				
		      
				
	
				lblSession = new JLabel();
				lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
				
				
				lblSession.setText("<html>" + currentClient.getName() + "<i>(" +" Client" + ")</i></html>");
				//toolbar
				JToolBar toolbar = new JToolBar();
				toolbar.add(btnContainers, BorderLayout.CENTER);
				toolbar.add(btnAddJourney);
				toolbar.add(btnAEditInfo);
				toolbar.add(lblSession);
				add(toolbar, BorderLayout.NORTH);
				
				
				JPanel bottomPanel = new JPanel(new BorderLayout());
				add(bottomPanel, BorderLayout.SOUTH);
			    bottomPanel.add(btnLogout, BorderLayout.EAST);
				
			
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
