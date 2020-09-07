package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableModel;

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
	
	private JTable tabellaRecensioni = new JTable();
	static DefaultTableModel dtm = new DefaultTableModel(0,0){       //Impostiamo le righe e colonne della JTable
                                                                     //cliccabili ma non modificabili
@Override
public boolean isCellEditable(int row, int column) {

	return false;
}
};	

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
		
		JTextArea txtrScriviRecensione = new JTextArea();
		txtrScriviRecensione.setFocusable(false);
		txtrScriviRecensione.setText("Dicci cosa ne pensi");
		txtrScriviRecensione.setForeground(Color.BLACK);
		txtrScriviRecensione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrScriviRecensione.setEditable(false);
		txtrScriviRecensione.setBackground(new Color(0, 191, 255));
		txtrScriviRecensione.setBounds(24, 475, 244, 29);
		contentPane.add(txtrScriviRecensione);
		
		JButton btnaggiungirecensione = new JButton("Aggiungi recensione");
		btnaggiungirecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnaggiungirecensione.setForeground(Color.BLACK);
		btnaggiungirecensione.setFont(new Font("Gadugi", Font.BOLD, 14));
		btnaggiungirecensione.setBackground(new Color(0,153,255));
		btnaggiungirecensione.setBounds(720, 519, 180, 54);
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
		valutazioneStelle.setBounds(668, 519, 42, 29);
		contentPane.add(valutazioneStelle);
		
		JTextArea txtrvalutazioneStelle = new JTextArea();
		txtrvalutazioneStelle.setFocusable(false);
		txtrvalutazioneStelle.setText("Stelle");
		txtrvalutazioneStelle.setForeground(Color.BLACK);
		txtrvalutazioneStelle.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrvalutazioneStelle.setEditable(false);
		txtrvalutazioneStelle.setBackground(new Color(0, 191, 255));
		txtrvalutazioneStelle.setBounds(658, 486, 61, 29);
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
		textAreaRecensione.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textAreaRecensione.setBounds(24, 498, 624, 98);
		textAreaRecensione.setLineWrap(true);

		contentPane.add(textAreaRecensione);
		
		JScrollPane scrollPane = new JScrollPane(textAreaRecensione);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 514, 624, 98);
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		
		JTextArea textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		textAreaDescrizione.setFocusable(false);
		textAreaDescrizione.setFont(new Font("Gadugi", Font.ITALIC, 16));
		textAreaDescrizione.setWrapStyleWord(true);
		textAreaDescrizione.setLineWrap(true);
		textAreaDescrizione.setEditable(false);
		textAreaDescrizione.setText(controller.getRistoranteDAO().getRistorante().getDescizione());
		textAreaDescrizione.setBackground(new Color(0, 191, 255));
		textAreaDescrizione.setBounds(270, 78, 537, 182);
		contentPane.add(textAreaDescrizione);
	for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
		dlm.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getTelefono());
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
			dlm1.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getSitoWeb());
		
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
		btnIndietro.setFont(new Font("Gadugi", Font.BOLD, 15));
		btnIndietro.setBackground(new Color(0,153,255));
		btnIndietro.setBounds(685, 583, 215, 29);
		contentPane.add(btnIndietro);
		
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
		categoryList.setBounds(20, 196, 302, 98);
		categoryList.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));

		panel.add(categoryList);
		categoryList.setFont(new Font("Gadugi", Font.PLAIN, 15));
		categoryList.setBackground(new Color(0, 153, 255));
		categoryList.setModel(dlm3);
		
		JLabel lblIconacategoria = new JLabel("iconaCategoria");
		lblIconacategoria.setBounds(16, 156, 28, 29);
		File category_icon = new File("images\\ristorante.png");
		BufferedImage imgcat = ImageIO.read(category_icon);
		Image img2cat = imgcat.getScaledInstance(lblIconacategoria.getWidth(), lblIconacategoria.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_categoria = new ImageIcon(img2cat);
		lblIconacategoria.setIcon(icona_categoria);
		panel.add(lblIconacategoria);
		
		JTextArea txtStato = new JTextArea();
		txtStato.setBounds(175, 52, 128, 29);
		txtStato.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		panel.add(txtStato);
		txtStato.setFont(new Font("Gadugi", Font.PLAIN, 17));
		txtStato.setBackground(new Color(0, 153, 255));
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
		txtrCity.setBounds(20, 52, 139, 29);
		txtrCity.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		panel.add(txtrCity);
		txtrCity.setFont(new Font("Gadugi", Font.PLAIN, 17));
		txtrCity.setBackground(new Color(0, 153, 255));
		txtrCity.setEditable(false);
		txtrCity.setText(controller.getLuogoDAO().getLuogo2().getCittà());
		
		JTextArea textprovincia = new JTextArea();
		textprovincia.setBounds(20, 117, 128, 29);
		textprovincia.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		panel.add(textprovincia);
		textprovincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		textprovincia.setBackground(new Color(0, 153, 255));
		textprovincia.setEditable(false);
		textprovincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		
		JTextArea indirizzo = new JTextArea();
		indirizzo.setBounds(164, 118, 158, 29);
		indirizzo.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		panel.add(indirizzo);
		indirizzo.setFont(new Font("Gadugi", Font.PLAIN, 15));
		indirizzo.setBackground(new Color(0, 153, 255));
		indirizzo.setEditable(false);
		indirizzo.setText(controller.getLuogoDAO().getLuogo2().getIndirizzo());
		
		JTextArea txtrDoveSiamo = new JTextArea();
		txtrDoveSiamo.setText("Dove siamo?");
		txtrDoveSiamo.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrDoveSiamo.setEditable(false);
		txtrDoveSiamo.setBackground(new Color(0, 153, 255));
		txtrDoveSiamo.setBounds(54, 11, 118, 33);
		panel.add(txtrDoveSiamo);
		
		JTextArea txtrCucine = new JTextArea();
		txtrCucine.setText("Cucine");
		txtrCucine.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrCucine.setEditable(false);
		txtrCucine.setBackground(new Color(0, 153, 255));
		txtrCucine.setBounds(54, 152, 71, 29);
		panel.add(txtrCucine);
		
		JTextArea txtrComeContattarci = new JTextArea();
		txtrComeContattarci.setText("Come contattarci");
		txtrComeContattarci.setFont(new Font("Gadugi", Font.BOLD, 18));
		txtrComeContattarci.setEditable(false);
		txtrComeContattarci.setBackground(new Color(0, 153, 255));
		txtrComeContattarci.setBounds(54, 324, 164, 29);
		panel.add(txtrComeContattarci);
		
		JLabel lblIconacontatti = new JLabel("iconaContatti");
		lblIconacontatti.setBounds(16, 324, 28, 29);
		File imgtelefono = new File("images\\telefono.png");
		BufferedImage imgtelefono2 = ImageIO.read(imgtelefono);
		Image imgtelefono3 = imgtelefono2.getScaledInstance(lblIconaMappa.getWidth(), lblIconaMappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_telefono = new ImageIcon(imgtelefono3);
		lblIconacontatti.setIcon(icona_telefono);
		panel.add(lblIconacontatti);
		
		JLabel lblIconaSitoWeb = new JLabel("iconaSitoWeb");
		lblIconaSitoWeb.setBounds(16, 480, 28, 29);
		File imgsitoweb = new File("images\\sitoweb.png");
		BufferedImage imgsitoweb2 = ImageIO.read(imgsitoweb);
		Image imgsitoweb3 = imgsitoweb2.getScaledInstance(lblIconaMappa.getWidth(), lblIconaMappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_sitoweb = new ImageIcon(imgsitoweb3);
		lblIconaSitoWeb.setIcon(icona_sitoweb);
		panel.add(lblIconaSitoWeb);

		JList listTelefono = new JList();
		listTelefono.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listTelefono.setBounds(20, 365, 302, 105);		
		listTelefono.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		panel.add(listTelefono);
		listTelefono.setFocusable(false);
		listTelefono.setFont(new Font("Gadugi", Font.PLAIN, 15));
		listTelefono.setBackground(new Color(0, 153, 255));
		listTelefono.setModel(dlm);
		
		JList listSitoWeb = new JList();
		listSitoWeb.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listSitoWeb.setBounds(20, 513, 302, 105);
		listSitoWeb.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		panel.add(listSitoWeb);
		listSitoWeb.setFocusable(false);
		listSitoWeb.setFont(new Font("Gadugi", Font.PLAIN, 15));
		listSitoWeb.setBackground(new Color(0, 153, 255));
		listSitoWeb.setModel(dlm1);
		
		JTextArea txtrProvincia = new JTextArea();
		txtrProvincia.setText("Provincia");
		txtrProvincia.setFont(new Font("Gadugi", Font.BOLD, 14));
		txtrProvincia.setEditable(false);
		txtrProvincia.setBackground(new Color(0, 153, 255));
		txtrProvincia.setBounds(20, 91, 103, 22);
		panel.add(txtrProvincia);
		
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
		
		tabellaRecensioni.setBackground(Color.WHITE);
		tabellaRecensioni.setFont(new Font("Gadugi", Font.PLAIN, 14));
		String nomeColonne[] = new String[] { "Recensioni", "Stelle" };
	    tabellaRecensioni.setModel(dtm);
	    dtm.setColumnIdentifiers(nomeColonne);
		tabellaRecensioni.setBounds(41, 279, 441, 173);
		contentPane.add(tabellaRecensioni);
		
		JScrollPane scrollPane2 = new JScrollPane(tabellaRecensioni);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane2.setBounds(24, 310, 488, 148);
		contentPane.add(scrollPane2);
		scrollPane2.setViewportView(tabellaRecensioni);
		
		riempitabellaRecensioni(controller);
		
		JTextArea textAreaVisualizzaRecensione = new JTextArea();
		textAreaVisualizzaRecensione.setFont(new Font("Gadugi", Font.PLAIN, 16));
		textAreaVisualizzaRecensione.setEditable(false);
		textAreaVisualizzaRecensione.setLineWrap(true);
		textAreaVisualizzaRecensione.setBounds(619, 255, 263, 193);
		contentPane.add(textAreaVisualizzaRecensione);
		
		JScrollPane scrollPane3 = new JScrollPane(textAreaVisualizzaRecensione);
		scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setBounds(566, 311, 316, 147);
		scrollPane3.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane3);
		
		JTextArea txtrRecensioni = new JTextArea();
		txtrRecensioni.setText("Recensioni");
		txtrRecensioni.setForeground(Color.BLACK);
		txtrRecensioni.setFont(new Font("Dialog", Font.BOLD, 21));
		txtrRecensioni.setFocusable(false);
		txtrRecensioni.setEditable(false);
		txtrRecensioni.setBackground(new Color(0, 191, 255));
		txtrRecensioni.setBounds(24, 271, 128, 29);
		contentPane.add(txtrRecensioni);
		
		JTextArea txtrVisualizzaRecensione = new JTextArea();
		txtrVisualizzaRecensione.setText("Visualizza recensione");
		txtrVisualizzaRecensione.setForeground(Color.BLACK);
		txtrVisualizzaRecensione.setFont(new Font("Dialog", Font.BOLD, 21));
		txtrVisualizzaRecensione.setFocusable(false);
		txtrVisualizzaRecensione.setEditable(false);
		txtrVisualizzaRecensione.setBackground(new Color(0, 191, 255));
		txtrVisualizzaRecensione.setBounds(566, 272, 228, 29);
		contentPane.add(txtrVisualizzaRecensione);
		
		btnaggiungirecensione.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String recensione = textAreaRecensione.getText();
				int stelle = valutazioneStelle.getSelectedIndex()+1;
				controller.getRecensioneDAO().addRecensioneRis(controller.getConnection(), recensione, stelle);
						
			}});
		
		tabellaRecensioni.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent mouseEvent) {
	            tabellaRecensioni = (JTable) mouseEvent.getSource();
	            Point point = mouseEvent.getPoint();
	            int row = tabellaRecensioni.rowAtPoint(point);
	            if (mouseEvent.getClickCount() == 2 && tabellaRecensioni.getSelectedRow() != -1) {
	            	int indice = tabellaRecensioni.getSelectedRow();
	            	int codiceRecensione = controller.getRecensioneDAO().getRecensioni().get(indice).getReview_ID();
	            	textAreaVisualizzaRecensione.setText(controller.getRecensioneDAO().getRecensioni().get(indice).getTesto() + "\n - " + controller.getRecensioneDAO().getNomeUtenteRecensione(controller.getConnection(), codiceRecensione));
	            	
	           	
	            }
	        }
		});
}
	
	
public void riempitabellaRecensioni(Controller controller) {
		
		controller.getRecensioneDAO().setRecensioniDaVisualizzareRistorante(controller.getConnection());
		
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		int i = 0;
		if(controller.getRecensioneDAO().getRecensioni().isEmpty()) {}
		else {
	do {
		
		dtm.addRow(new Object[] {
					controller.getRecensioneDAO().getRecensioni().get(i).getTesto(),controller.getRecensioneDAO().getRecensioni().get(i).getStelle()
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getRecensioneDAO().getRecensioni().size() != i);
	}
}}



