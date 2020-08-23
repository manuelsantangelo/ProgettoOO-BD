package logic.Classi;
import Tipi.*;

public class Attrazione {
	private int Attrazione_ID;
	private String Nome;
	private tipoattrazione Tipo;
	private double Voto;
	private String Descrizione;
	private prezzo Fascia_Prezzo;
	private int Luogo_FK;
	public int getAttrazione_ID() {
		return Attrazione_ID;
	}
	public void setAttrazione_ID(int attrazione_ID) {
		Attrazione_ID = attrazione_ID;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public tipoattrazione getTipo() {
		return Tipo;
	}
	public void setTipo(tipoattrazione tipo) {
		Tipo = tipo;
	}
	public double getVoto() {
		return Voto;
	}
	public void setVoto(double voto) {
		Voto = voto;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public prezzo getFascia_Prezzo() {
		return Fascia_Prezzo;
	}
	public void setFascia_Prezzo(prezzo fascia_Prezzo) {
		Fascia_Prezzo = fascia_Prezzo;
	}
	public int getLuogo_FK() {
		return Luogo_FK;
	}
	public void setLuogo_FK(int luogo_FK) {
		Luogo_FK = luogo_FK;
	}
	public Attrazione(String nome, tipoattrazione tipo, String descrizione, prezzo fascia_Prezzo, int luogo_FK) {
		super();
		Nome = nome;
		Tipo = tipo;
		Descrizione = descrizione;
		Fascia_Prezzo = fascia_Prezzo;
		Luogo_FK = luogo_FK;
	}
	
	public Attrazione() {
		
	}
	
	
}
