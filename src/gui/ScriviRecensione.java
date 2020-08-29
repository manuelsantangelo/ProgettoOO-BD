package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logic.Controller;

public class ScriviRecensione extends JFrame {

	private JPanel contentPane;

	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	
	String nomeDaRecensire; //inizializziamo il nome della cosa che vogliamo recensire 

public ScriviRecensione(Controller controller) {
	setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
	setTitle("Recensione");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
	
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 191, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	

		
		JTextArea txtrDescrizione = new JTextArea();
		txtrDescrizione.setText("Recensione");
		txtrDescrizione.setForeground(Color.WHITE);
		txtrDescrizione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrDescrizione.setEditable(false);
		txtrDescrizione.setBackground(new Color(0, 191, 255));
		txtrDescrizione.setBounds(24, 459, 128, 29);
		contentPane.add(txtrDescrizione);
		
		JTextArea descrizione = new JTextArea();
		descrizione.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		descrizione.setForeground(Color.BLACK);
		descrizione.setLineWrap(true);
		descrizione.setBackground(Color.WHITE);
		descrizione.setBounds(10, 45, 664, 102);
		contentPane.add(descrizione);
		
		JScrollPane scrollPane = new JScrollPane(descrizione);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 499, 664, 102);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(descrizione);
		
		JButton btnaggiungirecensione = new JButton("Aggiungi recensione");
		btnaggiungirecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnaggiungirecensione.setForeground(Color.BLACK);
		btnaggiungirecensione.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		btnaggiungirecensione.setBackground(Color.WHITE);
		btnaggiungirecensione.setBounds(717, 554, 177, 47);
		contentPane.add(btnaggiungirecensione);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		lblFoto.setBounds(42, 23, 160, 160);
		contentPane.add(lblFoto);
		
		JComboBox valutazioneStelle = new JComboBox();

		valutazioneStelle.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		valutazioneStelle.setBackground(new Color(20, 20, 20));
		valutazioneStelle.setForeground(Color.BLUE);
		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"});
		valutazioneStelle.setModel(model);
		valutazioneStelle.setBounds(717, 498, 177, 29);
		contentPane.add(valutazioneStelle);
		
		JTextArea txtrvalutazioneStelle = new JTextArea();
		txtrvalutazioneStelle.setText("Stelle valutazione");
		txtrvalutazioneStelle.setForeground(Color.WHITE);
		txtrvalutazioneStelle.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		txtrvalutazioneStelle.setEditable(false);
		txtrvalutazioneStelle.setBackground(new Color(0, 191, 255));
		txtrvalutazioneStelle.setBounds(713, 458, 181, 29);
		contentPane.add(txtrvalutazioneStelle);

		btnaggiungirecensione.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String recensione = descrizione.getText();
				int stelle = valutazioneStelle.getSelectedIndex()+1;
				controller.getRecensioneDAO().addRecensione(controller.getConnection(), recensione, stelle);
				
				
			}});
		
}

		
		//---------------------------arrivare fino a sotto--------------------------------------------------------
		
		// ci servirà per mettere la foto dal database di quel determinato ristorante, attrazione o albergo aperto
		
	/*	byte[] imgBytes = controller.get
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblFoto.setIcon(imageIcon);
		*/
		
		
}

// RICHIAMIAMO IL METODO GET DAL CONTROLLER E LO CONFRONTIAMO CON TUTTI I VALORI DEL DATABASE TRA ALBERGO, RISTORANTE E ATTRAZIONE
// VA BENE COME METODO???? Chissà!!

/*public void controlloNomeDaRecensire(Controller controller) {
	if (controller.getNomeDaRecensire() == controller. {
		
	}
}
*/
	///--------------------------------------------------------------------------------------------------------------
	


