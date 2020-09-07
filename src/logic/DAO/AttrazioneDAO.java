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

import Tipi.prezzo;
import Tipi.tipoattrazione;
import logic.Controller;
import logic.Classi.Attrazione;

public class AttrazioneDAO {

	Controller controller;
	private Attrazione attrazione = new Attrazione();

	//ArrayList utilizzato per contenere le attrazioni
	//presenti nel database quando viene effettuata una ricerca
	private ArrayList<Attrazione> attrazioni = new ArrayList<Attrazione>();
	
	public Attrazione getAttrazione() {
		return attrazione;
	}

	public void setAttrazione(Attrazione attrazione) {
		this.attrazione = attrazione;
	}
	
	public AttrazioneDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public ArrayList<Attrazione> getAttrazioni(){
		return this.attrazioni;
	}
	
	
	//Metodo utilizzato per inserire all'interno del database
	//una nuova attrazione
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
	
	//Metodo che restituisce l'ID dell'ultima attrazione inserita
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
	
	//Metodo che restituisce un ArrayList di stringhe contentente
	//tutti i nomi delle attrazioni presenti nel database
	public ArrayList<String> getNomeAttrazione (Connection conn) {
		ArrayList<String> nome =  new ArrayList<String>();
		String comando;
		
		
		comando = "select \"Nome\" From \"Attrazione\" ";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			String nome1 = null;
			while(rs.next()) {
				
			nome1 = rs.getString(1);
			nome.add(nome1);
			}
			rs.close();
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa � andato storto con l'Attrazione");
	}
		return nome;
	}
	
	
	//Metodo utilizzato per eliminare un'attrazione dal database
	public void deleteAttrazione(Connection conn, String nome1) {
		String comando;
		comando = "Delete From \"Attrazione\" where \"Nome\" = ? ";
		
		try {
			PreparedStatement ps = null;

			ps = conn.prepareStatement(comando);
			ps.setString(1, nome1);
			
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Attrazione eliminata con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa � andato storto con l'Attrazione");
	}
		
	}
	
	//Metodo che inizialmente pulisce l'ArrayList di attrazioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutte le attrazioni presenti all'interno del database
	public void setAllAttrazioni(Connection conn) {
		this.attrazioni.clear();
		try {		
			Attrazione attrazione;
			String comando = "SELECT * FROM public.\"Attrazione\" ";
	
			PreparedStatement ps = null;
			ResultSet rs = null;
	
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			while (rs.next()) {
				attrazione = new Attrazione();
				attrazione.setAttrazione_ID(rs.getInt(1));
				attrazione.setNome(rs.getString(2));
				attrazione.setTipo(tipoattrazione.valueOf((rs.getObject(3).toString())));
				attrazione.setVoto(rs.getDouble(4));
				attrazione.setDescrizione(rs.getString(5));
				attrazione.setFascia_Prezzo(prezzo.valueOf(rs.getObject(6).toString()));
				attrazione.setLuogo_FK(rs.getInt(7));
				attrazione.setFoto(rs.getBytes(8));
				this.attrazioni.add(attrazione);
			}
		} catch (Exception e) {
			System.out.println("ERROR IN SQL" + e);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa � andato storto con il recupero delle attrazioni");	
		}

	}
	
	
	//Metodo che inizialmente pulisce l'ArrayList di attrazioni
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//le attrazioni presenti all'interno del database per� effettuando
	//una ricerca con dei filtri in base a ci� che viene inserito dall'utente
	public void setAttrazioneByFiltro(Connection conn, String nome, String citt�, String stato, String provincia) {
		this.attrazioni.clear();
		
		int flagNome = 0;
		int flagStato = 0;
		int flagCitt� = 0;
		@SuppressWarnings("unused")
		int flagProvincia = 0;
		String comando = "Select * from \"Attrazione\" as attr join \"Luogo\" as lu on attr.\"Luogo_FK\" = lu.\"Luogo_ID\" where ";
		
		if(!nome.isEmpty()) {
		comando = comando + "\"Nome\" = " + "'" + nome + "'";
		flagNome++;
		}
		
		if(!stato.isEmpty()) {
			if(flagNome == 1) {
				comando = comando + " and \"Stato\" = " + "'" + stato + "'";
			}
			else {
				comando = comando + "\"Stato\" = " + "'" + stato + "'";
			}	
			flagStato++;
		}
		
		if(!citt�.isEmpty()) {
			if(flagNome == 1 || flagStato == 1) {
				comando = comando + " and \"Citt�\" = " + "'" + citt� + "'";
			}
			else {
				comando = comando + "\"Citt�\" = " + "'" + citt� + "'";
			}
			flagCitt�++;
		}
		
		if(!provincia.isEmpty()) {
			if(flagNome == 1 || flagStato == 1 || flagCitt� == 1) {
				comando = comando + " and \"Paese\" = " + "'" + provincia + "'";
			}
			else {
				comando = comando + "\"Paese\" = " + "'" + provincia + "'";
			}
			flagProvincia++;
		}
		
		try {
			
			Attrazione attrazione;
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				attrazione = new Attrazione();
				attrazione.setAttrazione_ID(rs.getInt(1));
				attrazione.setNome(rs.getString(2));
				attrazione.setTipo(tipoattrazione.valueOf((rs.getObject(3).toString())));
				attrazione.setVoto(rs.getDouble(4));
				attrazione.setDescrizione(rs.getString(5));
				attrazione.setFascia_Prezzo(prezzo.valueOf(rs.getObject(6).toString()));
				attrazione.setLuogo_FK(rs.getInt(7));
				attrazione.setFoto(rs.getBytes(8));
				this.attrazioni.add(attrazione);
			} 
		
	} catch (Exception e) {
		System.out.println("ERROR IN SQL" + e);
		JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa � andato storto con il recupero dell'alttrazione by filtro");	
		
	}
}}


