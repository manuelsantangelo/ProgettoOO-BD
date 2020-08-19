package logic.Classi;

public class TipoMenu {
	private String Nome;
	private String Testo;
	private int Ristorante_FK;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public int getRistorante_FK() {
		return Ristorante_FK;
	}
	public void setRistorante_FK(int ristorante_FK) {
		Ristorante_FK = ristorante_FK;
	}
	public TipoMenu(String nome, String testo, int ristorante_FK) {
		super();
		Nome = nome;
		Testo = testo;
		Ristorante_FK = ristorante_FK;
	}

}
