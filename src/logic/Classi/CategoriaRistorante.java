package logic.Classi;
import Tipi.*;

public class CategoriaRistorante {
	
	private tiporistorante Tipo;
	
	public tiporistorante getTipo() {
		return Tipo;
	}
	public void setTipo(tiporistorante tipo) {
		Tipo = tipo;
	}

	public CategoriaRistorante(tiporistorante tipo) {
		super();
		Tipo = tipo;
	}
		
}
