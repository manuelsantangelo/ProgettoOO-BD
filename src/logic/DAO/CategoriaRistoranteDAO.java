package logic.DAO;

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
