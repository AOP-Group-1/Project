package Login;


import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import grid.Grid;
import interfaces.clientInterface;
import interfaces.initializationInterface;

public class clientLogin extends JFrame {

	private static final long serialVersionUID = 1L;
		private JButton btnLogin;
	    private JTextField txtLogin;
	    private JPasswordField txtPass;
	
	
		public clientLogin() {
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setResizable(false);
				setTitle("Client Login");
				setLayout(new GridBagLayout());
				
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 313, 250);
				panel.setLayout(null);
				
			
				txtLogin = new JTextField(15);
				txtPass = new JPasswordField(15);
				btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						if(txtLogin.getText().equals(txtPass.getText()) && !txtLogin.getText().isEmpty()) {
							clientInterface.clientInterface();
							dispose();
							
						}
						else {
							JOptionPane.showMessageDialog(panel, "Wrong username/password combination", "Login error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
				});
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						initializationInterface.initializationInterface();
						dispose();
					}
				});
				
				
				add(panel);
				add(new JLabel("ClientId:"), Grid.constraint(0, 0, 5));
				add(txtLogin, Grid.constraint(1, 0, 5));
				add(new JLabel("Password:"), Grid.constraint(0, 1, 5));
				add(txtPass, Grid.constraint(1, 1, 5));
				add(btnBack,Grid.constraint(-1, 2, 5));
				add(btnLogin, Grid.constraint(1, 2, 5));
				
				pack();
				setLocationRelativeTo(null);
			}
			
		
		public static void clientLogin() {
	    clientLogin clientL = new clientLogin();
	    clientL.setVisible(true);
	}
}