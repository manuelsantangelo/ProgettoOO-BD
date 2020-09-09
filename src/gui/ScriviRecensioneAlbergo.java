package gui;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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

@SuppressWarnings("serial")  // Utilizzato per ignorare il warning che non crea problemi
public class ScriviRecensioneAlbergo extends JFrame {

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
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero5 = new DefaultListModel();
	
	//Impostiamo le righe e colonne della JTable
	 //cliccabili ma non modificabili
	private JTable tabellaRecensioni = new JTable();
	static DefaultTableModel dtm = new DefaultTableModel(0,0){      
                                                                    
@Override
public boolean isCellEditable(int row, int column) {

	return false;
}
};	


	@SuppressWarnings("unchecked") // Utilizzato per ignorare il warning che non crea problemi
	public ScriviRecensioneAlbergo(Controller controller) throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("Recensione " + controller.getAlbergoDAO().getAlbergo().getNome());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);	
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JTextArea testo_dicci_cosa_ne_pensi = new JTextArea();
		testo_dicci_cosa_ne_pensi.setFocusable(false);
		testo_dicci_cosa_ne_pensi.setText("Dicci cosa ne pensi");
		testo_dicci_cosa_ne_pensi.setForeground(Color.BLACK);
		testo_dicci_cosa_ne_pensi.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_dicci_cosa_ne_pensi.setEditable(false);
		testo_dicci_cosa_ne_pensi.setBackground(new Color(0, 191, 255));
		testo_dicci_cosa_ne_pensi.setBounds(24, 475, 205, 29);
		contentPane.add(testo_dicci_cosa_ne_pensi);
		
		//bottone utilizzato in seguito per aggiungere una recensione
		JButton bottone_aggiungi_recensione = new JButton("Aggiungi recensione");
		bottone_aggiungi_recensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiungi_recensione.setForeground(Color.BLACK);
		bottone_aggiungi_recensione.setFont(new Font("Gadugi", Font.BOLD, 14));
		bottone_aggiungi_recensione.setBackground(new Color(0, 153, 255));
		bottone_aggiungi_recensione.setBounds(720, 519, 180, 54);
		contentPane.add(bottone_aggiungi_recensione);
		
		
		JLabel label_per_immagine = new JLabel("foto");
		label_per_immagine.setFocusable(false);
		label_per_immagine.setBackground(new Color(255, 255, 255));
		label_per_immagine.setBounds(41, 91, 187, 182);
		contentPane.add(label_per_immagine);
		
		//In questo modo andiamo a prendere la foto relativa all'albergo
		//di cui stiamo scrivendo la recensione
		byte[] imgBytes = controller.getAlbergoDAO().getAlbergo().getFoto();
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(label_per_immagine.getWidth(), label_per_immagine.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		label_per_immagine.setIcon(imageIcon);
		
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JComboBox valutazioneStelle = new JComboBox();
		valutazioneStelle.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		valutazioneStelle.setBackground(new Color(0, 191, 255));
		valutazioneStelle.setForeground(new Color(0, 0, 0));
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"});
		valutazioneStelle.setModel(model);
		valutazioneStelle.setBounds(668, 520, 42, 29);
		contentPane.add(valutazioneStelle);
		
		JTextArea testo_Stelle = new JTextArea();
		testo_Stelle.setFocusable(false);
		testo_Stelle.setText("Stelle");
		testo_Stelle.setForeground(Color.BLACK);
		testo_Stelle.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Stelle.setEditable(false);
		testo_Stelle.setBackground(new Color(0, 191, 255));
		testo_Stelle.setBounds(658, 487, 61, 29);
		contentPane.add(testo_Stelle);
		
		JTextArea testo_Nome = new JTextArea();
		testo_Nome.setFocusable(false);
		testo_Nome.setEditable(false);
		testo_Nome.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Nome.setText(controller.getAlbergoDAO().getAlbergo().getNome());
		testo_Nome.setBackground(new Color(0, 191, 255));
		testo_Nome.setBounds(41, 10, 189, 29);
		contentPane.add(testo_Nome);
		
		JTextArea testo_Descrizione = new JTextArea();
		testo_Descrizione.setFocusable(false);
		testo_Descrizione.setEditable(false);
		testo_Descrizione.setBackground(new Color(0, 191, 255));
		testo_Descrizione.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Descrizione.setText("Descrizione");
		testo_Descrizione.setBounds(311, 10, 294, 22);
		contentPane.add(testo_Descrizione);
		
		JTextArea contenuto_scrivi_recensione = new JTextArea();
		contenuto_scrivi_recensione.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_scrivi_recensione.setBounds(24, 498, 624, 98);
		contenuto_scrivi_recensione.setLineWrap(true);
		contentPane.add(contenuto_scrivi_recensione);
		
		JScrollPane scrollPane_scrivi_recensione = new JScrollPane(contenuto_scrivi_recensione);
		scrollPane_scrivi_recensione.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_scrivi_recensione.setBounds(24, 514, 624, 98);
		scrollPane_scrivi_recensione.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane_scrivi_recensione);
		
		JTextArea contenuto_Descrizione = new JTextArea();
		contenuto_Descrizione.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		contenuto_Descrizione.setFocusable(false);
		contenuto_Descrizione.setFont(new Font("Gadugi", Font.ITALIC, 16));
		contenuto_Descrizione.setWrapStyleWord(true);
		contenuto_Descrizione.setLineWrap(true);
		contenuto_Descrizione.setEditable(false);
		contenuto_Descrizione.setText(controller.getAlbergoDAO().getAlbergo().getTesto());
		contenuto_Descrizione.setBackground(new Color(0, 191, 255));
		contenuto_Descrizione.setBounds(270, 48, 537, 182);
		contentPane.add(contenuto_Descrizione);
		
		//bottone_Indietro con il suo ActionListener che ha il compito
		//di tornare nella pagina principale
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.getContattiDAO().getSitoEtelefono().clear();
					controller.getAssociazione_Servizio_AlbergoDAO().getServizi().clear();
					controller.CambiaFrame(ScriviRecensioneAlbergo.this, controller.getPrincipale());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		bottone_Indietro.setForeground(new Color(0, 0, 0));
		bottone_Indietro.setFont(new Font("Gadugi", Font.BOLD, 15));
		bottone_Indietro.setBackground(new Color(0, 153, 255));
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
	
		
		JPanel panello_laterale = new JPanel();
		panello_laterale.setBackground(new Color(0, 153, 255));
		panello_laterale.setBounds(912, 0, 332, 651);
		contentPane.add(panello_laterale);
		panello_laterale.setLayout(null);
		
		JLabel label_per_prezzo = new JLabel("iconaPrezzo");
		label_per_prezzo.setBounds(43, 42, 28, 29);
		File price = new File("images\\prezzo.png");
		BufferedImage imgprice = ImageIO.read(price);
		Image imgprice2 = imgprice.getScaledInstance(label_per_prezzo.getWidth(), label_per_prezzo.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_prezzo = new ImageIcon(imgprice2);
		contentPane.add(label_per_prezzo);
		label_per_prezzo.setIcon(icona_prezzo);
		
		JLabel label_per_categoria = new JLabel("iconaCategoria");
		label_per_categoria.setBounds(16, 156, 28, 29);
		File category_icon = new File("images\\casa.png");
		BufferedImage imgcat = ImageIO.read(category_icon);
		Image img2cat = imgcat.getScaledInstance(label_per_categoria.getWidth(), label_per_categoria.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_categoria = new ImageIcon(img2cat);
		label_per_categoria.setIcon(icona_categoria);
		panello_laterale.add(label_per_categoria);
		
		JTextArea contenuto_Stato = new JTextArea();
		contenuto_Stato.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		contenuto_Stato.setBounds(175, 54, 128, 29);
		panello_laterale.add(contenuto_Stato);
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
		panello_laterale.add(label_per_mappa);
		
		JTextArea contenuto_Città = new JTextArea();
		contenuto_Città.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		contenuto_Città.setBounds(16, 54, 139, 29);
		panello_laterale.add(contenuto_Città);
		contenuto_Città.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_Città.setBackground(new Color(0, 153, 255));
		contenuto_Città.setEditable(false);
		contenuto_Città.setText(controller.getLuogoDAO().getLuogo2().getCittà());
		
		JTextArea contenuto_Provincia = new JTextArea();
		contenuto_Provincia.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		contenuto_Provincia.setBounds(16, 117, 128, 29);
		panello_laterale.add(contenuto_Provincia);
		contenuto_Provincia.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_Provincia.setBackground(new Color(0, 153, 255));
		contenuto_Provincia.setEditable(false);
		contenuto_Provincia.setText(controller.getLuogoDAO().getLuogo2().getPaese());
		
		JTextArea contenuto_Indirizzo = new JTextArea();
		contenuto_Indirizzo.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		contenuto_Indirizzo.setBounds(164, 118, 158, 29);
		panello_laterale.add(contenuto_Indirizzo);
		contenuto_Indirizzo.setFont(new Font("Gadugi", Font.PLAIN, 16));
		contenuto_Indirizzo.setBackground(new Color(0, 153, 255));
		contenuto_Indirizzo.setEditable(false);
		contenuto_Indirizzo.setText(controller.getLuogoDAO().getLuogo2().getIndirizzo());
		
		JTextArea testo_dove_siamo = new JTextArea();
		testo_dove_siamo.setText("Dove siamo?");
		testo_dove_siamo.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_dove_siamo.setEditable(false);
		testo_dove_siamo.setBackground(new Color(0, 153, 255));
		testo_dove_siamo.setBounds(54, 11, 118, 33);
		panello_laterale.add(testo_dove_siamo);
		
		JTextArea testo_tipo_di_struttura = new JTextArea();
		testo_tipo_di_struttura.setText("Tipo di struttura");
		testo_tipo_di_struttura.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_tipo_di_struttura.setEditable(false);
		testo_tipo_di_struttura.setBackground(new Color(0, 153, 255));
		testo_tipo_di_struttura.setBounds(54, 152, 150, 33);
		panello_laterale.add(testo_tipo_di_struttura);
		
		JTextArea testo_come_contattarci = new JTextArea();
		testo_come_contattarci.setText("Come contattarci");
		testo_come_contattarci.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_come_contattarci.setEditable(false);
		testo_come_contattarci.setBackground(new Color(0, 153, 255));
		testo_come_contattarci.setBounds(92, 481, 164, 29);
		panello_laterale.add(testo_come_contattarci);
		
		JLabel label_per_telefono = new JLabel("iconaContatti");
		label_per_telefono.setBounds(54, 480, 28, 29);
		File imgtelefono = new File("images\\telefono.png");
		BufferedImage imgtelefono2 = ImageIO.read(imgtelefono);
		Image imgtelefono3 = imgtelefono2.getScaledInstance(label_per_mappa.getWidth(), label_per_mappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_telefono = new ImageIcon(imgtelefono3);
		label_per_telefono.setIcon(icona_telefono);
		panello_laterale.add(label_per_telefono);
		
		JLabel label_per_sitoweb = new JLabel("iconaSitoWeb");
		label_per_sitoweb.setBounds(16, 480, 28, 29);
		File imgsitoweb = new File("images\\sitoweb.png");
		BufferedImage imgsitoweb2 = ImageIO.read(imgsitoweb);
		Image imgsitoweb3 = imgsitoweb2.getScaledInstance(label_per_mappa.getWidth(), label_per_mappa.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_sitoweb = new ImageIcon(imgsitoweb3);
		label_per_sitoweb.setIcon(icona_sitoweb);
		panello_laterale.add(label_per_sitoweb);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_telefono = new JList();
		lista_telefono.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lista_telefono.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_telefono.setBounds(9, 521, 300, 54);
		panello_laterale.add(lista_telefono);
		lista_telefono.setFocusable(false);
		lista_telefono.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lista_telefono.setBackground(new Color(0, 153, 255));
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
			modello_numero1.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getTelefono());
		lista_telefono.setModel(modello_numero1);
	
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_sitoweb = new JList();
		lista_sitoweb.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_sitoweb.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lista_sitoweb.setBounds(9, 586, 300, 54);
		panello_laterale.add(lista_sitoweb);
		lista_sitoweb.setFocusable(false);
		lista_sitoweb.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lista_sitoweb.setBackground(new Color(0, 153, 255));
		for(int i = 0; i<controller.getContattiDAO().getSitoEtelefono().size(); i++) 
		modello_numero2.addElement(controller.getContattiDAO().getSitoEtelefono().get(i).getSitoWeb());
		lista_sitoweb.setModel(modello_numero2);
		
			
		JTextArea testo_Numero_camere = new JTextArea();
		testo_Numero_camere.setBounds(54, 437, 139, 29);
		panello_laterale.add(testo_Numero_camere);
		testo_Numero_camere.setFocusable(false);
		testo_Numero_camere.setText("Numero camere");
		testo_Numero_camere.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Numero_camere.setEditable(false);
		testo_Numero_camere.setBackground(new Color(0, 153, 255));
		
		JTextArea contenuto_numero_camere = new JTextArea();
		contenuto_numero_camere.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		contenuto_numero_camere.setBounds(202, 438, 65, 29);
		panello_laterale.add(contenuto_numero_camere);
		contenuto_numero_camere.setFocusable(false);
		contenuto_numero_camere.setText(String.valueOf(controller.getAlbergoDAO().getAlbergo().getNumero_Camere()));
		contenuto_numero_camere.setFont(new Font("Gadugi", Font.PLAIN, 17));
		contenuto_numero_camere.setEditable(false);
		contenuto_numero_camere.setBackground(new Color(0, 153, 255));
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_tipo_di_struttura = new JList();
		lista_tipo_di_struttura.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lista_tipo_di_struttura.setBounds(16, 195, 287, 29);
		panello_laterale.add(lista_tipo_di_struttura);
		lista_tipo_di_struttura.setFocusable(false);
		lista_tipo_di_struttura.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lista_tipo_di_struttura.setBackground(new Color(0, 153, 255));
		modello_numero4.addElement(controller.getAlbergoDAO().getAlberghi().get(controller.getIndice()).getCategoria() + " " 
				+ controller.getAlbergoDAO().getAlberghi().get(controller.getIndice()).getStelle() + " stelle");
		lista_tipo_di_struttura.setModel(modello_numero4);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_servizio = new JList();
		lista_servizio.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista_servizio.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lista_servizio.setBounds(16, 269, 306, 135);
		panello_laterale.add(lista_servizio);
		lista_servizio.setFocusable(false);
		lista_servizio.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lista_servizio.setBackground(new Color(0, 153, 255));
		for(int i = 0; i < controller.getAssociazione_Servizio_AlbergoDAO().getServizi().size(); i++)
			modello_numero5.addElement(controller.getAssociazione_Servizio_AlbergoDAO().getServizi().get(i).getServizio_FK().toString());
		lista_servizio.setModel(modello_numero5);
		
		JTextArea testo_Servizio = new JTextArea();
		testo_Servizio.setText("Servizio");
		testo_Servizio.setFont(new Font("Gadugi", Font.BOLD, 18));
		testo_Servizio.setEditable(false);
		testo_Servizio.setBackground(new Color(0, 153, 255));
		testo_Servizio.setBounds(54, 235, 150, 29);
		panello_laterale.add(testo_Servizio);
		
		JLabel label_per_servizio = new JLabel("iconaServizio");
		label_per_servizio.setBounds(16, 235, 28, 29);
		File imginfo = new File("images\\info.png");
		BufferedImage imginfo2 = ImageIO.read(imginfo);
		Image imginfo3 = imginfo2.getScaledInstance(label_per_servizio.getWidth(), label_per_servizio.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_info = new ImageIcon(imginfo3);
		label_per_servizio.setIcon(icona_info);
		panello_laterale.add(label_per_servizio);
		
		JLabel label_per_camere = new JLabel("iconaCamere");
		label_per_camere.setBounds(16, 437, 28, 29);
		File imgcamere = new File("images\\camere.png");
		BufferedImage imgcamere2 = ImageIO.read(imgcamere);
		Image imgcamere3 = imgcamere2.getScaledInstance(label_per_camere.getWidth(), label_per_camere.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon icona_camere = new ImageIcon(imgcamere3);
		label_per_camere.setIcon(icona_camere);
		panello_laterale.add(label_per_camere);
		
		JTextArea testo_Provincia = new JTextArea();
		testo_Provincia.setText("Provincia");
		testo_Provincia.setFont(new Font("Gadugi", Font.BOLD, 14));
		testo_Provincia.setEditable(false);
		testo_Provincia.setBackground(new Color(0, 153, 255));
		testo_Provincia.setBounds(16, 85, 103, 22);
		panello_laterale.add(testo_Provincia);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JList lista_fascia_prezzo = new JList();
		lista_fascia_prezzo.setBounds(81, 45, 118, 22);
		contentPane.add(lista_fascia_prezzo);
		lista_fascia_prezzo.setBackground(new Color(0, 191, 255));
		lista_fascia_prezzo.setFont(new Font("Gadugi", Font.PLAIN, 13));
		modello_numero3.addElement(controller.getAlbergoDAO().getAlberghi().get(controller.getIndice()).getFascia_Prezzo());
		lista_fascia_prezzo.setModel(modello_numero3);
		
		tabellaRecensioni.setRowHeight(20);
		tabellaRecensioni.setBackground(Color.WHITE);
		tabellaRecensioni.setFont(new Font("Gadugi", Font.PLAIN, 14));
		String nomeColonne[] = new String[] { "Recensioni", "Stelle" };
	    tabellaRecensioni.setModel(dtm);
	    dtm.setColumnIdentifiers(nomeColonne);
		tabellaRecensioni.setBounds(41, 279, 441, 173);
		contentPane.add(tabellaRecensioni);
		
		JScrollPane scrollPane_tabella_Recensioni = new JScrollPane(tabellaRecensioni);
		scrollPane_tabella_Recensioni.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane_tabella_Recensioni.setBounds(24, 316, 488, 148);
		contentPane.add(scrollPane_tabella_Recensioni);
		scrollPane_tabella_Recensioni.setViewportView(tabellaRecensioni);
		
		//Richiamiamo il metodo all'esterno del costruttore per riempire la tabella delle recensioni 
		riempitabellaRecensioni(controller);
		
		JTextArea contenuto_Visualizza_Recensione = new JTextArea();
		contenuto_Visualizza_Recensione.setFont(new Font("Gadugi", Font.PLAIN, 16));
		contenuto_Visualizza_Recensione.setEditable(false);
		contenuto_Visualizza_Recensione.setLineWrap(true);
		contenuto_Visualizza_Recensione.setBounds(619, 255, 263, 193);
		contentPane.add(contenuto_Visualizza_Recensione);
		
		JScrollPane scrollPane_Visualizza_Recensione = new JScrollPane(contenuto_Visualizza_Recensione);
		scrollPane_Visualizza_Recensione.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_Visualizza_Recensione.setBounds(563, 316, 319, 147);
		scrollPane_Visualizza_Recensione.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane_Visualizza_Recensione);
		
		JTextArea testo_Recensioni = new JTextArea();
		testo_Recensioni.setText("Recensioni");
		testo_Recensioni.setForeground(Color.BLACK);
		testo_Recensioni.setFont(new Font("Dialog", Font.BOLD, 21));
		testo_Recensioni.setFocusable(false);
		testo_Recensioni.setEditable(false);
		testo_Recensioni.setBackground(new Color(0, 191, 255));
		testo_Recensioni.setBounds(24, 277, 128, 29);
		contentPane.add(testo_Recensioni);
		
		JTextArea testo_Visualizza_Recensione = new JTextArea();
		testo_Visualizza_Recensione.setText("Visualizza recensione");
		testo_Visualizza_Recensione.setForeground(Color.BLACK);
		testo_Visualizza_Recensione.setFont(new Font("Dialog", Font.BOLD, 21));
		testo_Visualizza_Recensione.setFocusable(false);
		testo_Visualizza_Recensione.setEditable(false);
		testo_Visualizza_Recensione.setBackground(new Color(0, 191, 255));
		testo_Visualizza_Recensione.setBounds(563, 277, 233, 29);
		contentPane.add(testo_Visualizza_Recensione);
		
		//ActionListener di bottone_aggiungi_recensione che ha il compito di 
		//aggiungere una recensione che in seguito deve essere approvata
		//o rifiutata da un moderatore
		
		bottone_aggiungi_recensione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recensione = contenuto_scrivi_recensione.getText();
				int stelle = valutazioneStelle.getSelectedIndex()+1;
				controller.getRecensioneDAO().addRecensioneAlb(controller.getConnection(), recensione, stelle);
					
			}});
		
		//Doppio click mouse, visualizzazione recensione per esteso
		tabellaRecensioni.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent mouseEvent) {
	            tabellaRecensioni = (JTable) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2 && tabellaRecensioni.getSelectedRow() != -1) {
	            	int indice = tabellaRecensioni.getSelectedRow();
	            	int codiceRecensione = controller.getRecensioneDAO().getRecensioni().get(indice).getReview_ID();
	            	contenuto_Visualizza_Recensione.setText(controller.getRecensioneDAO().getRecensioni().get(indice).getTesto() + "\n - " + controller.getRecensioneDAO().getNickNameRecensione(controller.getConnection(), codiceRecensione));
	            	
	           	
	            }
	        }
		});
		
}
	
	//-----------------------------------------------------------------------------------------------------------
	//METODO PER RIEMPIRE LA TABELLA

public void riempitabellaRecensioni (Controller controller) {
		
		controller.getRecensioneDAO().setRecensioniDaVisualizzareAlbergo(controller.getConnection());
		
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		int i = 0;
		if(controller.getRecensioneDAO().getRecensioni().isEmpty()) {}
		else {
	do {
		
		dtm.addRow(new Object[] {
					controller.getRecensioneDAO().getRecensioni().get(i).getTesto(), controller.getRecensioneDAO().getRecensioni().get(i).getStelle()
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getRecensioneDAO().getRecensioni().size() != i);
	}}
}


