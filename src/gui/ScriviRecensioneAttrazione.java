package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Tipi.tipoattrazione;
import logic.Controller;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JList;

public class ScriviRecensioneAttrazione extends JFrame {
	
	private JPanel contentPane;
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	private DefaultListModel dlm = new DefaultListModel();
	private DefaultListModel dlm1 = new DefaultListModel();
	private DefaultListModel dlm2 = new DefaultListModel();
	private DefaultListModel dlm3 = new DefaultListModel();


	
public ScriviRecensioneAttrazione(Controller controller) throws IOException {
	
	setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
	setTitle("Recensione " + controller.getAttrazioneDAO().getAttrazione().getNome());
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
	
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 191, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);


		JTextArea txtrDescrizione = new JTextArea();
		txtrDescrizione.setFocusable(false);
		txtrDescrizione.setText("Recensione");
		txtrDescrizione.setForeground(Color.WHITE);
		txtrDescrizione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrDescrizione.setEditable(false);
		txtrDescrizione.setBackground(new Color(0, 191, 255));
		txtrDescrizione.setBounds(24, 459, 128, 29);
		contentPane.add(txtrDescrizione);
		
		JButton btnaggiungirecensione = new JButton("Aggiungi recensione");
		btnaggiungirecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnaggiungirecensione.setForeground(Color.BLACK);
		btnaggiungirecensione.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnaggiungirecensione.setBackground(Color.WHITE);
		btnaggiungirecensione.setBounds(717, 537, 177, 47);
		contentPane.add(btnaggiungirecensione);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setFocusable(false);
		lblFoto.setBackground(new Color(255, 255, 255));
		lblFoto.setBounds(43, 48, 187, 182);
		contentPane.add(lblFoto);
		
		byte[] imgBytes = controller.getAttrazioneDAO().getAttrazione().getFoto();
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblFoto.setIcon(imageIcon);
		
		JComboBox valutazioneStelle = new JComboBox();

		valutazioneStelle.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		valutazioneStelle.setBackground(new Color(0, 191, 255));
		valutazioneStelle.setForeground(new Color(0, 0, 0));
		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"});
		valutazioneStelle.setModel(model);
		valutazioneStelle.setBounds(717, 498, 177, 29);
		contentPane.add(valutazioneStelle);
		
		JTextArea txtrvalutazioneStelle = new JTextArea();
		txtrvalutazioneStelle.setFocusable(false);
		txtrvalutazioneStelle.setText("Stelle valutazione");
		txtrvalutazioneStelle.setForeground(Color.WHITE);
		txtrvalutazioneStelle.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrvalutazioneStelle.setEditable(false);
		txtrvalutazioneStelle.setBackground(new Color(0, 191, 255));
		txtrvalutazioneStelle.setBounds(713, 458, 181, 29);
		contentPane.add(txtrvalutazioneStelle);
		
		JTextArea txtrNome = new JTextArea();
		txtrNome.setFocusable(false);
		txtrNome.setEditable(false);
		txtrNome.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrNome.setText(controller.getAttrazioneDAO().getAttrazione().getNome());
		txtrNome.setBackground(new Color(0, 191, 255));
		txtrNome.setBounds(41, 10, 189, 40);
		contentPane.add(txtrNome);
		
		JTextArea txtrDescrizione_1 = new JTextArea();
		txtrDescrizione_1.setFocusable(false);
		txtrDescrizione_1.setEditable(false);
		txtrDescrizione_1.setBackground(new Color(0, 191, 255));
		txtrDescrizione_1.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrDescrizione_1.setText("Descrizione");
		txtrDescrizione_1.setBounds(270, 10, 294, 22);
		contentPane.add(txtrDescrizione_1);
		
		JTextArea textAreaRecensione = new JTextArea();
		textAreaRecensione.setBounds(24, 498, 624, 98);
		textAreaRecensione.setLineWrap(true);
		contentPane.add(textAreaRecensione);
		
		JScrollPane scrollPane = new JScrollPane(textAreaRecensione);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 498, 624, 98);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);
		
		
		JTextArea textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setFocusable(false);
		textAreaDescrizione.setFont(new Font("Gadugi", Font.ITALIC, 16));
		textAreaDescrizione.setWrapStyleWord(true);
		textAreaDescrizione.setLineWrap(true);
		textAreaDescrizione.setEditable(false);
		textAreaDescrizione.setText(controller.getAttrazioneDAO().getAttrazione().getDescrizione());
		textAreaDescrizione.setBackground(new Color(0, 191, 255));
		textAreaDescrizione.setBounds(270, 48, 483, 182);
		contentPane.add(textAreaDescrizione);
		
		JTextArea txtrStato = new JTextArea();
		txtrStato.setFocusable(false);
		txtrStato.setBackground(new Color(0, 191, 255));
		txtrStato.setEditable(false);
		txtrStato.setText("Stato");
		txtrStato.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrStato.setBounds(43, 262, 118, 29);
		contentPane.add(txtrStato);
		
		JTextArea txtrCittà = new JTextArea();
		txtrCittà.setFocusable(false);
		txtrCittà.setBackground(new Color(0, 191, 255));
		txtrCittà.setEditable(false);
		txtrCittà.setText("Citt\u00E0\r\n");
		txtrCittà.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrCittà.setBounds(328, 262, 101, 29);
		contentPane.add(txtrCittà);
		
		JTextArea txtrProvincia = new JTextArea();
		txtrProvincia.setFocusable(false);
		txtrProvincia.setBackground(new Color(0, 191, 255));
		txtrProvincia.setEditable(false);
		txtrProvincia.setText("Provincia\r\n");
		txtrProvincia.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrProvincia.setBounds(581, 262, 85, 29);
		contentPane.add(txtrProvincia);
		
		JTextArea txtrIndirizzo = new JTextArea();
		txtrIndirizzo.setFocusable(false);
		txtrIndirizzo.setBackground(new Color(0, 191, 255));
		txtrIndirizzo.setEditable(false);
		txtrIndirizzo.setText("Indirizzo\r\n");
		txtrIndirizzo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrIndirizzo.setBounds(44, 365, 149, 29);
		contentPane.add(txtrIndirizzo);
		
		JTextArea txtrContatti = new JTextArea();
		txtrContatti.setFocusable(false);
		txtrContatti.setBackground(new Color(0, 191, 255));
		txtrContatti.setEditable(false);
		txtrContatti.setText("Telefono");
		txtrContatti.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrContatti.setBounds(291, 365, 80, 29);
		contentPane.add(txtrContatti);
		
		JTextArea txtrSitoWeb = new JTextArea();
		txtrSitoWeb.setFocusable(false);
		txtrSitoWeb.setBackground(new Color(0, 191, 255));
		txtrSitoWeb.setEditable(false);
		txtrSitoWeb.setText("Sito Web");
		txtrSitoWeb.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrSitoWeb.setBounds(480, 365, 80, 29);
		contentPane.add(txtrSitoWeb);
		
		JTextArea textStato = new JTextArea();
		textStato.setFocusable(false);
		textStato.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textStato.setBackground(new Color(0, 191, 255));
		textStato.setEditable(false);
		textStato.setText(controller.getLuogoDAO().getLuogo2().getStato());
		textStato.setBounds(43, 301, 255, 29);
		contentPane.add(textStato);
		
		JTextArea textCittà = new JTextArea();
		textCittà.setFocusable(false);
		textCittà.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textCittà.setBackground(new Color(0, 191, 255));
		textCittà.setEditable(false);
		textCittà.setText(controller.getLuogoDAO().getLuogo2().getCittà());
		textCittà.setBounds(328, 301, 236, 29);
		contentPane.add(textCittà);
		
		JTextArea textProvincia = new JTextArea();
		textProvincia.setFocusable(false);
		textProvincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textProvincia.setBackground(new Color(0, 191, 255));
		textProvincia.setEditable(false);
		textProvincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		textProvincia.setBounds(581, 301, 121, 29);
		contentPane.add(textProvincia);
		
		JTextArea textIndirizzo = new JTextArea();
		textIndirizzo.setFocusable(false);
		textIndirizzo.setFont(new Font("Gadugi", Font.PLAIN, 16));
		textIndirizzo.setBackground(new Color(0, 191, 255));
		textIndirizzo.setEditable(false);
		textIndirizzo.setText(controller.getLuogoDAO().getLuogo2().getIndirizzo());
		textIndirizzo.setBounds(43, 404, 238, 40);
		contentPane.add(textIndirizzo);
		
		JList listTelefono = new JList();
		listTelefono.setFocusable(false);
		listTelefono.setFont(new Font("Gadugi", Font.PLAIN, 13));
		listTelefono.setBackground(new Color(0, 191, 255));
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
			dlm.addElement(controller.getContattiDAO().getSitoEtelefono().get(0).getTelefono());
			listTelefono.setModel(dlm);
		listTelefono.setBounds(291, 404, 168, 40);
		contentPane.add(listTelefono);
		
		JList listSitoWeb = new JList();
		listSitoWeb.setFocusable(false);
		listSitoWeb.setFont(new Font("Gadugi", Font.PLAIN, 13));
		listSitoWeb.setBackground(new Color(0, 191, 255));
			dlm1.addElement(controller.getContattiDAO().getSitoEtelefono().get(0).getSitoWeb());
		listSitoWeb.setModel(dlm1);
		listSitoWeb.setBounds(490, 404, 128, 40);
		contentPane.add(listSitoWeb);
		
		JList Fascia_Prezzo = new JList();
		Fascia_Prezzo.setFocusable(false);
		Fascia_Prezzo.setBackground(new Color(0, 191, 255));
		Fascia_Prezzo.setFont(new Font("Gadugi", Font.PLAIN, 13));
		Fascia_Prezzo.setBounds(763, 57, 139, 34);
		dlm2.addElement(controller.getAttrazioneDAO().getAttrazioni().get(controller.getIndice()).getFascia_Prezzo());
		Fascia_Prezzo.setModel(dlm2);
		contentPane.add(Fascia_Prezzo);
		
		JList TipoAttrazione = new JList();
		TipoAttrazione.setFocusable(false);
		TipoAttrazione.setBackground(new Color(0, 191, 255));
		TipoAttrazione.setFont(new Font("Gadugi", Font.PLAIN, 13));
		TipoAttrazione.setBounds(750, 301, 128, 72);
		dlm3.addElement(controller.getAttrazioneDAO().getAttrazioni().get(controller.getIndice()).getTipo());
		TipoAttrazione.setModel(dlm3);
		contentPane.add(TipoAttrazione);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					controller.getContattiDAO().getSitoEtelefono().clear();
					controller.CambiaFrame(ScriviRecensioneAttrazione.this, controller.getPrincipale());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIndietro.setForeground(new Color(0, 0, 0));
		btnIndietro.setFont(new Font("Gadugi", Font.PLAIN, 15));
		btnIndietro.setBackground(new Color(0, 153, 255));
		btnIndietro.setBounds(717, 594, 177, 29);
		contentPane.add(btnIndietro);
		
		JTextArea txtrTipoAttrazione = new JTextArea();
		txtrTipoAttrazione.setFocusable(false);
		txtrTipoAttrazione.setText("Tipo Attrazione\r\n");
		txtrTipoAttrazione.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrTipoAttrazione.setEditable(false);
		txtrTipoAttrazione.setBackground(new Color(0, 191, 255));
		txtrTipoAttrazione.setBounds(740, 262, 139, 29);
		contentPane.add(txtrTipoAttrazione);
		
		JTextArea txtrFascia_Prezzo = new JTextArea();
		txtrFascia_Prezzo.setFocusable(false);
		txtrFascia_Prezzo.setText("Fascia prezzo");
		txtrFascia_Prezzo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrFascia_Prezzo.setEditable(false);
		txtrFascia_Prezzo.setBackground(new Color(0, 191, 255));
		txtrFascia_Prezzo.setBounds(760, 16, 139, 29);
		contentPane.add(txtrFascia_Prezzo);
		
		
		
		
		btnaggiungirecensione.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String recensione = textAreaRecensione.getText();
				int stelle = valutazioneStelle.getSelectedIndex()+1;
				controller.getRecensioneDAO().addRecensioneAttr(controller.getConnection(), recensione, stelle);
				
				
			}});
		
}
}


