package logic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.Classi.Contatti;

public class ContattiDAO {
	
	Controller controller;
	private Contatti contatti = new Contatti();
	private ArrayList<Contatti> sitoEtelefono = new ArrayList<Contatti>();
	
	public ArrayList<Contatti> getSitoEtelefono() {
		return sitoEtelefono;
	}
	public Contatti getContatti() {
		return contatti;
	}
	public void setContatti(Contatti contatti) {
		this.contatti = contatti;
	}

	public ContattiDAO(Controller controller) {
		this.controller = controller;	
	}
	
	public void addContattiRistorante(Connection conn, ArrayList<String> numTelefono, ArrayList<String> webSite, int ID) {
		String comando;
		comando = "INSERT INTO public.\"Contatti\"(\"Telefono\", \"SitoWeb\", \"Ristorante_FK\")VALUES (?, ?, ?);";
		
		int casotel = numTelefono.size();
		int casoweb = webSite.size();
		
		if(casotel >= casoweb) {
			for(int i = 0; i < casotel; i++) {
				if(webSite.get(i) != null) {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
						
						ps.setString(1, numTelefono.get(i));
						ps.setString(2, webSite.get(i));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}

				} else {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
						
						ps.setString(1, numTelefono.get(i));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}
				}
			}
		} else {
			for(int j = 0; j < casoweb; j++) {
				if(numTelefono.get(j) != null) {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
						
						ps.setString(1, numTelefono.get(j));
						ps.setString(2, webSite.get(j));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}
				} else {
					try {
						PreparedStatement ps = null;
						ps = conn.prepareStatement(comando);	
				
						ps.setString(2, webSite.get(j));
						ps.setInt(3, ID);
						
						ps.executeUpdate();
					} catch (SQLException e2) {
						System.out.println("ERROR IN SQL" + e2);
						JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
					}
				}
			}
		}
	}


public void addContattiAlbergo(Connection conn, ArrayList<String> numTelefono, ArrayList<String> webSite, int ID) {
	String comando;
	comando = "INSERT INTO public.\"Contatti\"(\"Telefono\", \"SitoWeb\", \"Albergo_FK\")VALUES (?, ?, ?);";
	
	int casotel = numTelefono.size();
	int casoweb = webSite.size();
	
	if(casotel >= casoweb) {
		for(int i = 0; i < casotel; i++) {
			if(webSite.get(i) != null) {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
					
					ps.setString(1, numTelefono.get(i));
					ps.setString(2, webSite.get(i));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}

			} else {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
					
					ps.setString(1, numTelefono.get(i));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}
			}
		}
	} else {
		for(int j = 0; j < casoweb; j++) {
			if(numTelefono.get(j) != null) {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
					
					ps.setString(1, numTelefono.get(j));
					ps.setString(2, webSite.get(j));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}
			} else {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
			
					ps.setString(2, webSite.get(j));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}
			}
		}
	}
}

public void addContattiAttrazione(Connection conn, ArrayList<String> numTelefono, ArrayList<String> webSite, int ID) {
	String comando;
	comando = "INSERT INTO public.\"Contatti\"(\"Telefono\", \"SitoWeb\", \"Attrazione_FK\")VALUES (?, ?, ?);";
	
	int casotel = numTelefono.size();
	int casoweb = webSite.size();
	
	if(casotel >= casoweb) {
		for(int i = 0; i < casotel; i++) {
			if(webSite.get(i) != null) {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
					
					ps.setString(1, numTelefono.get(i));
					ps.setString(2, webSite.get(i));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}

			} else {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
					
					ps.setString(1, numTelefono.get(i));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}
			}
		}
	} else {
		for(int j = 0; j < casoweb; j++) {
			if(numTelefono.get(j) != null) {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
					
					ps.setString(1, numTelefono.get(j));
					ps.setString(2, webSite.get(j));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}
			} else {
				try {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(comando);	
			
					ps.setString(2, webSite.get(j));
					ps.setInt(3, ID);
					
					ps.executeUpdate();
				} catch (SQLException e2) {
					System.out.println("ERROR IN SQL" + e2);
					JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con i contatti");
				}
			}
		}
	}
}

      public void setContattiAttrazioni(Connection conn) {
    	  String comando;
    	  comando = "Select * from \"Contatti\" where \"Attrazione_FK\" = " + controller.getAttrazioneDAO().getAttrazione().getAttrazione_ID();
    	  
    	  Contatti contattoAttrazione;
    	  try {

    		  PreparedStatement ps = conn.prepareStatement(comando);
    			ResultSet rs = ps.executeQuery();
    			
    		  while(rs.next()) {
    			  contattoAttrazione = new Contatti();
    			  contattoAttrazione.setTelefono(rs.getString(1));
    			  contattoAttrazione.setSitoWeb(rs.getString(2));
    			  contattoAttrazione.setContatti_ID(rs.getInt(3));
    			  contattoAttrazione.setAttrazione_FK(rs.getInt(6));

    			  this.sitoEtelefono.add(contattoAttrazione);
    			  
    		  }
    		  
    		  
		} catch (SQLException e) {
			System.out.println("ERROR IN SQL" + e);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con la select");		} 
    	  }
      
      public void setContattiAlbergo(Connection conn) {
    	  String comando;
    	  comando = "Select * from \"Contatti\" where \"Albergo_FK\" = " + controller.getAlbergoDAO().getAlbergo().getAlbergo_ID();
    	  
    	  Contatti contattoAlbergo;
    	  try {

    		  PreparedStatement ps = conn.prepareStatement(comando);
    			ResultSet rs = ps.executeQuery();
    			
    		  while(rs.next()) {
    			  contattoAlbergo = new Contatti();
    			  contattoAlbergo.setTelefono(rs.getString(1));
    			  contattoAlbergo.setSitoWeb(rs.getString(2));
    			  contattoAlbergo.setContatti_ID(rs.getInt(3));
    			  contattoAlbergo.setAlbergo_FK(rs.getInt(5));
    			  this.sitoEtelefono.add(contattoAlbergo);
    			  
    		  }
    		  
    		  
		} catch (SQLException e) {
			System.out.println("ERROR IN SQL" + e);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con la select");		} 
    	  }
      
      public void setContattiRistorante(Connection conn) {
    	  String comando;
    	  comando = "Select * from \"Contatti\" where \"Ristorante_FK\" = " + controller.getRistoranteDAO().getRistorante().getRistorante_ID();
    	  
    	  
    	  Contatti contattoRistorante;
    	  try {

    		  PreparedStatement ps = conn.prepareStatement(comando);
    			ResultSet rs = ps.executeQuery();
    			
    		  while(rs.next()) {
    			  contattoRistorante = new Contatti();
    			  contattoRistorante.setTelefono(rs.getString(1));
    			  contattoRistorante.setSitoWeb(rs.getString(2));
    			  contattoRistorante.setContatti_ID(rs.getInt(3));
    			  contattoRistorante.setRistorante_FK(rs.getInt(4));
    			  this.sitoEtelefono.add(contattoRistorante);


    		  }
    		  
    		  
		} catch (SQLException e) {
			System.out.println("ERROR IN SQL" + e);
			JOptionPane.showMessageDialog(null, "ERRORE! Qualcossa è andato storto con la select");		} 
    	  }
}
      
