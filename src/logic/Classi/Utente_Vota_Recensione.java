package logic.Classi;

public class Utente_Vota_Recensione {
	private int User_FK;
	private int Review_FK;
	public int getUser_FK() {
		return User_FK;
	}
	public void setUser_FK(int user_FK) {
		User_FK = user_FK;
	}
	public int getReview_FK() {
		return Review_FK;
	}
	public void setReview_FK(int review_FK) {
		Review_FK = review_FK;
	}
	public Utente_Vota_Recensione(int user_FK, int review_FK) {
		super();
		User_FK = user_FK;
		Review_FK = review_FK;
	}

}
