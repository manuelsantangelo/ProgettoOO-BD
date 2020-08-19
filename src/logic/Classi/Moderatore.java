package logic.Classi;

public class Moderatore {
	private int Moderatore_ID;
	private String Sede;
	private String Nome;
	private String Cognome;
	private String Email;
	private String Indirizzo;
	private String Data_Inizio_Lavoro;
	private String DataDiNascita;
	private String CF;
	private String Password;
	public int getModeratore_ID() {
		return Moderatore_ID;
	}
	public void setModeratore_ID(int moderatore_ID) {
		Moderatore_ID = moderatore_ID;
	}
	public String getSede() {
		return Sede;
	}
	public void setSede(String sede) {
		Sede = sede;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	public String getData_Inizio_Lavoro() {
		return Data_Inizio_Lavoro;
	}
	public void setData_Inizio_Lavoro(String data_Inizio_Lavoro) {
		Data_Inizio_Lavoro = data_Inizio_Lavoro;
	}
	public String getDataDiNascita() {
		return DataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		DataDiNascita = dataDiNascita;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Moderatore(String sede, String nome, String cognome, String email, String indirizzo,
			String data_Inizio_Lavoro, String dataDiNascita, String cF, String password) {
		super();
		Sede = sede;
		Nome = nome;
		Cognome = cognome;
		Email = email;
		Indirizzo = indirizzo;
		Data_Inizio_Lavoro = data_Inizio_Lavoro;
		DataDiNascita = dataDiNascita;
		CF = cF;
		Password = password;
	}
	
}
