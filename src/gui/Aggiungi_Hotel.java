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
import Tipi.tiporistorante;
import Tipi.tiposervizio;
import logic.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale.Category;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Aggiungi_Hotel extends JFrame {
	
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
	private JTextField txtTelefono;
	private JTextField txtSitoWeb;
	private DefaultListModel dlm;
	private DefaultListModel dlm1;
	private JTextField camere;

	public Aggiungi_Hotel(Controller controller) {
		
		this.controller = controller;
		
		dlm = new DefaultListModel();
		dlm1 = new DefaultListModel();

		setTitle("Aggiungi Hotel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manue\\eclipse-workspace\\SafeTravel6\\images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 1370, 651);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrNome = new JTextArea();
		txtrNome.setBackground(Color.BLACK);
		txtrNome.setForeground(Color.GREEN);
		txtrNome.setEditable(false);
		txtrNome.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrNome.setText("Nome");
		txtrNome.setBounds(24, 11, 63, 29);
		contentPane.add(txtrNome);
		
		nome = new JTextField();
		nome.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		nome.setForeground(Color.GREEN);
		nome.setBackground(Color.BLACK);
		nome.setBounds(24, 44, 173, 29);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JTextArea txtrStato = new JTextArea();
		txtrStato.setText("Stato");
		txtrStato.setForeground(Color.GREEN);
		txtrStato.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrStato.setEditable(false);
		txtrStato.setBackground(Color.BLACK);
		txtrStato.setBounds(253, 11, 63, 29);
		contentPane.add(txtrStato);
		
		stato = new JTextField();
		stato.setForeground(Color.GREEN);
		stato.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		stato.setColumns(10);
		stato.setBackground(Color.BLACK);
		stato.setBounds(253, 44, 173, 29);
		contentPane.add(stato);
		
		JTextArea txtrCitt = new JTextArea();
		txtrCitt.setText("Citt\u00E0");
		txtrCitt.setForeground(Color.GREEN);
		txtrCitt.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrCitt.setEditable(false);
		txtrCitt.setBackground(Color.BLACK);
		txtrCitt.setBounds(499, 11, 63, 29);
		contentPane.add(txtrCitt);
		
		città = new JTextField();
		città.setForeground(Color.GREEN);
		città.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		città.setColumns(10);
		città.setBackground(Color.BLACK);
		città.setBounds(499, 44, 173, 29);
		contentPane.add(città);
		
		JTextArea txtrPaese = new JTextArea();
		txtrPaese.setText("Paese");
		txtrPaese.setForeground(Color.GREEN);
		txtrPaese.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrPaese.setEditable(false);
		txtrPaese.setBackground(Color.BLACK);
		txtrPaese.setBounds(746, 11, 63, 29);
		contentPane.add(txtrPaese);
		
		paese = new JTextField();
		paese.setForeground(Color.GREEN);
		paese.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		paese.setColumns(10);
		paese.setBackground(Color.BLACK);
		paese.setBounds(746, 44, 173, 29);
		contentPane.add(paese);
		
		JTextArea txtrI = new JTextArea();
		txtrI.setText("Indirizzo");
		txtrI.setForeground(Color.GREEN);
		txtrI.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrI.setEditable(false);
		txtrI.setBackground(Color.BLACK);
		txtrI.setBounds(24, 115, 76, 29);
		contentPane.add(txtrI);
		
		indirizzo = new JTextField();
		indirizzo.setForeground(Color.GREEN);
		indirizzo.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		indirizzo.setColumns(10);
		indirizzo.setBackground(Color.BLACK);
		indirizzo.setBounds(24, 148, 173, 29);
		contentPane.add(indirizzo);
		
		JTextArea txtrPrezzo = new JTextArea();
		txtrPrezzo.setText("Prezzo");
		txtrPrezzo.setForeground(Color.GREEN);
		txtrPrezzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrPrezzo.setEditable(false);
		txtrPrezzo.setBackground(Color.BLACK);
		txtrPrezzo.setBounds(253, 115, 76, 29);
		contentPane.add(txtrPrezzo);
		
		JComboBox prezzi = new JComboBox();
		prezzi.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		prezzi.setBackground(Color.BLACK);
		prezzi.setForeground(Color.GREEN);
		prezzi.setModel(new DefaultComboBoxModel(prezzo.values()));
		prezzi.setSelectedIndex(0);
		prezzi.setBounds(253, 148, 173, 29);
		contentPane.add(prezzi);
		
		JTextArea txtrStelleAlbergo = new JTextArea();
		txtrStelleAlbergo.setText("Stelle");
		txtrStelleAlbergo.setForeground(Color.GREEN);
		txtrStelleAlbergo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrStelleAlbergo.setEditable(false);
		txtrStelleAlbergo.setBackground(Color.BLACK);
		txtrStelleAlbergo.setBounds(1149, 11, 63, 29);
		contentPane.add(txtrStelleAlbergo);
		
		JComboBox stelleAlbergo = new JComboBox();
		stelleAlbergo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		stelleAlbergo.setSelectedIndex(0);
		stelleAlbergo.setForeground(Color.GREEN);
		stelleAlbergo.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		stelleAlbergo.setBackground(Color.BLACK);
		stelleAlbergo.setBounds(1150, 44, 43, 29);
		contentPane.add(stelleAlbergo);
		
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
		categorie.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		categorie.setForeground(Color.GREEN);
		categorie.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		categorie.setBackground(Color.BLACK);
		categorie.setBounds(499, 151, 206, 176);
		contentPane.add(categorie);		
		
		JTextArea txtrTipologia = new JTextArea();
		txtrTipologia.setText("Tipologia");
		txtrTipologia.setForeground(Color.GREEN);
		txtrTipologia.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrTipologia.setEditable(false);
		txtrTipologia.setBackground(Color.BLACK);
		txtrTipologia.setBounds(499, 115, 128, 29);
		contentPane.add(txtrTipologia);
		
		JTextArea txtrTelefono = new JTextArea();
		txtrTelefono.setText("Telefono");
		txtrTelefono.setForeground(Color.GREEN);
		txtrTelefono.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrTelefono.setEditable(false);
		txtrTelefono.setBackground(Color.BLACK);
		txtrTelefono.setBounds(24, 226, 128, 29);
		contentPane.add(txtrTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.GREEN);
		txtTelefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.BLACK);
		txtTelefono.setBounds(24, 260, 142, 29);
		contentPane.add(txtTelefono);
		
		JList telefono = new JList();
		telefono.setBorder(new LineBorder(Color.GREEN));
		telefono.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		telefono.setLayoutOrientation(JList.VERTICAL_WRAP);
		telefono.setForeground(Color.GREEN);
		telefono.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		telefono.setBackground(Color.BLACK);
		telefono.setBounds(24, 300, 173, 138);
		contentPane.add(telefono);
		
		JButton button = new JButton("+");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num_tel = txtTelefono.getText();
				dlm.addElement(num_tel);
				telefono.setModel(dlm);
			}
		});
		button.setBackground(Color.BLACK);
		button.setForeground(Color.GREEN);
		button.setFont(new Font("Parametric Glitch", Font.PLAIN, 6));
		button.setBounds(173, 260, 24, 29);
		contentPane.add(button);
		
		txtSitoWeb = new JTextField();
		txtSitoWeb.setForeground(Color.GREEN);
		txtSitoWeb.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		txtSitoWeb.setColumns(10);
		txtSitoWeb.setBackground(Color.BLACK);
		txtSitoWeb.setBounds(253, 260, 142, 29);
		contentPane.add(txtSitoWeb);
		
		JList SitoWeb = new JList();
		SitoWeb.setBorder(new LineBorder(Color.GREEN));
		SitoWeb.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		SitoWeb.setLayoutOrientation(JList.VERTICAL_WRAP);
		SitoWeb.setForeground(Color.GREEN);
		SitoWeb.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		SitoWeb.setBackground(Color.BLACK);
		SitoWeb.setBounds(253, 300, 173, 138);
		contentPane.add(SitoWeb);
		
		JButton button_1 = new JButton("+");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sito = txtSitoWeb.getText();
				dlm1.addElement(sito);
				SitoWeb.setModel(dlm1);
			}
		});
		button_1.setForeground(Color.GREEN);
		button_1.setFont(new Font("Parametric Glitch", Font.PLAIN, 6));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(402, 260, 24, 29);
		contentPane.add(button_1);
		
		JTextArea txtrSitoWeb = new JTextArea();
		txtrSitoWeb.setText("Sito Web");
		txtrSitoWeb.setForeground(Color.GREEN);
		txtrSitoWeb.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrSitoWeb.setEditable(false);
		txtrSitoWeb.setBackground(Color.BLACK);
		txtrSitoWeb.setBounds(253, 226, 128, 29);
		contentPane.add(txtrSitoWeb);
		
		JTextArea txtrFoto = new JTextArea();
		txtrFoto.setText("Foto");
		txtrFoto.setForeground(Color.GREEN);
		txtrFoto.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrFoto.setEditable(false);
		txtrFoto.setBackground(Color.BLACK);
		txtrFoto.setBounds(1003, 115, 55, 29);
		contentPane.add(txtrFoto);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBorder(new LineBorder(Color.GREEN));
		imageLabel.setForeground(Color.GREEN);
		imageLabel.setBackground(Color.BLACK);
		imageLabel.setBounds(1003, 156, 314, 251);
		contentPane.add(imageLabel);
		
		JButton btnCerca = new JButton("Cerca\r\n");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("C:\\Users\\manue\\Desktop"));
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if(fc.showOpenDialog(btnCerca) == JFileChooser.APPROVE_OPTION) {
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
					      Image dimg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH); 
							ImageIcon imageIcon = new ImageIcon(dimg);
							imageLabel.setIcon(imageIcon);
					}}
					catch (IOException e2) 
					{
					    e2.printStackTrace();
					}
					
				}}
	});
		
		btnCerca.setForeground(Color.GREEN);
		btnCerca.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnCerca.setBackground(Color.BLACK);
		btnCerca.setBounds(1059, 115, 117, 29);
		contentPane.add(btnCerca);
		
		JTextArea txtrDescrizione = new JTextArea();
		txtrDescrizione.setText("Descrizione");
		txtrDescrizione.setForeground(Color.GREEN);
		txtrDescrizione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrDescrizione.setEditable(false);
		txtrDescrizione.setBackground(Color.BLACK);
		txtrDescrizione.setBounds(24, 459, 128, 29);
		contentPane.add(txtrDescrizione);
		
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
		
		JScrollPane scrollPane = new JScrollPane(descrizione);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 499, 664, 102);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(descrizione);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.setForeground(Color.GREEN);
		btnAggiungi.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnAggiungi.setBackground(Color.BLACK);
		btnAggiungi.setBounds(1119, 482, 117, 29);
		contentPane.add(btnAggiungi);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Aggiungi_Hotel.this, controller.getModeratore_Homepage());
			}
		});
		btnIndietro.setForeground(Color.GREEN);
		btnIndietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnIndietro.setBackground(Color.BLACK);
		btnIndietro.setBounds(1119, 542, 117, 29);
		contentPane.add(btnIndietro);
		
		JTextArea txtrCamere = new JTextArea();
		txtrCamere.setText("Camere");
		txtrCamere.setForeground(Color.GREEN);
		txtrCamere.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrCamere.setEditable(false);
		txtrCamere.setBackground(Color.BLACK);
		txtrCamere.setBounds(1003, 11, 82, 29);
		contentPane.add(txtrCamere);
		
		camere = new JTextField();
		camere.setForeground(Color.GREEN);
		camere.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		camere.setColumns(10);
		camere.setBackground(Color.BLACK);
		camere.setBounds(1003, 44, 76, 29);
		contentPane.add(camere);
		
		JTextArea txtrServizi = new JTextArea();
		txtrServizi.setText("Servizi");
		txtrServizi.setForeground(Color.GREEN);
		txtrServizi.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrServizi.setEditable(false);
		txtrServizi.setBackground(Color.BLACK);
		txtrServizi.setBounds(746, 115, 128, 29);
		contentPane.add(txtrServizi);
		
		JList servizi = new JList();
		servizi.setModel(new AbstractListModel() {
			String[] values = new String[] {"Campo_Da_Calcio", "Campo_Da_Basket", "Campo_Da_Tennis", "Campo_Da_Golf", "Aria_Condizionata", "WiFi", "Servizio_In_Camera", "Piscina", "Centro_Benessere", "FrigoBar", "Mezza_Pensione", "Pensione_Completa", "Internet_Point", "Sala_Giochi", "Bar_Interno", "Ristorante_Interno", "Animal_Friendly"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		servizi.setForeground(Color.GREEN);
		servizi.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		servizi.setBackground(Color.BLACK);
		servizi.setBounds(746, 151, 206, 435);
		contentPane.add(servizi);
		

		btnAggiungi.addActionListener(new ActionListener() {
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
				Object tempObject2[] = servizi.getSelectedValues().clone();
				ArrayList<String> webSite = new ArrayList<String>();
				ArrayList<String> temp = new ArrayList<String>();
				ArrayList<String> temp2 = new ArrayList<String>();
				ArrayList<categoriaalbergo> catalbergo = new ArrayList<categoriaalbergo>();
				ArrayList<tiposervizio> tiposer = new ArrayList<tiposervizio>();
				
				for(int i = 0; i < telefono.getModel().getSize(); i++) {
					numTelefono.add((String) telefono.getModel().getElementAt(i));
				}
				for(int j = 0; j < SitoWeb.getModel().getSize(); j++) {
					webSite.add((String) SitoWeb.getModel().getElementAt(j));
				}
				for(int k = 0; k < categorie.getSelectedValues().length; k++) {
					temp.add((String) tempObject[k]);
					catalbergo.add(categoriaalbergo.valueOf(temp.get(k)));
				}
				
				for(int z = 0; z < servizi.getSelectedValues().length; z++) {
					temp2.add((String) tempObject2[z]);
					tiposer.add(tiposervizio.valueOf(temp2.get(z)));
				}
				
				controller.getLuogoDAO().addLuogo(controller.getConnection(), stato1, città1, paese1, indirizzo1);
				controller.getAlbergoDAO().addAlbergo(controller.getConnection(), nome1, catalbergo, stelleAlbergo1, numerocamere, descrizione1, imgpath, price);
				ID = controller.getAlbergoDAO().getLastAlbergo(controller.getConnection());
				controller.getContattiDAO().addContattiAlbergo(controller.getConnection(), numTelefono, webSite, ID);
				controller.getAssociazione_Servizio_AlbergoDAO().addAssociazione_Servizio_Albergo(controller.getConnection(), tiposer, ID);
			}
		});

		
	}
}
