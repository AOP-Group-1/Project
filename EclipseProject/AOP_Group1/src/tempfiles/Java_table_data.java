package model;


import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Java_table_data   {

    // Variables declaration - do not modify                     
    private static JScrollPane jScrollPane1;
    private JTable jTable1;
    
    static Object[][] data = new Object[][] {
        {"1", "FZSFD", "GHJSQ", "13"},
        {"2", "FGHJ", "XCFGHY", "54"},
        {"3", "MLKJ", "NOQSDF", "78"},
        {"4", "OIUY", "ZERFGH", "24"},
        {"5", "CBRZDZ", "GHEFE", "33"}};
        
        static String[] columns = new String[] {
        "Id", "First Name", "Last Name", "Age"
    };
        
    public Java_table_data() {
        initComponents();
    }

    Show_table_row_data jtRowData = new Show_table_row_data();
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

     

        jTable1.setModel(new DefaultTableModel(data,columns ));
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
       jScrollPane1.setViewportView(jTable1);
      
    }                        

    private void jTable1MouseClicked(MouseEvent evt) {                                     
        int index = jTable1.getSelectedRow();
        
        TableModel model = jTable1.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        String firstName = model.getValueAt(index, 1).toString();
        String lastName = model.getValueAt(index, 2).toString();
        String age = model.getValueAt(index, 3).toString();
        
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setLocationRelativeTo(null);
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.jTextField_Id.setText(id);
        jtRowData.jTextField_FirstName.setText(firstName);
        jtRowData.jTextField_LastName.setText(lastName);
        jtRowData.jTextField_Age.setText(age);
        
    }                                    

    /**
     * @param args the command line arguments
     * @return 
     */
    public static Component Table() {
    	
                new Java_table_data();
				return jScrollPane1;
          
    }

}

