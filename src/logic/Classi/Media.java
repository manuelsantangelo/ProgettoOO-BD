package logic.Classi;

public class Media {
	private byte[] Foto;
	private int Ristorante_FK;
	private int Albergo_FK;
	private int Attrazione_FK;
	public byte[] getFoto() {
		return Foto;
	}
	public void setFoto(byte[] foto) {
		Foto = foto;
	}
	public int getRistorante_FK() {
		return Ristorante_FK;
	}
	public void setRistorante_FK(int ristorante_FK) {
		Ristorante_FK = ristorante_FK;
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
	public Media(byte[] foto, int ristorante_FK, int albergo_FK, int attrazione_FK) {
		super();
		Foto = foto;
		Ristorante_FK = ristorante_FK; // può essere null
		Albergo_FK = albergo_FK; // può essere null
		Attrazione_FK = attrazione_FK; // può essere null
	}
	
}
