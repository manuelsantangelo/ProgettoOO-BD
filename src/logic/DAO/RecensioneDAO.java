package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.Classi.Recensione;

public class RecensioneDAO {
	Controller controller;
	
	private Recensione recensione = new Recensione();
	//ArrayList utilizzato per contenere le recensioni
	//presenti nel database
	private ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
	
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	
	public Recensione getRecensione() {
		return recensione;
	}
	
	public void setRecensione(Recensione recensione) {
		this.recensione = recensione;
	}
	
	public RecensioneDAO(Controller controller) {
		this.controller = controller;
	}

	//Metodo utilizzato per inserire all'interno del database
	//una nuova recensione per un'attrazione 
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
	
	//Metodo utilizzato per inserire all'interno del database
	//una nuova recensione per un ristorante
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
	
	//Metodo utilizzato per inserire all'interno del database
	//una nuova recensione per un albergo
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
	

	//Metodo che inizialmente pulisce l'ArrayList di recensioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutte le recensioni presenti all'interno del database che però
	//non sono state approvate
	public void setAllRecensioni(Connection conn){
		this.recensioni.clear();
		
try {		
	Recensione recensione;
	
	String comando = "SELECT * FROM public.\"Recensione\" where \"Approvata\" = false ";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
	while (rs.next()) {
		recensione = new Recensione();
		recensione.setReview_ID(rs.getInt(1));
		recensione.setTesto(rs.getString(2));
		recensione.setStelle(rs.getInt(3));
		recensione.setApprovata(rs.getBoolean(4));
		recensione.setUser_FK1(rs.getInt(5));
		recensione.setModeratore_FK(rs.getInt(6));
		recensione.setAlbergo_FK(rs.getInt(7));
		recensione.setAttrazione_FK(rs.getInt(8));
		recensione.setRistorante_FK(rs.getInt(9));
		this.recensioni.add(recensione);	
	}
	
} catch (Exception e) {
	System.out.println("ERROR IN SQL" + e);
	JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero delle recensioni");	
	
}
	}
	
	
	//Metodo utilizzato per approvare una recensione 
	//da parte di un moderatore
	public void approvaRecensione (Connection conn, String testoRecensione, int Moderatore_ID) {
		String comando;
		comando = "Update \"Recensione\" set \"Approvata\" = true, \"Moderatore_FK\" = ? where \"Testo\" = ? ";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(comando);
			ps.setInt(1, Moderatore_ID);
			ps.setString(2, testoRecensione);

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Recensione approvata con successo!");
		} catch (Exception e) {
			System.out.println("ERROR IN SQL" + e);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'approvazione della recensione");
	
		}
		
	}
	

	//Metodo utilizzato per rifiutare una recensione 
	//da parte di un moderatore
	public void rifiutaRecensione(Connection conn, String testoRecensione) {
		String comando;
		comando = "Delete from \"Recensione\" where \"Testo\" = ? ";
		
try {
			
			PreparedStatement ps = conn.prepareStatement(comando);
			ps.setString(1, testoRecensione);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Recensione rifiutata con successo!");
		} catch (Exception e) {
			System.out.println("ERROR IN SQL" + e);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'eliminazione della recensione");
	
		}
	}
	
	//Metodo che inizialmente pulisce l'ArrayList di recensioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutte le recensioni presenti all'interno del database che
	// sono state approvate
	public void setAllRecensioniApprovate(Connection conn){
		this.recensioni.clear();
		
try {		
	Recensione recensione;
	
	String comando = "SELECT * FROM public.\"Recensione\" where \"Approvata\" = true ";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
	while (rs.next()) {
		recensione = new Recensione();
		recensione.setReview_ID(rs.getInt(1));
		recensione.setTesto(rs.getString(2));
		recensione.setStelle(rs.getInt(3));
		recensione.setApprovata(rs.getBoolean(4));
		recensione.setUser_FK1(rs.getInt(5));
		recensione.setModeratore_FK(rs.getInt(6));
		recensione.setAlbergo_FK(rs.getInt(7));
		recensione.setAttrazione_FK(rs.getInt(8));
		recensione.setRistorante_FK(rs.getInt(9));
		this.recensioni.add(recensione);
	
	}
	
} catch (Exception e) {
	System.out.println("ERROR IN SQL" + e);
	JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero delle recensioni");	
	
}
	}
	
	
	//Metodo che inizialmente pulisce l'ArrayList di recensioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutte le recensioni approvate per un determinato albergo
	public void setRecensioniDaVisualizzareAlbergo(Connection conn){
	this.recensioni.clear();
	
try {		
	Recensione recensione;
	String comando = "SELECT * FROM public.\"Recensione\" where \"Approvata\" = true and \"Albergo_FK\" = " + controller.getAlbergoDAO().getAlbergo().getAlbergo_ID() ;
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
while (rs.next()) {
	recensione = new Recensione();
	recensione.setReview_ID(rs.getInt(1));
	recensione.setTesto(rs.getString(2));
	recensione.setStelle(rs.getInt(3));
	recensione.setApprovata(rs.getBoolean(4));
	recensione.setUser_FK1(rs.getInt(5));
	recensione.setModeratore_FK(rs.getInt(6));
	recensione.setAlbergo_FK(rs.getInt(7));
	recensione.setAttrazione_FK(rs.getInt(8));
	recensione.setRistorante_FK(rs.getInt(9));
	this.recensioni.add(recensione);

}

} catch (Exception e) {
System.out.println("ERROR IN SQL" + e);
JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero delle recensioni");	

}

	}

	
	
	//Metodo che inizialmente pulisce l'ArrayList di recensioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutte le recensioni approvate per un determinato ristorante
	public void setRecensioniDaVisualizzareRistorante(Connection conn){
	this.recensioni.clear();
	
try {		
	Recensione recensione;
	String comando = "SELECT * FROM public.\"Recensione\" where \"Approvata\" = true and \"Ristorante_FK\" = " +
	controller.getRistoranteDAO().getRistorante().getRistorante_ID();
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
	
while (rs.next()) {
	recensione = new Recensione();
	recensione.setReview_ID(rs.getInt(1));
	recensione.setTesto(rs.getString(2));
	recensione.setStelle(rs.getInt(3));
	recensione.setApprovata(rs.getBoolean(4));
	recensione.setUser_FK1(rs.getInt(5));
	recensione.setModeratore_FK(rs.getInt(6));
	recensione.setAlbergo_FK(rs.getInt(7));
	recensione.setAttrazione_FK(rs.getInt(8));
	recensione.setRistorante_FK(rs.getInt(9));
	this.recensioni.add(recensione);
}

} catch (Exception e) {
System.out.println("ERROR IN SQL" + e);
JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero delle recensioni");	

}
	}
	
	
	
	//Metodo che inizialmente pulisce l'ArrayList di recensioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutte le recensioni approvate per una determinata attrazione
	public void setRecensioniDaVisualizzareAttrazione(Connection conn){
	this.recensioni.clear();
	
try {		
	Recensione recensione;
	String comando = "SELECT * FROM public.\"Recensione\"  where \"Approvata\" = true and \"Attrazione_FK\" = "
			+ controller.getAttrazioneDAO().getAttrazione().getAttrazione_ID() ;
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
	
while (rs.next()) {
	recensione = new Recensione();
	recensione.setReview_ID(rs.getInt(1));
	recensione.setTesto(rs.getString(2));
	recensione.setStelle(rs.getInt(3));
	recensione.setApprovata(rs.getBoolean(4));
	recensione.setUser_FK1(rs.getInt(5));
	recensione.setModeratore_FK(rs.getInt(6));
	recensione.setAlbergo_FK(rs.getInt(7));
	recensione.setAttrazione_FK(rs.getInt(8));
	recensione.setRistorante_FK(rs.getInt(9));
	this.recensioni.add(recensione);
}

} catch (Exception e) {
System.out.println("ERROR IN SQL" + e);
JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero delle recensioni");	

}
	}

	
	//Metodo che restituisce una stringa contenente il nickname
	//corrispondente ad una determinata recensione 
	public String getNickNameRecensione(Connection conn, int codiceRecensione) {
	
	String nickname = new String();

	try {
		
		String comando;
		comando = "Select \"NickName\" from \"Utente\" as ut join \"Recensione\" as rec on ut.\"User_ID\" = rec.\"User_FK1\" where rec.\"Review_ID\" =  " + codiceRecensione;
		
		

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		ps = conn.prepareStatement(comando);
		rs = ps.executeQuery();
		while (rs.next()) {
		nickname = rs.getString(1);	
		
		}
		
		
	} catch (Exception e) {
		System.out.println("ERROR IN SQL" + e);
		JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero del nome utente");	
	}
	
	return nickname;

}

	
	
	
	

}
