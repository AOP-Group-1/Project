package mainFeatures;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;


class StartPage extends JFrame {
	
	
	public JPanel Panel;
	public JPanel ButtonsPanel;
	public JButton SignInButton;
	
	public StartPage() {
		super("Application title");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Panel = new JPanel();
		getContentPane().add(Panel, BorderLayout.CENTER);
		Panel.setLayout(null);
		
		JPanel ButtonsPanel = new JPanel(new FlowLayout());
		Panel.add(ButtonsPanel);
		ButtonsPanel.setBounds(12, 23, 104, 215);
		ButtonsPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		
		
	    JButton SignInButton = new JButton("Sign In");
	    ButtonsPanel.add(SignInButton);
	    SignInButton.setPreferredSize(new Dimension(85, 23));
	    
	    JButton SignUpButton = new JButton("Sign Up");
	    ButtonsPanel.add(SignUpButton);  
	    SignUpButton.setPreferredSize(new Dimension(85, 23));
	    
	    
	}
	
	
}

class SignInPage extends JFrame {
	public JPanel centerPanel;
	
	public SignInPage() {
		super("Application title");
		setSize(900, 600);
		//setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		centerPanel.setPreferredSize(new Dimension(90, 60));
	}

	
	
	
}

class MainPage extends JFrame {
	
	public JPanel upperPanel;
	public JPanel ButtonsPanel;
	public JButton SignInButton;
	
	public MainPage() {
		super("Application title");
		setSize(900, 600);
		//setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JPanel upperPanel = new JPanel();
//		getContentPane().add(upperPanel, BorderLayout.NORTH);
//		upperPanel.setLayout(null);
//		upperPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
//		upperPanel.setPreferredSize(new Dimension(900, 35));
//		
//		JPanel leftPanel = new JPanel();
//		getContentPane().add(leftPanel, BorderLayout.WEST);
//		leftPanel.setLayout(null);
//		leftPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
//		leftPanel.setPreferredSize(new Dimension(600, 300));
//		
//		
//		JPanel rightPanel = new JPanel();
//		getContentPane().add(leftPanel, BorderLayout.EAST);
//		rightPanel.setLayout(null);
//		rightPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
//		rightPanel.setPreferredSize(new Dimension(600, 300));
//		
//		JPanel centerPanel = new JPanel();
//		getContentPane().add(leftPanel, BorderLayout.CENTER);
//		centerPanel.setLayout(null);
//		centerPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
//		centerPanel.setPreferredSize(new Dimension(600, 300));
		
		JPanel ButtonsPanel = new JPanel(new FlowLayout());
		getContentPane().add(ButtonsPanel, BorderLayout.WEST);
		
	    JButton JourneyManagementButton = new JButton("Journey Management");
	    ButtonsPanel.add(JourneyManagementButton);
	    //JourneyManagementButton.addActionListener(new ActionListener());
	    //SignInButton.setPreferredSize(new Dimension(85, 23));
	    
	    JButton ContainerStatusButton = new JButton("Container Status");
	    ButtonsPanel.add(ContainerStatusButton);  
	    //SignUpButton.setPreferredSize(new Dimension(85, 23));
	    
	    JButton ContainerHistoryButton = new JButton("Container History");
	    ButtonsPanel.add(ContainerHistoryButton);  
	    
	    JButton Button1 = new JButton("Container History");
	    ButtonsPanel.add(Button1);
	    
	    JButton Button2 = new JButton("Container History");
	    ButtonsPanel.add(Button2);
	    
	    JButton Button3 = new JButton("Container History");
	    ButtonsPanel.add(Button3);
	}
	
}


public class M4 {
		public static void main(String[] args) {
			
		//StartPage frame = new StartPage();
		//SignInPage frame = new SignInPage();
		MainPage frame = new MainPage();
				
			
		//frame.pack();
		frame.setVisible(true);
		
		
	
	}
}