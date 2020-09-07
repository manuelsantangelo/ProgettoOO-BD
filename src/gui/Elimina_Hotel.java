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
	public class Elimina_Hotel extends JFrame {

	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;
		
	final static int FINESTRA_Y = 0;
	final static int FINESTRA_X = 25;
	static File imgpath = null;

	@SuppressWarnings({ "rawtypes", "unchecked" }) // Utilizzati per ignorare i warning che non creano problemi
	public Elimina_Hotel (Controller controller) {
			
		this.controller = controller;

		setTitle("Elimina Hotel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setBounds(FINESTRA_Y, FINESTRA_X, 600, 260);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea testo_Hotel = new JTextArea();
		testo_Hotel.setBackground(Color.BLACK);
		testo_Hotel.setForeground(Color.GREEN);
		testo_Hotel.setEditable(false);
		testo_Hotel.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
		testo_Hotel.setText("Hotel");
		testo_Hotel.setBounds(24, 11, 114, 29);
		contentPane.add(testo_Hotel);
		
		JComboBox hotel = new JComboBox();
		hotel.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		hotel.setBackground(new Color(20, 20, 20));
		hotel.setForeground(Color.GREEN);
		DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getAlbergoDAO().getNomeAlbergo(controller.getConnection()).toArray());
		hotel.setModel(model);
		hotel.setBounds(24, 50, 173, 29);
		contentPane.add(hotel);
		
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
				controller.CambiaFrame(Elimina_Hotel.this, controller.getModeratore_Homepage());
				}
			});
		bottone_Indietro.setForeground(Color.GREEN);
		bottone_Indietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Indietro.setBackground(Color.BLACK);
		bottone_Indietro.setBounds(281, 103, 117, 29);
		contentPane.add(bottone_Indietro);
		
		// bottone con il suo ActionListener che ha il compito
		// di aggiornare la comboBox che elenca gli Hotel
				
		JButton bottone_Aggiorna = new JButton("Aggiorna");
		bottone_Aggiorna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Aggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getAlbergoDAO().getNomeAlbergo(controller.getConnection()).toArray());
				hotel.setModel(model);
				}
			});
		bottone_Aggiorna.setForeground(Color.GREEN);
		bottone_Aggiorna.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
		bottone_Aggiorna.setBackground(Color.BLACK);
		bottone_Aggiorna.setBounds(438, 50, 117, 29);
		contentPane.add(bottone_Aggiorna);
		
		// ActionListener di bottone_Elimina che ha il compito
		// eliminare l'Hotel selezionato
		
		bottone_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				String nome = hotel.getSelectedItem().toString();
				controller.getAlbergoDAO().deleteAlbergo(controller.getConnection(), nome);
					
				}});
	}
}