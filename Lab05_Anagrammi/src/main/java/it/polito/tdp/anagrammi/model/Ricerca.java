package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	
	private List <String> soluzione;
	public List <String> cerca(String anagramma) {
		
		soluzione = new ArrayList <> ();
		List <Character> caratteri = new ArrayList <> ();
		for (int i=0;i<anagramma.length();i++) {
			caratteri.add(anagramma.charAt(i));
		}
		ricorsione ("", 0, caratteri);
		
		return soluzione;
		
	}
	
	private void ricorsione (String parziale, int livello, List <Character> rimanenti) {
		if (rimanenti.isEmpty()) {
			soluzione.add(parziale);
		}
		for (Character ch : rimanenti) {
			String prova = parziale + ch;
			List <Character> ridotta = new ArrayList <> (rimanenti) ;
			ridotta.remove(ch);
			ricorsione(prova, livello+1, ridotta);
		}
	}

}
