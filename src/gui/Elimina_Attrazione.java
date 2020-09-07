package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logic.Controller;

@SuppressWarnings("serial")
public class Elimina_Attrazione extends JFrame {

	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;

	final static int FINESTRA_Y = 0;
	final static int FINESTRA_X = 25;
	static File imgpath = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })// Utilizzato per ignorare il warning che non crea problemi
	public Elimina_Attrazione(Controller controller) {
		
		this.controller = controller;

		setTitle("Elimina Attrazione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 600, 260);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea testo_Attrazione = new JTextArea();
		testo_Attrazione.setBackground(Color.BLACK);
		testo_Attrazione.setForeground(Color.GREEN);
		testo_Attrazione.setEditable(false);
		testo_Attrazione.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Attrazione.setText("Attrazione");
		testo_Attrazione.setBounds(24, 11, 114, 29);
		contentPane.add(testo_Attrazione);
		

		//combobox contenente le attrazioni presenti nel database 
		//e che possono essere eliminate
		
		JComboBox nomeAttrazioni = new JComboBox();
		nomeAttrazioni.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		nomeAttrazioni.setBackground(new Color(20, 20, 20));
		nomeAttrazioni.setForeground(Color.GREEN);
		DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getAttrazioneDAO().getNomeAttrazione(controller.getConnection()).toArray());
		nomeAttrazioni.setModel(model);
		nomeAttrazioni.setBounds(24, 50, 173, 29);
		contentPane.add(nomeAttrazioni);

		
		// bottone utilizzato in seguito per eliminare un attrazione
		JButton bottone_Elimina = new JButton("Elimina");
		bottone_Elimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Elimina.setForeground(Color.GREEN);
		bottone_Elimina.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Elimina.setBackground(Color.BLACK);
		bottone_Elimina.setBounds(281, 51, 117, 28);
		contentPane.add(bottone_Elimina);

		
		// bottone con il suo ActionListener che ha il compito
		// di farci tornare alla homepage del moderatore
		JButton bottone_indietro = new JButton("Indietro");
		bottone_indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_indietro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Elimina_Attrazione.this, controller.getModeratore_Homepage());
			}
		});
 
		bottone_indietro.setForeground(Color.GREEN);
		bottone_indietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_indietro.setBackground(Color.BLACK);
		bottone_indietro.setBounds(281, 103, 117, 29);
		contentPane.add(bottone_indietro);

	
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiornare la comboBox che elenca le attrazioni
		JButton bottone_aggiorna = new JButton("Aggiorna");
		bottone_aggiorna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_aggiorna.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getAttrazioneDAO().getNomeAttrazione(controller.getConnection()).toArray());
				nomeAttrazioni.setModel(model);

			

			}
		});
 
		bottone_aggiorna.setForeground(Color.GREEN);
		bottone_aggiorna.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_aggiorna.setBackground(Color.BLACK);
		bottone_aggiorna.setBounds(438, 50, 117, 29);
		contentPane.add(bottone_aggiorna);

	

	
		// bottone con il suo ActionListener che ha il compito
		// eliminare l'attrazione selezionata
		bottone_Elimina.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeAttrazioni.getSelectedItem().toString();
	
				controller.getAttrazioneDAO().deleteAttrazione(controller.getConnection(), nome);
				
			}});
}
}
