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

@SuppressWarnings("serial")// Utilizzato per ignorare il warning che non crea problemi
public class Elimina_Ristorante extends JFrame {
	
	@SuppressWarnings("unused")
	private Controller controller;

	private JPanel contentPane;
	
	final static int FINESTRA_Y = 0;
	final static int FINESTRA_X = 25;
	static File imgpath = null;

	@SuppressWarnings({ "rawtypes", "unchecked" }) // Utilizzato per ignorare i warning che non creano problemi
	public Elimina_Ristorante (Controller controller) {
		
		this.controller = controller;

		setTitle("Elimina Ristorante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 600, 260);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea testo_Ristorante = new JTextArea();
		testo_Ristorante.setBackground(Color.BLACK);
		testo_Ristorante.setForeground(Color.GREEN);
		testo_Ristorante.setEditable(false);
		testo_Ristorante.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Ristorante.setText("Ristorante");
		testo_Ristorante.setBounds(24, 11, 114, 29);
		contentPane.add(testo_Ristorante);
		
		JComboBox ristoranti = new JComboBox();
		ristoranti.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		ristoranti.setBackground(new Color(20, 20, 20));
		ristoranti.setForeground(Color.GREEN);
		DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getRistoranteDAO().getNomeRistorante(controller.getConnection()).toArray());
		ristoranti.setModel(model);
		ristoranti.setBounds(24, 50, 173, 29);
		contentPane.add(ristoranti);
		
		JButton bottone_Elimina = new JButton("Elimina");
		bottone_Elimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Elimina.setForeground(Color.GREEN);
		bottone_Elimina.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Elimina.setBackground(Color.BLACK);
		bottone_Elimina.setBounds(281, 51, 117, 28);
		contentPane.add(bottone_Elimina);
		
		// bottone con il suo ActionListener che ha il compito
		// di farci tornare alla HomePage del Moderatore
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Elimina_Ristorante.this, controller.getModeratore_Homepage());
			}
		});
		bottone_Indietro.setForeground(Color.GREEN);
		bottone_Indietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Indietro.setBackground(Color.BLACK);
		bottone_Indietro.setBounds(281, 103, 117, 29);
		contentPane.add(bottone_Indietro);
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiornare la comboBox che elenca i Ristoranti
		
		JButton bottone_Aggiorna = new JButton("Aggiorna");
		bottone_Aggiorna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Aggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getRistoranteDAO().getNomeRistorante(controller.getConnection()).toArray());
				ristoranti.setModel(model);
			}
		});
		bottone_Aggiorna.setForeground(Color.GREEN);
		bottone_Aggiorna.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Aggiorna.setBackground(Color.BLACK);
		bottone_Aggiorna.setBounds(438, 50, 117, 29);
		contentPane.add(bottone_Aggiorna);	
		
		// ActionListener di bottone_Elimina che ha il compito
		// eliminare il Ristorante selezionato
		
		bottone_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = ristoranti.getSelectedItem().toString();
				controller.getRistoranteDAO().deleteRistorante(controller.getConnection(), nome);
				
			}});
}
}