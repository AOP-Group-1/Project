package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;


public class clientInterface extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTable tblInventory;
	private JLabel lblSession;
	

	public clientInterface() {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setTitle("Client Interface");
				setPreferredSize(new Dimension(800, 600));
				
				// buttons
				JButton btnJournMan = new JButton("Journey Management");
				btnJournMan.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//controller.validateCredentials(txtLogin.getText(), String.valueOf(txtPass.getPassword()));

					}
				});
				JButton btnContStat = new JButton("Container Status");
				//btnContStat.setEnabled(false);
				btnContStat.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//ContainerStatus.ContainerStatus();
					}
				});
				
				JButton btnContHis = new JButton("Container History");
				btnContHis.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				JButton btnEditInfo = new JButton("Edit Infomation");
				btnEditInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				// toolbar
				lblSession = new JLabel();
				lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
				
				JToolBar toolbar = new JToolBar();
				toolbar.add(btnJournMan);
				toolbar.add(btnContStat);
				toolbar.add(btnContHis);
				toolbar.add(btnEditInfo);
				toolbar.add(Box.createHorizontalGlue());
				toolbar.add(lblSession);
				add(toolbar, BorderLayout.NORTH);
				
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

