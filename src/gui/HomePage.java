package gui;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logic.Controller;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JTextArea;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class HomePage extends JFrame {
	
	@SuppressWarnings("unused")
	private Controller controller;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	private JPanel contentPane;
	private JTextField nickname;
	private JPasswordField password;

	public HomePage(Controller controller) {
		
		this.controller = controller;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("SafeTravel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo_image = new JLabel("New label");
		logo_image.setIcon(new ImageIcon("images\\Corretto.png"));
		logo_image.setBounds(10, 49, 468, 315);
		contentPane.add(logo_image);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(507, 0, 677, 651);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel testo_Accedi = new JLabel("Accedi");
		testo_Accedi.setFont(new Font("Gadugi", Font.BOLD, 40));
		testo_Accedi.setBounds(72, 45, 133, 63);
		panel.add(testo_Accedi);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBackground(new Color(153, 204, 255));
		password.setFont(new Font("Gadugi", Font.BOLD, 30));
		password.setBounds(20, 326, 337, 53);
		panel.add(password);
		password.setColumns(10);
		
		JLabel testo_Nickname = new JLabel("Nickname");
		testo_Nickname.setFont(new Font("Gadugi", Font.BOLD, 25));
		testo_Nickname.setBounds(52, 151, 153, 34);
		panel.add(testo_Nickname);
		
		nickname = new JTextField();
		nickname.setBackground(new Color(153, 204, 255));
		nickname.setFont(new Font("Gadugi", Font.BOLD, 30));
		nickname.setBounds(20, 199, 337, 53);
		panel.add(nickname);
		nickname.setColumns(10);
		
		JLabel testo_Password = new JLabel("Password");
		testo_Password.setFont(new Font("Gadugi", Font.BOLD, 25));
		testo_Password.setBounds(52, 281, 153, 34);
		panel.add(testo_Password);
		
		// CheckBox con il suo Listener che ha il compito
		// di mostrare o nascondere la password, sostituendo 
		// ogni carattere con '*'
		
		JCheckBox check_Box_Mostra_Password = new JCheckBox("Mostra Password");
		check_Box_Mostra_Password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check_Box_Mostra_Password.isSelected()) {
					password.setEchoChar((char)0);
				}else {
					password.setEchoChar('*');
				}
			}
		});
		check_Box_Mostra_Password.setHorizontalAlignment(SwingConstants.LEFT);
		check_Box_Mostra_Password.setBackground(new Color(0, 153, 255));
		check_Box_Mostra_Password.setFont(new Font("Gadugi", Font.BOLD, 13));
		check_Box_Mostra_Password.setBounds(20, 388, 133, 23);
		panel.add(check_Box_Mostra_Password);
		
		// Bottone con il suo Listener che una volta premuto
		// attraverso la chiamata di alcune funzioni delle DAO
		// tramite il controller, controllano se il i campi nickname
		// e password corrispondono a un Moderatore o a un Utente
		// e successivamente passano al frame successivo adeguato
		// (Principale per Utente e HomePage_Moderatore per un 
	    // Moderatore)
		
		Button tasto_di_accesso = new Button("Accedi");
		tasto_di_accesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nick = nickname.getText();
				@SuppressWarnings("deprecation")
				String pass = password.getText();
				boolean flagMod = false;
				boolean flagUser = false;
				
				flagMod = controller.getModeratoreDAO().checkModeratore(controller.getConnection(), nick, pass);
				flagUser = controller.getUtenteDAO().checkUtente(controller.getConnection(), nick, pass);
				
				if(flagMod) {
				controller.getModeratoreDAO().setModeratore(controller.getModeratoreDAO().getThisModeratore(controller.getConnection(), nick, pass));
				nickname.setText("");
				password.setText("");
				controller.CambiaFrame(HomePage.this, controller.getModeratore_Homepage());
				}else if (flagUser) {
					controller.getUtenteDAO().setUtente(controller.getUtenteDAO().getThisUtente(controller.getConnection(), nick, pass));
						nickname.setText("");
						password.setText("");
					try {
							controller.CambiaFrame(HomePage.this, controller.getPrincipale());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} 
				
				else {
					JOptionPane.showMessageDialog(null, "Per accedere devi iscriverti. Non sei ne un utente ne un moderatore!");
				}
			}
		});
		tasto_di_accesso.setBounds(38, 455, 185, 45);
		panel.add(tasto_di_accesso);
		tasto_di_accesso.setBackground(new Color(0, 204, 255));
		tasto_di_accesso.setForeground(new Color(51, 51, 51));
		tasto_di_accesso.setFont(new Font("Gadugi", Font.BOLD, 18));
		tasto_di_accesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Button tasto_di_iscrizione = new Button("Iscriviti!");
		tasto_di_iscrizione.setBackground(new Color(0, 153, 204));
		tasto_di_iscrizione.setForeground(new Color(51, 51, 51));
		tasto_di_iscrizione.setFont(new Font("Gadugi", Font.BOLD, 18));
		tasto_di_iscrizione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tasto_di_iscrizione.setBounds(65, 455, 185, 45);
		contentPane.add(tasto_di_iscrizione);
		
		JTextArea piccola_Descrizione = new JTextArea();
		piccola_Descrizione.setLineWrap(true);
		piccola_Descrizione.setEditable(false);
		piccola_Descrizione.setForeground(new Color(51, 51, 51));
		piccola_Descrizione.setFont(new Font("Gadugi", Font.BOLD, 15));
		piccola_Descrizione.setBackground(new Color(0, 191, 255));
		piccola_Descrizione.setText("Se non sei ancora iscritto che aspetti?\r\nCi vogliono solo 5 minuti!");
		piccola_Descrizione.setBounds(65, 387, 278, 56);
		contentPane.add(piccola_Descrizione);
		
		// Listener del tasto_di_iscrizione che ha il compito di passare
		// dalla HomePage alla finestra di Iscrizione
		
		tasto_di_iscrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(HomePage.this, controller.getIscrizione());
				}
		});
	}
}
