package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Controller;
import logic.Classi.Albergo;
import logic.Classi.Attrazione;
import logic.Classi.Ristorante;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Principale extends JFrame {
	
	private Controller controller;

	private JPanel contentPane;
	private JFrame frame;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	private JTable elementi = new JTable();
	private JTextArea txtDomanda;

	static DefaultTableModel dtm = new DefaultTableModel(0,0){       //Impostiamo le righe e colonne della JTable
		                                                             //cliccabili ma non modificabili
		@Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};	
	
	
	static int lista = 0; 
	private JTextField areaNome;
	private JTextField areaStato;
	private JTextField areaCittà;
	private JTextField areaProvincia;
	public Principale(Controller controller) throws IOException{
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("Benvenuto " + controller.getUtenteDAO().getUtente().getNome() + " " + controller.getUtenteDAO().getUtente().getCognome());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton cerca = new JButton("Cerca");
		cerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cerca.setForeground(Color.BLACK);
		cerca.setFont(new Font("Gadugi", Font.BOLD, 16));
		cerca.setBackground(Color.WHITE);
		cerca.setBounds(777, 534, 117, 28);
		contentPane.add(cerca);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 312, 651);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeECognome = new JLabel(controller.getUtenteDAO().getUtente().getNome() + " " + controller.getUtenteDAO().getUtente().getCognome());
		lblNomeECognome.setFont(new Font("Gadugi", Font.BOLD, 21));
		lblNomeECognome.setBounds(42, 203, 244, 35);
		lblNomeECognome.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNomeECognome);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lblFoto.setBounds(42, 23, 160, 160);
		panel.add(lblFoto);
		
		byte[] imgBytes = controller.getUtenteDAO().getUtente().getPropic();
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblFoto.setIcon(imageIcon);
		
		JLabel lblNickname = new JLabel(controller.getUtenteDAO().getUtente().getNickname());
		lblNickname.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNickname.setAlignmentX(0.5f);
		lblNickname.setBounds(42, 229, 194, 35);
		panel.add(lblNickname);
		
		JLabel lblEmail = new JLabel(controller.getUtenteDAO().getUtente().getEmail());
		lblEmail.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(42, 250, 194, 35);
		panel.add(lblEmail);
		
		JLabel lblDataDiIscrizione = new JLabel("Data di Iscrizione: " + controller.getUtenteDAO().getUtente().getData_Iscrizione());
		lblDataDiIscrizione.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblDataDiIscrizione.setAlignmentX(0.5f);
		lblDataDiIscrizione.setBounds(42, 296, 244, 35);
		panel.add(lblDataDiIscrizione);
		
		JLabel lblDescrizioniEffettuate = new JLabel("Descrizioni effettuate: " + controller.getUtenteDAO().getUtente().getContributi());
		lblDescrizioniEffettuate.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblDescrizioniEffettuate.setAlignmentX(0.5f);
		lblDescrizioniEffettuate.setBounds(42, 320, 235, 35);
		panel.add(lblDescrizioniEffettuate);
		
		JButton btnIndietro = new JButton("Logout");
		btnIndietro.setBounds(93, 506, 117, 29);
		panel.add(btnIndietro);
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Principale.this, controller.getHome());
			}
		});
		btnIndietro.setForeground(new Color(0, 0, 0));
		btnIndietro.setFont(new Font("Gadugi", Font.BOLD, 15));
		btnIndietro.setBackground(new Color(0, 153, 255));
		
		txtDomanda = new JTextArea();
		txtDomanda.setEditable(false);
		txtDomanda.setFont(new Font("Gadugi", Font.BOLD, 30));
		txtDomanda.setText("Cosa si desidera recensire?");
		txtDomanda.setForeground(new Color(0, 0, 0));
		txtDomanda.setBackground(new Color(0, 191, 255));
		txtDomanda.setBounds(417, 10, 391, 54);
		contentPane.add(txtDomanda);
		txtDomanda.setColumns(10);
		
		JComboBox attrazioneristorantehotel = new JComboBox();

		attrazioneristorantehotel.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		attrazioneristorantehotel.setBackground(Color.WHITE);
		attrazioneristorantehotel.setForeground(Color.BLACK);
		String [] tipi = {"Attrazione","Ristorante","Albergo"};
		DefaultComboBoxModel model = new DefaultComboBoxModel(tipi);
		attrazioneristorantehotel.setModel(model);
		attrazioneristorantehotel.setBounds(332, 81, 117, 29);
		contentPane.add(attrazioneristorantehotel);
		elementi.setSelectionBackground(UIManager.getColor("Table.selectionBackground"));
		elementi.setRowHeight(25);
		
	
		elementi.setBackground(new Color(255, 255, 255));
		elementi.setFont(new Font("Gadugi", Font.PLAIN, 18));
		String nomeColonne[] = new String[] { "Nome", "Città", "Voto" };
	    elementi.setModel(dtm);
	    dtm.setColumnIdentifiers(nomeColonne);
		elementi.setBounds(332, 148, 514, 304);
		contentPane.add(elementi);
		
		JScrollPane scrollPane = new JScrollPane(elementi);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBounds(332, 194, 563, 316);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(elementi);
		
		JTextArea txtrNome = new JTextArea();
		txtrNome.setText("Nome\r\n");
		txtrNome.setForeground(Color.BLACK);
		txtrNome.setFont(new Font("Gadugi", Font.BOLD, 17));
		txtrNome.setEditable(false);
		txtrNome.setColumns(10);
		txtrNome.setBackground(new Color(0, 191, 255));
		txtrNome.setBounds(332, 125, 60, 29);
		contentPane.add(txtrNome);
		
		areaNome = new JTextField();
		areaNome.setFont(new Font("Gadugi", Font.BOLD, 14));
		areaNome.setBounds(389, 130, 173, 20);
		contentPane.add(areaNome);
		areaNome.setColumns(10);
		
		JTextArea txtrStato = new JTextArea();
		txtrStato.setText("Stato\r\n");
		txtrStato.setForeground(Color.BLACK);
		txtrStato.setFont(new Font("Gadugi", Font.BOLD, 17));
		txtrStato.setEditable(false);
		txtrStato.setColumns(10);
		txtrStato.setBackground(new Color(0, 191, 255));
		txtrStato.setBounds(332, 154, 60, 29);
		contentPane.add(txtrStato);
		
		areaStato = new JTextField();
		areaStato.setFont(new Font("Gadugi", Font.BOLD, 14));
		areaStato.setColumns(10);
		areaStato.setBounds(389, 161, 173, 20);
		contentPane.add(areaStato);
		
		JTextArea txtrCittà = new JTextArea();
		txtrCittà.setText("Citt\u00E0");
		txtrCittà.setForeground(Color.BLACK);
		txtrCittà.setFont(new Font("Gadugi", Font.BOLD, 17));
		txtrCittà.setEditable(false);
		txtrCittà.setColumns(10);
		txtrCittà.setBackground(new Color(0, 191, 255));
		txtrCittà.setBounds(633, 121, 50, 29);
		contentPane.add(txtrCittà);
		
		JTextArea txtrProvincia = new JTextArea();
		txtrProvincia.setText("Provincia");
		txtrProvincia.setForeground(Color.BLACK);
		txtrProvincia.setFont(new Font("Gadugi", Font.BOLD, 17));
		txtrProvincia.setEditable(false);
		txtrProvincia.setColumns(10);
		txtrProvincia.setBackground(new Color(0, 191, 255));
		txtrProvincia.setBounds(606, 154, 77, 29);
		contentPane.add(txtrProvincia);
		
		areaCittà = new JTextField();
		areaCittà.setFont(new Font("Gadugi", Font.BOLD, 14));
		areaCittà.setColumns(10);
		areaCittà.setBounds(693, 128, 173, 20);
		contentPane.add(areaCittà);
		
		areaProvincia = new JTextField();
		areaProvincia.setFont(new Font("Gadugi", Font.BOLD, 14));
		areaProvincia.setColumns(10);
		areaProvincia.setBounds(693, 161, 173, 20);
		contentPane.add(areaProvincia);
		
		
	
		cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = attrazioneristorantehotel.getSelectedItem().toString();
	
				if(nome == "Attrazione") {
				lista = 1;
				riempitabellaAttrazioni(controller);
				
				}else if(nome == "Ristorante"){
					lista = 2;
					riempitabellaRistoranti(controller);
					
				}else if(nome == "Albergo") {
					lista = 3;
					riempitabellaAlberghi(controller);
				}
			}});
	
	 //Doppio click mouse, apertura pagina recensioni 
    elementi.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent mouseEvent) {
            elementi = (JTable) mouseEvent.getSource();
            Point point = mouseEvent.getPoint();
            int row = elementi.rowAtPoint(point);
            if (mouseEvent.getClickCount() == 2 && elementi.getSelectedRow() != -1) {
           	
            	
            	int indice = elementi.getSelectedRow();
            	controller.setIndice(indice);
            	if(lista == 1) {
            		controller.getAttrazioneDAO().setAttrazione(controller.getAttrazioneDAO().getAttrazioni().get(indice));
            		controller.getLuogoDAO().setLuogo2(controller.getConnection(), controller.getAttrazioneDAO().getAttrazione().getLuogo_FK());
            		controller.getContattiDAO().setContattiAttrazioni(controller.getConnection());

            		try {
						controller.CambiaFrame(Principale.this, controller.getScriviRecensioneAttr());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
            	}else if(lista == 2) {
            		
            		controller.getRistoranteDAO().setRistorante(controller.getRistoranteDAO().getRistoranti().get(indice));
            		controller.getLuogoDAO().setLuogo2(controller.getConnection(), controller.getRistoranteDAO().getRistorante().getLuogo_FK());
            		controller.getContattiDAO().setContattiRistorante(controller.getConnection());
            		controller.getAssociazione_Categoria_RistoranteDAO().setAssociazione_Categoria_RistoranteByID(controller.getConnection());
         
            		try {
            			
						controller.CambiaFrame(Principale.this, controller.getScriviRecensioneRis());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
            	}else if (lista == 3) {
            		controller.getAlbergoDAO().setAlbergo(controller.getAlbergoDAO().getAlberghi().get(indice));
            		controller.getLuogoDAO().setLuogo2(controller.getConnection(), controller.getAlbergoDAO().getAlbergo().getLuogo_FK());
            		controller.getContattiDAO().setContattiAlbergo(controller.getConnection());
            		controller.getAssociazione_Servizio_AlbergoDAO().setAssociazione_Servizio_AlbergoByID(controller.getConnection());
            		try {
						controller.CambiaFrame(Principale.this, controller.getScriviRecensioneAlb());
					} catch (IOException e) {
						e.printStackTrace();
					}
           }
				
            }
        }
    });
	}
	//-----------------------------------------------------------------------------------------------------------
	//CHIUSURA COSTRUTTORE
	//FUNZIONI PER RIEMPIRE LE TABELLE!!!!
	
	
	public void riempitabellaAlberghi(Controller controller) {
	
		if(areaNome.getText().isEmpty() && areaStato.getText().isEmpty() && areaCittà.getText().isEmpty() && areaProvincia.getText().isEmpty())
		{
		
			controller.getAlbergoDAO().setAllAlberghi(controller.getConnection());
			
		}
		else {
			controller.getAlbergoDAO().setAlbergoByFiltro(controller.getConnection(), areaNome.getText(), areaCittà.getText(), areaStato.getText(), areaProvincia.getText());
		}
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		int i = 0;
		if(controller.getAlbergoDAO().getAlberghi().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati!");
		}	
		else {
	do {
		int luogoFK = controller.getAlbergoDAO().getAlberghi().get(i).getLuogo_FK();
		controller.getLuogoDAO().setLuogoByID(controller.getConnection(), luogoFK);
		dtm.addRow(new Object[] {
					controller.getAlbergoDAO().getAlberghi().get(i).getNome(),controller.getLuogoDAO().getLuogo().getCittà() ,controller.getAlbergoDAO().getAlberghi().get(i).getVoto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getAlbergoDAO().getAlberghi().size() != i);
	
		}
	}
	
	public void riempitabellaRistoranti(Controller controller) {
		if(areaNome.getText().isEmpty() && areaStato.getText().isEmpty() && areaCittà.getText().isEmpty() && areaProvincia.getText().isEmpty())
		{
		
			controller.getRistoranteDAO().setAllRistoranti(controller.getConnection());
			
		}
		else {
			controller.getRistoranteDAO().setRistoranteByFiltro(controller.getConnection(), areaNome.getText(), areaCittà.getText(), areaStato.getText(), areaProvincia.getText());
		}
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);


		int i = 0;
		if(controller.getRistoranteDAO().getRistoranti().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati!");

		}	else {
	do {
		int luogoFK = controller.getRistoranteDAO().getRistoranti().get(i).getLuogo_FK();
		controller.getLuogoDAO().setLuogoByID(controller.getConnection(), luogoFK);
		
		
			dtm.addRow(new Object[] {
					controller.getRistoranteDAO().getRistoranti().get(i).getNome(), controller.getLuogoDAO().getLuogo().getCittà(), controller.getRistoranteDAO().getRistoranti().get(i).getVoto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
			
		}while(controller.getRistoranteDAO().getRistoranti().size() != i);
	
	}
	}
	
	public void riempitabellaAttrazioni(Controller controller) {
		if(areaNome.getText().isEmpty() && areaStato.getText().isEmpty() && areaCittà.getText().isEmpty() && areaProvincia.getText().isEmpty())
		{
		
			controller.getAttrazioneDAO().setAllAttrazioni(controller.getConnection());
			
		}
		else {
			controller.getAttrazioneDAO().setAttrazioneByFiltro(controller.getConnection(), areaNome.getText(), areaCittà.getText(), areaStato.getText(), areaProvincia.getText());
		}
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		
		int i = 0;
		if(controller.getAttrazioneDAO().getAttrazioni().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati!");
		}	else {
	do {
		int luogoFK = controller.getAttrazioneDAO().getAttrazioni().get(i).getLuogo_FK();
		controller.getLuogoDAO().setLuogoByID(controller.getConnection(), luogoFK);
		
			dtm.addRow(new Object[] {
					controller.getAttrazioneDAO().getAttrazioni().get(i).getNome(),controller.getLuogoDAO().getLuogo().getCittà(), controller.getAttrazioneDAO().getAttrazioni().get(i).getVoto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getAttrazioneDAO().getAttrazioni().size() != i);
	}
}
	
}
	

