package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.Classi.Moderatore;

public class ModeratoreDAO {
	
	Controller controller;
	private Moderatore moderatore = new Moderatore();
	
	public Moderatore getModeratore() {
		return this.moderatore;
	}
	
	public void setModeratore(Moderatore moderatore) {
		this.moderatore = moderatore;
	}
	
	public ModeratoreDAO(Controller controller) {
		this.controller = controller;	
	}
	
	//Metodo utilizzato per controllare se chi sta effettuando l'accesso
	//è effettivamente un moderatore.
	//Ricordiamo che un moderatore a differenza di un utente accede con il proprio nome
	public boolean checkModeratore(Connection conn, String nome, String pass) {
		boolean flag = false;
		int count = 0;
		String comando;
		
        comando = "SELECT COUNT(*) FROM public.\"Moderatore\" WHERE \"Nome\" = ? AND \"Password\" = ?";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			ps.setString(1, nome);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			count = rs.getInt(1);
			}
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il check del Moderatore");	
		}
		
		if(count == 1) {
			flag = true;
			return flag;
		}
		
		return flag;	
	}
	
	//Metodo che restituisce un preciso moderatore
	public Moderatore getThisModeratore(Connection conn, String nome, String pass) {
		Moderatore mod = new Moderatore();
		String comando;
		
		comando = "SELECT * FROM public.\"Moderatore\" WHERE \"Nome\" = ? AND \"Password\" = ?";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			ps.setString(1, nome);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
			mod.setModeratore_ID(rs.getInt(1));
			mod.setSede(rs.getString(2));
			mod.setNome(rs.getString(3));
			mod.setCognome(rs.getString(4));
			mod.setEmail(rs.getString(5));
			mod.setIndirizzo(rs.getString(6));
			mod.setData_Inizio_Lavoro(rs.getDate(7));
			mod.setDataDiNascita(rs.getDate(8));
			mod.setCF(rs.getString(9));
			mod.setPassword(rs.getString(10));
			}
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero del Moderatore");	
		}
		
		return mod;	
		
	}
}


