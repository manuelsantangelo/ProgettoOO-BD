 package logic;

import gui.*;
import logic.Classi.Albergo;
import logic.Classi.Attrazione;
import logic.Classi.Moderatore;
import logic.Classi.Ristorante;
import logic.DAO.AlbergoDAO;
import logic.DAO.Associazione_Categoria_RistoranteDAO;
import logic.DAO.Associazione_Servizio_AlbergoDAO;
import logic.DAO.AttrazioneDAO;
import logic.DAO.CategoriaRistoranteDAO;
import logic.DAO.ContattiDAO;
import logic.DAO.LuogoDAO;
import logic.DAO.ModeratoreDAO;
import logic.DAO.RecensioneDAO;
import logic.DAO.RistoranteDAO;
import logic.DAO.UtenteDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Controller {
	//CAMBIARE VALORI URL, USERNAME E PASS IN BASE AL PROPRIO DATABASE!!!!
	private String  url =  "jdbc:postgresql://rogue.db.elephantsql.com:5432/tdzrnvmi";
	private String username = "tdzrnvmi";
	private String pass = "Qs1bbw564IBF7ktInw6e0CAa8EH2jKUR";
	
	private Connection conn;
	
	
	//inizializza DAO
	
	private UtenteDAO utenteDAO = new UtenteDAO(this);
	private LuogoDAO luogoDAO = new LuogoDAO(this);
	private RistoranteDAO ristoranteDAO = new RistoranteDAO(this);
	private ContattiDAO contattiDAO = new ContattiDAO(this);
	private Associazione_Categoria_RistoranteDAO associazione_categoria_ristoranteDAO = new Associazione_Categoria_RistoranteDAO(this);
	private AlbergoDAO albergoDAO = new AlbergoDAO(this);
	private Associazione_Servizio_AlbergoDAO associazione_servizio_albergoDAO = new Associazione_Servizio_AlbergoDAO(this);
	private AttrazioneDAO attrazioneDAO = new AttrazioneDAO(this);
	private ModeratoreDAO moderatoreDAO = new ModeratoreDAO(this);
	private RecensioneDAO recensioneDAO = new RecensioneDAO(this);
	private CategoriaRistoranteDAO categoriaristoranteDAO = new CategoriaRistoranteDAO();

	
	//inizializza FINESTRE
	private HomePage home;
	private Iscrizione iscrizione;
	private Moderatore_Homepage mod;
	private ApprovaRecensione approvaRecensione;
	private Aggiungi_Ristorante addRest;
	private Aggiungi_Hotel addHotel;
	private Aggiungi_Attrazione addAtt;
	private Principale principale;
	private Elimina_Attrazione delAtt;
	private Elimina_Ristorante delRest;
	private Elimina_Hotel delHotel;
	private ScriviRecensioneRistorante scriviRecRis;
	private ScriviRecensioneAlbergo scriviRecAlb;
	private ScriviRecensioneAttrazione scriviRecAttr;
	
	
	private int indice;
	
	
	//****************************************
	
	public Controller() {
		ConnectToDatabase();
		InizializzaFinestre();
		
	}

	public void ConnectToDatabase() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			MostraMessaggioErrore ("Errore", "Driver non trovato!");
		}
		
		try { 
			conn = DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			MostraMessaggioErrore ("Errore", e.getMessage());
		}
	}

	public void InizializzaFinestre() {
//inizializza le finestre e passa il controllore come parametro 
		
		home = new HomePage(this);
		iscrizione = new Iscrizione(this);
		addRest = new Aggiungi_Ristorante(this);
		addHotel = new Aggiungi_Hotel(this);
		addAtt = new Aggiungi_Attrazione(this);
		delAtt = new Elimina_Attrazione(this);
		delRest = new Elimina_Ristorante(this);
		delHotel = new Elimina_Hotel(this);
		
		home.setVisible(true);

	}
	
	public void MostraMessaggioErrore( String titolo, String testo) {
		JOptionPane.showMessageDialog(null, testo, titolo, JOptionPane.ERROR_MESSAGE);
	}
	
	//metodo per cambiare finestre
	public void CambiaFrame (JFrame frameDaNascondere, JFrame frameDaMostrare) {
		 ChiudiFrame(frameDaNascondere);
		 frameDaMostrare.setVisible(true);
	}
	
	public void CambiaFrame2(JFrame frameDaNascondere, JFrame frameDaMostrare) {
		ChiudiFrame(frameDaNascondere);
		frameDaNascondere = null;
		frameDaMostrare.setVisible(true);
	}

	//metodo per chiudere finestra
	public void ChiudiFrame(JFrame frameDaChiudere) {
		frameDaChiudere.dispose();	
	}


	
// i getter per le DAO
	
	public UtenteDAO getUtenteDAO() {
		return utenteDAO;
	}
	
	public LuogoDAO getLuogoDAO() {
		return luogoDAO;
	}
	
	public RistoranteDAO getRistoranteDAO() {
		return ristoranteDAO;
	}
	
	public ContattiDAO getContattiDAO() {
		return contattiDAO;
	}
	
	public Associazione_Categoria_RistoranteDAO getAssociazione_Categoria_RistoranteDAO() {
		return associazione_categoria_ristoranteDAO;
	}
		
	public AlbergoDAO getAlbergoDAO(){
		return albergoDAO;
	}
	
	public Associazione_Servizio_AlbergoDAO getAssociazione_Servizio_AlbergoDAO() {
		return associazione_servizio_albergoDAO;
	}
	
	public AttrazioneDAO getAttrazioneDAO() {
		return attrazioneDAO;
	}
	
	public ModeratoreDAO getModeratoreDAO() {
		return moderatoreDAO;
	}
	
	public RecensioneDAO getRecensioneDAO() {
		return recensioneDAO;
	}

	public CategoriaRistoranteDAO getCategoriaristoranteDAO() {
		return categoriaristoranteDAO;
	}
// i metodi seguenti servono per passare le finestre quando vengono chiamati i metodi CambiaFrame e ChiudiFrame
	
	public Iscrizione getIscrizione() {
		return iscrizione;
	}
	
	public HomePage getHome() {
		return home;
	}
	
	public Aggiungi_Ristorante getAggiungi_Ristorante() {
		return addRest;
	}
	
	public Moderatore_Homepage getModeratore_Homepage() {
		mod = new Moderatore_Homepage(this);
		return mod;
	}
	
	public ApprovaRecensione getApprovaRecensione() {
		approvaRecensione = new ApprovaRecensione(this);
		return approvaRecensione;
	}
	public Principale getPrincipale() throws IOException {
		principale = new Principale(this);
		return principale;
		
	}
	
	public ScriviRecensioneRistorante getScriviRecensioneRis() throws IOException{
		scriviRecRis = new ScriviRecensioneRistorante(this);
		return scriviRecRis;
	}
	
	public ScriviRecensioneAlbergo getScriviRecensioneAlb() throws IOException {
		scriviRecAlb = new ScriviRecensioneAlbergo(this);
		return scriviRecAlb;
	}
	
	public ScriviRecensioneAttrazione getScriviRecensioneAttr() throws IOException{
		scriviRecAttr = new ScriviRecensioneAttrazione(this);
		return scriviRecAttr;
		}
	
	public Aggiungi_Hotel getAggiungi_Hotel() {
		return addHotel;
	}
	
	public Aggiungi_Attrazione getAggiungi_Attrazione() {
		return addAtt;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public Elimina_Attrazione getElimina_Attrazione() {
		return delAtt;
	}
	public Elimina_Ristorante getElimina_Ristorante() {
		return delRest;
	}

	public Elimina_Hotel getElimina_Hotel() {
		return delHotel;
			}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public int getIndice() {
		return indice;
	}
	

}
