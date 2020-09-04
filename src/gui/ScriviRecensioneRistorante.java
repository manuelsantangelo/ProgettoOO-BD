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
import java.io.File;
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
	final static int LUNGHEZZA_FINESTRA = 1260;
	
	private DefaultListModel dlm = new DefaultListModel();
	private DefaultListModel dlm1 = new DefaultListModel();
	private DefaultListModel dlm2 = new DefaultListModel();
	private DefaultListModel dlm3 = new DefaultListModel();


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
		lblFoto.setBounds(43, 78, 187, 182);
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
		txtrNome.setText(controller.getRistoranteDAO().getRistorante().getNome());
		txtrNome.setBackground(new Color(0, 191, 255));
		txtrNome.setBounds(41, 10, 189, 34);
		contentPane.add(txtrNome);
		
		JTextArea txtrDescrizione_1 = new JTextArea();
		txtrDescrizione_1.setFocusable(false);
		txtrDescrizione_1.setEditable(false);
		txtrDescrizione_1.setBackground(new Color(0, 191, 255));
		txtrDescrizione_1.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrDescrizione_1.setText("Descrizione");
		txtrDescrizione_1.setBounds(308, 13, 111, 22);
		contentPane.add(txtrDescrizione_1);
		
		JTextArea textAreaRecensione = new JTextArea();
		textAreaRecensione.setBounds(24, 498, 624, 98);
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
		textAreaDescrizione.setText(controller.getRistoranteDAO().getRistorante().getDescizione());
		textAreaDescrizione.setBackground(new Color(0, 191, 255));
		textAreaDescrizione.setBounds(270, 78, 489, 182);
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
		txtrProvincia.setBounds(599, 262, 85, 29);
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
		txtrSitoWeb.setBounds(622, 365, 80, 29);
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
		textCittà.setBounds(328, 301, 238, 29);
		contentPane.add(textCittà);
		
		JTextArea textProvincia = new JTextArea();
		textProvincia.setFocusable(false);
		textProvincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textProvincia.setBackground(new Color(0, 191, 255));
		textProvincia.setEditable(false);
		textProvincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		textProvincia.setBounds(599, 301, 177, 29);
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
		listTelefono.setBounds(291, 404, 273, 40);
	for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
		dlm.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getTelefono());
		listTelefono.setModel(dlm);
	
		contentPane.add(listTelefono);
		
		JList listSitoWeb = new JList();
		listSitoWeb.setFocusable(false);
		listSitoWeb.setFont(new Font("Gadugi", Font.PLAIN, 13));
		listSitoWeb.setBackground(new Color(0, 191, 255));
		listSitoWeb.setBounds(622, 404, 280, 40);
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
			dlm1.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getSitoWeb());
		listSitoWeb.setModel(dlm1);
		contentPane.add(listSitoWeb);
		
		JList Fascia_Prezzo = new JList();
		Fascia_Prezzo.setFocusable(false);
		Fascia_Prezzo.setBackground(new Color(0, 191, 255));
		Fascia_Prezzo.setFont(new Font("Gadugi", Font.PLAIN, 13));
		Fascia_Prezzo.setBounds(786, 48, 118, 47);
		dlm2.addElement(controller.getRistoranteDAO().getRistoranti().get(controller.getIndice()).getFascia_Prezzo());
		

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.getAssociazione_Categoria_RistoranteDAO().getCategorie().clear();
					controller.getContattiDAO().getSitoEtelefono().clear();
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
		txtrCategoriaRistoramte.setFocusable(false);
		txtrCategoriaRistoramte.setText("Categoria ");
		txtrCategoriaRistoramte.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrCategoriaRistoramte.setEditable(false);
		txtrCategoriaRistoramte.setBackground(new Color(0, 191, 255));
		txtrCategoriaRistoramte.setBounds(786, 102, 85, 29);
		contentPane.add(txtrCategoriaRistoramte);
		
		JTextArea txtrFasciaPrezzo = new JTextArea();
		txtrFasciaPrezzo.setFocusable(false);
		txtrFasciaPrezzo.setText("Fascia prezzo");
		txtrFasciaPrezzo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrFasciaPrezzo.setEditable(false);
		txtrFasciaPrezzo.setBackground(new Color(0, 191, 255));
		txtrFasciaPrezzo.setBounds(786, 10, 118, 29);
		contentPane.add(txtrFasciaPrezzo);
		
		JLabel lblIconadescrizione = new JLabel("iconaDescrizione");
		lblIconadescrizione.setBounds(270, 14, 28, 29);
		File nota = new File("images\\nota.png");
		BufferedImage img = ImageIO.read(nota);
		Image img2 = img.getScaledInstance(lblIconadescrizione.getWidth(), lblIconadescrizione.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_nota = new ImageIcon(img2);
		lblIconadescrizione.setIcon(icona_nota);
		contentPane.add(lblIconadescrizione);
		
		JList category = new JList();
		category.setFocusable(false);
		category.setFont(new Font("Gadugi", Font.PLAIN, 13));
		category.setBackground(new Color(0, 191, 255));
		category.setBounds(786, 142, 118, 73);
		for(int i = 0; i < controller.getAssociazione_Categoria_RistoranteDAO().getCategorie().size(); i++)
		dlm3.addElement(controller.getAssociazione_Categoria_RistoranteDAO().getCategorie().get(i).getCategoria_Ristorante_FK().toString());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(912, 0, 332, 651);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIconaprezzo = new JLabel("iconaPrezzo");
		lblIconaprezzo.setBounds(43, 42, 28, 29);
		File price = new File("images\\prezzo.png");
		BufferedImage imgprice = ImageIO.read(price);
		Image imgprice2 = imgprice.getScaledInstance(lblIconaprezzo.getWidth(), lblIconaprezzo.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_prezzo = new ImageIcon(imgprice2);
		contentPane.add(lblIconaprezzo);
		lblIconaprezzo.setIcon(icona_prezzo);
		
		JList categoryList = new JList();
		categoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		categoryList.setBounds(54, 227, 249, 98);
		panel.add(categoryList);
		categoryList.setFont(new Font("Gadugi", Font.PLAIN, 13));
		categoryList.setBackground(new Color(0, 191, 255));
		categoryList.setModel(dlm3);
		
		JLabel lblIconacategoria = new JLabel("iconaCategoria");
		lblIconacategoria.setBounds(16, 251, 28, 29);
		File category_icon = new File("images\\ristorante.png");
		BufferedImage imgcat = ImageIO.read(category_icon);
		Image img2cat = imgcat.getScaledInstance(lblIconacategoria.getWidth(), lblIconacategoria.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_categoria = new ImageIcon(img2cat);
		lblIconacategoria.setIcon(icona_categoria);
		panel.add(lblIconacategoria);
		
		JTextArea txtStato = new JTextArea();
		txtStato.setBounds(26, 55, 128, 29);
		panel.add(txtStato);
		txtStato.setFont(new Font("Gadugi", Font.PLAIN, 17));
		txtStato.setBackground(new Color(0, 191, 255));
		txtStato.setEditable(false);
		txtStato.setText(controller.getLuogoDAO().getLuogo2().getStato());
		
		JLabel lblIconaMappa = new JLabel("iconaMappa");
		lblIconaMappa.setBounds(16, 15, 28, 29);
		File imgmap = new File("images\\mappa.png");
		BufferedImage imgmap2 = ImageIO.read(imgmap);
		Image imgmap3 = imgmap2.getScaledInstance(lblIconaMappa.getWidth(), lblIconaMappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_mappa = new ImageIcon(imgmap3);
		lblIconaMappa.setIcon(icona_mappa);
		panel.add(lblIconaMappa);
		
		JTextArea txtrCity = new JTextArea();
		txtrCity.setBounds(164, 55, 139, 29);
		panel.add(txtrCity);
		txtrCity.setFont(new Font("Gadugi", Font.PLAIN, 17));
		txtrCity.setBackground(new Color(0, 191, 255));
		txtrCity.setEditable(false);
		txtrCity.setText(controller.getLuogoDAO().getLuogo2().getCittà());
		
		JTextArea textprovincia = new JTextArea();
		textprovincia.setBounds(26, 101, 128, 29);
		panel.add(textprovincia);
		textprovincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textprovincia.setBackground(new Color(0, 191, 255));
		textprovincia.setEditable(false);
		textprovincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		
		JTextArea indirizzo = new JTextArea();
		indirizzo.setBounds(164, 102, 139, 29);
		panel.add(indirizzo);
		indirizzo.setFont(new Font("Gadugi", Font.PLAIN, 16));
		indirizzo.setBackground(new Color(0, 191, 255));
		indirizzo.setEditable(false);
		indirizzo.setText(controller.getLuogoDAO().getLuogo2().getIndirizzo());
		
		JTextArea txtrDoveSiamo = new JTextArea();
		txtrDoveSiamo.setText("Informazioni");
		txtrDoveSiamo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrDoveSiamo.setEditable(false);
		txtrDoveSiamo.setBackground(new Color(0, 153, 255));
		txtrDoveSiamo.setBounds(54, 11, 118, 22);
		panel.add(txtrDoveSiamo);
		
		JLabel lblAereo1 = new JLabel("");
		lblAereo1.setBounds(61, 170, 41, 39);
		panel.add(lblAereo1);
		
		JLabel lblAereo2 = new JLabel("");
		lblAereo2.setBounds(113, 152, 41, 39);
		panel.add(lblAereo2);
		
		JLabel lblAereo3 = new JLabel("");
		lblAereo3.setBounds(164, 170, 41, 39);
		panel.add(lblAereo3);
		
		JLabel lblAereo4 = new JLabel("");
		lblAereo4.setBounds(215, 152, 41, 39);
		panel.add(lblAereo4);
		
		JLabel lblAereo5 = new JLabel("");
		lblAereo5.setBounds(266, 170, 41, 39);
		panel.add(lblAereo5);
		
		JLabel lblAereo6 = new JLabel("");
		lblAereo6.setBounds(16, 152, 41, 39);
		panel.add(lblAereo6);
		
		File aereo = new File("images\\aereo.png");
		BufferedImage imgaereo = ImageIO.read(aereo);
		Image aereoimg = imgaereo.getScaledInstance(lblAereo1.getWidth(), lblAereo1.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_aereo = new ImageIcon(aereoimg);
		
		lblAereo1.setIcon(icona_aereo);
		lblAereo2.setIcon(icona_aereo);
		lblAereo3.setIcon(icona_aereo);
		lblAereo4.setIcon(icona_aereo);
		lblAereo5.setIcon(icona_aereo);
		lblAereo6.setIcon(icona_aereo);
		
		JLabel lblNave1 = new JLabel("");
		lblNave1.setBounds(61, 371, 41, 39);
		panel.add(lblNave1);
		
		JLabel lblNave2 = new JLabel("");
		lblNave2.setBounds(113, 353, 41, 39);
		panel.add(lblNave2);
		
		JLabel lblNave3 = new JLabel("");
		lblNave3.setBounds(164, 371, 41, 39);
		panel.add(lblNave3);
		
		JLabel lblNave4 = new JLabel("");
		lblNave4.setBounds(215, 353, 41, 39);
		panel.add(lblNave4);
		
		JLabel lblNave5 = new JLabel("");
		lblNave5.setBounds(266, 371, 41, 39);
		panel.add(lblNave5);
		
		JLabel lblNave6 = new JLabel("");
		lblNave6.setBounds(16, 353, 41, 39);
		panel.add(lblNave6);

		File nave = new File("images\\nave.png");
		BufferedImage imgnave = ImageIO.read(nave);
		Image naveimg = imgnave.getScaledInstance(lblNave1.getWidth(), lblNave1.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_nave = new ImageIcon(naveimg);
		
		lblNave1.setIcon(icona_nave);
		lblNave2.setIcon(icona_nave);
		lblNave3.setIcon(icona_nave);
		lblNave4.setIcon(icona_nave);
		lblNave5.setIcon(icona_nave);
		lblNave6.setIcon(icona_nave);
		
		JList FasciaPrezzo = new JList();
		FasciaPrezzo.setBounds(81, 45, 118, 22);
		contentPane.add(FasciaPrezzo);
		FasciaPrezzo.setBackground(new Color(0, 191, 255));
		FasciaPrezzo.setFont(new Font("Gadugi", Font.PLAIN, 13));
		FasciaPrezzo.setModel(dlm2);
		
		JLabel lblIconamichelin = new JLabel("");
		lblIconamichelin.setBounds(308, 46, 22, 21);
		contentPane.add(lblIconamichelin);
		
		JLabel lblIconamichelin_1 = new JLabel("");
		lblIconamichelin_1.setBounds(337, 46, 22, 21);
		contentPane.add(lblIconamichelin_1);
		
		JLabel lblIconamichelin_2 = new JLabel("");
		lblIconamichelin_2.setBounds(366, 46, 22, 21);
		contentPane.add(lblIconamichelin_2);
		
		File stellaM = new File("images\\michelin.png");
		BufferedImage imgstar = ImageIO.read(stellaM);
		Image stella1 = imgstar.getScaledInstance(lblIconamichelin.getWidth(), lblIconamichelin.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_stella = new ImageIcon(stella1);
		
		if(controller.getRistoranteDAO().getRistorante().getStelle_Michelin() > 0) {
			lblIconamichelin.setIcon(icona_stella);
			
			if(controller.getRistoranteDAO().getRistorante().getStelle_Michelin() > 1) {
				lblIconamichelin_1.setIcon(icona_stella);
				
				if(controller.getRistoranteDAO().getRistorante().getStelle_Michelin() == 3) {
					lblIconamichelin_2.setIcon(icona_stella);
				}			
			}
		}
		
		
		btnaggiungirecensione.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String recensione = textAreaRecensione.getText();
				int stelle = valutazioneStelle.getSelectedIndex()+1;
				controller.getRecensioneDAO().addRecensioneRis(controller.getConnection(), recensione, stelle);
						
			}});
		
}
}


