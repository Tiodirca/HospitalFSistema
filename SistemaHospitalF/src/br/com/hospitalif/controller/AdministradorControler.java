package br.com.hospitalif.controller;

import java.io.IOException;

import App.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdministradorControler extends Main {

	@FXML
    private Button btnCadFuncionario;

    @FXML
    private Button btnVoltar;
    
    @FXML
    void back(ActionEvent event) throws IOException {
    	openPage(Rotas.Dash);
    }

    @FXML
    void cadFuncionario(ActionEvent event) throws IOException {
    	openPage(Rotas.Funcionario);
    }

}

