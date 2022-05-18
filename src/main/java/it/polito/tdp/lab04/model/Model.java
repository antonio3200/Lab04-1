package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	

	public Model() {
		super();
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}
	



	public List<String> getNomiCorsi(){
		List<String> result= new ArrayList<>();
		for(Corso c : this.corsoDao.getTuttiICorsi()) {
			result.add(c.getNome());
		}
		result.add("");
		Collections.sort(result);
		return result;
	}
	
	public Studente getStudenteByMatricola(int matricola) {
		for(Studente s : this.studenteDao.getStudenti()) {
			if( s.matricola==matricola)
				return s;
		}
		return null;
	}
	public List<Studente> getStudentiByCorso(Corso corso){
		return this.corsoDao.getStudentiIscrittiAlCorso(corso);
	}
}
