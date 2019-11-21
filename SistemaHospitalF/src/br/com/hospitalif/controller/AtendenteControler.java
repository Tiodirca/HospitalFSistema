package br.com.hospitalif.controller;

import java.io.IOException;

import App.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AtendenteControler extends Main {

	@FXML
    private Button btnCadPaciente;

    @FXML
    private Button btnVoltar;


    @FXML
    void back(ActionEvent event) throws IOException {
    	openPage(Rotas.Dash);
    }

    @FXML
    void cadPaciente(ActionEvent event) throws IOException {
    	openPage(Rotas.Paciente);
    }

}

