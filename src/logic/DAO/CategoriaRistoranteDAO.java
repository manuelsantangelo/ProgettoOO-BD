package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tipi.tiporistorante;
import logic.Controller;

public class CategoriaRistoranteDAO {
	Controller controller;
	ArrayList<tiporistorante> tipoRistoranteList = new ArrayList<tiporistorante>();
	private tiporistorante tipoR;
	
	public void setTipoR(tiporistorante tipoR) {
		this.tipoR = tipoR;
	}
	
	public tiporistorante getTipoR() {
		return tipoR;
	}
	
	public ArrayList<tiporistorante> getTipoRistoranteList() {
		return tipoRistoranteList;
	}
	
	public void setTipo (Connection conn) {
		String comando = "Select * from \"CategoriaRistorante\" where \"Tipo\" = " + controller.getAssociazione_Categoria_RistoranteDAO().getAssociazione_categoria_ristorante().getCategoria_Ristorante_FK();
		
		try {
			PreparedStatement ps = conn.prepareStatement(comando);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tiporistorante tiporis;
				tiporis = tiporistorante.valueOf(rs.getObject(1).toString());
				tipoRistoranteList.add(tiporis);
	}
		
		
		}
		 catch (Exception e) {
			 System.out.println("ERROR IN SQL" + e);
				JOptionPane.showMessageDialog(null, "ERRORE! Qualcosa è andato storto con il recupero della catRistorante");	
			
		} 
		
		System.out.println(tipoRistoranteList.size());
	}


}
