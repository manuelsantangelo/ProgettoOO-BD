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
		return moderatore;
	}
	
	
	public void setModeratore(Moderatore moderatore) {
		this.moderatore = moderatore;
	}
	
	public ModeratoreDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public boolean checkModeratore(Connection conn, String nome, String pass) {
		boolean flag = false;
		int count = 0;
		String comando;
		
		comando = "SELECT COUNT(*) FROM public.\"Moderatore\" WHERE \"Nome\" = ? AND \"Password\" = ?";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			count = rs.getInt(1);
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa èandato storto con il check del Moderatore");	
		}
		
		if(count == 1) {
			flag = true;
			return flag;
		}
		
		return flag;	
		
	}
	
	public Moderatore getThisModeratore(Connection conn, String nome, String pass) {
		Moderatore mod = new Moderatore();
		String comando;
		
		comando = "SELECT * FROM public.\"Moderatore\" WHERE \"Nome\" = ? AND \"Password\" = ?";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			
			mod.setModeratore_ID(rs.getInt(0));
			mod.setSede(rs.getString(1));
			mod.setNome(rs.getString(2));
			mod.setCognome(rs.getString(3));
			mod.setEmail(rs.getString(4));
			mod.setIndirizzo(rs.getString(5));
			mod.setData_Inizio_Lavoro(rs.getDate(6));
			mod.setDataDiNascita(rs.getDate(7));
			mod.setCF(rs.getString(8));
			mod.setPassword(rs.getString(9));
			
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa èandato storto con il recupero del Moderatore");	
		}
		
		
		return mod;	
		
	}
	
	
	
	
 
}


