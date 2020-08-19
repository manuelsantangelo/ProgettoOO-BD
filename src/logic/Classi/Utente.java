package logic.Classi;

import java.sql.Date;

public class Utente {
	private int User_ID;
	private String Password;
	private String Nome;
	private String Nickname;
	private String Email;
	private Date Data_Iscrizione;
	private Date Data_di_Nascita;
	private String Cognome;
	private String Città;
	private byte[] Propic;
	private int Contributi;
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getData_Iscrizione() {
		return Data_Iscrizione;
	}
	public void setData_Iscrizione(Date data_Iscrizione) {
		Data_Iscrizione = data_Iscrizione;
	}
	public Date getData_di_Nascita() {
		return Data_di_Nascita;
	}
	public void setData_di_Nascita(Date data_di_Nascita) {
		Data_di_Nascita = data_di_Nascita;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getCittà() {
		return Città;
	}
	public void setCittà(String città) {
		Città = città;
	}
	public byte[] getPropic() {
		return Propic;
	}
	public void setPropic(byte[] propic) {
		Propic = propic;
	}
	public int getContributi() {
		return Contributi;
	}
	public void setContributi(int contributi) {
		Contributi = contributi;
	}
	
	public Utente() {	
	}
	
	public Utente(String password, String nome, String nickname, String email, Date data_di_Nascita, String cognome,
			String città, byte[] propic) {
		super();
		Password = password;
		Nome = nome;
		Nickname = nickname;
		Email = email;
		Data_di_Nascita = data_di_Nascita;
		Cognome = cognome;
		Città = città;
		Propic = propic;
	}

}
