package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.Classi.Luogo;

public class LuogoDAO {
	Controller controller;
	private Luogo luogo = new Luogo();
	private Luogo luogo2 = new Luogo();
	
	public Luogo getLuogo() {
		return luogo;
	}
	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}
	
	public void setLuogo2(Connection conn, int fk) {
		
		String comando;
		comando = "SELECT * FROM \"Luogo\" WHERE \"Luogo_ID\" = " + fk;
		
		try {
			Luogo luogo;
		
		PreparedStatement ps = conn.prepareStatement(comando);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		luogo = new Luogo();
		luogo.setStato(rs.getString(1));
		luogo.setCittà(rs.getString(2));
		luogo.setPaese(rs.getString(3));
		luogo.setIndirizzo(rs.getString(4));
		luogo.setLuogo_ID(rs.getInt(5));
		luogo.setRistorante_FK(rs.getInt(6));
		luogo.setAlbergo_FK(rs.getInt(7));
		luogo.setAttrazione_FK(rs.getInt(8));
		this.luogo2 = luogo;	
		}
		} catch (Exception e4) {
			System.out.println("ERROR IN SQL" + e4);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con la select");
			
		}
	}
		
	public Luogo getLuogo2() {
		return luogo2;
	}
	
	public LuogoDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addLuogo(Connection conn, String stato1, String città1, String paese1, String indirizzo1) {
		String comando;
		comando = "INSERT INTO public.\"Luogo\"(\"Stato\", \"Città\", \"Paese\", \"Indirizzo\") VALUES (?, ?, ?, ?);";
		try {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(comando);
		
		ps.setString(1, stato1);
		ps.setString(2, città1);
		ps.setString(3, paese1);
		ps.setString(4, indirizzo1);
		
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "LUOGO AGGIUNTO CON SUCCESSO");
		
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con il luogo");
	}
	}
	
	public void setLuogoByID(Connection conn, int luogoFK) {
		String comando;
		comando = "SELECT * FROM \"Luogo\" WHERE \"Luogo_ID\" = " + luogoFK;
		
		try {
			Luogo luogo;
		
		PreparedStatement ps = conn.prepareStatement(comando);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		luogo = new Luogo();
		luogo.setStato(rs.getString(1));
		luogo.setCittà(rs.getString(2));
		luogo.setPaese(rs.getString(3));
		luogo.setIndirizzo(rs.getString(4));
		luogo.setLuogo_ID(rs.getInt(5));
		luogo.setRistorante_FK(rs.getInt(6));
		luogo.setAlbergo_FK(rs.getInt(7));
		luogo.setAttrazione_FK(rs.getInt(8));
		this.luogo = luogo;	
		}
		} catch (Exception e4) {
			System.out.println("ERROR IN SQL" + e4);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con la select");
			
		}
		
		
	}
}

