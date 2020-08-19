package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tipi.tiporistorante;
import logic.Controller;
import logic.Classi.Associazione_Categoria_Ristorante;

public class Associazione_Categoria_RistoranteDAO {
	Controller controller;
	private Associazione_Categoria_Ristorante associazione_categoria_ristorante = new Associazione_Categoria_Ristorante();
	
	public Associazione_Categoria_Ristorante getAssociazione_categoria_ristorante() {
		return associazione_categoria_ristorante;
	}
	public void setAssociazione_categoria_ristorante(Associazione_Categoria_Ristorante associazione_categoria_ristorante) {
		this.associazione_categoria_ristorante = associazione_categoria_ristorante;
	}
	public Associazione_Categoria_RistoranteDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addAssociazione_Categoria_Ristorante(Connection conn, ArrayList<tiporistorante> type, int ID) {
		String comando;
		comando = "INSERT INTO public.\"Associazione_Categoria_Ristorante\"(\"Ristorante_FK\", \"CategoriaRistorante_FK\") VALUES (?, ?);";
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
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con l'Associazione dei tipi dei Ristoranti");
		}

	
}
}