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

import Tipi.categoriaalbergo;
import Tipi.prezzo;
import logic.Controller;
import logic.Classi.Albergo;


public class AlbergoDAO {
	
	Controller controller;
	private Albergo albergo = new Albergo();
	
	//ArrayList utilizzato per contenere gli alberghi
	//presenti nel database quando viene effettuata una ricerca
	private ArrayList<Albergo> alberghi = new ArrayList<Albergo>();

	public Albergo getAlbergo() {
		return albergo;
	}

	public void setAlbergo(Albergo albergo) {
		this.albergo = albergo;
	}

	public AlbergoDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public ArrayList<Albergo> getAlberghi(){
		return this.alberghi;
	}
	
	//Metodo utilizzato per inserire all'interno del database
	//un nuovo albergo
	public void addAlbergo(Connection conn, String nome1, ArrayList<categoriaalbergo> type, int stelleAlbergo, int numeroCamere, String descrizione1, File immagine, prezzo price) {
		String comando;
		comando = "INSERT INTO \"Albergo\"(\"Nome\", \"Stelle\", \"Descrizione\", \"Categoria\", \"Foto\",\"Numero_Camere\", \"Fascia_Prezzo\" ) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setString(1, nome1);
			ps.setInt(2, stelleAlbergo);
			ps.setString(3, descrizione1);
			for(int i = 0; i < type.size(); i++) {
				ps.setObject(4, type.get(i), Types.OTHER);
			}
			
			try {
				ps.setBinaryStream(5 ,new FileInputStream(immagine), immagine.length());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			ps.setInt(6, numeroCamere);
			ps.setObject(7, price, Types.OTHER);
		
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Albergo aggiunto con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'Albergo");
	}
		
	}
	
	

	//Metodo che restituisce l'ID dell'ultimo albergo inserito
	public int getLastAlbergo(Connection conn) {
		int ID = 0;
		String comando;
		comando = "SELECT \"Albergo_ID\" FROM public.\"Albergo\" ORDER BY \"Albergo_ID\" DESC LIMIT 100";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			if(rs.next())
			ID = rs.getInt(1);
			
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa èandato storto con il recupero di Albergo_ID");	
		}
		
		return ID;
	}
	
	//Metodo che restituisce un ArrayList di stringhe contentente
	//tutti i nomi degli alberghi presenti nel database
	public ArrayList<String> getNomeAlbergo (Connection conn) {
		ArrayList<String> nome =  new ArrayList<String>();
		String comando;
		
		
		comando = "select \"Nome\" From \"Albergo\" ";
		
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
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'Albergo");
	}
		return nome;
	}
	
	//Metodo utilizzato per eliminare un albergo dal database
	public void deleteAlbergo(Connection conn, String nome1) {
		String comando;
		comando = "Delete From \"Albergo\" where \"Nome\" = ? ";
		
		try {
			PreparedStatement ps = null;

			ps = conn.prepareStatement(comando);
			ps.setString(1, nome1);
			
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Albergo eliminato con successo!");
			
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'Albergo");
	}
		
	}
	
	
	//Metodo che inizialmente pulisce l'ArrayList di alberghi
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//tutti gli alberghi presenti all'interno del database
	public void setAllAlberghi(Connection conn){
		this.alberghi.clear();
		
try {		
	Albergo albergo;
	
	String comando = "SELECT * FROM public.\"Albergo\" ";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ps = conn.prepareStatement(comando);
	rs = ps.executeQuery();
	while (rs.next()) {
		albergo = new Albergo();
		albergo.setAlbergo_ID(rs.getInt(1));
		albergo.setNome(rs.getString(2));
		albergo.setCategoria(categoriaalbergo.valueOf(rs.getObject(3).toString()));
		albergo.setStelle(rs.getInt(4));
		albergo.setVoto(rs.getDouble(5));
		albergo.setTesto(rs.getString(6));
		albergo.setNumero_Camere(rs.getInt(7));
		albergo.setLuogo_FK(rs.getInt(8));
		albergo.setFascia_Prezzo(prezzo.valueOf(rs.getObject(9).toString()));
		albergo.setFoto(rs.getBytes(10));
		this.alberghi.add(albergo);
	
	}
	
} catch (Exception e) {
	System.out.println("ERROR IN SQL" + e);
	JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero dell'albergo");	
	
}
	}
	
	//Metodo che inizialmente pulisce l'ArrayList di alberghi
	// e poi viene utilizzato per inserire nell'ArrayList stesso
	//gli alberghi presenti all'interno del database però effettuando
	//una ricerca con dei filtri in base a ciò che viene inserito dall'utente
	public void setAlbergoByFiltro(Connection conn, String nome, String città, String stato, String provincia) {
		this.alberghi.clear();
		
		int flagNome = 0;
		int flagStato = 0;
		int flagCittà = 0;
		@SuppressWarnings("unused") // Utilizzato per ignorare il warning che non crea problemi
		int flagProvincia = 0;
		String comando = "Select * from \"Albergo\" as al join \"Luogo\" as lu on al.\"Luogo_FK\" = lu.\"Luogo_ID\" where ";
		
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
		
		if(!città.isEmpty()) {
			if(flagNome == 1 || flagStato == 1) {
				comando = comando + " and \"Città\" = " + "'" + città + "'";
			}
			else {
				comando = comando + "\"Città\" = " + "'" + città + "'";
			}
			flagCittà++;
		}
		
		if(!provincia.isEmpty()) {
			if(flagNome == 1 || flagStato == 1 || flagCittà == 1) {
				comando = comando + " and \"Paese\" = " + "'" + provincia + "'";
			}
			else {
				comando = comando + "\"Paese\" = " + "'" + provincia + "'";
			}
			flagProvincia++;
		}
		
		try {
			
			Albergo albergo;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = conn.prepareStatement(comando);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				albergo = new Albergo();
				albergo.setAlbergo_ID(rs.getInt(1));
				albergo.setNome(rs.getString(2));
				albergo.setCategoria(categoriaalbergo.valueOf(rs.getObject(3).toString()));
				albergo.setStelle(rs.getInt(4));
				albergo.setVoto(rs.getDouble(5));
				albergo.setTesto(rs.getString(6));
				albergo.setNumero_Camere(rs.getInt(7));
				albergo.setLuogo_FK(rs.getInt(8));
				albergo.setFascia_Prezzo(prezzo.valueOf(rs.getObject(9).toString()));
				albergo.setFoto(rs.getBytes(10));
				this.alberghi.add(albergo);
			} 
		
	} catch (Exception e) {
		System.out.println("ERROR IN SQL" + e);
		JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero dell'albergo by filtro");	
		
	}
}}