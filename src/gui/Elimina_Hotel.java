package gui;

	import java.awt.Color;
	import java.awt.Cursor;
	import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;

	import javax.swing.DefaultComboBoxModel;
	import javax.swing.DefaultListModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.border.EmptyBorder;

	import logic.Controller;

public class Elimina_Hotel extends JFrame {

	
		
		private Controller controller;

		private JPanel contentPane;
		
		final static int FINESTRA_Y = 0;
		final static int FINESTRA_X = 25;
		final static int ALTEZZA_FINESTRA = 690;
		final static int LUNGHEZZA_FINESTRA = 940;
		static File imgpath = null;

		
		
		private DefaultListModel dlm;
		private DefaultListModel dlm1;
		

	public Elimina_Hotel (Controller controller) {
			
	this.controller = controller;
			
			dlm = new DefaultListModel();
			dlm1 = new DefaultListModel();

			setTitle("Elimina hotel");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
			setBounds(FINESTRA_Y, FINESTRA_X, 605, 605);
			contentPane = new JPanel();
			contentPane.setForeground(Color.WHITE);
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JTextArea txtrHotel = new JTextArea();
			txtrHotel.setBackground(Color.BLACK);
			txtrHotel.setForeground(Color.GREEN);
			txtrHotel.setEditable(false);
			txtrHotel.setFont(new Font("Parametric Glitch", Font.BOLD, 21));
			txtrHotel.setText("Ristorante");
			txtrHotel.setBounds(24, 11, 114, 29);
			contentPane.add(txtrHotel);
			
			
			JComboBox hotel = new JComboBox();

			hotel.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
			hotel.setBackground(new Color(20, 20, 20));
			hotel.setForeground(Color.GREEN);
			DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getAlbergoDAO().getNomeAlbergo(controller.getConnection()).toArray());
			hotel.setModel(model);
			hotel.setBounds(24, 50, 173, 29);
			contentPane.add(hotel);
			
			JButton btnElimina = new JButton("Elimina");
			btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnElimina.setForeground(Color.GREEN);
			btnElimina.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
			btnElimina.setBackground(Color.BLACK);
			btnElimina.setBounds(281, 51, 117, 28);
			contentPane.add(btnElimina);
			
			JButton btnIndietro = new JButton("Indietro");
			btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnIndietro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.CambiaFrame(Elimina_Hotel.this, controller.getModeratore_Homepage());
				}
			});
			btnIndietro.setForeground(Color.GREEN);
			btnIndietro.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
			btnIndietro.setBackground(Color.BLACK);
			btnIndietro.setBounds(281, 103, 117, 29);
			contentPane.add(btnIndietro);
			
			
			JButton btnAggiorna = new JButton("Aggiorna");
			btnAggiorna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAggiorna.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultComboBoxModel model = new DefaultComboBoxModel(controller.getAlbergoDAO().getNomeAlbergo(controller.getConnection()).toArray());
					hotel.setModel(model);

				
				}
			});
			btnAggiorna.setForeground(Color.GREEN);
			btnAggiorna.setFont(new Font("Parametric Glitch", Font.PLAIN, 14));
			btnAggiorna.setBackground(Color.BLACK);
			btnAggiorna.setBounds(438, 50, 117, 29);
			contentPane.add(btnAggiorna);
			
		
			
				
			
			btnElimina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String nome = hotel.getSelectedItem().toString();
		
					controller.getAlbergoDAO().deleteAlbergo(controller.getConnection(), nome);
					
				}});
	}
	}




