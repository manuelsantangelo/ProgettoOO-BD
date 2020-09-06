package logic.Classi;

public class Contatti {
	private String Telefono;
	private String SitoWeb;
	private int Contatti_ID;
	private int Ristorante_FK;
	private int Albergo_FK;
	private int Attrazione_FK;
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getSitoWeb() {
		return SitoWeb;
	}
	public void setSitoWeb(String sitoWeb) {
		SitoWeb = sitoWeb;
	}
	public int getContatti_ID() {
		return Contatti_ID;
	}
	public void setContatti_ID(int contatti_ID) {
		Contatti_ID = contatti_ID;
	}
	public int getRistorante_FK() {
		return Ristorante_FK;
	}
	public void setRistorante_FK(int ristorante_FK) {
		Ristorante_FK = ristorante_FK;
	}
	public int getAlbergo_FK() {
		return Albergo_FK;
	}
	public void setAlbergo_FK(int albergo_FK) {
		Albergo_FK = albergo_FK;
	}
	public int getAttrazione_FK() {
		return Attrazione_FK;
	}
	public void setAttrazione_FK(int attrazione_FK) {
		Attrazione_FK = attrazione_FK;
	}

	public Contatti() {
	}
	
}
