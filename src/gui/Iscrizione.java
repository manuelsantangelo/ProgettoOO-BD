package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
//import java.util.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Controller;

import java.time.chrono.JapaneseDate;
import javax.swing.JTextArea;

public class Iscrizione extends JFrame{
	private Controller controller;

	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;

	
	private JTextField nome;
	private JTextField cognome;
	private JTextField nickname;
	private JTextField email;
	private JTextField password;
	private JTextField city;
	String s;
	
	static File imgpath = null;

	public Iscrizione(Controller controller) {
		
		this.controller = controller;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manue\\eclipse-workspace\\SafeTravel6\\images\\LogoPiccolo.png"));
		
		setTitle("SafeTravel - Iscriviti!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome *");
		lblNome.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblNome.setBounds(25, 11, 79, 33);
		panel.add(lblNome);
		
		nome = new JTextField();
		nome.setFont(new Font("Gadugi", Font.BOLD, 15));
		nome.setBounds(25, 54, 193, 33);
		panel.add(nome);
		nome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome *");
		lblCognome.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblCognome.setBounds(279, 11, 140, 33);
		panel.add(lblCognome);
		
		cognome = new JTextField();
		cognome.setFont(new Font("Gadugi", Font.BOLD, 15));
		cognome.setBounds(279, 54, 193, 29);
		panel.add(cognome);
		cognome.setColumns(10);
		
		DateTextField calendario = new DateTextField();
		calendario.setBounds(25,391,193,29);
		panel.add(calendario);
		
		JLabel lblN = new JLabel("Nickname");
		lblN.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblN.setBounds(25, 129, 106, 27);
		panel.add(lblN);
		
		nickname = new JTextField();
		nickname.setFont(new Font("Gadugi", Font.BOLD, 15));
		nickname.setColumns(10);
		nickname.setBounds(25, 173, 193, 33);
		panel.add(nickname);
		
		JLabel lblEmail = new JLabel("Email *");
		lblEmail.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblEmail.setBounds(279, 129, 140, 33);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setFont(new Font("Gadugi", Font.BOLD, 15));
		email.setColumns(10);
		email.setBounds(279, 173, 193, 33);
		panel.add(email);
		
		JLabel lblPassword = new JLabel("Password *");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblPassword.setBounds(25, 240, 106, 27);
		panel.add(lblPassword);
		
		password = new JTextField();
		password.setFont(new Font("Gadugi", Font.BOLD, 15));
		password.setColumns(10);
		password.setBounds(25, 278, 193, 33);
		panel.add(password);
		
		JLabel lblCitt = new JLabel("Citt\u00E0 *");
		lblCitt.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblCitt.setBounds(279, 240, 72, 27);
		panel.add(lblCitt);
		
		city = new JTextField();
		city.setFont(new Font("Gadugi", Font.BOLD, 15));
		city.setColumns(10);
		city.setBounds(279, 278, 193, 33);
		panel.add(city);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita *");
		lblDataDiNascita.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblDataDiNascita.setBounds(25, 349, 174, 27);
		panel.add(lblDataDiNascita);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(531, 0, 424, 650);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setBounds(10, 11, 65, 33);
		panel_1.add(lblNote);
		lblNote.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		JTextArea txtrTuttiICampi = new JTextArea();
		txtrTuttiICampi.setWrapStyleWord(true);
		txtrTuttiICampi.setFont(new Font("Gadugi", Font.BOLD, 13));
		txtrTuttiICampi.setLineWrap(true);
		txtrTuttiICampi.setEditable(false);
		txtrTuttiICampi.setText("Tutti i campi contrassegnati dall'asterisco sono campi obbligatori.\r\n\r\nIl Nome e il Cognome non possono essere pi\u00F9 lunghi di 50 caratteri.\r\n\r\nLa Password non puo essere pi\u00F9 lunga di 20 caratteri e deve \r\ncontenere numeri e lettere.\r\n\r\nL'Email deve essere valida.\r\n\r\nLa Citt\u00E0 non deve essere pi\u00F9 lunga di 20 caratteri.\r\n\r\nLa Data deve essere valida.\r\n\r\n");
		txtrTuttiICampi.setBackground(new Color(0, 153, 255));
		txtrTuttiICampi.setBounds(10, 39, 380, 261);
		panel_1.add(txtrTuttiICampi);
		
		JButton btnIscriviti = new JButton("Iscriviti");
		btnIscriviti.setFont(new Font("Gadugi", Font.BOLD, 18));
		btnIscriviti.setBackground(new Color(0, 191, 255));
		btnIscriviti.setBounds(141, 406, 123, 33);
		panel_1.add(btnIscriviti);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Gadugi", Font.BOLD, 18));
		btnAnnulla.setBackground(new Color(0, 191, 255));
		btnAnnulla.setBounds(141, 458, 123, 33);
		panel_1.add(btnAnnulla);
		
		JLabel lblImmagineDelProfilo = new JLabel("Immagine del profilo");
		lblImmagineDelProfilo.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblImmagineDelProfilo.setBounds(279, 349, 227, 27);
		panel.add(lblImmagineDelProfilo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(279, 395, 184, 144);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setBackground(new Color(0, 191, 255));
		imagelabel.setBounds(0, 0, 184, 144);
		panel_2.add(imagelabel);
		
		JButton button2 = new JButton("Cerca");
		button2.setBackground(new Color(0, 153, 255));
		button2.setFont(new Font("Gadugi", Font.BOLD, 11));
		button2.setBounds(328, 550, 89, 23);
		panel.add(button2);
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new java.io.File("C:/Users/Biagio/Desktop"));
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			if(fc.showOpenDialog(button2) == JFileChooser.APPROVE_OPTION) {
				String path = fc.getSelectedFile().getAbsolutePath();
				imgpath = new File(path);
				BufferedImage img = null;
				try 
				{
					img = ImageIO.read(imgpath); 
				    if(img == null) {
				    	 JOptionPane.showMessageDialog(null, "ERRORE! Non hai selezionato una foto!");	
				    
			    }
			    else {
			      ByteArrayOutputStream bos = new ByteArrayOutputStream();
			      ImageIO.write(img, "jpg", bos );
			  	  Image dimg = img.getScaledInstance(imagelabel.getWidth(), imagelabel.getHeight(), Image.SCALE_SMOOTH); 
				  ImageIcon imageIcon = new ImageIcon(dimg);
				  imagelabel.setIcon(imageIcon);
				    } }
				catch (IOException e2) 
				{
				    e2.printStackTrace();
				}
				
			}}
		}); 
		
		btnAnnulla.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(Iscrizione.this, controller.getHome());
				}
		});
		

		btnIscriviti.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e ) {
				
				String nome1 = nome.getText();
				String password1 = password.getText();			
				String nickname1 = nickname.getText();	
				String email1= email.getText();
				String cognome1 = cognome.getText();
				java.util.Date dataNascita = calendario.getDate();	
				java.sql.Date dataNascita1 = new java.sql.Date(dataNascita.getTime());
				String città1 = city.getText();
				
				controller.getUtenteDAO().addUtente(controller.getConnection(), nome1, password1, nickname1, email1, cognome1, dataNascita1, città1, imgpath);
				}
		});
		
		
	}
}

