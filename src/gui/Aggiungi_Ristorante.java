
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

import Tipi.prezzo;
import Tipi.tiporistorante;
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

public class Aggiungi_Ristorante extends JFrame {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;
	
	final int MAX = 10;
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	static File imgpath = null;

	private JTextField nome;
	private JTextField stato;
	private JTextField città;
	private JTextField paese;
	private JTextField indirizzo;
	private JTextField numero_Telefono;
	private JTextField sitoWeb;
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero1;
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero2;

	@SuppressWarnings({ "rawtypes", "unchecked", "serial" }) // Utilizzato per ignorare l warning che non creano problemi
	public Aggiungi_Ristorante(Controller controller) {
		
		this.controller = controller;
		
		modello_numero1 = new DefaultListModel();
		modello_numero2 = new DefaultListModel();

		setTitle("Aggiungi Ristorante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 1099, 651);
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
		testo_Paese.setBounds(746, 11, 63, 29);
		contentPane.add(testo_Paese);
		
		paese = new JTextField();
		paese.setForeground(Color.GREEN);
		paese.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		paese.setColumns(10);
		paese.setBackground(Color.BLACK);
		paese.setBounds(746, 44, 173, 29);
		contentPane.add(paese);
		
		JTextArea testo_indirizzo = new JTextArea();
		testo_indirizzo.setText("Indirizzo");
		testo_indirizzo.setForeground(Color.GREEN);
		testo_indirizzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_indirizzo.setEditable(false);
		testo_indirizzo.setBackground(Color.BLACK);
		testo_indirizzo.setBounds(24, 115, 104, 29);
		contentPane.add(testo_indirizzo);
		
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
		
		JTextArea testo_StelleMichelin = new JTextArea();
		testo_StelleMichelin.setText("Stelle Michelin");
		testo_StelleMichelin.setForeground(Color.GREEN);
		testo_StelleMichelin.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_StelleMichelin.setEditable(false);
		testo_StelleMichelin.setBackground(Color.BLACK);
		testo_StelleMichelin.setBounds(499, 115, 128, 29);
		contentPane.add(testo_StelleMichelin);
		
		JComboBox stelleMichelin = new JComboBox();
		stelleMichelin.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));
		stelleMichelin.setForeground(Color.GREEN);
		stelleMichelin.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		stelleMichelin.setBackground(Color.BLACK);
		stelleMichelin.setBounds(499, 148, 43, 29);
		contentPane.add(stelleMichelin);
		
		// Lista contenente i vari tipi di Ristoranti e consente
		// la selezione multipla
		
		JList lista_Tipologia = new JList();
		lista_Tipologia.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista_Tipologia.setModel(new AbstractListModel() {
			String[] values = new String[] {"Braceria", "Pizzeria", "Trattoria", "Gourmet", "Paninoteca", "Ristorante", "Bar", "Fast_Food", "Cucina_Etnica", "Pesce", "Cornetteria", "Gelateria", "Osteria", "Buffet"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lista_Tipologia.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista_Tipologia.setForeground(Color.GREEN);
		lista_Tipologia.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		lista_Tipologia.setBackground(Color.BLACK);
		lista_Tipologia.setBounds(498, 262, 218, 189);
		contentPane.add(lista_Tipologia);		
		
		JTextArea testo_Tipologia = new JTextArea();
		testo_Tipologia.setText("Tipologia");
		testo_Tipologia.setForeground(Color.GREEN);
		testo_Tipologia.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Tipologia.setEditable(false);
		testo_Tipologia.setBackground(Color.BLACK);
		testo_Tipologia.setBounds(498, 226, 128, 29);
		contentPane.add(testo_Tipologia);
		
		JTextArea testo_Telefono = new JTextArea();
		testo_Telefono.setText("Telefono");
		testo_Telefono.setForeground(Color.GREEN);
		testo_Telefono.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Telefono.setEditable(false);
		testo_Telefono.setBackground(Color.BLACK);
		testo_Telefono.setBounds(24, 226, 128, 29);
		contentPane.add(testo_Telefono);
		
		numero_Telefono = new JTextField();
		numero_Telefono.setForeground(Color.GREEN);
		numero_Telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		numero_Telefono.setColumns(10);
		numero_Telefono.setBackground(Color.BLACK);
		numero_Telefono.setBounds(24, 260, 142, 29);
		contentPane.add(numero_Telefono);
		
		JList lista_telefono = new JList();
		lista_telefono.setBorder(new LineBorder(Color.GREEN));
		lista_telefono.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista_telefono.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista_telefono.setForeground(Color.GREEN);
		lista_telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		lista_telefono.setBackground(Color.BLACK);
		lista_telefono.setBounds(24, 300, 173, 138);
		contentPane.add(lista_telefono);
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiungere un numero di telefono nella lista_telefono
		
		JButton bottone_aggiungi_numero_di_telefono = new JButton("+");
		bottone_aggiungi_numero_di_telefono.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiungi_numero_di_telefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num_tel = numero_Telefono.getText();
				modello_numero1.addElement(num_tel);
				lista_telefono.setModel(modello_numero1);
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
		testo_Foto.setBounds(746, 115, 55, 29);
		contentPane.add(testo_Foto);
		
		JLabel frame_immagine = new JLabel("");
		frame_immagine.setBorder(new LineBorder(Color.GREEN));
		frame_immagine.setForeground(Color.GREEN);
		frame_immagine.setBackground(Color.BLACK);
		frame_immagine.setBounds(746, 156, 314, 251);
		contentPane.add(frame_immagine);
		
		// bottone con il suo ActionListener che ha il compito
		// di cercare una foto all'interno della cartella C:\\Users 
		// (resa il più generica possibile per evitare errori di
		// incompatibilità con altri File System e di inserirla nel 
		// frame_per_immagine dopo averla ridimensionata
		
		JButton bottone_Cerca = new JButton("Cerca\r\n");
		bottone_Cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C:\\Users"));
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					if(fc.showOpenDialog(bottone_Cerca) == JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
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
						      Image dimg = img.getScaledInstance(frame_immagine.getWidth(), frame_immagine.getHeight(), Image.SCALE_SMOOTH); 
								ImageIcon imageIcon = new ImageIcon(dimg);
								frame_immagine.setIcon(imageIcon);
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
		bottone_Cerca.setBounds(802, 115, 117, 29);
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
		bottone_Aggiungi.setBounds(849, 499, 117, 29);
		contentPane.add(bottone_Aggiungi);
		
		// bottone con il suo ActionListener che ha il compito
		// di farci tornare alla HomePage 
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Indietro.setForeground(Color.GREEN);
		bottone_Indietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Indietro.setBackground(Color.BLACK);
		bottone_Indietro.setBounds(849, 559, 117, 29);
		contentPane.add(bottone_Indietro);
		
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Aggiungi_Ristorante.this, controller.getModeratore_Homepage());
			}
		});
		
		// ActionListener di bottone_Aggiungi che ha il compito
		// di aggiungere il Ristorante creato nella Gui all'interno del
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
				int stelleMichelin1 = stelleMichelin.getSelectedIndex();
				String descrizione1 = descrizione.getText();
				ArrayList<String> numTelefono = new ArrayList<String>();
				Object tempObject[] = lista_Tipologia.getSelectedValues().clone();
				ArrayList<String> webSite = new ArrayList<String>();
				ArrayList<String> temp = new ArrayList<String>();
				ArrayList<tiporistorante> type = new ArrayList<tiporistorante>();
				
				for(int i = 0; i < lista_telefono.getModel().getSize(); i++) {
					numTelefono.add((String) lista_telefono.getModel().getElementAt(i));
				}
				for(int j = 0; j < lista_SitoWeb.getModel().getSize(); j++) {
					webSite.add((String) lista_SitoWeb.getModel().getElementAt(j));
				}
				for(int k = 0; k < lista_Tipologia.getSelectedValues().length; k++) {
					temp.add((String) tempObject[k]);
					type.add(tiporistorante.valueOf(temp.get(k)));
				}
				
				controller.getLuogoDAO().addLuogo(controller.getConnection(), stato1, città1, paese1, indirizzo1);
				controller.getRistoranteDAO().addRistorante(controller.getConnection(), nome1, price, stelleMichelin1, descrizione1, imgpath);
				ID = controller.getRistoranteDAO().getLastRestaurant(controller.getConnection());
				controller.getContattiDAO().addContattiRistorante(controller.getConnection(), numTelefono, webSite, ID);
				controller.getAssociazione_Categoria_RistoranteDAO().addAssociazione_Categoria_Ristorante(controller.getConnection(), type, ID);
			
			    // Pulizia dei vari campi per facilitare l'aggiunta di più
				// attrazioni senza dover far ripartire il programma

				nome.setText("");
				stato.setText("");
				città.setText("");
				paese.setText("");
				indirizzo.setText("");
				descrizione.setText("");
				numTelefono.clear();
				numero_Telefono.setText("");
				DefaultListModel ripuliamo1 = (DefaultListModel)lista_telefono.getModel();
				ripuliamo1.removeAllElements();
				sitoWeb.setText("");
				webSite.clear();
				DefaultListModel ripuliamo2 = (DefaultListModel)lista_SitoWeb.getModel();
				ripuliamo2.removeAllElements();
			}
		});

	}
}
