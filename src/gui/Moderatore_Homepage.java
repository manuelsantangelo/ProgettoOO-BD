package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Controller;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Moderatore_Homepage extends JFrame {
	
	private Controller controller;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;

	private JPanel contentPane;
	private JTextArea txtDomanda;
	private Font custom_font;
	private JButton btnAggiu;
	private JButton btnAggiungiRistorante;
	private JButton btnAggiungiAttrazione;
	private JButton btnEliminaHotel;
	private JButton btnEliminaRistorante;
	private JButton btnEliminaAttrazione;
	private JButton btnLogout;

	public Moderatore_Homepage(Controller controller) {
		
		this.controller = controller;
		
		// La parola moderatore va cambiata con il nome del moderatore preso da Postgresql
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("Benvenuto, Moderatore");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, (LUNGHEZZA_FINESTRA/2)+30, ALTEZZA_FINESTRA/2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			custom_font = Font.createFont(Font.TRUETYPE_FONT, new File("font\\Parametric Glitch Bold.ttf")).deriveFont(36f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font\\Parametric Glitch Bold.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		txtDomanda = new JTextArea();
		txtDomanda.setEditable(false);
		txtDomanda.setFont(custom_font);
		txtDomanda.setText("Cosa si desidera fare?");
		txtDomanda.setForeground(Color.GREEN);
		txtDomanda.setBackground(Color.BLACK);
		txtDomanda.setBounds(67, 22, 361, 54);
		contentPane.add(txtDomanda);
		txtDomanda.setColumns(10);
		
		JButton btnApprovarecensione = new JButton("Approva Recensione");
		btnApprovarecensione.setForeground(Color.GREEN);
		btnApprovarecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApprovarecensione.setBackground(Color.BLACK);
		btnApprovarecensione.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnApprovarecensione.setBounds(248, 87, 152, 47);
		contentPane.add(btnApprovarecensione);
		
		btnAggiu = new JButton("Aggiungi Hotel");
		btnAggiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Moderatore_Homepage.this, controller.getAggiungi_Hotel());	
			}
		});
		btnAggiu.setForeground(Color.GREEN);
		btnAggiu.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnAggiu.setBackground(Color.BLACK);
		btnAggiu.setBounds(10, 163, 152, 47);
		contentPane.add(btnAggiu);
		
		btnAggiungiRistorante = new JButton("Aggiungi Ristorante");
		btnAggiungiRistorante.setForeground(Color.GREEN);
		btnAggiungiRistorante.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnAggiungiRistorante.setBackground(Color.BLACK);
		btnAggiungiRistorante.setBounds(165, 163, 152, 47);
		contentPane.add(btnAggiungiRistorante);
		
		btnAggiungiAttrazione = new JButton("Aggiungi Attrazione");
		btnAggiungiAttrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Moderatore_Homepage.this, controller.getAggiungi_Attrazione());
			}
		});
		btnAggiungiAttrazione.setForeground(Color.GREEN);
		btnAggiungiAttrazione.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnAggiungiAttrazione.setBackground(Color.BLACK);
		btnAggiungiAttrazione.setBounds(320, 163, 152, 47);
		contentPane.add(btnAggiungiAttrazione);
		
		btnEliminaHotel = new JButton("Elimina Hotel");
		btnEliminaHotel.setForeground(Color.GREEN);
		btnEliminaHotel.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnEliminaHotel.setBackground(Color.BLACK);
		btnEliminaHotel.setBounds(10, 229, 152, 47);
		contentPane.add(btnEliminaHotel);
		
		btnEliminaRistorante = new JButton("Elimina Ristorante");
		btnEliminaRistorante.setForeground(Color.GREEN);
		btnEliminaRistorante.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnEliminaRistorante.setBackground(Color.BLACK);
		btnEliminaRistorante.setBounds(165, 229, 152, 47);
		contentPane.add(btnEliminaRistorante);
		
		btnEliminaAttrazione = new JButton("Elimina Attrazione");
		btnEliminaAttrazione.setForeground(Color.GREEN);
		btnEliminaAttrazione.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnEliminaAttrazione.setBackground(Color.BLACK);
		btnEliminaAttrazione.setBounds(320, 229, 152, 47);
		contentPane.add(btnEliminaAttrazione);
		
		btnLogout = new JButton("Log-out");
		btnLogout.setForeground(Color.GREEN);
		btnLogout.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		btnLogout.setBackground(Color.BLACK);
		btnLogout.setBounds(67, 87, 152, 47);
		contentPane.add(btnLogout);
		
		btnAggiungiRistorante.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(Moderatore_Homepage.this, controller.getAggiungi_Ristorante());
				}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(Moderatore_Homepage.this, controller.getHome());
				}
		});
	}
}
