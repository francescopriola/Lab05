package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Anagramma model;
	
	public void setModel(Anagramma model) {
		this.model = model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textAnagramma;

    @FXML
    private TextArea textCorretti;

    @FXML
    private TextArea textWrong;

    @FXML
    void doAnagramma(ActionEvent event) {
    	this.textCorretti.clear();
    	this.textWrong.clear();
    	
    	String s = this.textAnagramma.getText();
    	
    	if(s.length() > 7) {
    		this.textWrong.appendText("Inserisci una parola con non piu' di 7 caratteri.\n");
    		this.textCorretti.appendText("Inserisci una parola con non piu' di 7 caratteri.\n");
    		return;
    	}
    	Set<String> anagrammi = model.anagramma(s);
    	
    	for(String p : anagrammi) {
    		if(model.isCorrect(p))
    			this.textCorretti.appendText(p + "\n");
    		else
    			this.textWrong.appendText(p + "\n");
    	}
    		
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.textAnagramma.clear();
    	this.textCorretti.clear();
    	this.textWrong.clear();
    }

    @FXML
    void initialize() {
        assert textAnagramma != null : "fx:id=\"textAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textCorretti != null : "fx:id=\"textCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textWrong != null : "fx:id=\"textWrong\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
