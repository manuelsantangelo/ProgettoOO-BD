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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logic.Controller;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial") // Utilizzato per ignorare il warning che non crea problemi
public class Principale extends JFrame {
	
	@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
	private Controller controller;

	private JPanel contentPane;
	
	final static int FINESTRA_Y = 80;
	final static int FINESTRA_X = 25;
	final static int ALTEZZA_FINESTRA = 690;
	final static int LUNGHEZZA_FINESTRA = 940;
	private JTable tabellaPrincipale = new JTable();
	private JTextArea testo_Domanda;

    //Impostiamo le righe e colonne della JTable
    //cliccabili ma non modificabili
	static DefaultTableModel dtm = new DefaultTableModel(0,0){     
		@Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};	
	
	static int lista = 0; 
	private JTextField scrivi_Nome_per_ricerca;
	private JTextField scrivi_Stato_per_ricerca;
	private JTextField scrivi_Città_per_ricerca;
	private JTextField scrivi_Provincia_per_ricerca;
	
	@SuppressWarnings("unchecked")// Utilizzato per ignorare il warning che non crea problemi
	public Principale(Controller controller) throws IOException{
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setTitle("Benvenuto " + controller.getUtenteDAO().getUtente().getNome() + " " + controller.getUtenteDAO().getUtente().getCognome());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(FINESTRA_Y, FINESTRA_X, LUNGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton bottone_cerca = new JButton("Cerca");
		bottone_cerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_cerca.setForeground(Color.BLACK);
		bottone_cerca.setFont(new Font("Gadugi", Font.BOLD, 16));
		bottone_cerca.setBackground(Color.WHITE);
		bottone_cerca.setBounds(777, 534, 117, 28);
		contentPane.add(bottone_cerca);
		
		JPanel pannello_laterale = new JPanel();
		pannello_laterale.setForeground(new Color(0, 0, 0));
		pannello_laterale.setBackground(new Color(0, 153, 255));
		pannello_laterale.setBounds(0, 0, 312, 651);
		contentPane.add(pannello_laterale);
		pannello_laterale.setLayout(null);
		
		JLabel label_nome_cognome = new JLabel(controller.getUtenteDAO().getUtente().getNome() + " " + controller.getUtenteDAO().getUtente().getCognome());
		label_nome_cognome.setFont(new Font("Gadugi", Font.BOLD, 21));
		label_nome_cognome.setBounds(42, 203, 244, 35);
		label_nome_cognome.setAlignmentX(Component.CENTER_ALIGNMENT);
		pannello_laterale.add(label_nome_cognome);
		
		JLabel label_per_foto = new JLabel("foto");
		label_per_foto.setBorder(new LineBorder(new Color(0, 191, 255), 2, true));
		label_per_foto.setBounds(42, 23, 160, 160);
		pannello_laterale.add(label_per_foto);
		
		byte[] imgBytes = controller.getUtenteDAO().getUtente().getPropic();
		ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
	    BufferedImage bImage = ImageIO.read(bis);
	    Image dimg = bImage.getScaledInstance(label_per_foto.getWidth(), label_per_foto.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon imageIcon = new ImageIcon(dimg);
		label_per_foto.setIcon(imageIcon);
		
		JLabel label_per_nickname = new JLabel(controller.getUtenteDAO().getUtente().getNickname());
		label_per_nickname.setFont(new Font("Gadugi", Font.BOLD, 17));
		label_per_nickname.setAlignmentX(0.5f);
		label_per_nickname.setBounds(42, 229, 244, 35);
		pannello_laterale.add(label_per_nickname);
		
		JLabel label_per_email = new JLabel(controller.getUtenteDAO().getUtente().getEmail());
		label_per_email.setFont(new Font("Gadugi", Font.BOLD, 17));
		label_per_email.setAlignmentX(0.5f);
		label_per_email.setBounds(42, 250, 260, 35);
		pannello_laterale.add(label_per_email);
		
		JLabel label_per_data_di_iscrizione = new JLabel("Data di Iscrizione: " + controller.getUtenteDAO().getUtente().getData_Iscrizione());
		label_per_data_di_iscrizione.setFont(new Font("Gadugi", Font.BOLD, 17));
		label_per_data_di_iscrizione.setAlignmentX(0.5f);
		label_per_data_di_iscrizione.setBounds(42, 296, 244, 35);
		pannello_laterale.add(label_per_data_di_iscrizione);
		
		JLabel label_per_recensioni_effettuate = new JLabel("Recensioni effettuate: " + controller.getUtenteDAO().getUtente().getContributi());
		label_per_recensioni_effettuate.setFont(new Font("Gadugi", Font.BOLD, 17));
		label_per_recensioni_effettuate.setAlignmentX(0.5f);
		label_per_recensioni_effettuate.setBounds(42, 320, 235, 35);
		pannello_laterale.add(label_per_recensioni_effettuate);
		
		//Bottone che con il suo ActionListener ha il compito di
		//passare dalla finestra Principale alla HomePage
		JButton bottone_Logout = new JButton("Logout");
		bottone_Logout.setBounds(93, 506, 117, 29);
		pannello_laterale.add(bottone_Logout);
		bottone_Logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CambiaFrame(Principale.this, controller.getHome());
			}
		});
		bottone_Logout.setForeground(new Color(0, 0, 0));
		bottone_Logout.setFont(new Font("Gadugi", Font.BOLD, 15));
		bottone_Logout.setBackground(new Color(0, 153, 255));
		
		
		testo_Domanda = new JTextArea();
		testo_Domanda.setEditable(false);
		testo_Domanda.setFont(new Font("Gadugi", Font.BOLD, 30));
		testo_Domanda.setText("Cosa si desidera recensire?");
		testo_Domanda.setForeground(new Color(0, 0, 0));
		testo_Domanda.setBackground(new Color(0, 191, 255));
		testo_Domanda.setBounds(417, 10, 391, 54);
		contentPane.add(testo_Domanda);
		testo_Domanda.setColumns(10);
		
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		JComboBox selezione_per_ricerca = new JComboBox();
		selezione_per_ricerca.setFont(new Font("Parametric Glitch", Font.PLAIN, 16));
		selezione_per_ricerca.setBackground(Color.WHITE);
		selezione_per_ricerca.setForeground(Color.BLACK);
		String [] tipi = {"Attrazione","Ristorante","Albergo"};
		@SuppressWarnings("rawtypes") // Utilizzato per ignorare il warning che non crea problemi
		DefaultComboBoxModel model = new DefaultComboBoxModel(tipi);
		selezione_per_ricerca.setModel(model);
		selezione_per_ricerca.setBounds(332, 81, 117, 29);
		contentPane.add(selezione_per_ricerca);
		
		
		tabellaPrincipale.setSelectionBackground(UIManager.getColor("Table.selectionBackground"));
		tabellaPrincipale.setRowHeight(25);
		tabellaPrincipale.setBackground(new Color(255, 255, 255));
		tabellaPrincipale.setFont(new Font("Gadugi", Font.PLAIN, 18));
		String nomeColonne[] = new String[] { "Nome", "Città", "Voto" };
	    tabellaPrincipale.setModel(dtm);
	    dtm.setColumnIdentifiers(nomeColonne);
		tabellaPrincipale.setBounds(332, 148, 514, 304);
		contentPane.add(tabellaPrincipale);
		
		JScrollPane scrollPane_tabellaPrincipale = new JScrollPane(tabellaPrincipale);
		scrollPane_tabellaPrincipale.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane_tabellaPrincipale.setBounds(332, 194, 563, 316);
		contentPane.add(scrollPane_tabellaPrincipale);
		scrollPane_tabellaPrincipale.setViewportView(tabellaPrincipale);
		
		JTextArea testo_Nome = new JTextArea();
		testo_Nome.setText("Nome\r\n");
		testo_Nome.setForeground(Color.BLACK);
		testo_Nome.setFont(new Font("Gadugi", Font.BOLD, 17));
		testo_Nome.setEditable(false);
		testo_Nome.setColumns(10);
		testo_Nome.setBackground(new Color(0, 191, 255));
		testo_Nome.setBounds(332, 125, 60, 29);
		contentPane.add(testo_Nome);
		
		scrivi_Nome_per_ricerca = new JTextField();
		scrivi_Nome_per_ricerca.setFont(new Font("Gadugi", Font.BOLD, 14));
		scrivi_Nome_per_ricerca.setBounds(389, 130, 173, 20);
		contentPane.add(scrivi_Nome_per_ricerca);
		scrivi_Nome_per_ricerca.setColumns(10);
		
		JTextArea testo_Stato = new JTextArea();
		testo_Stato.setText("Stato\r\n");
		testo_Stato.setForeground(Color.BLACK);
		testo_Stato.setFont(new Font("Gadugi", Font.BOLD, 17));
		testo_Stato.setEditable(false);
		testo_Stato.setColumns(10);
		testo_Stato.setBackground(new Color(0, 191, 255));
		testo_Stato.setBounds(332, 154, 60, 29);
		contentPane.add(testo_Stato);
		
		scrivi_Stato_per_ricerca = new JTextField();
		scrivi_Stato_per_ricerca.setFont(new Font("Gadugi", Font.BOLD, 14));
		scrivi_Stato_per_ricerca.setColumns(10);
		scrivi_Stato_per_ricerca.setBounds(389, 161, 173, 20);
		contentPane.add(scrivi_Stato_per_ricerca);
		
		JTextArea testo_Città = new JTextArea();
		testo_Città.setText("Citt\u00E0");
		testo_Città.setForeground(Color.BLACK);
		testo_Città.setFont(new Font("Gadugi", Font.BOLD, 17));
		testo_Città.setEditable(false);
		testo_Città.setColumns(10);
		testo_Città.setBackground(new Color(0, 191, 255));
		testo_Città.setBounds(633, 121, 50, 29);
		contentPane.add(testo_Città);
		
		JTextArea testo_Provincia = new JTextArea();
		testo_Provincia.setText("Provincia");
		testo_Provincia.setForeground(Color.BLACK);
		testo_Provincia.setFont(new Font("Gadugi", Font.BOLD, 17));
		testo_Provincia.setEditable(false);
		testo_Provincia.setColumns(10);
		testo_Provincia.setBackground(new Color(0, 191, 255));
		testo_Provincia.setBounds(606, 154, 77, 29);
		contentPane.add(testo_Provincia);
		
		scrivi_Città_per_ricerca = new JTextField();
		scrivi_Città_per_ricerca.setFont(new Font("Gadugi", Font.BOLD, 14));
		scrivi_Città_per_ricerca.setColumns(10);
		scrivi_Città_per_ricerca.setBounds(693, 128, 173, 20);
		contentPane.add(scrivi_Città_per_ricerca);
		
		scrivi_Provincia_per_ricerca = new JTextField();
		scrivi_Provincia_per_ricerca.setFont(new Font("Gadugi", Font.BOLD, 14));
		scrivi_Provincia_per_ricerca.setColumns(10);
		scrivi_Provincia_per_ricerca.setBounds(693, 161, 173, 20);
		contentPane.add(scrivi_Provincia_per_ricerca);
		
		//ActionListener del bottone_cerca che ha il compito
		//di chiamare la funzione per riempire la tabella 
		//in base al tipo di valore
		//selezionato all'interno della combobox
	
		bottone_cerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = selezione_per_ricerca.getSelectedItem().toString();
	
				if(nome == "Attrazione") {
				lista = 1;
				riempitabellaAttrazioni(controller);
				
				}else if(nome == "Ristorante"){
					lista = 2;
					riempitabellaRistoranti(controller);
					
				}else if(nome == "Albergo") {
					lista = 3;
					riempitabellaAlberghi(controller);
				}
			}});
	
	
	//Doppio click mouse, apertura pagina recensioni 
    tabellaPrincipale.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent mouseEvent) {
            tabellaPrincipale = (JTable) mouseEvent.getSource();
                      if (mouseEvent.getClickCount() == 2 && tabellaPrincipale.getSelectedRow() != -1) {
           	
            	
            	int indice = tabellaPrincipale.getSelectedRow();
            	controller.setIndice(indice);
            	if(lista == 1) {
            		controller.getAttrazioneDAO().setAttrazione(controller.getAttrazioneDAO().getAttrazioni().get(indice));
            		controller.getLuogoDAO().setLuogo2(controller.getConnection(), controller.getAttrazioneDAO().getAttrazione().getLuogo_FK());
            		controller.getContattiDAO().setContattiAttrazioni(controller.getConnection());

            		try {
						controller.CambiaFrame(Principale.this, controller.getScriviRecensioneAttr());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
            	}else if(lista == 2) {
            		
            		controller.getRistoranteDAO().setRistorante(controller.getRistoranteDAO().getRistoranti().get(indice));
            		controller.getLuogoDAO().setLuogo2(controller.getConnection(), controller.getRistoranteDAO().getRistorante().getLuogo_FK());
            		controller.getContattiDAO().setContattiRistorante(controller.getConnection());
            		controller.getAssociazione_Categoria_RistoranteDAO().setAssociazione_Categoria_RistoranteByID(controller.getConnection());
         
            		try {
            			
						controller.CambiaFrame(Principale.this, controller.getScriviRecensioneRis());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
            	}else if (lista == 3) {
            		controller.getAlbergoDAO().setAlbergo(controller.getAlbergoDAO().getAlberghi().get(indice));
            		controller.getLuogoDAO().setLuogo2(controller.getConnection(), controller.getAlbergoDAO().getAlbergo().getLuogo_FK());
            		controller.getContattiDAO().setContattiAlbergo(controller.getConnection());
            		controller.getAssociazione_Servizio_AlbergoDAO().setAssociazione_Servizio_AlbergoByID(controller.getConnection());
            		try {
						controller.CambiaFrame(Principale.this, controller.getScriviRecensioneAlb());
					} catch (IOException e) {
						e.printStackTrace();
					}
           }
				
            }
        }
    });
	}
	//-----------------------------------------------------------------------------------------------------------
	//METODI PER RIEMPIRE LE TABELLE
	
	
	public void riempitabellaAlberghi(Controller controller) {
	
		if(scrivi_Nome_per_ricerca.getText().isEmpty() && scrivi_Stato_per_ricerca.getText().isEmpty() && scrivi_Città_per_ricerca.getText().isEmpty() && scrivi_Provincia_per_ricerca.getText().isEmpty())
		{
		
			controller.getAlbergoDAO().setAllAlberghi(controller.getConnection());
			
		}
		else {
			controller.getAlbergoDAO().setAlbergoByFiltro(controller.getConnection(), scrivi_Nome_per_ricerca.getText(), scrivi_Città_per_ricerca.getText(), scrivi_Stato_per_ricerca.getText(), scrivi_Provincia_per_ricerca.getText());
		}
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		int i = 0;
		if(controller.getAlbergoDAO().getAlberghi().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati!");
		}	
		else {
	do {
		int luogoFK = controller.getAlbergoDAO().getAlberghi().get(i).getLuogo_FK();
		controller.getLuogoDAO().setLuogoByID(controller.getConnection(), luogoFK);
		dtm.addRow(new Object[] {
					controller.getAlbergoDAO().getAlberghi().get(i).getNome(),controller.getLuogoDAO().getLuogo().getCittà() ,controller.getAlbergoDAO().getAlberghi().get(i).getVoto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getAlbergoDAO().getAlberghi().size() != i);
	
		}
	}
	
	public void riempitabellaRistoranti(Controller controller) {
		if(scrivi_Nome_per_ricerca.getText().isEmpty() && scrivi_Stato_per_ricerca.getText().isEmpty() && scrivi_Città_per_ricerca.getText().isEmpty() && scrivi_Provincia_per_ricerca.getText().isEmpty())
		{
		
			controller.getRistoranteDAO().setAllRistoranti(controller.getConnection());
			
		}
		else {
			controller.getRistoranteDAO().setRistoranteByFiltro(controller.getConnection(), scrivi_Nome_per_ricerca.getText(), scrivi_Città_per_ricerca.getText(), scrivi_Stato_per_ricerca.getText(), scrivi_Provincia_per_ricerca.getText());
		}
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);


		int i = 0;
		if(controller.getRistoranteDAO().getRistoranti().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati!");

		}	else {
	do {
		int luogoFK = controller.getRistoranteDAO().getRistoranti().get(i).getLuogo_FK();
		controller.getLuogoDAO().setLuogoByID(controller.getConnection(), luogoFK);
		
		
			dtm.addRow(new Object[] {
					controller.getRistoranteDAO().getRistoranti().get(i).getNome(), controller.getLuogoDAO().getLuogo().getCittà(), controller.getRistoranteDAO().getRistoranti().get(i).getVoto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
			
		}while(controller.getRistoranteDAO().getRistoranti().size() != i);
	
	}
	}
	
	public void riempitabellaAttrazioni(Controller controller) {
		if(scrivi_Nome_per_ricerca.getText().isEmpty() && scrivi_Stato_per_ricerca.getText().isEmpty() && scrivi_Città_per_ricerca.getText().isEmpty() && scrivi_Provincia_per_ricerca.getText().isEmpty())
		{
		
			controller.getAttrazioneDAO().setAllAttrazioni(controller.getConnection());
			
		}
		else {
			controller.getAttrazioneDAO().setAttrazioneByFiltro(controller.getConnection(), scrivi_Nome_per_ricerca.getText(), scrivi_Città_per_ricerca.getText(), scrivi_Stato_per_ricerca.getText(), scrivi_Provincia_per_ricerca.getText());
		}
		while (dtm.getRowCount() > 0) {
		    dtm.removeRow(0);
		}
		
		dtm.setRowCount(0);

		
		int i = 0;
		if(controller.getAttrazioneDAO().getAttrazioni().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati!");
		}	else {
	do {
		int luogoFK = controller.getAttrazioneDAO().getAttrazioni().get(i).getLuogo_FK();
		controller.getLuogoDAO().setLuogoByID(controller.getConnection(), luogoFK);
		
			dtm.addRow(new Object[] {
					controller.getAttrazioneDAO().getAttrazioni().get(i).getNome(),controller.getLuogoDAO().getLuogo().getCittà(), controller.getAttrazioneDAO().getAttrazioni().get(i).getVoto(),
			});
			dtm.isCellEditable(i, 1);
			dtm.isCellEditable(i, 2);
			i++;
		}while(controller.getAttrazioneDAO().getAttrazioni().size() != i);
	}
}
	
}