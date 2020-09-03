package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tipi.tiporistorante;
import logic.Controller;
import logic.Classi.Associazione_Categoria_Ristorante;
import logic.Classi.Contatti;

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
		
		public void setAssociazione_Categoria_RistoranteByID (Connection conn) {
		
			String comando = "Select \"CategoriaRistorante_FK\" from  \"Associazione_Categoria_Ristorante\" where "
					+ "\"Ristorante_FK\" = " + controller.getRistoranteDAO().getRistorante().getRistorante_ID();
			
			
			try {
				Associazione_Categoria_Ristorante asscatris;
				
				PreparedStatement ps = conn.prepareStatement(comando);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					asscatris = new Associazione_Categoria_Ristorante();
					
					asscatris.setCategoria_Ristorante_FK(tiporistorante.valueOf(rs.getObject(1).toString()));
					this.associazione_categoria_ristorante = asscatris;
					System.out.println(asscatris.getCategoria_Ristorante_FK());
				
					/*tiporistorante tiporis;
					tiporis = tiporistorante.valueOf(rs.getObject(1).toString());
					setAssociazione_categoria_ristorante(associazione_categoria_ristorante);
					tipoR.add(tiporis);*/
				}
				
				
			} catch (Exception e) {
				 System.out.println("ERROR IN SQL" + e);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero dell primo sql");			}
		}
		
		

	

	
}