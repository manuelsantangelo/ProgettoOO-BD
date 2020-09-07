package gui;

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

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import javax.swing.JTextArea;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Moderatore_Homepage extends JFrame {
	
	@SuppressWarnings("unused")
	private Controller controller;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;

	private JPanel contentPane;
	private JTextArea testo_Domanda;
	private Font custom_font;
	private JButton bottone_Aggiungi_Hotel;
	private JButton bottone_Aggiungi_Ristorante;
	private JButton bottone_Aggiungi_Attrazione;
	private JButton bottone_Elimina_Hotel;
	private JButton bottone_Elimina_Ristorante;
	private JButton bottone_Elimina_Attrazione;
	private JButton bottone_logout;

	public Moderatore_Homepage(Controller controller) {
		
		this.controller = controller;
		
		
		// La parola moderatore va cambiata con il nome del moderatore preso da Postgresql
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));

		setTitle("Benvenuto, "+ controller.getModeratoreDAO().getModeratore().getNome());
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
		
		testo_Domanda = new JTextArea();
		testo_Domanda.setEditable(false);
		testo_Domanda.setFont(custom_font);
		testo_Domanda.setText("Cosa si desidera fare?");
		testo_Domanda.setForeground(Color.GREEN);
		testo_Domanda.setBackground(Color.BLACK);
		testo_Domanda.setBounds(67, 22, 361, 54);
		contentPane.add(testo_Domanda);
		testo_Domanda.setColumns(10);
		
		JButton bottone_ApprovaRecensione = new JButton("Approva Recensione");
		bottone_ApprovaRecensione.setForeground(Color.GREEN);
		bottone_ApprovaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_ApprovaRecensione.setBackground(Color.BLACK);
		bottone_ApprovaRecensione.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_ApprovaRecensione.setBounds(248, 87, 160, 47);
		contentPane.add(bottone_ApprovaRecensione);
		
		bottone_Aggiungi_Hotel = new JButton("Aggiungi Hotel");
		bottone_Aggiungi_Hotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Moderatore_Homepage.this, controller.getAggiungi_Hotel());	
			}
		});
		bottone_Aggiungi_Hotel.setForeground(Color.GREEN);
		bottone_Aggiungi_Hotel.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_Aggiungi_Hotel.setBackground(Color.BLACK);
		bottone_Aggiungi_Hotel.setBounds(10, 163, 152, 47);
		contentPane.add(bottone_Aggiungi_Hotel);
		
		bottone_Aggiungi_Ristorante = new JButton("Aggiungi Ristorante");
		bottone_Aggiungi_Ristorante.setForeground(Color.GREEN);
		bottone_Aggiungi_Ristorante.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_Aggiungi_Ristorante.setBackground(Color.BLACK);
		bottone_Aggiungi_Ristorante.setBounds(165, 163, 152, 47);
		contentPane.add(bottone_Aggiungi_Ristorante);
		
		bottone_Aggiungi_Attrazione = new JButton("Aggiungi Attrazione");
		bottone_Aggiungi_Attrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Moderatore_Homepage.this, controller.getAggiungi_Attrazione());
			}
		});
		bottone_Aggiungi_Attrazione.setForeground(Color.GREEN);
		bottone_Aggiungi_Attrazione.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_Aggiungi_Attrazione.setBackground(Color.BLACK);
		bottone_Aggiungi_Attrazione.setBounds(320, 163, 152, 47);
		contentPane.add(bottone_Aggiungi_Attrazione);
		
		bottone_Elimina_Hotel = new JButton("Elimina Hotel");
		bottone_Elimina_Hotel.setForeground(Color.GREEN);
		bottone_Elimina_Hotel.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_Elimina_Hotel.setBackground(Color.BLACK);
		bottone_Elimina_Hotel.setBounds(10, 229, 152, 47);
		contentPane.add(bottone_Elimina_Hotel);
		
		bottone_Elimina_Ristorante = new JButton("Elimina Ristorante");
		bottone_Elimina_Ristorante.setForeground(Color.GREEN);
		bottone_Elimina_Ristorante.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_Elimina_Ristorante.setBackground(Color.BLACK);
		bottone_Elimina_Ristorante.setBounds(165, 229, 152, 47);
		contentPane.add(bottone_Elimina_Ristorante);
		
		bottone_Elimina_Attrazione = new JButton("Elimina Attrazione");
		bottone_Elimina_Attrazione.setForeground(Color.GREEN);
		bottone_Elimina_Attrazione.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_Elimina_Attrazione.setBackground(Color.BLACK);
		bottone_Elimina_Attrazione.setBounds(320, 229, 152, 47);
		contentPane.add(bottone_Elimina_Attrazione);
		
		bottone_logout = new JButton("Log-out");
		bottone_logout.setForeground(Color.GREEN);
		bottone_logout.setFont(new Font("Parametric Glitch", Font.BOLD, 14));
		bottone_logout.setBackground(Color.BLACK);
		bottone_logout.setBounds(67, 87, 152, 47);
		contentPane.add(bottone_logout);
		
		bottone_Aggiungi_Ristorante.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(Moderatore_Homepage.this, controller.getAggiungi_Ristorante());
				}
		});
		
		bottone_logout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(Moderatore_Homepage.this, controller.getHome());
				}
		});
		
bottone_Elimina_Attrazione.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			controller.CambiaFrame(Moderatore_Homepage.this, controller.getElimina_Attrazione());
				}
		});

bottone_Elimina_Ristorante.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
	controller.CambiaFrame(Moderatore_Homepage.this, controller.getElimina_Ristorante());
		}
});

bottone_Elimina_Hotel.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
	controller.CambiaFrame(Moderatore_Homepage.this, controller.getElimina_Hotel());
		}
});

bottone_ApprovaRecensione.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		controller.CambiaFrame(Moderatore_Homepage.this, controller.getApprovaRecensione());
	}
	
	
});
	}
}
