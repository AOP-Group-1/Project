package tempfiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import grid.Grid;




public class Show_table_row_data extends JFrame {
    
	// Variables declaration                   
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    public JTextField jTextField_Age;
    public JTextField jTextField_FirstName;
    public JTextField jTextField_Id;
    public JTextField jTextField_LastName;

   
    public Show_table_row_data() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	setLayout(new GridBagLayout());
    	
    	JPanel panel = new JPanel();
		panel.setBounds(0, 0, 313, 250);
		panel.setLayout(null);
		
		
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField_Id = new JTextField(15);
        jTextField_FirstName = new JTextField(15);
        jTextField_LastName = new JTextField(15);
        jTextField_Age = new JTextField(15);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        jLabel1.setText("ID :");

        
        jLabel2.setText("First Name :");

        
        jLabel3.setText("Last Name :");

       
        jLabel4.setText("Age :");

    

        add(panel);
        add( jLabel1, Grid.constraint(0, 0, 5));
        add( jTextField_Id, Grid.constraint(1, 0, 5));
        add( jLabel2,Grid.constraint(0, 1, 5));
        add( jTextField_FirstName,Grid.constraint(1, 1, 5));
        add( jLabel3,Grid.constraint(0, 2, 5));
        add( jTextField_LastName, Grid.constraint(1, 2, 5));
        
        
        
       
        
        pack();
        setLocationRelativeTo(null);
        
    }                        

    /**
     * @param args the command line arguments
     */
    public static void Table(){
    	 
                  new Show_table_row_data().setVisible(true);
              }
         
      
    
      
    

            

}

