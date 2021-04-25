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
import interfaces.companyInterface;
import interfaces.initializationInterface;

public class companyLogin extends JFrame {

	private static final long serialVersionUID = 1L;
		private JButton btnLogin;
	    private static JTextField txtLogin;
	    private JPasswordField txtPass;
	
	
		public companyLogin() {
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setResizable(false);
				setTitle("Company Login");
				setLayout(new GridBagLayout());
				
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 313, 250);
				panel.setLayout(null);
				
				String password="123";
			    
				
				txtLogin = new JTextField(15);
				txtPass = new JPasswordField(15);
				btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						if(txtPass.getText().equals(password) && !txtLogin.getText().isEmpty()) {
							companyInterface.companyInterface();
							
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
				add(new JLabel("Company name:"), Grid.constraint(0, 0, 5));
				add(txtLogin, Grid.constraint(1, 0, 5));
				add(new JLabel("Password:"), Grid.constraint(0, 1, 5));
				add(txtPass, Grid.constraint(1, 1, 5));
				add(btnBack,Grid.constraint(-1, 2, 5));
				add(btnLogin, Grid.constraint(1, 2, 5));
				
				pack();
				setLocationRelativeTo(null);
			}
			
		public static String getUsername() {
			return txtLogin.getText();
		}
		
		
		
		public static void companyLogin() {
		companyLogin companyL = new companyLogin();
		companyL.setVisible(true);
	}
}
