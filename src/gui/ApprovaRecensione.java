package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Controller;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApprovaRecensione extends JFrame{
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;
	
	final static int FINESTRA_Y = 0;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	private JTable recensioni = new JTable();

	@SuppressWarnings("serial") // Utilizzato per ignorare il warning che non crea problemi
	static DefaultTableModel modello_di_default = new DefaultTableModel(0,0){       //Impostiamo le righe e colonne della JTable
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
		setBounds(FINESTRA_Y, FINESTRA_X, 1000, 651);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea testo_Recensioni = new JTextArea();
		testo_Recensioni.setBackground(Color.BLACK);
		testo_Recensioni.setForeground(Color.GREEN);
		testo_Recensioni.setEditable(false);
		testo_Recensioni.setLineWrap(true);
		testo_Recensioni.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Recensioni.setText("Recensioni da approvare");
		testo_Recensioni.setBounds(24, 11, 268, 29);
		contentPane.add(testo_Recensioni);
		
		recensioni.setRowHeight(30);
		recensioni.setSelectionBackground(Color.LIGHT_GRAY);
		recensioni.setGridColor(Color.WHITE);
		recensioni.setBorder(new LineBorder(Color.GREEN, 2));
		recensioni.setForeground(Color.WHITE);
		recensioni.setBackground(Color.BLACK);
		recensioni.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		String nomeColonne[] = new String[] { "User ID", "Recensione" };
	    recensioni.setModel(modello_di_default);
	    modello_di_default.setColumnIdentifiers(nomeColonne);
		recensioni.setBounds(24, 50, 514, 304);
		contentPane.add(recensioni);
		
		//funzione che riempie la tabella delle recensioni
		riempitabellaRecensioni(controller);
		
		JScrollPane barra_di_scorrimento = new JScrollPane(recensioni);
		barra_di_scorrimento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		barra_di_scorrimento.setBounds(24, 50, 513, 180);
		contentPane.add(barra_di_scorrimento);
		barra_di_scorrimento.setViewportView(recensioni);
		
		JTextArea area_Visualizza_Recensione = new JTextArea();
		area_Visualizza_Recensione.setFont(new Font("Gadugi", Font.PLAIN, 18));
		area_Visualizza_Recensione.setEditable(false);
		area_Visualizza_Recensione.setLineWrap(true);
		area_Visualizza_Recensione.setBounds(24, 313, 513, 198);
		contentPane.add(area_Visualizza_Recensione);
		
		JScrollPane secoda_barra_di_scorrimento = new JScrollPane(area_Visualizza_Recensione);
		secoda_barra_di_scorrimento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		secoda_barra_di_scorrimento.setBounds(24, 313, 513, 198);
		secoda_barra_di_scorrimento.getViewport().setBackground(Color.BLACK);
		getContentPane().add(secoda_barra_di_scorrimento);
		
		JButton bottone_Approva = new JButton("Approva");
		bottone_Approva.setForeground(Color.BLACK);
		bottone_Approva.setFont(new Font("Dialog", Font.PLAIN, 18));
		bottone_Approva.setBackground(Color.GREEN);
		bottone_Approva.setBounds(619, 50, 117, 56);
		contentPane.add(bottone_Approva);
		
		JButton bottone_Rifiuta = new JButton("Rifiuta");
		bottone_Rifiuta.setForeground(Color.BLACK);
		bottone_Rifiuta.setFont(new Font("Dialog", Font.PLAIN, 18));
		bottone_Rifiuta.setBackground(Color.RED);
		bottone_Rifiuta.setBounds(788, 50, 117, 56);
		contentPane.add(bottone_Rifiuta);
		
		JButton bottone_Aggiorna = new JButton("Aggiorna");
		bottone_Aggiorna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Aggiorna.setForeground(Color.GREEN);
		bottone_Aggiorna.setFont(new Font("Dialog", Font.PLAIN, 18));
		bottone_Aggiorna.setBackground(Color.BLACK);
		bottone_Aggiorna.setBounds(701, 136, 117, 39);
		contentPane.add(bottone_Aggiorna);
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Indietro.setForeground(Color.GREEN);
		bottone_Indietro.setFont(new Font("Dialog", Font.PLAIN, 18));
		bottone_Indietro.setBackground(Color.BLACK);
		bottone_Indietro.setBounds(843, 519, 117, 45);
		contentPane.add(bottone_Indietro);
		
		JTextArea testo_Recensione_Completa = new JTextArea();
		testo_Recensione_Completa.setText("Testo recensione completa\r\n");
		testo_Recensione_Completa.setForeground(Color.GREEN);
		testo_Recensione_Completa.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Recensione_Completa.setEditable(false);
		testo_Recensione_Completa.setLineWrap(true);
		testo_Recensione_Completa.setBackground(Color.BLACK);
		testo_Recensione_Completa.setBounds(24, 274, 284, 29);
		contentPane.add(testo_Recensione_Completa);
		
		// Listener della lista_Recensioni che ci permette di visualizzare
		// con un doppio clickla recensione nel riquadro ad essa dedicata
		// con il nome del recensore
		
		recensioni.addMouseListener(new MouseAdapter() {
	        @SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
			public void mousePressed(MouseEvent mouseEvent) {
	            recensioni = (JTable) mouseEvent.getSource();
	            Point point = mouseEvent.getPoint();
	            int row = recensioni.rowAtPoint(point);
	            if (mouseEvent.getClickCount() == 2 && recensioni.getSelectedRow() != -1) {
	            	int indice = recensioni.getSelectedRow();
	            	area_Visualizza_Recensione.setText(controller.getRecensioneDAO().getRecensioni().get(indice).getTesto());
	            }
	        }
		});
		
		// Listener di bottone_Approva che richiama una funzione dalla DAO
		// attraverso il controller che esegue un UPDATE della tabella Recensione
		// in modo da far si che essa sia approvata, quindi utilizzabile dal 
		// programma
		
		bottone_Approva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indice = recensioni.getSelectedRow();
				String testoRecensione = recensioni.getModel().getValueAt(indice, 1).toString();
				controller.getRecensioneDAO().approvaRecensione(controller.getConnection(), testoRecensione, controller.getModeratoreDAO().getModeratore().getModeratore_ID());
				}
		});
		
		// Listener di bottone_Aggiorna che esegue semplicemente  
		// la funzione riempitabellaRecensioni in modo da aggiorare
		//la lista
		
		bottone_Aggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 riempitabellaRecensioni(controller);
				 }
		});
		
		//lister di bottone_Rifiuta cheche richiama una funzione dalla DAO
		// attraverso il controller che esegue un DELETE sulla tabella 
		// Recensioni, eliminando le recensioni che non vengono approvate
		
		bottone_Rifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = recensioni.getSelectedRow();
				String testoRecensione = recensioni.getModel().getValueAt(indice, 1).toString();
				controller.getRecensioneDAO().rifiutaRecensione(controller.getConnection(), testoRecensione);
			}
		});
		
		// listener di bottone_Indietro che riporta alla HomePage del
		// Moderatore
		
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(ApprovaRecensione.this, controller.getModeratore_Homepage());
			}
		});
		
	}
	
	// Metodo che richiama un paio di funzioni dalla DAO mediante il controller
	// che settano un ArrayList di Recensioni, che verrà usato nella Gui
	// per popolare la tabella
	
	public void riempitabellaRecensioni (Controller controller) {
		
		controller.getRecensioneDAO().setAllRecensioni(controller.getConnection());
	
		while (modello_di_default.getRowCount() > 0) {
		    modello_di_default.removeRow(0);
		}
		
		modello_di_default.setRowCount(0);

		int i = 0;
		
	do {
		
		modello_di_default.addRow(new Object[] {
					controller.getRecensioneDAO().getRecensioni().get(i).getUser_FK1(),controller.getRecensioneDAO().getRecensioni().get(i).getTesto(),
			});
			modello_di_default.isCellEditable(i, 1);
			modello_di_default.isCellEditable(i, 2);
			i++;
		}while(controller.getRecensioneDAO().getRecensioni().size() != i);
	}
}
