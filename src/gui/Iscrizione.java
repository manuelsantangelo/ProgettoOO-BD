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
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import logic.Controller;
import javax.swing.JTextArea;

@SuppressWarnings("serial") // Utilizzato per ignorare il warning che non crea problemi
public class Iscrizione extends JFrame{
	
	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
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
	static File imgpath = null;

	public Iscrizione(Controller controller) {
		
		this.controller = controller;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("SafeTravel - Iscriviti!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel testo_Nome = new JLabel("Nome *");
		testo_Nome.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Nome.setBounds(25, 11, 79, 33);
		panel.add(testo_Nome);
		
		nome = new JTextField();
		nome.setFont(new Font("Gadugi", Font.BOLD, 15));
		nome.setBounds(25, 54, 193, 33);
		panel.add(nome);
		nome.setColumns(10);
		
		JLabel testo_Cognome = new JLabel("Cognome *");
		testo_Cognome.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Cognome.setBounds(279, 11, 140, 33);
		panel.add(testo_Cognome);
		
		cognome = new JTextField();
		cognome.setFont(new Font("Gadugi", Font.BOLD, 15));
		cognome.setBounds(279, 54, 193, 29);
		panel.add(cognome);
		cognome.setColumns(10);
		
		DateTextField calendario = new DateTextField();
		calendario.setBounds(25,391,193,29);
		panel.add(calendario);
		
		JLabel testo_Nickname = new JLabel("Nickname *");
		testo_Nickname.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Nickname.setBounds(25, 129, 140, 27);
		panel.add(testo_Nickname);
		
		nickname = new JTextField();
		nickname.setFont(new Font("Gadugi", Font.BOLD, 15));
		nickname.setColumns(10);
		nickname.setBounds(25, 173, 193, 33);
		panel.add(nickname);
		
		JLabel testo_Email = new JLabel("Email *");
		testo_Email.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Email.setBounds(279, 129, 140, 33);
		panel.add(testo_Email);
		
		email = new JTextField();
		email.setFont(new Font("Gadugi", Font.BOLD, 15));
		email.setColumns(10);
		email.setBounds(279, 173, 193, 33);
		panel.add(email);
		
		JLabel testo_Password = new JLabel("Password *");
		testo_Password.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Password.setBounds(25, 240, 106, 27);
		panel.add(testo_Password);
		
		password = new JTextField();
		password.setFont(new Font("Gadugi", Font.BOLD, 15));
		password.setColumns(10);
		password.setBounds(25, 278, 193, 33);
		panel.add(password);
		
		JLabel testo_Città = new JLabel("Città *");
		testo_Città.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Città.setBounds(279, 240, 72, 27);
		panel.add(testo_Città);
		
		city = new JTextField();
		city.setFont(new Font("Gadugi", Font.BOLD, 15));
		city.setColumns(10);
		city.setBounds(279, 278, 193, 33);
		panel.add(city);
		
		JLabel testo_DataDiNascita = new JLabel("Data di nascita *");
		testo_DataDiNascita.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_DataDiNascita.setBounds(25, 349, 174, 27);
		panel.add(testo_DataDiNascita);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(531, 0, 424, 650);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel testo_Note = new JLabel("Note:");
		testo_Note.setBounds(10, 11, 65, 33);
		panel_1.add(testo_Note);
		testo_Note.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		JTextArea testo_Informazioni = new JTextArea();
		testo_Informazioni.setWrapStyleWord(true);
		testo_Informazioni.setFont(new Font("Gadugi", Font.BOLD, 13));
		testo_Informazioni.setLineWrap(true);
		testo_Informazioni.setEditable(false);
		testo_Informazioni.setText("Tutti i campi contrassegnati dall'asterisco sono campi obbligatori.\r\n\r\nIl Nome e il Cognome non possono essere pi\u00F9 lunghi di 50 caratteri.\r\n\r\nLa Password deve essere minimo di 8 caratteri e non pi\u00F9 lunga di 20 caratteri e deve contenere numeri e lettere.\r\n\r\nL'Email deve essere valida.\r\n\r\nLa Citt\u00E0 non deve essere pi\u00F9 lunga di 20 caratteri.\r\n\r\nLa Data di nascita deve essere valida.\r\n\r\n");
		testo_Informazioni.setBackground(new Color(0, 153, 255));
		testo_Informazioni.setBounds(10, 39, 380, 296);
		panel_1.add(testo_Informazioni);
		
		JButton bottone_Iscriviti = new JButton("Iscriviti");
		bottone_Iscriviti.setFont(new Font("Gadugi", Font.BOLD, 18));
		bottone_Iscriviti.setBackground(new Color(0, 191, 255));
		bottone_Iscriviti.setBounds(141, 406, 123, 33);
		panel_1.add(bottone_Iscriviti);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setFont(new Font("Gadugi", Font.BOLD, 18));
		bottone_Annulla.setBackground(new Color(0, 191, 255));
		bottone_Annulla.setBounds(141, 458, 123, 33);
		panel_1.add(bottone_Annulla);
		
		JLabel testo_Immagine_Del_Profilo = new JLabel("Immagine del profilo");
		testo_Immagine_Del_Profilo.setFont(new Font("Gadugi", Font.BOLD, 20));
		testo_Immagine_Del_Profilo.setBounds(279, 349, 227, 27);
		panel.add(testo_Immagine_Del_Profilo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(279, 395, 184, 144);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel frame_Immagine_del_Profilo = new JLabel("");
		frame_Immagine_del_Profilo.setBackground(new Color(0, 191, 255));
		frame_Immagine_del_Profilo.setBounds(0, 0, 184, 144);
		panel_2.add(frame_Immagine_del_Profilo);
		
		// bottone con il suo ActionListener che ha il compito
		// di cercare una foto all'interno della cartella C:\\Users 
		// (resa il più generica possibile per evitare errori di
		// incompatibilità con altri File System e di inserirla nel 
		// frame_per_immagine dopo averla ridimensionata
		
		JButton bottone_Cerca = new JButton("Cerca");
		bottone_Cerca.setBackground(new Color(0, 153, 255));
		bottone_Cerca.setFont(new Font("Gadugi", Font.BOLD, 11));
		bottone_Cerca.setBounds(328, 550, 89, 23);
		panel.add(bottone_Cerca);
		bottone_Cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new java.io.File("C:/Users"));
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
			    }
			    else {
			      ByteArrayOutputStream bos = new ByteArrayOutputStream();
			      ImageIO.write(img, "jpg", bos );
			  	  Image dimg = img.getScaledInstance(frame_Immagine_del_Profilo.getWidth(), frame_Immagine_del_Profilo.getHeight(), Image.SCALE_SMOOTH); 
				  ImageIcon imageIcon = new ImageIcon(dimg);
				  frame_Immagine_del_Profilo.setIcon(imageIcon);
				    } }
				catch (IOException e2) 
				{
				    e2.printStackTrace();
				}
				
			}}
		}); 
		
		// Listener di bottone_Annulla che libera tutti i campi della precedente
		// o tentata iscrizione e torna alla HomePage
		
		bottone_Annulla.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				password.setText("");
				nickname.setText("");
				email.setText("");
				cognome.setText("");
				city.setText("");
				
			controller.CambiaFrame(Iscrizione.this, controller.getHome());
				}
		});		

		// Listener di bottone_Iscriviti che crea una nuova istanza di Utente
		// nel database in base ai campi inseriti dall'utente durante l'iscrizione
		
		bottone_Iscriviti.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e ) {
				String nome1;
				String password1;
				String nickname1;
				String email1;
				String cognome1;
				String città1;
				
				if(nome.getText().isEmpty()) { 
				 nome1 = null;}
				else {nome1 = nome.getText();}
				
				if(password.getText().isEmpty()){
					password1 = null;} else {
						password1 = password.getText();
				}
				
				if(nickname.getText().isEmpty()) {
					nickname1 = null;}
				else {
				 nickname1 = nickname.getText();
				}
				
				if(email.getText().isEmpty()) {
					email1 = null;
				}else {
				email1 = email.getText();
				}
				
				if(cognome.getText().isEmpty()) {
					cognome1 = null;
				}else {
				cognome1 = cognome.getText();
				}

				if(city.getText().isEmpty()) {
					città1 = null;} 
				else {
				città1  = city.getText();}
				
				
				java.util.Date dataNascita = calendario.getDate();	
				java.sql.Date dataNascita1 = new java.sql.Date(dataNascita.getTime());
				
				
				controller.getUtenteDAO().addUtente(controller.getConnection(), nome1, password1, nickname1, email1, cognome1, dataNascita1, città1, imgpath);
				
			}
		});
	}
}