package logic.Classi;

import Tipi.tiporistorante;

public class Associazione_Categoria_Ristorante {
	private int Ristorante_FK;
	private tiporistorante Categoria_Ristorante_FK;
	
	public Associazione_Categoria_Ristorante(int ristorante_FK, tiporistorante categoria_Ristorante_FK) {
		super();
		Ristorante_FK = ristorante_FK;
		Categoria_Ristorante_FK = categoria_Ristorante_FK;
	}
	public Associazione_Categoria_Ristorante() {
		
	}
	public int getRistorante_FK() {
		return Ristorante_FK;
	}
	public void setRistorante_FK(int ristorante_FK) {
		Ristorante_FK = ristorante_FK;
	}
	
	public tiporistorante getCategoria_Ristorante_FK() {
		return Categoria_Ristorante_FK;
	}
	
	public void setCategoria_Ristorante_FK(tiporistorante categoria_Ristorante_FK) {
		Categoria_Ristorante_FK = categoria_Ristorante_FK;
	}


}
