package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.Classi.Luogo;

public class LuogoDAO {
	Controller controller;
	private Luogo luogo = new Luogo();
	
	public Luogo getLuogo() {
		return luogo;
	}
	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
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
		
		//JOptionPane.showMessageDialog(null, "LUOGO AGGIUNTO CON SUCCESSO");
		
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con il luogo");
	}
	}
}

