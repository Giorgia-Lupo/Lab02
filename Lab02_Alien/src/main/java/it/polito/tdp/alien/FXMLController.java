package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTranslate;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	this.dizionario.cancella();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String s = this.txtTranslate.getText().toLowerCase();
    	txtTranslate.clear();
    	
    	String array[] = s.split(" ");
    	
    	if(array.length == 1 && isOK(array[0])==true) {
    		this.txtResult.setText("La traduzione e': "+this.dizionario.translateWord(array[0]));    		
    	}
    	
    	else if(array.length == 2 && isOK(array[0])==true && isOK(array[1])==true) {
    		this.dizionario.addWord(array[0], array[1]);    			
			this.txtResult.setText("Parola aggiunta al dizionario!\n");
    	}
    	
    	else
    		txtResult.setText("Errore nell'inseriemento");
    }    	    	
    
    boolean isOK(String alienWord) {
    	for(char c : alienWord.toCharArray()) 
    		if(!Character.isLetter(c))
    			return false;    		
    	return true;
    }
    
    @FXML
    void initialize() {
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        dizionario = new AlienDictionary();
    }
}
