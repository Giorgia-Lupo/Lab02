package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<WordEnhanced>parole = new LinkedList<WordEnhanced>();	
	
	public WordEnhanced cercaParolaAliena (String alienWord) {
		for(WordEnhanced w : this.parole) {
			if(alienWord.contains(w.getAlienWord()))
				return w;
		}
		return null;
	}
		
	public void addWord(String alienWord, String translation) {	
		if(this.cercaParolaAliena(alienWord) != null) 
			this.cercaParolaAliena(alienWord).setTranslation(translation);		
		else
			parole.add(new WordEnhanced(alienWord, translation));		
	}
	
	public Collection<String> translateWord(String alienWord) {
		if(this.cercaParolaAliena(alienWord) == null)
			return null; //"Non trovata";
		else
			return this.cercaParolaAliena(alienWord).getTranslation();			
	}
	
	public void cancella() {
		this.parole.clear();
	}

}
