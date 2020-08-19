package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.Classi.Contatti;

public class ContattiDAO {
	
	Controller controller;
	private Contatti contatti = new Contatti();
	
	public Contatti getContatti() {
		return contatti;
	}
	public void setContatti(Contatti contatti) {
		this.contatti = contatti;
	}

	public ContattiDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addContattiRistorante(Connection conn, ArrayList<String> numTelefono, ArrayList<String> webSite, int ID) {
		String comando;
		comando = "INSERT INTO public.\"Contatti\"(\"Telefono\", \"SitoWeb\", \"Ristorante_FK\")VALUES (?, ?, ?);";
		
		int casotel = numTelefono.size();
		int casoweb = webSite.size();
		
		if(casotel >= casoweb) {
			for(int i = 0; i < casotel; i++) {
				if(webSite.get(i) != null) {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
						
						ps.setString(1, numTelefono.get(i));
						ps.setString(2, webSite.get(i));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}

				} else {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
						
						ps.setString(1, numTelefono.get(i));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}
				}
			}
		} else {
			for(int j = 0; j < casoweb; j++) {
				if(numTelefono.get(j) != null) {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
						
						ps.setString(1, numTelefono.get(j));
						ps.setString(2, webSite.get(j));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}
				} else {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
				
						ps.setString(2, webSite.get(j));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}
				}
			}
		}
	}
}
