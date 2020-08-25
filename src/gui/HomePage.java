package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

//Se vedi questo commento allora la commit è avvenuta con successo

public class HomePage extends JFrame {
	
	private Controller controller;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

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
		
		JLabel lblAccedi = new JLabel("Accedi");
		lblAccedi.setFont(new Font("Gadugi", Font.BOLD, 40));
		lblAccedi.setBounds(72, 45, 133, 63);
		panel.add(lblAccedi);
		
		textField_1 = new JPasswordField();
		textField_1.setEchoChar('*');
		textField_1.setBackground(new Color(153, 204, 255));
		textField_1.setFont(new Font("Gadugi", Font.BOLD, 30));
		textField_1.setBounds(20, 326, 337, 53);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Gadugi", Font.BOLD, 25));
		lblNickname.setBounds(52, 151, 153, 34);
		panel.add(lblNickname);
		
		textField = new JTextField();
		textField.setBackground(new Color(153, 204, 255));
		textField.setFont(new Font("Gadugi", Font.BOLD, 30));
		textField.setBounds(20, 199, 337, 53);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 25));
		lblPassword.setBounds(52, 281, 153, 34);
		panel.add(lblPassword);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostra Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					textField_1.setEchoChar((char)0);
				}else {
					textField_1.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxNewCheckBox.setBackground(new Color(0, 153, 255));
		chckbxNewCheckBox.setFont(new Font("Gadugi", Font.BOLD, 13));
		chckbxNewCheckBox.setBounds(20, 388, 133, 23);
		panel.add(chckbxNewCheckBox);
		
		Button tasto_di_accesso = new Button("Accedi");
		tasto_di_accesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nick = textField.getText();
				@SuppressWarnings("deprecation")
				String pass = textField_1.getText();
				boolean flagMod = false;
				boolean flagUser = false;
				
				
				flagMod = controller.getModeratoreDAO().checkModeratore(controller.getConnection(), nick, pass);
				if(flagMod)
					controller.CambiaFrame(HomePage.this, controller.getModeratore_Homepage());
	
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
		
		JTextArea txtrSeNonSei = new JTextArea();
		txtrSeNonSei.setLineWrap(true);
		txtrSeNonSei.setEditable(false);
		txtrSeNonSei.setForeground(new Color(51, 51, 51));
		txtrSeNonSei.setFont(new Font("Gadugi", Font.BOLD, 15));
		txtrSeNonSei.setBackground(new Color(0, 191, 255));
		txtrSeNonSei.setText("Se non sei ancora iscritto che aspetti?\r\nCi vogliono solo 5 minuti!");
		txtrSeNonSei.setBounds(65, 387, 278, 56);
		contentPane.add(txtrSeNonSei);
		
		tasto_di_iscrizione.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(HomePage.this, controller.getIscrizione());
				}
		});
		
		controller.getModeratoreDAO().getModeratore();
	}

}
