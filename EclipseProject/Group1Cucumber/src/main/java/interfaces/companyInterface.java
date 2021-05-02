package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.TableModel;

import Login.companyLogin;


public class companyInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable tblInventory;
	private JLabel lblSession;
	
	public companyInterface() {
		
		
		    
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Company Interface");
			setPreferredSize(new Dimension(800, 600));
			
			// buttons
			JButton btnAddClient = new JButton("Add Client");
			btnAddClient.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addClientFrame.showAddClientFrame();
					setVisible(true);
				}
			});
			
			JButton btnAddContainer = new JButton("Add Container");
			btnAddContainer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// Open frame with table
					// of all clients (Selectable)
					// 
					
					addContainerFrame.showAddContainerFrame();
					setVisible(true);
					
				}
			});
			
			
			JButton btnUpdMeasure = new JButton("Add Measurements");
			btnUpdMeasure.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					AddMeasurementFrame.showAddMeasurementFrame();
					setVisible(true);
					//Same idea as Update Journey
					//Except with three text fields instead of one
					
				}
			});
			
			
			JButton btnUpdJourney = new JButton("Update Journey");
			btnUpdJourney.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					updateJourneyFrame.showUpdateJourneyFrame();
					setVisible(true);
					
					
				}
			});
			
			JButton btnSearchClient = new JButton("Search Client");
			btnSearchClient.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					searchBoxFrame.showSearchBox();
					setVisible(true);
					
					//Dialogue box frame
					//click "search " (confirm) button
					//dispose dialogue box 
					//then show table with all clients matching search.
					
					
				}
			});
			
		
			
			
			
			JButton btnLogout = new JButton("Logout");

			//btnLogout.setBounds(670, 540, 120, 30);
			btnLogout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you wanna logout?","EXIT",JOptionPane.YES_NO_OPTION);
		
					if (confirmed == JOptionPane.YES_OPTION) {
						companyLogin.companyLogin();
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
			lblSession.setText("<html>" + companyLogin.getUsername() + " <i>(" +" Admin" + ")</i></html>");

			
			JToolBar toolbar = new JToolBar();
			toolbar.add(btnAddClient);
			toolbar.add(btnAddContainer);
			toolbar.add(btnUpdMeasure);
			toolbar.add(btnUpdJourney);
			toolbar.add(btnSearchClient);
			toolbar.add(Box.createHorizontalGlue());
			toolbar.add(lblSession);
			add(toolbar, BorderLayout.NORTH);
			
			
	
			JPanel bottomPanel = new JPanel(new BorderLayout());
			add(bottomPanel, BorderLayout.SOUTH);
		    bottomPanel.add(btnLogout, BorderLayout.EAST);
			
			// table
			tblInventory = new JTable();
			tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
				}
			});
			add(new JScrollPane(tblInventory), BorderLayout.CENTER);
			
			pack();
			setLocationRelativeTo(null);
		}
		
		public void setTableModel(TableModel model) {
			tblInventory.setModel(model);
		}
	

	
	public static void companyInterface() {
		companyInterface companyI = new companyInterface();
		companyI.setVisible(true);
		
		
	}
}
