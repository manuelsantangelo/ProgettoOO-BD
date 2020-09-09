package logic.Classi;

import Tipi.*;

public class Ristorante {
	private int Ristorante_ID;
	private String Nome;
	private int Stelle_Michelin;
	private double Voto;
	private String Descrizione;
	private prezzo Fascia_Prezzo;
	private int Luogo_FK;
	private byte[] Foto;
	
	public int getRistorante_ID() {
		return Ristorante_ID;
	}
	public void setRistorante_ID(int ristorante_ID) {
		Ristorante_ID = ristorante_ID;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getStelle_Michelin() {
		return Stelle_Michelin;
	}
	public void setStelle_Michelin(int stelle_Michelin) {
		Stelle_Michelin = stelle_Michelin;
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
	public void setDescrizione(String descizione) {
		Descrizione = descizione;
	}
	public prezzo getFascia_Prezzo() {
		return Fascia_Prezzo;
	}
	public void setFascia_Prezzo(prezzo fascia_Prezzo) {
		Fascia_Prezzo = fascia_Prezzo;
	}
	
	public void setFoto(byte[] foto) {
		Foto = foto;
	}
	public byte[] getFoto() {
		return Foto;
	}
	public int getLuogo_FK() {
		return Luogo_FK;
	}
	public void setLuogo_FK(int luogo_FK) {
		Luogo_FK = luogo_FK;
	}
	
	public Ristorante() {
		
	}

}
