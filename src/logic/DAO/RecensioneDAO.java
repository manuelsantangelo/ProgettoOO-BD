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
	
	public void addRecensioneAttr(Connection conn, String testo, int stelle) {
		String comando;
	
		comando = "INSERT INTO public.\"Recensione\"(\"Testo\", \"Stelle\", \"User_FK1\", \"Attrazione_FK\") VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setString(1, testo);
			ps.setInt(2, stelle);
			ps.setInt(3, controller.getUtenteDAO().getUtente().getUser_ID());
			ps.setInt(4, controller.getAttrazioneDAO().getAttrazione().getAttrazione_ID());

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Recensione aggiunta con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ATTENZIONE! Non puoi recensire la stessa Attrazione più di una volta!");
	}
	}
	
	public void addRecensioneRis(Connection conn, String testo, int stelle) {
		String comando;
	
		comando = "INSERT INTO public.\"Recensione\"(\"Testo\", \"Stelle\", \"User_FK1\", \"Ristorante_FK\") VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setString(1, testo);
			ps.setInt(2, stelle);
			ps.setInt(3, controller.getUtenteDAO().getUtente().getUser_ID());
			ps.setInt(4, controller.getRistoranteDAO().getRistorante().getRistorante_ID());

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Recensione aggiunta con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ATTENZIONE! Non puoi recensire lo stesso Ristorante più di una volta!");
	}
	}
	
	public void addRecensioneAlb(Connection conn, String testo, int stelle) {
		String comando;
	
		comando = "INSERT INTO public.\"Recensione\"(\"Testo\", \"Stelle\", \"User_FK1\", \"Albergo_FK\") VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setString(1, testo);
			ps.setInt(2, stelle);
			ps.setInt(3, controller.getUtenteDAO().getUtente().getUser_ID());
			ps.setInt(4, controller.getAlbergoDAO().getAlbergo().getAlbergo_ID());

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Recensione aggiunta con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ATTENZIONE! Non puoi recensire lo stesso Albergo più di una volta!");
	}
	}

}
