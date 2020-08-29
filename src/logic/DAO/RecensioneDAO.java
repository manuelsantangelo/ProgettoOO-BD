package logic.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import Tipi.prezzo;
import logic.Controller;
import logic.Classi.Recensione;

public class RecensioneDAO {
	Controller controller;
	
	private Recensione recensione = new Recensione();
	
	public Recensione getRecensione() {
		return recensione;
	}
	
	public void setRecensione(Recensione recensione) {
		this.recensione = recensione;
	}
	
	public RecensioneDAO(Controller controller) {
		this.controller = controller;
	}
	
	public void addRecensione(Connection conn, String testo, int stelle) {
		String comando;
		comando = "INSERT INTO \"Recensione\" (\"Testo\", \"Stelle\") VALUES (?, ?);";
		
		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			ResultSet rs = ps.executeQuery();
			
			ps.setString(1, testo);
			ps.setInt(2, stelle);
			while(rs.next()) {
				recensione.setReview_ID(rs.getInt(1));
				recensione.setMiPiace(rs.getInt(4));
				recensione.setApprovata(rs.getBoolean(5));
				recensione.setUser_FK1(rs.getInt(6));
				recensione.setModeratore_FK(rs.getInt(7));
				recensione.setAlbergo_FK(rs.getInt(8));
				recensione.setAttrazione_FK(rs.getInt(9));
				recensione.setRistorante_FK(rs.getInt(10));
			}
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Recensione aggiunta con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con la Recensione");
	}
	}

}
