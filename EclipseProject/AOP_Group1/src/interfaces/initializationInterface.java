package interfaces;


import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;

import Login.clientLogin;
import Login.companyLogin;


public class initializationInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private ButtonGroup group;
	private JPanel panel;
	
	public initializationInterface() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(310, 230));
		setTitle("Initialization");		
		setAlwaysOnTop(true);
		setResizable(false);
		
		
		panel = new JPanel();
		panel.setForeground(Color.DARK_GRAY);
		panel.setBackground(Color.DARK_GRAY);		
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Header = new JLabel("Login as Company or Client:");
		Header.setForeground(Color.WHITE);
		Header.setFont(new Font("Arial", Font.BOLD, 18));	
		Header.setBounds(40, 15, 280, 25);
		
		
		JRadioButton companyB = new JRadioButton("Company");
		companyB.setForeground(Color.WHITE);
		companyB.setFont(new Font("Arial", Font.BOLD, 14));
		companyB.setBounds(20, 60, 100, 20);
		
		JRadioButton clientB = new JRadioButton("Client");
		clientB.setForeground(Color.WHITE);
		clientB.setFont(new Font("Arial", Font.BOLD, 14));
		clientB.setBounds(20, 100, 100, 20);
	
		
		JButton exitB = new JButton("Exit");
		exitB.setFont(new Font("Arial", Font.BOLD, 18));
		exitB.setBounds(10, 160, 140, 25);
		exitB.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		
		
		JButton nextB = new JButton("Next");
		nextB.setFont(new Font("Arial", Font.BOLD, 18));
		nextB.setBounds(150, 160, 140, 25);
		nextB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clientB.isSelected() == false && companyB.isSelected() == false) {
					JOptionPane.showMessageDialog(panel,"Please choose a login","Error", JOptionPane.ERROR_MESSAGE);
				} 
				else if (clientB.isSelected() == true) {
					clientLogin.clientLogin();
					dispose();
				}
				else if (companyB.isSelected() == true){
					companyLogin.companyLogin();
					dispose();
				}
				
			}
		});
		
		group = new ButtonGroup();
		group.add(clientB);
		group.add(companyB);
		
		panel.add(Header);
		panel.add(companyB);
		panel.add(clientB);
		panel.add(exitB);
		panel.add(nextB);
		setLocationRelativeTo(null);
	}

	public static void initializationInterface() {
		initializationInterface initialization = new initializationInterface();
		initialization.setVisible(true);
	}
}