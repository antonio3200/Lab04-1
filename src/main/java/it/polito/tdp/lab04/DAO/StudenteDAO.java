package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	public List<Studente> getStudenti(){
		final String sql= "SELECT * FROM studente";
		List<Studente> studenti= new LinkedList<Studente>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String CDS = rs.getString("CDS");
				
				Studente s =  new Studente(matricola,nome,cognome,CDS);
				studenti.add(s);
				

	}
			conn.close();
			return studenti;
		}
		catch(SQLException e) {
		     e.printStackTrace();
		     throw new RuntimeException("Errore db",e);
		}
		}

}
