package interfaces;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;


import controller.ClientController;
import controller.ClientEditController;
import grid.Grid;
import mainFeatures.Client;

public class editUserInfoFrame extends JFrame {

	private static final long serialVersionUID = 249545332907396226L;
	private static JTextField Name;
    private static JTextField Password;
    private static JTextField Email;
    private static JTextField Address;
    private static JTextField Reference_Person;
    
    public editUserInfoFrame() {
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(310, 230));
		setTitle("Edit info");
		setLayout(new GridBagLayout());
		
		Name = new JTextField(20);
		Password = new JTextField(20);
		Email = new JTextField(20);
		Address = new JTextField(20);
		Reference_Person = new JTextField(20);

		
		List<JTextField> textFields = new ArrayList<JTextField>();
		List<String> textFieldNames = new ArrayList<String>();
		
		textFields.add(Name);
		textFieldNames.add("Name");
		textFields.add(Password);
		textFieldNames.add("Password");
		textFields.add(Email);
		textFieldNames.add("Email");
		textFields.add(Address);
		textFieldNames.add("Address");
		textFields.add(Reference_Person);
		textFieldNames.add("Reference_Person");
		

		add(new JLabel("Edit name:"), Grid.constraint(0, 0, 5));
		add(Name,Grid.constraint(1, 0, 5));
		add(new JLabel("Edit Password:"), Grid.constraint(0, 1, 5));
		add(Password,Grid.constraint(1, 1, 5));
		add(new JLabel("Edit Email:"), Grid.constraint(0, 2, 5));
		add(Email,Grid.constraint(1, 2, 5));
		add(new JLabel("Edit Address:"), Grid.constraint(0, 3, 5));
		add(Address,Grid.constraint(1, 3, 5));
		add(new JLabel("Edit Reference Person:"), Grid.constraint(0, 4, 5));
		add(Reference_Person,Grid.constraint(1, 4, 5));

		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Client currentClient = ClientController.getClient();
				for (int i = 0 ; i < textFields.size() ; i++) {
					JTextField txt = new JTextField();
					txt = textFields.get(i); 
					if (!(txt.getText().isEmpty())) {
						ClientEditController.editClientInfo(currentClient, txt.getText(), textFieldNames.get(i));
					}
				}
				
				
			}
		});
		
		add(btnConfirm, Grid.constraint(1, 6, 5));
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void showEditUserFrame() {
		editUserInfoFrame window = new editUserInfoFrame();
		window.setVisible(true);
		window.setAlwaysOnTop(true);;
		
	}
	
}
