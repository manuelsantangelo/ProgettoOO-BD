package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
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

import logic.Controller;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JList;

public class ScriviRecensioneRistorante extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	String nomeDaRecensire; //inizializziamo il nome della cosa che vogliamo recensire 


	public ScriviRecensioneRistorante(Controller controller) throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("Recensione " + controller.getRistoranteDAO().getRistorante().getNome());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrDescrizione = new JTextArea();
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
		btnaggiungirecensione.setBounds(717, 554, 177, 47);
		contentPane.add(btnaggiungirecensione);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setBackground(new Color(255, 255, 255));
		lblFoto.setBounds(43, 48, 187, 182);
		contentPane.add(lblFoto);
		
		byte[] imgBytes = controller.getRistoranteDAO().getRistorante().getFoto();
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
		txtrvalutazioneStelle.setText("Stelle valutazione");
		txtrvalutazioneStelle.setForeground(Color.WHITE);
		txtrvalutazioneStelle.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrvalutazioneStelle.setEditable(false);
		txtrvalutazioneStelle.setBackground(new Color(0, 191, 255));
		txtrvalutazioneStelle.setBounds(713, 458, 181, 29);
		contentPane.add(txtrvalutazioneStelle);
		
		JTextArea txtrNome = new JTextArea();
		txtrNome.setEditable(false);
		txtrNome.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrNome.setText("Nome\r\n");
		txtrNome.setBackground(new Color(0, 191, 255));
		txtrNome.setBounds(41, 10, 189, 40);
		contentPane.add(txtrNome);
		
		JTextArea txtrDescrizione_1 = new JTextArea();
		txtrDescrizione_1.setEditable(false);
		txtrDescrizione_1.setBackground(new Color(0, 191, 255));
		txtrDescrizione_1.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrDescrizione_1.setText("Descrizione");
		txtrDescrizione_1.setBounds(270, 10, 294, 22);
		contentPane.add(txtrDescrizione_1);
		
		JTextArea textAreaRecensione = new JTextArea();
		textAreaRecensione.setBounds(24, 498, 624, 98);
		contentPane.add(textAreaRecensione);
		
		JTextArea textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setFont(new Font("Gadugi", Font.ITALIC, 16));
		textAreaDescrizione.setWrapStyleWord(true);
		textAreaDescrizione.setLineWrap(true);
		textAreaDescrizione.setEditable(false);
		textAreaDescrizione.setText(controller.getRistoranteDAO().getRistorante().getDescizione());
		textAreaDescrizione.setBackground(new Color(0, 191, 255));
		textAreaDescrizione.setBounds(270, 48, 489, 182);
		contentPane.add(textAreaDescrizione);
		
		JTextArea txtrStato = new JTextArea();
		txtrStato.setBackground(new Color(0, 191, 255));
		txtrStato.setEditable(false);
		txtrStato.setText("Stato");
		txtrStato.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrStato.setBounds(43, 262, 118, 29);
		contentPane.add(txtrStato);
		
		JTextArea txtrCitt� = new JTextArea();
		txtrCitt�.setBackground(new Color(0, 191, 255));
		txtrCitt�.setEditable(false);
		txtrCitt�.setText("Citt\u00E0\r\n");
		txtrCitt�.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrCitt�.setBounds(328, 262, 101, 29);
		contentPane.add(txtrCitt�);
		
		JTextArea txtrProvincia = new JTextArea();
		txtrProvincia.setBackground(new Color(0, 191, 255));
		txtrProvincia.setEditable(false);
		txtrProvincia.setText("Provincia\r\n");
		txtrProvincia.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrProvincia.setBounds(599, 262, 85, 29);
		contentPane.add(txtrProvincia);
		
		JTextArea txtrIndirizzo = new JTextArea();
		txtrIndirizzo.setBackground(new Color(0, 191, 255));
		txtrIndirizzo.setEditable(false);
		txtrIndirizzo.setText("Indirizzo\r\n");
		txtrIndirizzo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrIndirizzo.setBounds(44, 365, 149, 29);
		contentPane.add(txtrIndirizzo);
		
		JTextArea txtrContatti = new JTextArea();
		txtrContatti.setBackground(new Color(0, 191, 255));
		txtrContatti.setEditable(false);
		txtrContatti.setText("Telefono");
		txtrContatti.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrContatti.setBounds(291, 365, 80, 29);
		contentPane.add(txtrContatti);
		
		JTextArea txtrSitoWeb = new JTextArea();
		txtrSitoWeb.setBackground(new Color(0, 191, 255));
		txtrSitoWeb.setEditable(false);
		txtrSitoWeb.setText("Sito Web");
		txtrSitoWeb.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrSitoWeb.setBounds(622, 365, 80, 29);
		contentPane.add(txtrSitoWeb);
		
		JTextArea textStato = new JTextArea();
		textStato.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textStato.setBackground(new Color(0, 191, 255));
		textStato.setEditable(false);
		textStato.setText(controller.getLuogoDAO().getLuogo2().getStato());
		textStato.setBounds(43, 301, 255, 29);
		contentPane.add(textStato);
		
		JTextArea textCitt� = new JTextArea();
		textCitt�.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textCitt�.setBackground(new Color(0, 191, 255));
		textCitt�.setEditable(false);
		textCitt�.setText(controller.getLuogoDAO().getLuogo2().getCitt�());
		textCitt�.setBounds(328, 301, 238, 29);
		contentPane.add(textCitt�);
		
		JTextArea textProvincia = new JTextArea();
		textProvincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textProvincia.setBackground(new Color(0, 191, 255));
		textProvincia.setEditable(false);
		textProvincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		textProvincia.setBounds(599, 301, 177, 29);
		contentPane.add(textProvincia);
		
		JTextArea textIndirizzo = new JTextArea();
		textIndirizzo.setFont(new Font("Gadugi", Font.PLAIN, 16));
		textIndirizzo.setBackground(new Color(0, 191, 255));
		textIndirizzo.setEditable(false);
		textIndirizzo.setText(controller.getLuogoDAO().getLuogo2().getIndirizzo());
		textIndirizzo.setBounds(43, 404, 238, 40);
		contentPane.add(textIndirizzo);
		
		JList listTelefono = new JList();
		listTelefono.setBackground(new Color(255, 255, 255));
		
		listTelefono.setBounds(291, 404, 273, 40);
		contentPane.add(listTelefono);
		
		JList listSitoWeb = new JList();
		listSitoWeb.setBounds(622, 404, 294, 40);
		contentPane.add(listSitoWeb);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CambiaFrame(ScriviRecensioneRistorante.this, controller.getPrincipale());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnIndietro.setForeground(new Color(0, 0, 0));
		btnIndietro.setFont(new Font("Gadugi", Font.PLAIN, 15));
		btnIndietro.setBackground(new Color(0, 153, 255));
		btnIndietro.setBounds(717, 594, 177, 29);
		contentPane.add(btnIndietro);
		
		JTextArea txtrCategoriaRistoramte = new JTextArea();
		txtrCategoriaRistoramte.setText("Categoria ");
		txtrCategoriaRistoramte.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrCategoriaRistoramte.setEditable(false);
		txtrCategoriaRistoramte.setBackground(new Color(0, 191, 255));
		txtrCategoriaRistoramte.setBounds(787, 262, 85, 29);
		contentPane.add(txtrCategoriaRistoramte);
		
		JTextArea txtrFasciaPrezzo = new JTextArea();
		txtrFasciaPrezzo.setText("Fascia prezzo");
		txtrFasciaPrezzo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrFasciaPrezzo.setEditable(false);
		txtrFasciaPrezzo.setBackground(new Color(0, 191, 255));
		txtrFasciaPrezzo.setBounds(786, 10, 118, 29);
		contentPane.add(txtrFasciaPrezzo);
		
		btnaggiungirecensione.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String recensione = textAreaRecensione.getText();
				controller.getRecensioneDAO().addRecensione(controller.getConnection(), recensione, 3);
				int stelle = valutazioneStelle.getSelectedIndex()+1;
				controller.getRecensioneDAO().addRecensione(controller.getConnection(), recensione, stelle);
				
				
			}});
		
}
}


