package logic.DAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import logic.Controller;
import logic.Classi.Utente;

public class UtenteDAO {

	Controller controller;
	private Utente utente = new Utente();
	
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public UtenteDAO(Controller controller) {
		this.controller = controller;	
	}
	

	
	public void addUtente (Connection conn, String nome1, String password1, String nickname1, String email1, String cognome1, java.sql.Date dataNascita1, String città1, File immagine) {
			String comando;
			if(immagine == null && nickname1 == null) {
				comando = "insert into \"Utente\" (\"User_ID\", \"Password\", \"Nome\", \"NickName\", \"Email\", \"Data_Iscrizione\", \"Data_Di_Nascita\", \"Cognome\", \"Città\", \"Propic\", \"Contributi\") values (DEFAULT,?,?,?,?,DEFAULT,?,?,?,DEFAULT,DEFAULT)";
				
				try {
					ResultSet nickUser = conn.createStatement().executeQuery("SELECT \"User_ID\" FROM public.\"Utente\"\r\n" + "ORDER BY \"User_ID\" DESC LIMIT 1");
					int UID = nickUser.getInt(1);
					UID++;
					String nick = "User00" + UID;
					
					System.out.println(UID);
					
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);
					
					ps.setString(1, password1);
					ps.setString(2, nome1);
					ps.setString(3, nick);
					ps.setString(4, email1);
					ps.setDate(5, dataNascita1);
					ps.setString(6, cognome1);
					ps.setString(7, città1);
					
					ps.executeUpdate();
					System.out.println("NULLI ENTREMBI :" + password1 + " "+ nome1 + " " + nickname1 + " " + email1 + " " + dataNascita1 + " " + cognome1 + " " + città1);
					
					JOptionPane.showMessageDialog(null, "TI SEI ISCRITTO CON SUCCESSO! ORA PUOI ACCEDERE");
					controller.CambiaFrame(controller.getIscrizione(), controller.getHome());
				
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Uno o più campi non sono rispettati!");
					
				}
			}
			else if (immagine == null) {
				comando = "insert into \"Utente\" (\"User_ID\", \"Password\", \"Nome\", \"NickName\", \"Email\", \"Data_Iscrizione\", \"Data_Di_Nascita\", \"Cognome\", \"Città\", \"Propic\", \"Contributi\") values (DEFAULT,?,?,?,?,DEFAULT,?,?,?,DEFAULT,DEFAULT)";

				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);
					
					ps.setString(1, password1);
					ps.setString(2, nome1);
					ps.setString(3, nickname1);
					ps.setString(4, email1);
					ps.setDate(5, dataNascita1);
					ps.setString(6, cognome1);
					ps.setString(7, città1);
				
					System.out.println("NULLA FOTO :" + password1 + " "+ nome1 + " " + nickname1 + " " + email1 + " " + dataNascita1 + " " + cognome1 + " " + città1);

					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "TI SEI ISCRITTO CON SUCCESSO! ORA PUOI ACCEDERE");
					controller.CambiaFrame(controller.getIscrizione(), controller.getHome());
				
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Uno o più campi non sono rispettati!");
					
				}
			
			}else if(nickname1 == null) {
			 
				comando = "insert into \"Utente\" (\"User_ID\", \"Password\", \"Nome\", \"NickName\" \"Email\", \"Data_Iscrizione\", \"Data_Di_Nascita\", \"Cognome\", \"Città\", \"Propic\", \"Contributi\") values (DEFAULT,?,?,?,?,DEFAULT,?,?,?,?,DEFAULT)";
				
				try {
					ResultSet nickUser = conn.createStatement().executeQuery("SELECT * FROM public.\"Utente\"\r\n" + "ORDER BY \"User_ID\" DESC LIMIT 1");
					int UID = nickUser.getInt(1);
					UID++;
					String nick = "User00" + UID;
					
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);
					
					ps.setString(1, password1);
					ps.setString(2, nome1);
					ps.setString(3, nick);
					ps.setString(4, email1);
					ps.setDate(5, dataNascita1);
					ps.setString(6, cognome1);
					ps.setString(7, città1);
					try {
						ps.setBinaryStream(8 ,new FileInputStream(immagine), immagine.length());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("NULLO NICKNAME :" + password1 + " "+ nome1 + " " + nick + " " + email1 + " " + dataNascita1 + " " + cognome1 + " " + città1);

					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "TI SEI ISCRITTO CON SUCCESSO! ORA PUOI ACCEDERE");
					controller.CambiaFrame(controller.getIscrizione(), controller.getHome());
				
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Uno o più campi non sono rispettati!");
					
				}
			
			}else {
				comando = "insert into \"Utente\" (\"User_ID\", \"Password\", \"Nome\", \"NickName\", \"Email\", \"Data_Iscrizione\", \"Data_Di_Nascita\", \"Cognome\", \"Città\", \"Propic\", \"Contributi\") values (DEFAULT,?,?,?,?,DEFAULT,?,?,?,?,DEFAULT)";
				
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);
					
					ps.setString(1, password1);
					ps.setString(2, nome1);
					ps.setString(3, nickname1);
					ps.setString(4, email1);
					ps.setDate(5, dataNascita1);
					ps.setString(6, cognome1);
					ps.setString(7, città1);
					try {
						ps.setBinaryStream(8 ,new FileInputStream(immagine), immagine.length());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("NULLI NIENTE :" + password1 + " "+ nome1 + " " + nickname1 + " " + email1 + " " + dataNascita1 + " " + cognome1 + " " + città1);

					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "TI SEI ISCRITTO CON SUCCESSO! ORA PUOI ACCEDERE");
					controller.CambiaFrame(controller.getIscrizione(), controller.getHome());
				
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Uno o più campi non sono rispettati!");
					
				}
			}
		
		}
}