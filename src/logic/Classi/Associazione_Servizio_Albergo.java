package logic.Classi;

public class Associazione_Servizio_Albergo {
	private int Albergo_FK;
	private int Servizio_FK;
	public int getAlbergo_FK() {
		return Albergo_FK;
	}
	public void setAlbergo_FK(int albergo_FK) {
		Albergo_FK = albergo_FK;
	}
	public int getServizio_FK() {
		return Servizio_FK;
	}
	public void setServizio_FK(int servizio_FK) {
		Servizio_FK = servizio_FK;
	}
	public Associazione_Servizio_Albergo(int albergo_FK, int servizio_FK) {
		super();
		Albergo_FK = albergo_FK;
		Servizio_FK = servizio_FK;
	}
}
