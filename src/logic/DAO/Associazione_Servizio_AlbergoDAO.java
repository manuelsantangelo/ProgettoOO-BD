package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import Tipi.categoriaalbergo;
import Tipi.tiporistorante;
import Tipi.tiposervizio;
import logic.Controller;
import logic.Classi.Associazione_Servizio_Albergo;

public class Associazione_Servizio_AlbergoDAO {
	
	Controller controller;
	private Associazione_Servizio_Albergo associazione_servizio_albergo  = new Associazione_Servizio_Albergo();
	
	public Associazione_Servizio_Albergo getAssociazione_categoria_ristorante() {
		return associazione_servizio_albergo;
	}
	public void setAssociazione_categoria_ristorante(Associazione_Servizio_Albergo associazione_servizio_albergo) {
		this.associazione_servizio_albergo = associazione_servizio_albergo;
	}
	 public Associazione_Servizio_AlbergoDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addAssociazione_Servizio_Albergo(Connection conn, ArrayList<tiposervizio> type, int ID) {
		String comando;
		comando = "INSERT INTO public.\"Associazione_Servizio_Albergo\"(\"Albergo_FK\", \"Servizio_FK\") VALUES (?, ?);";
		try {
		for(int i = 0; i < type.size(); i++) {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(comando);
			
			ps.setInt(1, ID);
			ps.setObject(2, type.get(i), Types.OTHER);
			
			ps.executeUpdate();
		}
		
		} catch (SQLException e2) {
			System.out.println("ERROR IN SQL" + e2);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'Associazione dei tipi degli alberghi");
		}
		
		/*public void setServizioByID (Connection co) {
			
		}*/
		

	
}}


