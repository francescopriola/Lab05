package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Anagramma {

	List<String> anagrammi;
	private AnagrammaDAO anagrammaDao;
	
	public Anagramma() {
		anagrammaDao = new AnagrammaDAO();
	}
	
	public boolean isCorrect(String anagramma) {
		return anagrammaDao.isCorrect(anagramma);
	}
	
	public List<String> anagramma(String s) {
		anagrammi = new ArrayList<String>();
		anagramma_ricorsiva("", 0, s);
		return anagrammi;
	}

	private List<String> anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		
		if (rimanenti.length() == 0) { /* caso terminale */
			anagrammi.add(parziale);
		} else {
			/* caso normale */
			// es: parziale="AC", livello=2, rimanenti="BD"
			for (int pos = 0; pos < rimanenti.length(); pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos + 1);
				anagramma_ricorsiva(nuova_parziale, livello + 1, nuova_rimanenti);
			}
		}
	return anagrammi;
	}
}
