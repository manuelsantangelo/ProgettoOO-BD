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
import Tipi.tiporistorante;
import logic.Controller;
import logic.Classi.Albergo;
import logic.Classi.Attrazione;
import logic.Classi.Ristorante;

public class RistoranteDAO {
	
	Controller controller;
	private Ristorante ristorante = new Ristorante();
	private ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();

	public Ristorante getRistorante() {
		return ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public RistoranteDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addRistorante(Connection conn, String nome1, prezzo price, int stelleMichelin1, String descrizione1, File immagine) {
		String comando;
		comando = "INSERT INTO \"Ristorante\"(\"Nome\", \"Stelle_Michelin\", \"Descrizione\", \"Fascia_Prezzo\", \"Foto\") VALUES (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setString(1, nome1);
			ps.setInt(2, stelleMichelin1);
			ps.setString(3, descrizione1);
			ps.setObject(4, price, Types.OTHER);
			try {
				ps.setBinaryStream(5 ,new FileInputStream(immagine), immagine.length());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Ristorante aggiunto con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il Ristorante, non puoi inserire lo stesso nome per più ristoranti");
	}
	}

	public int getLastRestaurant(Connection conn) {
		int ID = 0;
		String comando;
		comando = "SELECT \"Ristorante_ID\" FROM public.\"Ristorante\" ORDER BY \"Ristorante_ID\" DESC LIMIT 100";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			if(rs.next())
			ID = rs.getInt(1);
			
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa èandato storto con il recupero di Ristorante_ID");	
		}
		
		return ID;
	}
	
	public ArrayList<String> getNomeRistorante (Connection conn) {
		ArrayList<String> nome =  new ArrayList<String>();
		String comando;
		
		
		comando = "select \"Nome\" From \"Ristorante\" ";
		
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
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il Ristorante");
	}
		return nome;
	}
	
	public void deleteRistorante(Connection conn, String nome1) {
		String comando;
		comando = "Delete From \"Ristorante\" where \"Nome\" = ? ";
		
		try {
			PreparedStatement ps = null;

			ps = conn.prepareStatement(comando);
			ps.setString(1, nome1);
			
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Ristorante eliminato con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il Ristorante");
	}
	
}
	
	public ArrayList<Ristorante> getRistoranti(){
		return this.ristoranti;
	}
	
	public void setAllRistoranti(Connection conn){
		
		this.ristoranti.clear();
		
try {		
	Ristorante ristorante;
	
	String comando = "SELECT * FROM public.\"Ristorante\" ";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
	while (rs.next()) {
		ristorante = new Ristorante();
		ristorante.setRistorante_ID(rs.getInt(1));
		ristorante.setNome(rs.getString(2));
		ristorante.setStelle_Michelin(rs.getInt(3));
		ristorante.setVoto(rs.getDouble(4));
		ristorante.setDescizione(rs.getString(5));
		ristorante.setFascia_Prezzo(prezzo.valueOf(rs.getObject(6).toString()));
		ristorante.setLuogo_FK(rs.getInt(7));
		ristorante.setFoto(rs.getBytes(8));
		this.ristoranti.add(ristorante);
	
	}
	
} catch (Exception e) {
	System.out.println("ERROR IN SQL" + e);
	JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero del ristorante");	
	
}

	}
	
	
	
}


