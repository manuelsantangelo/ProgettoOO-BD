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
	


	//Metodo utilizzato per inserire all'interno del database
	//un nuovo utente tenendo conto di tutte le varie condizioni che possono 
	//venirsi a verificare
	public void addUtente (Connection conn, String nome1, String password1, String nickname1, String email1, String cognome1, java.sql.Date dataNascita1, String città1, File immagine) {
			String comando;
			
			if (immagine == null ) {
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
	
	//Metodo utilizzato per controllare se chi sta effettuando l'accesso
	//è effettivamente un utente.
	//Ricordiamo che un utente a differenza di un moderatore accede con il proprio NickName
	public boolean checkUtente(Connection conn, String nickname, String pass) {
		boolean flag = false;
		int count = 0;
		String comando;
		
		comando = "SELECT COUNT(*) FROM \"Utente\" WHERE \"NickName\" = ? AND \"Password\" = ?";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			ps.setString(1, nickname);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			count = rs.getInt(1);
			}
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il check dell'utente");	
		}
		
		if(count == 1) {
			flag = true;
			return flag;
		}
		
		return flag;	
	}
	
	
	//Metodo che restituisce un preciso utente
	public Utente getThisUtente(Connection conn, String nickname, String pass) {
		Utente user = new Utente();
		String comando;
		
		comando = "SELECT * FROM public.\"Utente\" WHERE \"NickName\" = ? AND \"Password\" = ?";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			ps.setString(1, nickname);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
			user.setUser_ID(rs.getInt(1));
			user.setPassword(rs.getString(2));
			user.setNome(rs.getString(3));
			user.setNickname(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setData_Iscrizione(rs.getDate(6));
			user.setData_di_Nascita(rs.getDate(7));
			user.setCognome(rs.getString(8));
			user.setCittà(rs.getString(9));
			user.setPropic(rs.getBytes(10));
			user.setContributi(rs.getInt(11));
			
			}
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero del Moderatore");	
		}
		
		return user;	
		
	}
}