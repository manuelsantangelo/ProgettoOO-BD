package logic.Classi;
import Tipi.*;

public class CategoriaRistorante {
	
	private tiporistorante Tipo;
	private int CategoriaRistorante_ID;
	
	public tiporistorante getTipo() {
		return Tipo;
	}
	public void setTipo(tiporistorante tipo) {
		Tipo = tipo;
	}
	public int getCategoriaRistorante_ID() {
		return CategoriaRistorante_ID;
	}
	public void setCategoriaRistorante_ID(int categoriaRistorante_ID) {
		CategoriaRistorante_ID = categoriaRistorante_ID;
	}
	public CategoriaRistorante(tiporistorante tipo) {
		super();
		Tipo = tipo;
	}
	
	
}
