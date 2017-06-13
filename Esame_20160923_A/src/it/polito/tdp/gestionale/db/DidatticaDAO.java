package it.polito.tdp.gestionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import it.polito.tdp.gestionale.model.Map;
import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.Nodo;
import it.polito.tdp.gestionale.model.Studente;

public class DidatticaDAO {
	private Map m= new Map();

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(String codins) {

		final String sql = "SELECT * FROM corso where codins=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),
						rs.getInt("pd"));
				return corso;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Data una matricola ottengo lo studente.
	 */
	public Studente getStudente(int matricola) {

		final String sql = "SELECT * FROM studente where matricola=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				
				return studente;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public List<Studente> ListaStudenti(){
		
		final String sql= "SELECT * FROM  studente, `iscritti_corsi_gestionale`.`iscrizione` "+
		                     " WHERE `iscrizione`.`matricola` = studente.matricola ";

		List<Studente> lista= new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("cds"));
				
				m.put(rs.getString("codins"), studente);
				lista.add(studente);
				
			}

			return lista;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
	}
	
public List<Corso> ListaCorso(){
		
		final String sql= "SELECT * FROM corso, `iscritti_corsi_gestionale`.`iscrizione` "+
		                     " WHERE `iscrizione`.`codins` = corso.codins ";
		List<Corso> lista= new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),
						rs.getInt("pd"));
				m.put(rs.getString("codins"), corso);
				lista.add(corso);
				
			}

			return lista;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
	}

public String Iscrizioni(){
	
	final String sql= "SELECT * FROM `iscritti_corsi_gestionale`.`iscrizione` ";
	//List<Studente> lista= new ArrayList<>();
	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		String s="";

		while (rs.next()) {

			s=s+rs.getInt("matricola")+" corso "+rs.getString("codins")+"\n";
			
		}

		return s;

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}
	
	
}
     public Map getM(){
    	 return m;
     }

	// Test main
	public static void main(String[] args) {
		
		DidatticaDAO dd = new DidatticaDAO();
		System.out.println(dd.getCorso("01JEFPG"));
		System.out.println(dd.getStudente(134806));
		
		System.out.println(dd.ListaStudenti());
		System.out.println(dd.ListaCorso());
		//System.out.println(dd.Iscrizioni());
		System.out.println("ooooooooo");
		System.out.println(dd.getM());
	}

}
