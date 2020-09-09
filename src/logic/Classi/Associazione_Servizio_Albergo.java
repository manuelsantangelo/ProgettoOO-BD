package logic.Classi;

import Tipi.tiposervizio;

public class Associazione_Servizio_Albergo {
	private int Albergo_FK;
	private tiposervizio Servizio_FK;
	
	public int getAlbergo_FK() {
		return Albergo_FK;
	}
	
	public Associazione_Servizio_Albergo() {
		
	}
	public void setAlbergo_FK(int albergo_FK) {
		Albergo_FK = albergo_FK;
	}
	public tiposervizio getServizio_FK() {
		return Servizio_FK;
	}
	
	public void setServizio_FK(tiposervizio servizio_FK) {
		Servizio_FK = servizio_FK;
	}
	
}
