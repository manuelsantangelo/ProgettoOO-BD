package logic.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tipi.tipoattrazione;
import Tipi.prezzo;
import logic.Controller;
import logic.Classi.Attrazione;

public class AttrazioneDAO {

	Controller controller;
	private Attrazione attrazione = new Attrazione();
	
	public Attrazione getAttrazione() {
		return attrazione;
	}

	public void setAttrazione(Attrazione attrazione) {
		this.attrazione = attrazione;
	}
	
	public AttrazioneDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addAttrazione(Connection conn, String nome1, ArrayList<tipoattrazione> type, String descrizione1, File immagine, prezzo price) {
		String comando;
		comando = "INSERT INTO \"Attrazione\"(\"Nome\", \"Descrizione\", \"Tipo\", \"Foto\", \"Fascia_Prezzo\" ) VALUES (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setString(1, nome1);
			ps.setString(2, descrizione1);
			
			for(int i = 0; i < type.size(); i++) {
				ps.setObject(3, type.get(i), Types.OTHER);
			}
			
			
			
			try {
				ps.setBinaryStream(4 ,new FileInputStream(immagine), immagine.length());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			ps.setObject(5, price, Types.OTHER);
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Attrazione aggiunta con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa � andato storto con l'Attrazione");
	}
		
	}
	

	public int getLastAttrazione(Connection conn) {
		int ID = 0;
		String comando;
		comando = "SELECT \"Attrazione_ID\" FROM public.\"Attrazione\" ORDER BY \"Attrazione_ID\" DESC LIMIT 100";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			if(rs.next())
			ID = rs.getInt(1);
			
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa �andato storto con il recupero di Attrazione_ID");	
		}
		
		return ID;
	}
}


