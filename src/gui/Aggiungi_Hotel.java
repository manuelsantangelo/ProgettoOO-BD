package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import Tipi.categoriaalbergo;
import Tipi.prezzo;
import Tipi.tiposervizio;
import logic.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Aggiungi_Hotel extends JFrame {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;
	
	final static int FINESTRA_Y = 0;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	static File imgpath = null;

	
	private JTextField nome;
	private JTextField stato;
	private JTextField città;
	private JTextField paese;
	private JTextField indirizzo;
	private JTextField numero_telefono;
	private JTextField sitoWeb;
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero1;
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero2;
	private JTextField camere;

	@SuppressWarnings({ "rawtypes", "unchecked", "serial" }) // Utilizzato per ignorare i warning che non creano problemi
	public Aggiungi_Hotel(Controller controller) {
		
		this.controller = controller;
		
		modello_numero1 = new DefaultListModel();
		modello_numero2 = new DefaultListModel();

		setTitle("Aggiungi Hotel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 1370, 651);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea testo_Nome = new JTextArea();
		testo_Nome.setBackground(Color.BLACK);
		testo_Nome.setForeground(Color.GREEN);
		testo_Nome.setEditable(false);
		testo_Nome.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Nome.setText("Nome");
		testo_Nome.setBounds(24, 11, 63, 29);
		contentPane.add(testo_Nome);
		
		nome = new JTextField();
		nome.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		nome.setForeground(Color.GREEN);
		nome.setBackground(Color.BLACK);
		nome.setBounds(24, 44, 173, 29);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JTextArea testo_Stato = new JTextArea();
		testo_Stato.setText("Stato");
		testo_Stato.setForeground(Color.GREEN);
		testo_Stato.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Stato.setEditable(false);
		testo_Stato.setBackground(Color.BLACK);
		testo_Stato.setBounds(253, 11, 63, 29);
		contentPane.add(testo_Stato);
		
		stato = new JTextField();
		stato.setForeground(Color.GREEN);
		stato.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		stato.setColumns(10);
		stato.setBackground(Color.BLACK);
		stato.setBounds(253, 44, 173, 29);
		contentPane.add(stato);
		
		JTextArea testo_Città = new JTextArea();
		testo_Città.setText("Citt\u00E0");
		testo_Città.setForeground(Color.GREEN);
		testo_Città.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Città.setEditable(false);
		testo_Città.setBackground(Color.BLACK);
		testo_Città.setBounds(499, 11, 63, 29);
		contentPane.add(testo_Città);
		
		città = new JTextField();
		città.setForeground(Color.GREEN);
		città.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		città.setColumns(10);
		città.setBackground(Color.BLACK);
		città.setBounds(499, 44, 173, 29);
		contentPane.add(città);
		
		JTextArea testo_Paese = new JTextArea();
		testo_Paese.setText("Provincia");
		testo_Paese.setForeground(Color.GREEN);
		testo_Paese.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Paese.setEditable(false);
		testo_Paese.setBackground(Color.BLACK);
		testo_Paese.setBounds(746, 11, 128, 29);
		contentPane.add(testo_Paese);
		
		paese = new JTextField();
		paese.setForeground(Color.GREEN);
		paese.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		paese.setColumns(10);
		paese.setBackground(Color.BLACK);
		paese.setBounds(746, 44, 173, 29);
		contentPane.add(paese);
		
		JTextArea testo_Indirizzo = new JTextArea();
		testo_Indirizzo.setText("Indirizzo");
		testo_Indirizzo.setForeground(Color.GREEN);
		testo_Indirizzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Indirizzo.setEditable(false);
		testo_Indirizzo.setBackground(Color.BLACK);
		testo_Indirizzo.setBounds(24, 115, 98, 29);
		contentPane.add(testo_Indirizzo);
		
		indirizzo = new JTextField();
		indirizzo.setForeground(Color.GREEN);
		indirizzo.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		indirizzo.setColumns(10);
		indirizzo.setBackground(Color.BLACK);
		indirizzo.setBounds(24, 148, 173, 29);
		contentPane.add(indirizzo);
		
		JTextArea testo_Prezzo = new JTextArea();
		testo_Prezzo.setText("Prezzo");
		testo_Prezzo.setForeground(Color.GREEN);
		testo_Prezzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Prezzo.setEditable(false);
		testo_Prezzo.setBackground(Color.BLACK);
		testo_Prezzo.setBounds(253, 115, 76, 29);
		contentPane.add(testo_Prezzo);
		
		JComboBox prezzi = new JComboBox();
		prezzi.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		prezzi.setBackground(Color.BLACK);
		prezzi.setForeground(Color.GREEN);
		prezzi.setModel(new DefaultComboBoxModel(prezzo.values()));
		prezzi.setSelectedIndex(0);
		prezzi.setBounds(253, 148, 173, 29);
		contentPane.add(prezzi);
		
		JTextArea testo_StelleAlbergo = new JTextArea();
		testo_StelleAlbergo.setText("Stelle");
		testo_StelleAlbergo.setForeground(Color.GREEN);
		testo_StelleAlbergo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_StelleAlbergo.setEditable(false);
		testo_StelleAlbergo.setBackground(Color.BLACK);
		testo_StelleAlbergo.setBounds(1149, 11, 63, 29);
		contentPane.add(testo_StelleAlbergo);
		
		JComboBox stelleAlbergo = new JComboBox();
		stelleAlbergo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		stelleAlbergo.setSelectedIndex(0);
		stelleAlbergo.setForeground(Color.GREEN);
		stelleAlbergo.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		stelleAlbergo.setBackground(Color.BLACK);
		stelleAlbergo.setBounds(1150, 44, 43, 29);
		contentPane.add(stelleAlbergo);
		
		// Lista contenente i vari tipi di alberghi
		
		JList categorie = new JList();
		categorie.setLayoutOrientation(JList.VERTICAL_WRAP);
		categorie.setModel(new AbstractListModel() {
			String[] values = new String[] {"Hotel", "Motel", "BnB", "Villaggio_Turistico", "Beauty_Farm", "Albergo_Residenziale", "Residenza_di_epoca_alberghiera"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		categorie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categorie.setForeground(Color.GREEN);
		categorie.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		categorie.setBackground(Color.BLACK);
		categorie.setBounds(476, 151, 249, 184);
		contentPane.add(categorie);		
		
		JTextArea testo_Tipologia = new JTextArea();
		testo_Tipologia.setText("Tipologia");
		testo_Tipologia.setForeground(Color.GREEN);
		testo_Tipologia.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Tipologia.setEditable(false);
		testo_Tipologia.setBackground(Color.BLACK);
		testo_Tipologia.setBounds(476, 115, 128, 29);
		contentPane.add(testo_Tipologia);
		
		JTextArea testo_Telefono = new JTextArea();
		testo_Telefono.setText("Telefono");
		testo_Telefono.setForeground(Color.GREEN);
		testo_Telefono.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Telefono.setEditable(false);
		testo_Telefono.setBackground(Color.BLACK);
		testo_Telefono.setBounds(24, 226, 128, 29);
		contentPane.add(testo_Telefono);
		
		numero_telefono = new JTextField();
		numero_telefono.setForeground(Color.GREEN);
		numero_telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		numero_telefono.setColumns(10);
		numero_telefono.setBackground(Color.BLACK);
		numero_telefono.setBounds(24, 260, 142, 29);
		contentPane.add(numero_telefono);
		
		JList lista_Telefono = new JList();
		lista_Telefono.setBorder(new LineBorder(Color.GREEN));
		lista_Telefono.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista_Telefono.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista_Telefono.setForeground(Color.GREEN);
		lista_Telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		lista_Telefono.setBackground(Color.BLACK);
		lista_Telefono.setBounds(24, 300, 173, 138);
		contentPane.add(lista_Telefono);
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiungere un numero di telefono nella lista_telefono
		
		JButton bottone_aggiungi_numero_di_telefono = new JButton("+");
		bottone_aggiungi_numero_di_telefono.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiungi_numero_di_telefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num_tel = numero_telefono.getText();
				modello_numero1.addElement(num_tel);
				lista_Telefono.setModel(modello_numero1);
			}
		});
		bottone_aggiungi_numero_di_telefono.setBackground(Color.BLACK);
		bottone_aggiungi_numero_di_telefono.setForeground(Color.GREEN);
		bottone_aggiungi_numero_di_telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 6));
		bottone_aggiungi_numero_di_telefono.setBounds(173, 260, 24, 29);
		contentPane.add(bottone_aggiungi_numero_di_telefono);
		
		sitoWeb = new JTextField();
		sitoWeb.setForeground(Color.GREEN);
		sitoWeb.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		sitoWeb.setColumns(10);
		sitoWeb.setBackground(Color.BLACK);
		sitoWeb.setBounds(253, 260, 142, 29);
		contentPane.add(sitoWeb);
		
		JList lista_SitoWeb = new JList();
		lista_SitoWeb.setBorder(new LineBorder(Color.GREEN));
		lista_SitoWeb.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista_SitoWeb.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista_SitoWeb.setForeground(Color.GREEN);
		lista_SitoWeb.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		lista_SitoWeb.setBackground(Color.BLACK);
		lista_SitoWeb.setBounds(253, 300, 173, 138);
		contentPane.add(lista_SitoWeb);
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiungere un sito web nella lista_sitoWeb
		
		JButton bottone_aggiungi_sitoWeb = new JButton("+");
		bottone_aggiungi_sitoWeb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiungi_sitoWeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sito = sitoWeb.getText();
				modello_numero2.addElement(sito);
				lista_SitoWeb.setModel(modello_numero2);
			}
		});
		bottone_aggiungi_sitoWeb.setForeground(Color.GREEN);
		bottone_aggiungi_sitoWeb.setFont(new Font("Parametric Glitch", Font.PLAIN, 6));
		bottone_aggiungi_sitoWeb.setBackground(Color.BLACK);
		bottone_aggiungi_sitoWeb.setBounds(402, 260, 24, 29);
		contentPane.add(bottone_aggiungi_sitoWeb);
		
		JTextArea testo_SitoWeb = new JTextArea();
		testo_SitoWeb.setText("Sito Web");
		testo_SitoWeb.setForeground(Color.GREEN);
		testo_SitoWeb.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_SitoWeb.setEditable(false);
		testo_SitoWeb.setBackground(Color.BLACK);
		testo_SitoWeb.setBounds(253, 226, 128, 29);
		contentPane.add(testo_SitoWeb);
		
		JTextArea testo_Foto = new JTextArea();
		testo_Foto.setText("Foto");
		testo_Foto.setForeground(Color.GREEN);
		testo_Foto.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Foto.setEditable(false);
		testo_Foto.setBackground(Color.BLACK);
		testo_Foto.setBounds(1003, 115, 55, 29);
		contentPane.add(testo_Foto);
		
		JLabel frame_Immagine = new JLabel("");
		frame_Immagine.setBorder(new LineBorder(Color.GREEN));
		frame_Immagine.setForeground(Color.GREEN);
		frame_Immagine.setBackground(Color.BLACK);
		frame_Immagine.setBounds(1003, 156, 314, 251);
		contentPane.add(frame_Immagine);
		
		// bottone con il suo ActionListener che ha il compito
		// di cercare una foto all'interno della cartella C:\\Users 
		// (resa il più generica possibile per evitare errori di
		// incompatibilità con altri File System e di inserirla nel 
		// frame_per_immagine dopo averla ridimensionata
		
		JButton bottone_Cerca = new JButton("Cerca\r\n");
		bottone_Cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("C:\\Users"));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if(fileChooser.showOpenDialog(bottone_Cerca) == JFileChooser.APPROVE_OPTION) {
					String path = fileChooser.getSelectedFile().getAbsolutePath();
					imgpath = new File(path);
					BufferedImage img = null;
					try 
					{
					    img = ImageIO.read(imgpath); 
					    if(img == null) {
					    	 JOptionPane.showMessageDialog(null, "ERRORE! Non hai selezionato una foto!");	
					} else {
						 ByteArrayOutputStream bos = new ByteArrayOutputStream();
					      ImageIO.write(img, "jpg", bos );
					      Image dimg = img.getScaledInstance(frame_Immagine.getWidth(), frame_Immagine.getHeight(), Image.SCALE_SMOOTH); 
							ImageIcon imageIcon = new ImageIcon(dimg);
							frame_Immagine.setIcon(imageIcon);
					}}
					catch (IOException e2) 
					{
					    e2.printStackTrace();
					}
					
				}}
	});
		
		bottone_Cerca.setForeground(Color.GREEN);
		bottone_Cerca.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Cerca.setBackground(Color.BLACK);
		bottone_Cerca.setBounds(1059, 115, 117, 29);
		contentPane.add(bottone_Cerca);
		
		JTextArea testo_Descrizione = new JTextArea();
		testo_Descrizione.setText("Descrizione");
		testo_Descrizione.setForeground(Color.GREEN);
		testo_Descrizione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Descrizione.setEditable(false);
		testo_Descrizione.setBackground(Color.BLACK);
		testo_Descrizione.setBounds(24, 459, 128, 29);
		contentPane.add(testo_Descrizione);
		
		JTextArea descrizione = new JTextArea();
		descrizione.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		descrizione.setForeground(Color.GREEN);
		descrizione.setLineWrap(true);
		descrizione.setBackground(Color.BLACK);
		descrizione.setBounds(24, 499, 664, 102);
		contentPane.add(descrizione);
		
		Border border = BorderFactory.createLineBorder(Color.GREEN);
		descrizione.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane barra_di_scorrimento = new JScrollPane(descrizione);
		barra_di_scorrimento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barra_di_scorrimento.setBounds(24, 499, 664, 102);
		contentPane.add(barra_di_scorrimento);
		barra_di_scorrimento.setViewportView(descrizione);
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Aggiungi.setForeground(Color.GREEN);
		bottone_Aggiungi.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Aggiungi.setBackground(Color.BLACK);
		bottone_Aggiungi.setBounds(1119, 482, 117, 29);
		contentPane.add(bottone_Aggiungi);
		
		// bottone con il suo ActionListener che ha il compito
		// di farci tornare alla HomePage 
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Aggiungi_Hotel.this, controller.getModeratore_Homepage());
			}
		});
		bottone_Indietro.setForeground(Color.GREEN);
		bottone_Indietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Indietro.setBackground(Color.BLACK);
		bottone_Indietro.setBounds(1119, 542, 117, 29);
		contentPane.add(bottone_Indietro);
		
		JTextArea testo_Camere = new JTextArea();
		testo_Camere.setText("Camere");
		testo_Camere.setForeground(Color.GREEN);
		testo_Camere.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Camere.setEditable(false);
		testo_Camere.setBackground(Color.BLACK);
		testo_Camere.setBounds(1003, 11, 82, 29);
		contentPane.add(testo_Camere);
		
		camere = new JTextField();
		camere.setForeground(Color.GREEN);
		camere.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		camere.setColumns(10);
		camere.setBackground(Color.BLACK);
		camere.setBounds(1003, 44, 76, 29);
		contentPane.add(camere);
		
		JTextArea testo_Servizi = new JTextArea();
		testo_Servizi.setText("Servizi");
		testo_Servizi.setForeground(Color.GREEN);
		testo_Servizi.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Servizi.setEditable(false);
		testo_Servizi.setBackground(Color.BLACK);
		testo_Servizi.setBounds(746, 115, 128, 29);
		contentPane.add(testo_Servizi);
		
		// Lista contenente i vari Servizi che offre l'albergo
		// la quale permette una selezione multipla
		
		JList lista_Servizi = new JList();
		lista_Servizi.setModel(new AbstractListModel() {
			String[] values = new String[] {"Campo_Da_Calcio", "Campo_Da_Basket", "Campo_Da_Tennis", "Campo_Da_Golf", "Aria_Condizionata", "WiFi", "Servizio_In_Camera", "Piscina", "Centro_Benessere", "FrigoBar", "Mezza_Pensione", "Pensione_Completa", "Internet_Point", "Sala_Giochi", "Bar_Interno", "Ristorante_Interno", "Animal_Friendly"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lista_Servizi.setForeground(Color.GREEN);
		lista_Servizi.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		lista_Servizi.setBackground(Color.BLACK);
		lista_Servizi.setBounds(746, 151, 206, 435);
		contentPane.add(lista_Servizi);
		
		// ActionListener di bottone_Aggiungi che ha il compito
		// di aggiungere l'Albergo creato nella Gui all'interno del
		// db prendendo i vari campi dali vari componenti e utilizzandoli 
		// all'interno di funzioni che verranno richiamate dal controller
		// presenti nelle classi DAO

		bottone_Aggiungi.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int ID;
				String nome1 = nome.getText();
				String stato1 = stato.getText();
				String città1 = città.getText();
				String paese1 = paese.getText();
				String indirizzo1 = indirizzo.getText();
				
				prezzo price = prezzo.valueOf(prezzi.getSelectedItem().toString());
				int stelleAlbergo1 = (stelleAlbergo.getSelectedIndex() + 1);
				int numerocamere = Integer.parseInt(camere.getText());
				String descrizione1 = descrizione.getText();
				ArrayList<String> numTelefono = new ArrayList<String>();
				Object tempObject[] = categorie.getSelectedValues().clone();
				Object tempObject2[] = lista_Servizi.getSelectedValues().clone();
				ArrayList<String> webSite = new ArrayList<String>();
				ArrayList<String> temp = new ArrayList<String>();
				ArrayList<String> temp2 = new ArrayList<String>();
				ArrayList<categoriaalbergo> catalbergo = new ArrayList<categoriaalbergo>();
				ArrayList<tiposervizio> tiposer = new ArrayList<tiposervizio>();
				
				for(int i = 0; i < lista_Telefono.getModel().getSize(); i++) {
					numTelefono.add((String) lista_Telefono.getModel().getElementAt(i));
				}
				for(int j = 0; j < lista_SitoWeb.getModel().getSize(); j++) {
					webSite.add((String) lista_SitoWeb.getModel().getElementAt(j));
				}
				for(int k = 0; k < categorie.getSelectedValues().length; k++) {
					temp.add((String) tempObject[k]);
					catalbergo.add(categoriaalbergo.valueOf(temp.get(k)));
				}
				
				for(int z = 0; z < lista_Servizi.getSelectedValues().length; z++) {
					temp2.add((String) tempObject2[z]);
					tiposer.add(tiposervizio.valueOf(temp2.get(z)));
				}
				
				controller.getLuogoDAO().addLuogo(controller.getConnection(), stato1, città1, paese1, indirizzo1);
				controller.getAlbergoDAO().addAlbergo(controller.getConnection(), nome1, catalbergo, stelleAlbergo1, numerocamere, descrizione1, imgpath, price);
				ID = controller.getAlbergoDAO().getLastAlbergo(controller.getConnection());
				controller.getContattiDAO().addContattiAlbergo(controller.getConnection(), numTelefono, webSite, ID);
				controller.getAssociazione_Servizio_AlbergoDAO().addAssociazione_Servizio_Albergo(controller.getConnection(), tiposer, ID);
			
			    // Pulizia dei vari campi per facilitare l'aggiunta di più
				// attrazioni senza dover far ripartire il programma

				nome.setText("");
				stato.setText("");
				città.setText("");
				paese.setText("");
				indirizzo.setText("");
				camere.setText("");
				descrizione.setText("");
				numTelefono.clear();
				numero_telefono.setText("");
				DefaultListModel ripuliamo1 = (DefaultListModel)lista_Telefono.getModel();
				ripuliamo1.removeAllElements();
				sitoWeb.setText("");
				webSite.clear();
				DefaultListModel ripuliamo2 = (DefaultListModel)lista_SitoWeb.getModel();
				ripuliamo2.removeAllElements();
			}
		});
	
	}
}
