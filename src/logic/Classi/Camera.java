package logic.Classi;
import Tipi.*;

public class Camera {
	private tipocamera TipoDiCamera;
	private prezzo Fascia_Prezzo;
	private int Albergo_FK;
	public tipocamera getTipoDiCamera() {
		return TipoDiCamera;
	}
	public void setTipoDiCamera(tipocamera tipoDiCamera) {
		TipoDiCamera = tipoDiCamera;
	}
	public prezzo getFascia_Prezzo() {
		return Fascia_Prezzo;
	}
	public void setFascia_Prezzo(prezzo fascia_Prezzo) {
		Fascia_Prezzo = fascia_Prezzo;
	}
	public int getAlbergo_FK() {
		return Albergo_FK;
	}
	public void setAlbergo_FK(int albergo_FK) {
		Albergo_FK = albergo_FK;
	}
	public Camera(tipocamera tipoDiCamera, prezzo fascia_Prezzo, int albergo_FK) {
		super();
		TipoDiCamera = tipoDiCamera;
		Fascia_Prezzo = fascia_Prezzo;
		Albergo_FK = albergo_FK;
	}

	
}
