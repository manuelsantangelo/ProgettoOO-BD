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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Controller;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class Principale extends JFrame {
	
	private Controller controller;


	private JFrame frame;
	private JPanel contentPane;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	private JTable table_1;
	

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
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
	
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBounds(332, 194, 563, 316);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table_1);
		
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
		lblFoto.setBounds(42, 23, 213, 169);
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
		
	}
}
