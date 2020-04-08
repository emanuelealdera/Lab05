package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

import java.util.ArrayList;

public class Model {
	
	Ricerca ricerca = new Ricerca () ;
	AnagrammaDAO aDAO = new AnagrammaDAO () ;

	/**
	 * metodo che restituisce tutti gli anagrammi della parola data
	 * @param parola parola da anagrammare
	 * @return 
	 */
	public List <String> getAnagrammi (String parola) {
		return ricerca.cerca(parola);
	}
	
	/**
	 * data una parola, restituisce tutti gli anagrammi che compaiono nel database
	 * @param parola da anagrammare
	 * @return lista di anagrammi corretti sotto forma di stringhe
	 */
	public List <String> getAnagrammiCorretti (String parola) { 
		List <String> corretti = new ArrayList <> ();
		for (String s : getAnagrammi(parola)) {
			if (aDAO.isCorretto(s))
				corretti.add(s);
		}
		return corretti;
	}
	

}
