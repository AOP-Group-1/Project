package interfaces;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grid.Grid;
import mainFeatures.Client;

public class searchBoxFrame extends JFrame {

	private static JTextField Id;
	private static JTextField Name;
	private static JTextField Email;
	

	public searchBoxFrame() {
		
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setPreferredSize(new Dimension(310, 230));
			setTitle("Edit info");
			setLayout(new GridBagLayout());
			
			Id = new JTextField(20);
			Name = new JTextField(20);
			Email = new JTextField(20);

			List<JTextField> textFields = new ArrayList<JTextField>();

			textFields.add(Id);
			textFields.add(Name);
			textFields.add(Email);

			add(new JLabel("ID:"), Grid.constraint(0, 3, 5));
			add(Id,Grid.constraint(1, 3, 5));
			add(new JLabel("Name:"), Grid.constraint(0, 0, 5));
			add(Name,Grid.constraint(1, 0, 5));
			add(new JLabel("Email:"), Grid.constraint(0, 2, 5));
			add(Email,Grid.constraint(1, 2, 5));
			
			JButton btnSearch = new JButton("Search");
			//btnLogout.setBounds(670, 540, 120, 30);
			btnSearch.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] searchTerms = {null,null,null};
					
					
					for (int i = 0 ; i < textFields.size() ; i++) {
						JTextField txt = new JTextField();
						txt = textFields.get(i); 
						if (!(txt.getText().isBlank())) {
							searchTerms[i] = txt.getText();	
						}
					}

					ResultSet rs = Client.searchForClient(searchTerms[0],searchTerms[2],searchTerms[1], null, null);
					searchTableFrame.showSearchTableFrame(rs);
					dispose();
					
					
				}
			});
			add(btnSearch,Grid.constraint(1, 5, 5));
			pack();
		
		
	}
	
	
	public static void showSearchBox() {
		searchBoxFrame window = new searchBoxFrame();
		window.setVisible(true);
		
	}
	
	
	
	
}
