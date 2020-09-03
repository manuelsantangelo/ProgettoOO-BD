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
	private tiporistorante tipoR;
	
	public void setTipoR(tiporistorante tipoR) {
		this.tipoR = tipoR;
	}
	
	public tiporistorante getTipoR() {
		return tipoR;
	}
	
}
