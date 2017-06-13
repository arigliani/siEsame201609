package it.polito.tdp.gestionale;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DidatticaGestionaleController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtMatricolaStudente;

	@FXML
	private TextArea txtResult;

	@FXML
	void doCorsiFrequentati(ActionEvent event) {
	}
	
	@FXML
	void doVisualizzaCorsi(ActionEvent event) {
	}

	@FXML
	void initialize() {
		assert txtMatricolaStudente != null : "fx:id=\"txtMatricolaStudente\" was not injected: check your FXML file 'DidatticaGestionale.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DidatticaGestionale.fxml'.";

	}

}
