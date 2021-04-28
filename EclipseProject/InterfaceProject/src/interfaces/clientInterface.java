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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import Login.clientLogin;
import Login.companyLogin;

public class clientInterface extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTable tblInventory;
	private JLabel lblSession;
	

	public clientInterface() {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setTitle("Client Interface");
				setPreferredSize(new Dimension(800, 600));
				
				// buttons
				JButton btnJournMan = new JButton("Containers");
				btnJournMan.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//controller.validateCredentials(txtLogin.getText(), String.valueOf(txtPass.getPassword()));

					}
				});
				JButton btnContStat = new JButton("Add Container");
				//btnContStat.setEnabled(false);
				btnContStat.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//ContainerStatus.ContainerStatus();
					}
				});

				
				JButton btnEditInfo = new JButton("Edit Infomation");
				btnEditInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
<<<<<<< HEAD
				
							
								
=======
				JButton btnLogout = new JButton("Logout");

			        btnLogout.setBounds(670, 540, 120, 30);
			        btnLogout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you wanna logout?","EXIT",JOptionPane.YES_NO_OPTION);
		
					if (confirmed == JOptionPane.YES_OPTION) {
						clientLogin.clientLogin();
						dispose();
					}
					else if (confirmed == JOptionPane.NO_OPTION){
						//remove(confirmed);
					}
				   
					
				}
			});
		
>>>>>>> cac749bb3bc0b286c78be8b91dd35b348d0841a0
				// toolbar
				lblSession = new JLabel();
				lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
				
				JToolBar toolbar = new JToolBar();
				toolbar.add(btnJournMan);
				toolbar.add(btnContStat);
				toolbar.add(btnEditInfo);
				toolbar.add(Box.createHorizontalGlue());
				toolbar.add(lblSession);
				add(toolbar, BorderLayout.NORTH);
<<<<<<< HEAD
				add(btnLogOut);
				
				
=======
				add(btnLogout);
>>>>>>> cac749bb3bc0b286c78be8b91dd35b348d0841a0
				
				lblSession.setText("<html>" + clientLogin.getUsername() + " <i>(" +" Client" + ")</i></html>");
				
				
				// table
				tblInventory = new JTable();
				tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				
				});
				add(new JScrollPane(tblInventory), BorderLayout.CENTER);
				
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

