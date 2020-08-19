package logic.Classi;

public class Recensione {
	private int Review_ID;
	private String Testo;
	private int Stelle;
	private int MiPiace;
	private boolean Approvata;
	private int User_FK1;
	private int Moderatore_FK;
	private int Albergo_FK;
	private int Attrazione_FK;
	private int Ristorante_FK;
	public int getReview_ID() {
		return Review_ID;
	}
	public void setReview_ID(int review_ID) {
		Review_ID = review_ID;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public int getStelle() {
		return Stelle;
	}
	public void setStelle(int stelle) {
		Stelle = stelle;
	}
	public int getMiPiace() {
		return MiPiace;
	}
	public void setMiPiace(int miPiace) {
		MiPiace = miPiace;
	}
	public boolean isApprovata() {
		return Approvata;
	}
	public void setApprovata(boolean approvata) {
		Approvata = approvata;
	}
	public int getUser_FK1() {
		return User_FK1;
	}
	public void setUser_FK1(int user_FK1) {
		User_FK1 = user_FK1;
	}
	public int getModeratore_FK() {
		return Moderatore_FK;
	}
	public void setModeratore_FK(int moderatore_FK) {
		Moderatore_FK = moderatore_FK;
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
	public int getRistorante_FK() {
		return Ristorante_FK;
	}
	public void setRistorante_FK(int ristorante_FK) {
		Ristorante_FK = ristorante_FK;
	}
	public Recensione(String testo, int stelle, int user_FK1, int albergo_FK, int attrazione_FK, int ristorante_FK) {
		super();
		Testo = testo;
		Stelle = stelle;
		User_FK1 = user_FK1;
		Albergo_FK = albergo_FK;
		Attrazione_FK = attrazione_FK;
		Ristorante_FK = ristorante_FK;
	}

	
}
