package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Controller;
import logic.Classi.Albergo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Principale extends JFrame {
	
	private Controller controller;


	private JFrame frame;
	private JPanel contentPane;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	private JTable elementi;
	
	private ArrayList<Albergo> listaAlberghi = new ArrayList<Albergo>();
	

	public Principale(Controller controller) throws IOException{
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("SafeTravel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//https://stackoverflow.com/questions/22371720/how-to-add-row-dynamically-in-jtable
		
		
		
		
		
	
		
		
		
		JButton cerca = new JButton("Cerca");
		cerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cerca.setForeground(Color.BLACK);
		cerca.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		cerca.setBackground(Color.WHITE);
		cerca.setBounds(729, 82, 117, 28);
		contentPane.add(cerca);
		
		JButton btnIndietro = new JButton("Logout");
		btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Principale.this, controller.getHome());
			}
		});
		btnIndietro.setForeground(Color.CYAN);
		btnIndietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnIndietro.setBackground(Color.RED);
		btnIndietro.setBounds(759, 553, 117, 29);
		contentPane.add(btnIndietro);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 312, 651);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeECognome = new JLabel(controller.getUtenteDAO().getUtente().getNome() + " " + controller.getUtenteDAO().getUtente().getCognome());
		lblNomeECognome.setFont(new Font("Gadugi", Font.BOLD, 21));
		lblNomeECognome.setBounds(42, 203, 244, 35);
		lblNomeECognome.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNomeECognome);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lblFoto.setBounds(42, 23, 160, 160);
		panel.add(lblFoto);
		
		byte[] imgBytes = controller.getUtenteDAO().getUtente().getPropic();
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblFoto.setIcon(imageIcon);
		
		JLabel lblNickname = new JLabel(controller.getUtenteDAO().getUtente().getNickname());
		lblNickname.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNickname.setAlignmentX(0.5f);
		lblNickname.setBounds(42, 229, 194, 35);
		panel.add(lblNickname);
		
		JLabel lblEmail = new JLabel(controller.getUtenteDAO().getUtente().getEmail());
		lblEmail.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(42, 250, 194, 35);
		panel.add(lblEmail);
		
		JLabel lblDataDiIscrizione = new JLabel("Data di Iscrizione: " + controller.getUtenteDAO().getUtente().getData_Iscrizione());
		lblDataDiIscrizione.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblDataDiIscrizione.setAlignmentX(0.5f);
		lblDataDiIscrizione.setBounds(42, 296, 244, 35);
		panel.add(lblDataDiIscrizione);
		
		JLabel lblDescrizioniEffettuate = new JLabel("Descrizioni effettuate: " + controller.getUtenteDAO().getUtente().getContributi());
		lblDescrizioniEffettuate.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblDescrizioniEffettuate.setAlignmentX(0.5f);
		lblDescrizioniEffettuate.setBounds(42, 320, 194, 35);
		panel.add(lblDescrizioniEffettuate);
		
		JComboBox attrazioneristorantehotel = new JComboBox();

		attrazioneristorantehotel.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		attrazioneristorantehotel.setBackground(Color.WHITE);
		attrazioneristorantehotel.setForeground(Color.BLACK);
		String [] tipi = {"Attrazione","Ristorante","Albergo"};
		DefaultComboBoxModel model = new DefaultComboBoxModel(tipi);
		attrazioneristorantehotel.setModel(model);
		attrazioneristorantehotel.setBounds(332, 81, 173, 29);
		contentPane.add(attrazioneristorantehotel);
		
	
		cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = attrazioneristorantehotel.getSelectedItem().toString();
	
				if(nome == "Attrazione") {
				
				}else if(nome == "Ristorante"){
					
				}else if(nome == "Albergo") {
					listaAlberghi = controller.getAlberghi();
					System.out.println(listaAlberghi.size());
					riempitabella();
				}
			}});
	}
	
	public void riempitabella() {
		elementi = new JTable();
		elementi.setBackground(Color.WHITE);
		elementi.setFont(new Font("Gadugi", Font.PLAIN, 14));
		DefaultTableModel dtm = new DefaultTableModel(0,0);
		
		String nomeColonne[] = new String[] { "Nome albergo", "Stelle" };
	    elementi.setModel(dtm);
		dtm.setColumnIdentifiers(nomeColonne);
		elementi.setBounds(332, 148, 514, 304);
		contentPane.add(elementi);
		
		JScrollPane scrollPane = new JScrollPane(elementi);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBounds(332, 194, 563, 316);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(elementi);
		
		int i = 0;
	do {
		
		
			dtm.addRow(new Object[] {
					listaAlberghi.get(i).getNome(), listaAlberghi.get(i).getStelle(),
			});
			i++;
		}while(listaAlberghi.size() != i);
		
	}
}
