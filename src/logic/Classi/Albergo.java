package logic.Classi;
import Tipi.*;

public class Albergo {
	private int Albergo_ID;
	private String Nome;
	private categoriaalbergo Categoria;
	private int Stelle;
	private double Voto;
	private String Testo;
	private int Numero_Camere;
	private int Luogo_FK;
	private prezzo Fascia_Prezzo;
	private byte[] Foto;
	
	public int getAlbergo_ID() {
		return Albergo_ID;
	}
	public void setAlbergo_ID(int albergo_ID) {
		Albergo_ID = albergo_ID;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public categoriaalbergo getCategoria() {
		return Categoria;
	}
	public void setCategoria(categoriaalbergo categoria) {
		Categoria = categoria;
	}
	
	public prezzo getFascia_Prezzo() {
		return Fascia_Prezzo;
	}
	
	public void setFascia_Prezzo(prezzo fascia_Prezzo) {
		Fascia_Prezzo = fascia_Prezzo;
	}
	
	public byte[] getFoto() {
		return Foto;
	}
	
	public void setFoto(byte[] foto) {
		Foto = foto;
	}
	
	public int getStelle() {
		return Stelle;
	}
	public void setStelle(int stelle) {
		Stelle = stelle;
	}
	public double getVoto() {
		return Voto;
	}
	public void setVoto(double voto) {
		Voto = voto;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public int getNumero_Camere() {
		return Numero_Camere;
	}
	public void setNumero_Camere(int numero_Camere) {
		Numero_Camere = numero_Camere;
	}
	public int getLuogo_FK() {
		return Luogo_FK;
	}
	public void setLuogo_FK(int luogo_FK) {
		Luogo_FK = luogo_FK;
	}
	public Albergo(String nome, categoriaalbergo categoria, int stelle, String testo, int numero_Camere, int luogo_FK) {
		super();
		Nome = nome;
		Categoria = categoria;
		Stelle = stelle;
		Testo = testo;
		Numero_Camere = numero_Camere;
		Luogo_FK = luogo_FK;
		
	}
	
	public Albergo() {
		
	}
	

}
