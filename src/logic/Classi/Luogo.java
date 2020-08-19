package logic.Classi;

public class Luogo {
	private String Stato;
	private String Città;
	private String Paese;
	private String Indirizzo;
	private int Luogo_ID;
	private int Ristorante_FK;
	private int Albergo_FK;
	public String getStato() {
		return Stato;
	}
	public void setStato(String stato) {
		Stato = stato;
	}
	public String getCittà() {
		return Città;
	}
	public void setCittà(String città) {
		Città = città;
	}
	public String getPaese() {
		return Paese;
	}
	public void setPaese(String paese) {
		Paese = paese;
	}
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	public int getLuogo_ID() {
		return Luogo_ID;
	}
	public void setLuogo_ID(int luogo_ID) {
		Luogo_ID = luogo_ID;
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
	
	public Luogo(String stato, String città, String paese, String indirizzo) {
		super();
		Stato = stato;
		Città = città;
		Paese = paese;
		Indirizzo = indirizzo;
	}
	public Luogo() {

	}
	
}
