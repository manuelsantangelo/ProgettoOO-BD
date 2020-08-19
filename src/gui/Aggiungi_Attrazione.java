package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import Tipi.prezzo;
import logic.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Aggiungi_Attrazione extends JFrame {
	
	private Controller controller;

	private JPanel contentPane;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private DefaultListModel dlm;
	private DefaultListModel dlm1;

	public Aggiungi_Attrazione(Controller controller) {
		
		this.controller = controller;
		
		dlm = new DefaultListModel();
		dlm1 = new DefaultListModel();

		setTitle("Aggiungi Attrazione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manue\\eclipse-workspace\\SafeTravel6\\images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 1099, 651);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField.setForeground(Color.GREEN);
		textField.setBackground(Color.BLACK);
		textField.setBounds(24, 44, 173, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrStato = new JTextArea();
		txtrStato.setText("Stato");
		txtrStato.setForeground(Color.GREEN);
		txtrStato.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrStato.setEditable(false);
		txtrStato.setBackground(Color.BLACK);
		txtrStato.setBounds(253, 11, 63, 29);
		contentPane.add(txtrStato);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.GREEN);
		textField_1.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(253, 44, 173, 29);
		contentPane.add(textField_1);
		
		JTextArea txtrCitt = new JTextArea();
		txtrCitt.setText("Citt\u00E0");
		txtrCitt.setForeground(Color.GREEN);
		txtrCitt.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrCitt.setEditable(false);
		txtrCitt.setBackground(Color.BLACK);
		txtrCitt.setBounds(499, 11, 63, 29);
		contentPane.add(txtrCitt);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GREEN);
		textField_2.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(499, 44, 173, 29);
		contentPane.add(textField_2);
		
		JTextArea txtrPaese = new JTextArea();
		txtrPaese.setText("Paese");
		txtrPaese.setForeground(Color.GREEN);
		txtrPaese.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrPaese.setEditable(false);
		txtrPaese.setBackground(Color.BLACK);
		txtrPaese.setBounds(24, 115, 63, 29);
		contentPane.add(txtrPaese);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.GREEN);
		textField_3.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(24, 148, 173, 29);
		contentPane.add(textField_3);
		
		JTextArea txtrI = new JTextArea();
		txtrI.setText("Indirizzo");
		txtrI.setForeground(Color.GREEN);
		txtrI.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrI.setEditable(false);
		txtrI.setBackground(Color.BLACK);
		txtrI.setBounds(253, 115, 76, 29);
		contentPane.add(txtrI);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.GREEN);
		textField_4.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.BLACK);
		textField_4.setBounds(253, 148, 173, 29);
		contentPane.add(textField_4);
		
		JTextArea txtrPrezzo = new JTextArea();
		txtrPrezzo.setText("Prezzo");
		txtrPrezzo.setForeground(Color.GREEN);
		txtrPrezzo.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrPrezzo.setEditable(false);
		txtrPrezzo.setBackground(Color.BLACK);
		txtrPrezzo.setBounds(499, 115, 76, 29);
		contentPane.add(txtrPrezzo);
		
		JComboBox list = new JComboBox();
		list.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		list.setBackground(new Color(20, 20, 20));
		list.setForeground(Color.GREEN);
		list.setModel(new DefaultComboBoxModel(prezzo.values()));
		list.setSelectedIndex(0);
		list.setBounds(499, 148, 173, 29);
		contentPane.add(list);
		
		JList comboBox_1 = new JList();
		comboBox_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Museo", "Teatro", "Stadio", "Parco Divertimenti", "Zona Verde", "Arena", "Giro Turistico", "Sagra"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		comboBox_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		comboBox_1.setForeground(Color.GREEN);
		comboBox_1.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		comboBox_1.setBackground(Color.BLACK);
		comboBox_1.setBounds(499, 263, 142, 176);
		contentPane.add(comboBox_1);		
		
		JTextArea txtrTipologia = new JTextArea();
		txtrTipologia.setText("Tipologia");
		txtrTipologia.setForeground(Color.GREEN);
		txtrTipologia.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrTipologia.setEditable(false);
		txtrTipologia.setBackground(Color.BLACK);
		txtrTipologia.setBounds(498, 226, 128, 29);
		contentPane.add(txtrTipologia);
		
		JTextArea txtrTelefono = new JTextArea();
		txtrTelefono.setText("Telefono");
		txtrTelefono.setForeground(Color.GREEN);
		txtrTelefono.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrTelefono.setEditable(false);
		txtrTelefono.setBackground(Color.BLACK);
		txtrTelefono.setBounds(24, 226, 128, 29);
		contentPane.add(txtrTelefono);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.GREEN);
		textField_5.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.BLACK);
		textField_5.setBounds(24, 260, 142, 29);
		contentPane.add(textField_5);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(Color.GREEN));
		list_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list_1.setLayoutOrientation(JList.VERTICAL_WRAP);
		list_1.setForeground(Color.GREEN);
		list_1.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		list_1.setBackground(Color.BLACK);
		list_1.setBounds(24, 300, 173, 138);
		contentPane.add(list_1);
		
		JButton button = new JButton("+");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num_tel = textField_5.getText();
				dlm.addElement(num_tel);
				list_1.setModel(dlm);
			}
		});
		button.setBackground(Color.BLACK);
		button.setForeground(Color.GREEN);
		button.setFont(new Font("Parametric Glitch", Font.PLAIN, 6));
		button.setBounds(173, 260, 24, 29);
		contentPane.add(button);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.GREEN);
		textField_6.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.BLACK);
		textField_6.setBounds(253, 260, 142, 29);
		contentPane.add(textField_6);
		
		JList list_2 = new JList();
		list_2.setBorder(new LineBorder(Color.GREEN));
		list_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list_2.setLayoutOrientation(JList.VERTICAL_WRAP);
		list_2.setForeground(Color.GREEN);
		list_2.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		list_2.setBackground(Color.BLACK);
		list_2.setBounds(253, 300, 173, 138);
		contentPane.add(list_2);
		
		JButton button_1 = new JButton("+");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sito = textField_6.getText();
				dlm1.addElement(sito);
				list_2.setModel(dlm1);
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
		txtrFoto.setBounds(746, 58, 55, 29);
		contentPane.add(txtrFoto);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBorder(new LineBorder(Color.GREEN));
		imageLabel.setForeground(Color.GREEN);
		imageLabel.setBackground(Color.BLACK);
		imageLabel.setBounds(746, 99, 314, 251);
		contentPane.add(imageLabel);
		
		JButton btnCerca = new JButton("Cerca\r\n");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C:/Users/Biagio/Desktop"));
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					if(fc.showOpenDialog(btnCerca) == JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						String namefile = fc.getSelectedFile().getName();
					//	imagelabel.setIcon(new ImageIcon(path));
						BufferedImage img = null;
						try 
						{
						    img = ImageIO.read(new File(path)); 
						} 
						catch (IOException e2) 
						{
						    e2.printStackTrace();
						}
						Image dimg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH); 
						ImageIcon imageIcon = new ImageIcon(dimg);
						imageLabel.setIcon(imageIcon);
					}}
		});
		btnCerca.setForeground(Color.GREEN);
		btnCerca.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnCerca.setBackground(Color.BLACK);
		btnCerca.setBounds(802, 58, 117, 29);
		contentPane.add(btnCerca);
		
		JTextArea txtrDescrizione = new JTextArea();
		txtrDescrizione.setText("Descrizione");
		txtrDescrizione.setForeground(Color.GREEN);
		txtrDescrizione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrDescrizione.setEditable(false);
		txtrDescrizione.setBackground(Color.BLACK);
		txtrDescrizione.setBounds(24, 459, 128, 29);
		contentPane.add(txtrDescrizione);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		textArea.setForeground(Color.GREEN);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(24, 499, 664, 102);
		contentPane.add(textArea);
		
		Border border = BorderFactory.createLineBorder(Color.GREEN);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.setForeground(Color.GREEN);
		btnAggiungi.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnAggiungi.setBackground(Color.BLACK);
		btnAggiungi.setBounds(849, 437, 117, 29);
		contentPane.add(btnAggiungi);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Aggiungi_Attrazione.this, controller.getModeratore_Homepage());
			}
		});
		btnIndietro.setForeground(Color.GREEN);
		btnIndietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnIndietro.setBackground(Color.BLACK);
		btnIndietro.setBounds(849, 497, 117, 29);
		contentPane.add(btnIndietro);
		

	}
}
