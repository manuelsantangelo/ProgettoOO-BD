package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Controller;
import javax.swing.border.LineBorder;

public class ApprovaRecensione extends JFrame{
	
	private Controller controller;

	private JPanel contentPane;
	
	final static int FINESTRA_Y = 0;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	private JTable recensioni = new JTable();

	static DefaultTableModel dtm = new DefaultTableModel(0,0){       //Impostiamo le righe e colonne della JTable
                                                                     //cliccabili ma non modificabil
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
}
};	
	
	public ApprovaRecensione(Controller controller) {
		
		setTitle("Approva recensione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 1370, 651);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrRecensioni = new JTextArea();
		txtrRecensioni.setBackground(Color.BLACK);
		txtrRecensioni.setForeground(Color.GREEN);
		txtrRecensioni.setEditable(false);
		txtrRecensioni.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrRecensioni.setText("Recensioni da approvare");
		txtrRecensioni.setBounds(24, 11, 268, 29);
		contentPane.add(txtrRecensioni);
		recensioni.setRowHeight(30);
		recensioni.setSelectionBackground(Color.LIGHT_GRAY);
		
		
		recensioni.setGridColor(Color.WHITE);
		recensioni.setBorder(new LineBorder(Color.GREEN, 2));
		recensioni.setForeground(Color.WHITE);
		recensioni.setBackground(Color.BLACK);
		recensioni.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		String nomeColonne[] = new String[] { "Nome utente", "Recensione" };
	    recensioni.setModel(dtm);
	    dtm.setColumnIdentifiers(nomeColonne);
		recensioni.setBounds(24, 50, 514, 304);
		contentPane.add(recensioni);
		
		//funzione che riempie la tabella delle recensioni
		riempitabellaRecensioni(controller);
		
		JScrollPane scrollPane = new JScrollPane(recensioni);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBounds(24, 50, 513, 180);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(recensioni);
		
		JTextArea textAreaVisualizzaRecensione = new JTextArea();
		textAreaVisualizzaRecensione.setFont(new Font("Gadugi", Font.PLAIN, 18));
		textAreaVisualizzaRecensione.setEditable(false);
		textAreaVisualizzaRecensione.setBounds(24, 313, 513, 198);
		contentPane.add(textAreaVisualizzaRecensione);
		
		/*JScrollPane scrollPane2 = new JScrollPane(textAreaVisualizzaRecensione);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBounds(24, 313, 513, 198);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textAreaVisualizzaRecensione);*/
		
		
		
		
		
		recensioni.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent mouseEvent) {
	            recensioni = (JTable) mouseEvent.getSource();
	            Point point = mouseEvent.getPoint();
	            int row = recensioni.rowAtPoint(point);
	            if (mouseEvent.getClickCount() == 2 && recensioni.getSelectedRow() != -1) {
	            	int indice = recensioni.getSelectedRow();
	            	
	            	textAreaVisualizzaRecensione.setText(controller.getRecensioneDAO().getRecensioni().get(indice).getTesto());
	            	
	           	
	            }
	        }
		});
		
	}
	
	public void riempitabellaRecensioni (Controller controller) {
		
		controller.getRecensioneDAO().setAllRecensioni(controller.getConnection());
		
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		int i = 0;
	do {
		
		dtm.addRow(new Object[] {
					controller.getRecensioneDAO().getRecensioni().get(i).getUser_FK1(),controller.getRecensioneDAO().getRecensioni().get(i).getTesto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getRecensioneDAO().getRecensioni().size() != i);
	}
}
