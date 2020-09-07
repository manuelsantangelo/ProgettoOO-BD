package gui;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logic.Controller;

@SuppressWarnings("serial") // Utilizzato per ignorare il warning che non crea problemi
public class ScriviRecensioneRistorante extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller; 

	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 1260;
	
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero1 = new DefaultListModel();
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero2 = new DefaultListModel();
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero3 = new DefaultListModel();
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero4 = new DefaultListModel();
	
	
	   //Impostiamo le righe e colonne della JTable
    //cliccabili ma non modificabili
	private JTable tabellaRecensioni = new JTable();
	static DefaultTableModel dtm = new DefaultTableModel(0,0){                                                             
public boolean isCellEditable(int row, int column) {

	return false;
}
};	

	@SuppressWarnings("unchecked")
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
		
		JTextArea testo_Dicci_cosa_ne_pensi = new JTextArea();
		testo_Dicci_cosa_ne_pensi.setFocusable(false);
		testo_Dicci_cosa_ne_pensi.setText("Dicci cosa ne pensi");
		testo_Dicci_cosa_ne_pensi.setForeground(Color.BLACK);
		testo_Dicci_cosa_ne_pensi.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Dicci_cosa_ne_pensi.setEditable(false);
		testo_Dicci_cosa_ne_pensi.setBackground(new Color(0, 191, 255));
		testo_Dicci_cosa_ne_pensi.setBounds(24, 475, 244, 29);
		contentPane.add(testo_Dicci_cosa_ne_pensi);
		
		JButton bottone_aggiungi_Recensione = new JButton("Aggiungi recensione");
		bottone_aggiungi_Recensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiungi_Recensione.setForeground(Color.BLACK);
		bottone_aggiungi_Recensione.setFont(new Font("Gadugi", Font.BOLD, 14));
		bottone_aggiungi_Recensione.setBackground(new Color(0,153,255));
		bottone_aggiungi_Recensione.setBounds(720, 519, 180, 54);
		contentPane.add(bottone_aggiungi_Recensione);
		
		JLabel label_per_foto = new JLabel("foto");
		label_per_foto.setFocusable(false);
		label_per_foto.setBackground(new Color(255, 255, 255));
		label_per_foto.setBounds(43, 78, 187, 182);
		contentPane.add(label_per_foto);
		
		//In questo modo andiamo a prendere la foto relativa al ristorante
		//di cui stiamo scrivendo la recensione
		byte[] imgBytes = controller.getRistoranteDAO().getRistorante().getFoto();
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(label_per_foto.getWidth(), label_per_foto.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		label_per_foto.setIcon(imageIcon);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JComboBox valutazioneStelle = new JComboBox();
		valutazioneStelle.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		valutazioneStelle.setBackground(new Color(0, 191, 255));
		valutazioneStelle.setForeground(new Color(0, 0, 0));
		@SuppressWarnings("rawtypes")  // Utilizzato per ignorare il warning che non crea problemi
		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"});
		valutazioneStelle.setModel(model);
		valutazioneStelle.setBounds(668, 519, 42, 29);
		contentPane.add(valutazioneStelle);
		
		JTextArea testo_Stelle = new JTextArea();
		testo_Stelle.setFocusable(false);
		testo_Stelle.setText("Stelle");
		testo_Stelle.setForeground(Color.BLACK);
		testo_Stelle.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Stelle.setEditable(false);
		testo_Stelle.setBackground(new Color(0, 191, 255));
		testo_Stelle.setBounds(658, 486, 61, 29);
		contentPane.add(testo_Stelle);
		
		JTextArea testo_Nome = new JTextArea();
		testo_Nome.setFocusable(false);
		testo_Nome.setEditable(false);
		testo_Nome.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Nome.setText(controller.getRistoranteDAO().getRistorante().getNome());
		testo_Nome.setBackground(new Color(0, 191, 255));
		testo_Nome.setBounds(41, 10, 189, 34);
		contentPane.add(testo_Nome);
		
		JTextArea testo_Descrizione = new JTextArea();
		testo_Descrizione.setFocusable(false);
		testo_Descrizione.setEditable(false);
		testo_Descrizione.setBackground(new Color(0, 191, 255));
		testo_Descrizione.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Descrizione.setText("Descrizione");
		testo_Descrizione.setBounds(308, 13, 111, 22);
		contentPane.add(testo_Descrizione);
		
		JTextArea testo_scrivi_recensione = new JTextArea();
		testo_scrivi_recensione.setFont(new Font("Gadugi", Font.PLAIN, 17));
		testo_scrivi_recensione.setBounds(24, 498, 624, 98);
		testo_scrivi_recensione.setLineWrap(true);

		contentPane.add(testo_scrivi_recensione);
		
		JScrollPane scrollPane = new JScrollPane(testo_scrivi_recensione);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 514, 624, 98);
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		
		JTextArea contenuto_Descrizione = new JTextArea();
		contenuto_Descrizione.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		contenuto_Descrizione.setFocusable(false);
		contenuto_Descrizione.setFont(new Font("Gadugi", Font.ITALIC, 16));
		contenuto_Descrizione.setWrapStyleWord(true);
		contenuto_Descrizione.setLineWrap(true);
		contenuto_Descrizione.setEditable(false);
		contenuto_Descrizione.setText(controller.getRistoranteDAO().getRistorante().getDescizione());
		contenuto_Descrizione.setBackground(new Color(0, 191, 255));
		contenuto_Descrizione.setBounds(270, 78, 537, 182);
		contentPane.add(contenuto_Descrizione);
	
		
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
		modello_numero1.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getTelefono());
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
			modello_numero2.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getSitoWeb());
		
		/*@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_fascia_prezzo = new JList();
		lista_fascia_prezzo.setFocusable(false);
		lista_fascia_prezzo.setBackground(new Color(0, 191, 255));
		lista_fascia_prezzo.setFont(new Font("Gadugi", Font.PLAIN, 13));
		lista_fascia_prezzo.setBounds(786, 48, 118, 47);
		dlm2.addElement(controller.getRistoranteDAO().getRistoranti().get(controller.getIndice()).getFascia_Prezzo());*/
		

		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Indietro.addActionListener(new ActionListener() {
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
		bottone_Indietro.setForeground(new Color(0, 0, 0));
		bottone_Indietro.setFont(new Font("Gadugi", Font.BOLD, 15));
		bottone_Indietro.setBackground(new Color(0,153,255));
		bottone_Indietro.setBounds(685, 583, 215, 29);
		contentPane.add(bottone_Indietro);
		
		JLabel label_per_descrizione = new JLabel("iconaDescrizione");
		label_per_descrizione.setBounds(270, 14, 28, 29);
		File nota = new File("images\\nota.png");
		BufferedImage img = ImageIO.read(nota);
		Image img2 = img.getScaledInstance(label_per_descrizione.getWidth(), label_per_descrizione.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_nota = new ImageIcon(img2);
		label_per_descrizione.setIcon(icona_nota);
		contentPane.add(label_per_descrizione);
		
		/*@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList category = new JList();
		category.setFocusable(false);
		category.setFont(new Font("Gadugi", Font.PLAIN, 13));
		category.setBackground(new Color(0, 191, 255));
		category.setBounds(786, 142, 118, 73);
		for(int i = 0; i < controller.getAssociazione_Categoria_RistoranteDAO().getCategorie().size(); i++)
		dlm3.addElement(controller.getAssociazione_Categoria_RistoranteDAO().getCategorie().get(i).getCategoria_Ristorante_FK().toString());*/
		
		JPanel pannello_laterale = new JPanel();
		pannello_laterale.setBackground(new Color(0, 153, 255));
		pannello_laterale.setBounds(912, 0, 332, 651);
		contentPane.add(pannello_laterale);
		pannello_laterale.setLayout(null);
		
		JLabel label_per_prezzo = new JLabel("iconaPrezzo");
		label_per_prezzo.setBounds(43, 42, 28, 29);
		File price = new File("images\\prezzo.png");
		BufferedImage imgprice = ImageIO.read(price);
		Image imgprice2 = imgprice.getScaledInstance(label_per_prezzo.getWidth(), label_per_prezzo.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_prezzo = new ImageIcon(imgprice2);
		contentPane.add(label_per_prezzo);
		label_per_prezzo.setIcon(icona_prezzo);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_cucine = new JList();
		lista_cucine.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_cucine.setBounds(20, 196, 302, 98);
		lista_cucine.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));

		pannello_laterale.add(lista_cucine);
		lista_cucine.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lista_cucine.setBackground(new Color(0, 153, 255));
		lista_cucine.setModel(modello_numero4);
		
		JLabel label_per_cucine = new JLabel("iconaCategoria");
		label_per_cucine.setBounds(16, 156, 28, 29);
		File category_icon = new File("images\\ristorante.png");
		BufferedImage imgcat = ImageIO.read(category_icon);
		Image img2cat = imgcat.getScaledInstance(label_per_cucine.getWidth(), label_per_cucine.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_categoria = new ImageIcon(img2cat);
		label_per_cucine.setIcon(icona_categoria);
		pannello_laterale.add(label_per_cucine);
		
		JTextArea contenuto_Stato = new JTextArea();
		contenuto_Stato.setBounds(175, 52, 128, 29);
		contenuto_Stato.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		pannello_laterale.add(contenuto_Stato);
		contenuto_Stato.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_Stato.setBackground(new Color(0, 153, 255));
		contenuto_Stato.setEditable(false);
		contenuto_Stato.setText(controller.getLuogoDAO().getLuogo2().getStato());
		
		JLabel label_per_mappa = new JLabel("iconaMappa");
		label_per_mappa.setBounds(16, 15, 28, 29);
		File imgmap = new File("images\\mappa.png");
		BufferedImage imgmap2 = ImageIO.read(imgmap);
		Image imgmap3 = imgmap2.getScaledInstance(label_per_mappa.getWidth(), label_per_mappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_mappa = new ImageIcon(imgmap3);
		label_per_mappa.setIcon(icona_mappa);
		pannello_laterale.add(label_per_mappa);
		
		JTextArea contenuto_Città = new JTextArea();
		contenuto_Città.setBounds(20, 52, 139, 29);
		contenuto_Città.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		pannello_laterale.add(contenuto_Città);
		contenuto_Città.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_Città.setBackground(new Color(0, 153, 255));
		contenuto_Città.setEditable(false);
		contenuto_Città.setText(controller.getLuogoDAO().getLuogo2().getCittà());
		
		JTextArea contenuto_Provincia = new JTextArea();
		contenuto_Provincia.setBounds(20, 117, 128, 29);
		contenuto_Provincia.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		pannello_laterale.add(contenuto_Provincia);
		contenuto_Provincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_Provincia.setBackground(new Color(0, 153, 255));
		contenuto_Provincia.setEditable(false);
		contenuto_Provincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		
		JTextArea contenuto_Indirizzo = new JTextArea();
		contenuto_Indirizzo.setBounds(164, 118, 158, 29);
		contenuto_Indirizzo.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		pannello_laterale.add(contenuto_Indirizzo);
		contenuto_Indirizzo.setFont(new Font("Gadugi", Font.PLAIN, 15));
		contenuto_Indirizzo.setBackground(new Color(0, 153, 255));
		contenuto_Indirizzo.setEditable(false);
		contenuto_Indirizzo.setText(controller.getLuogoDAO().getLuogo2().getIndirizzo());
		
		JTextArea testo_Dove_siamo = new JTextArea();
		testo_Dove_siamo.setText("Dove siamo?");
		testo_Dove_siamo.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Dove_siamo.setEditable(false);
		testo_Dove_siamo.setBackground(new Color(0, 153, 255));
		testo_Dove_siamo.setBounds(54, 11, 118, 33);
		pannello_laterale.add(testo_Dove_siamo);
		
		JTextArea contenuto_Cucine = new JTextArea();
		contenuto_Cucine.setText("Cucine");
		contenuto_Cucine.setFont(new Font("Gadugi", Font.BOLD, 18));
		contenuto_Cucine.setEditable(false);
		contenuto_Cucine.setBackground(new Color(0, 153, 255));
		contenuto_Cucine.setBounds(54, 152, 71, 29);
		pannello_laterale.add(contenuto_Cucine);
		
		JTextArea testo_Come_contattarci = new JTextArea();
		testo_Come_contattarci.setText("Come contattarci");
		testo_Come_contattarci.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Come_contattarci.setEditable(false);
		testo_Come_contattarci.setBackground(new Color(0, 153, 255));
		testo_Come_contattarci.setBounds(54, 324, 164, 29);
		pannello_laterale.add(testo_Come_contattarci);
		
		JLabel label_per_contatti = new JLabel("iconaContatti");
		label_per_contatti.setBounds(16, 324, 28, 29);
		File imgtelefono = new File("images\\telefono.png");
		BufferedImage imgtelefono2 = ImageIO.read(imgtelefono);
		Image imgtelefono3 = imgtelefono2.getScaledInstance(label_per_mappa.getWidth(), label_per_mappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_telefono = new ImageIcon(imgtelefono3);
		label_per_contatti.setIcon(icona_telefono);
		pannello_laterale.add(label_per_contatti);
		
		JLabel label_sitoweb = new JLabel("iconaSitoWeb");
		label_sitoweb.setBounds(16, 480, 28, 29);
		File imgsitoweb = new File("images\\sitoweb.png");
		BufferedImage imgsitoweb2 = ImageIO.read(imgsitoweb);
		Image imgsitoweb3 = imgsitoweb2.getScaledInstance(label_per_mappa.getWidth(), label_per_mappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_sitoweb = new ImageIcon(imgsitoweb3);
		label_sitoweb.setIcon(icona_sitoweb);
		pannello_laterale.add(label_sitoweb);

		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_telefono = new JList();
		lista_telefono.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_telefono.setBounds(20, 365, 302, 105);		
		lista_telefono.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		pannello_laterale.add(lista_telefono);
		lista_telefono.setFocusable(false);
		lista_telefono.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lista_telefono.setBackground(new Color(0, 153, 255));
		lista_telefono.setModel(modello_numero1);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_sitoweb = new JList();
		lista_sitoweb.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_sitoweb.setBounds(20, 513, 302, 105);
		lista_sitoweb.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		pannello_laterale.add(lista_sitoweb);
		lista_sitoweb.setFocusable(false);
		lista_sitoweb.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lista_sitoweb.setBackground(new Color(0, 153, 255));
		lista_sitoweb.setModel(modello_numero2);
		
		JTextArea testo_Provincia = new JTextArea();
		testo_Provincia.setText("Provincia");
		testo_Provincia.setFont(new Font("Gadugi", Font.BOLD, 14));
		testo_Provincia.setEditable(false);
		testo_Provincia.setBackground(new Color(0, 153, 255));
		testo_Provincia.setBounds(20, 91, 103, 22);
		pannello_laterale.add(testo_Provincia);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList FasciaPrezzo = new JList();
		FasciaPrezzo.setBounds(81, 45, 118, 22);
		contentPane.add(FasciaPrezzo);
		FasciaPrezzo.setBackground(new Color(0, 191, 255));
		FasciaPrezzo.setFont(new Font("Gadugi", Font.PLAIN, 13));
		modello_numero3.addElement(controller.getRistoranteDAO().getRistoranti().get(controller.getIndice()).getFascia_Prezzo());
		FasciaPrezzo.setModel(modello_numero3);
		
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
		
		JScrollPane scrollPane_tabellaRecensioni = new JScrollPane(tabellaRecensioni);
		scrollPane_tabellaRecensioni.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane_tabellaRecensioni.setBounds(24, 310, 488, 148);
		contentPane.add(scrollPane_tabellaRecensioni);
		scrollPane_tabellaRecensioni.setViewportView(tabellaRecensioni);
		
		riempitabellaRecensioni(controller);
		
		JTextArea contenuto_Visualizza_recensione = new JTextArea();
		contenuto_Visualizza_recensione.setFont(new Font("Gadugi", Font.PLAIN, 16));
		contenuto_Visualizza_recensione.setEditable(false);
		contenuto_Visualizza_recensione.setLineWrap(true);
		contenuto_Visualizza_recensione.setBounds(619, 255, 263, 193);
		contentPane.add(contenuto_Visualizza_recensione);
		
		JScrollPane scrollPane_Visualizza_recensione = new JScrollPane(contenuto_Visualizza_recensione);
		scrollPane_Visualizza_recensione.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_Visualizza_recensione.setBounds(566, 311, 316, 147);
		scrollPane_Visualizza_recensione.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane_Visualizza_recensione);
		
		JTextArea testo_Recensioni = new JTextArea();
		testo_Recensioni.setText("Recensioni");
		testo_Recensioni.setForeground(Color.BLACK);
		testo_Recensioni.setFont(new Font("Dialog", Font.BOLD, 21));
		testo_Recensioni.setFocusable(false);
		testo_Recensioni.setEditable(false);
		testo_Recensioni.setBackground(new Color(0, 191, 255));
		testo_Recensioni.setBounds(24, 271, 128, 29);
		contentPane.add(testo_Recensioni);
		
		JTextArea testo_Visualizza_recensione = new JTextArea();
		testo_Visualizza_recensione.setText("Visualizza recensione");
		testo_Visualizza_recensione.setForeground(Color.BLACK);
		testo_Visualizza_recensione.setFont(new Font("Dialog", Font.BOLD, 21));
		testo_Visualizza_recensione.setFocusable(false);
		testo_Visualizza_recensione.setEditable(false);
		testo_Visualizza_recensione.setBackground(new Color(0, 191, 255));
		testo_Visualizza_recensione.setBounds(566, 272, 228, 29);
		contentPane.add(testo_Visualizza_recensione);
		
		bottone_aggiungi_Recensione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recensione = testo_scrivi_recensione.getText();
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
	            	contenuto_Visualizza_recensione.setText(controller.getRecensioneDAO().getRecensioni().get(indice).getTesto() + "\n - " + controller.getRecensioneDAO().getNickNameRecensione(controller.getConnection(), codiceRecensione));
	            	
	           	
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



