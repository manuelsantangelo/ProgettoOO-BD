package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Tipi.prezzo;
import Tipi.tipoattrazione;
import logic.Controller;

public class Aggiungi_Attrazione extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;
	
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
	private JTextField Telefono;
	private JTextField sitoWeb;
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero1;
	@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
	private DefaultListModel modello_numero2;

	@SuppressWarnings({ "rawtypes", "serial", "unchecked" }) // Utilizzato per ignorare i warning che non creano problemi
	public Aggiungi_Attrazione(Controller controller) {
		
		this.controller = controller;
		
		modello_numero1 = new DefaultListModel();
		modello_numero2 = new DefaultListModel();

		setTitle("Aggiungi Attrazione");
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
		
		JTextArea testoCittà = new JTextArea();
		testoCittà.setText("Citt\u00E0");
		testoCittà.setForeground(Color.GREEN);
		testoCittà.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testoCittà.setEditable(false);
		testoCittà.setBackground(Color.BLACK);
		testoCittà.setBounds(499, 11, 63, 29);
		contentPane.add(testoCittà);
		
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
		testo_Paese.setBounds(24, 115, 108, 29);
		contentPane.add(testo_Paese);
		
		paese = new JTextField();
		paese.setForeground(Color.GREEN);
		paese.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		paese.setColumns(10);
		paese.setBackground(Color.BLACK);
		paese.setBounds(24, 148, 173, 29);
		contentPane.add(paese);
		
		JTextArea testo_Indirizzo = new JTextArea();
		testo_Indirizzo.setText("Indirizzo");
		testo_Indirizzo.setForeground(Color.GREEN);
		testo_Indirizzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Indirizzo.setEditable(false);
		testo_Indirizzo.setBackground(Color.BLACK);
		testo_Indirizzo.setBounds(253, 115, 100, 29);
		contentPane.add(testo_Indirizzo);
		
		indirizzo = new JTextField();
		indirizzo.setForeground(Color.GREEN);
		indirizzo.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		indirizzo.setColumns(10);
		indirizzo.setBackground(Color.BLACK);
		indirizzo.setBounds(253, 148, 173, 29);
		contentPane.add(indirizzo);
		
		JTextArea testo_Prezzo = new JTextArea();
		testo_Prezzo.setText("Prezzo");
		testo_Prezzo.setForeground(Color.GREEN);
		testo_Prezzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Prezzo.setEditable(false);
		testo_Prezzo.setBackground(Color.BLACK);
		testo_Prezzo.setBounds(499, 115, 76, 29);
		contentPane.add(testo_Prezzo);
		
		JComboBox prezzi = new JComboBox();
		prezzi.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		prezzi.setBackground(new Color(20, 20, 20));
		prezzi.setForeground(Color.GREEN);
		prezzi.setModel(new DefaultComboBoxModel(prezzo.values()));
		prezzi.setSelectedIndex(0);
		prezzi.setBounds(499, 148, 173, 29);
		contentPane.add(prezzi);
		
		// Lista contenente i vari tipi di attrazioni
		
		JList attrazione = new JList();
		attrazione.setModel(new AbstractListModel() {
			String[] values = new String[] {"Museo", "Teatro", "Stadio", "Parco_Divertimenti", "Zona_Verde", "Arena", "Giro_Turistico", "Sagra", "Monumento"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		attrazione.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		attrazione.setForeground(Color.GREEN);
		attrazione.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		attrazione.setBackground(Color.BLACK);
		attrazione.setBounds(499, 263, 189, 213);
		contentPane.add(attrazione);		
		
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
		
		Telefono = new JTextField();
		Telefono.setForeground(Color.GREEN);
		Telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		Telefono.setColumns(10);
		Telefono.setBackground(Color.BLACK);
		Telefono.setBounds(24, 260, 142, 29);
		contentPane.add(Telefono);
		
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
				String num_tel = Telefono.getText();
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
		
		JList lista_sitoWeb = new JList();
		lista_sitoWeb.setBorder(new LineBorder(Color.GREEN));
		lista_sitoWeb.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista_sitoWeb.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista_sitoWeb.setForeground(Color.GREEN);
		lista_sitoWeb.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		lista_sitoWeb.setBackground(Color.BLACK);
		lista_sitoWeb.setBounds(253, 300, 173, 138);
		contentPane.add(lista_sitoWeb);
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiungere un sito web nella lista_sitoWeb
		
		JButton bottone_aggiungi_sitoWeb = new JButton("+");
		bottone_aggiungi_sitoWeb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiungi_sitoWeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sito = sitoWeb.getText();
				modello_numero2.addElement(sito);
				lista_sitoWeb.setModel(modello_numero2);
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
		testo_Foto.setBounds(746, 58, 55, 29);
		contentPane.add(testo_Foto);
		
		JLabel frame_per_immagine = new JLabel("");
		frame_per_immagine.setBorder(new LineBorder(Color.GREEN));
		frame_per_immagine.setForeground(Color.GREEN);
		frame_per_immagine.setBackground(Color.BLACK);
		frame_per_immagine.setBounds(746, 99, 314, 251);
		contentPane.add(frame_per_immagine);
		
		// bottone con il suo ActionListener che ha il compito
		// di cercare una foto all'interno della cartella C:\\Users 
		// (resa il più generica possibile per evitare errori di
		// incompatibilità con altri File System e di inserirla nel 
		// frame_per_immagine dopo averla ridimensionata
		
		JButton bottone_cerca = new JButton("Cerca\r\n");
		bottone_cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("C:\\Users"));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if(fileChooser.showOpenDialog(bottone_cerca) == JFileChooser.APPROVE_OPTION) {
					String path = fileChooser.getSelectedFile().getAbsolutePath();
					imgpath = new File(path);
					BufferedImage bufferedImage = null;
					try 
					{
					    bufferedImage = ImageIO.read(imgpath); 
					    if(bufferedImage == null) {
					    	 JOptionPane.showMessageDialog(null, "ERRORE! Non hai selezionato una foto!");	
					} else {
						 ByteArrayOutputStream bos = new ByteArrayOutputStream();
					      ImageIO.write(bufferedImage, "jpg", bos );
					      Image image = bufferedImage.getScaledInstance(frame_per_immagine.getWidth(), frame_per_immagine.getHeight(), Image.SCALE_SMOOTH); 
							ImageIcon imageIcon = new ImageIcon(image);
							frame_per_immagine.setIcon(imageIcon);
					}}
					catch (IOException e2) 
					{
					    e2.printStackTrace();
					}
				}}
		});
		
		bottone_cerca.setForeground(Color.GREEN);
		bottone_cerca.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_cerca.setBackground(Color.BLACK);
		bottone_cerca.setBounds(802, 58, 117, 29);
		contentPane.add(bottone_cerca);
		
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
		
		JScrollPane barra_di_scorrimento = new JScrollPane(descrizione);
		barra_di_scorrimento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barra_di_scorrimento.setBounds(24, 499, 664, 102);
		contentPane.add(barra_di_scorrimento);
		barra_di_scorrimento.setViewportView(descrizione);


		Border border = BorderFactory.createLineBorder(Color.GREEN);
		descrizione.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Aggiungi.setForeground(Color.GREEN);
		bottone_Aggiungi.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Aggiungi.setBackground(Color.BLACK);
		bottone_Aggiungi.setBounds(849, 437, 117, 29);
		contentPane.add(bottone_Aggiungi);
		
		// bottone con il suo ActionListener che ha il compito
		// di farci tornare alla HomePage 

		JButton bottone_indietro = new JButton("Indietro");
		bottone_indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Aggiungi_Attrazione.this, controller.getModeratore_Homepage());
			}
		});
		bottone_indietro.setForeground(Color.GREEN);
		bottone_indietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_indietro.setBackground(Color.BLACK);
		bottone_indietro.setBounds(849, 497, 117, 29);
		contentPane.add(bottone_indietro);
		
		// ActionListener di bottone_Aggiungi che ha il compito
		// di aggiungere l'Attrazione creata nella Gui all'interno del
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
				String descrizione1 = descrizione.getText();
				ArrayList<String> numTelefono = new ArrayList<String>();
				Object tempObject[] = attrazione.getSelectedValues().clone();
				ArrayList<String> webSite = new ArrayList<String>();
				ArrayList<String> temp = new ArrayList<String>();
				ArrayList<tipoattrazione> tipoattr = new ArrayList<tipoattrazione>();
				
				for(int i = 0; i < lista_telefono.getModel().getSize(); i++) {
					numTelefono.add((String) lista_telefono.getModel().getElementAt(i));
				}
				for(int j = 0; j < lista_sitoWeb.getModel().getSize(); j++) {
					webSite.add((String) lista_sitoWeb.getModel().getElementAt(j));
				}
				for(int k = 0; k < attrazione.getSelectedValues().length; k++) {
					temp.add((String) tempObject[k]);
					tipoattr.add(tipoattrazione.valueOf(temp.get(k)));
				}
				
				
				controller.getLuogoDAO().addLuogo(controller.getConnection(), stato1, città1, paese1, indirizzo1);
				controller.getAttrazioneDAO().addAttrazione(controller.getConnection(), nome1, tipoattr, descrizione1, imgpath, price);
				ID = controller.getAttrazioneDAO().getLastAttrazione(controller.getConnection());
				controller.getContattiDAO().addContattiAttrazione(controller.getConnection(), numTelefono, webSite, ID);

			    // Pulizia dei vari campi per facilitare l'aggiunta di più
				// attrazioni senza dover far ripartire il programma

				nome.setText("");
				stato.setText("");
				città.setText("");
				paese.setText("");
				indirizzo.setText("");
				descrizione.setText("");
				numTelefono.clear();
				Telefono.setText("");
				DefaultListModel ripuliamo1 = (DefaultListModel)lista_telefono.getModel();
				ripuliamo1.removeAllElements();
				sitoWeb.setText("");
				webSite.clear();
				DefaultListModel ripuliamo2 = (DefaultListModel)lista_sitoWeb.getModel();
				ripuliamo2.removeAllElements();
		
			}});
	
	}
}
