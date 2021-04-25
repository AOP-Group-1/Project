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
			JButton btnNew = new JButton("Add inventory item");
			btnNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			JButton btnDelete = new JButton("Remove selected item");
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			// toolbar
			lblSession = new JLabel();
			lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSession.setText("<html>" + companyLogin.getUsername() + " <i>(" +" Admin" + ")</i></html>");
			
			
			JToolBar toolbar = new JToolBar();
			toolbar.add(btnNew);
			toolbar.add(btnDelete);
			toolbar.add(Box.createHorizontalGlue());
			toolbar.add(lblSession);
			add(toolbar, BorderLayout.NORTH);
			
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
