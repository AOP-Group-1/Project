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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import grid.Grid;
import mainFeatures.Client;

public class addClientFrame extends JFrame {

	private static final long serialVersionUID = -8197384896405094748L;
	private static JTextField Name;
	    private static JTextField Password;
	    private static JTextField Email;
	    private static JTextField Address;
	    private static JTextField Reference_Person;
	    
	    public addClientFrame() {
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(new Dimension(310, 230));
			setTitle("Add Client");
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
			
			

			add(new JLabel("Name"), Grid.constraint(0, 0, 5));
			add(Name,Grid.constraint(1, 0, 5));
			add(new JLabel("Password:"), Grid.constraint(0, 1, 5));
			add(Password,Grid.constraint(1, 1, 5));
			add(new JLabel("Email:"), Grid.constraint(0, 2, 5));
			add(Email,Grid.constraint(1, 2, 5));
			add(new JLabel("Address:"), Grid.constraint(0, 3, 5));
			add(Address,Grid.constraint(1, 3, 5));
			add(new JLabel("Reference Person:"), Grid.constraint(0, 4, 5));
			add(Reference_Person,Grid.constraint(1, 4, 5));

			
			
			JButton btnConfirm = new JButton("Confirm");

			btnConfirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//check that all fields are filled out and unique name
					
					boolean allFilled = true;
					for (int i = 0 ; i < textFields.size() ; i++) {
						JTextField txt = new JTextField();
						txt = textFields.get(i); 
						allFilled = allFilled && !txt.getText().isBlank();
					}

					if (allFilled) {
					
					Client newClient = new Client();
					newClient.setName(Name.getText());
					newClient.setEmail(Email.getText());
					newClient.setAddress(Address.getText());
					newClient.setRefPer(Reference_Person.getText());
					newClient.setPassword(Password.getText());

					newClient.registerClient();
					dispose();
					}
					
					else {
						JPanel panel = new JPanel();
						JOptionPane.showMessageDialog(panel, "Please fill out all text fields", "Filling Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			});
			
			add(btnConfirm, Grid.constraint(1, 6, 5));
			
			pack();
		}
		
		public static void showAddClientFrame() {
			addClientFrame window = new addClientFrame();
			window.setVisible(true);
			window.toFront();
			
		}
	
	
}
