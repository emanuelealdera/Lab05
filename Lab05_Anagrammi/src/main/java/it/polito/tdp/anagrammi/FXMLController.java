package it.polito.tdp.anagrammi;

import java.util.List;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private TextField parola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea corretti;

    @FXML
    private TextArea nonCorretti;

    @FXML
    private Button btnReset;

    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	this.corretti.clear(); this.nonCorretti.clear();
    	String parola = this.parola.getText().toLowerCase();
    	for (int i=0; i<parola.length(); i++) {
    		if (Character.isLetter(parola.charAt(i)) == false) {
    			this.corretti.setText("Please insert only letters in the word!!");
    			return;
    	}}
    	String corrette=""; 
    	String nonCorrette="";
    	
    	List <String> anagrammiCorretti = model.getAnagrammiCorretti(parola);
    	
    	for (String s : anagrammiCorretti) {
    		corrette+=s+"\n";
    	}
    	for (String s : model.getAnagrammi(parola)) {
    		if (!anagrammiCorretti.contains(s))
    			nonCorrette+=s+"\n";
    	}
    	this.corretti.setText(corrette);
    	this.nonCorretti.setText(nonCorrette);
    }

    @FXML
    void reset(ActionEvent event) {
    	this.corretti.clear();
    	this.nonCorretti.clear();
    	this.parola.clear();
    }
    
    public void setModel (Model model) {
    	this.model=model;
    }

}
