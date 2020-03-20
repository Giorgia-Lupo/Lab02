package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private String translation;
	List<String> translations = new LinkedList<String>();
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public Collection<String> getTranslation() {
		return translations;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
		this.translations.add(translation);
	}
	
	
	public boolean equals(Object obj) {
		if(obj.equals(alienWord))
			return true;
		return false;
	}

}
