package basedados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	
	private Reader reader;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					init();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param bd 
	 */
	public GUI(Reader bd) {
		this.reader = bd;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		
		String [] DefaultColumns  = {"ID","Descricao","Quantidade"};
		table_1 = getJTable(DefaultColumns);

		panel.add(table_1);
		contentPane.add(panel, BorderLayout.CENTER);
		
//		table_1 = new JTable();
//		panel.add(table_1);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("ReadFile");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String [] Columns = reader.getColumns;
				List <Fatura> ListFaturas = reader.getFaturas();
				
		    	JTable table = getJTable(Columns);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		       // model.addRow(new Object[]{fatura.getID(),fatura.getDescricao(), fatura.getQuantidade()});
		        model.setColumnIdentifiers(Columns);
		        
		        model.setRowCount(0);
		        for(Fatura fatura : ListFaturas){
		        	Object[] obj = fatura.covToObjectVect();
		        	model.addRow(obj);
		        }
		    
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
	}
	private JTable getJTable(String[] columns) {
    	
        if (table_1 == null) {
        	table_1 = new JTable() {
                public boolean isCellEditable(int nRow, int nCol) {
                    return false;
                }
            };
        }
        DefaultTableModel contactTableModel = (DefaultTableModel) table_1
                .getModel();
        contactTableModel.setColumnIdentifiers(columns);
        table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return table_1;
    }
	
	public static void init(){
	      
	     	Reader bd = new Reader();
	        bd.readFile("teste.txt");
	        bd.readDataTest();
	        GUI frame = new GUI(bd);
	        frame.setVisible(true);
	    }


}
