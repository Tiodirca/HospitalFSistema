package br.com.hospitalif.controller;

import java.io.IOException;

import App.Main;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashControler extends Main{

    @FXML
    private Button buttonAdministrador;

    @FXML
    private Button buttonEntrada;

    @FXML
    private Button buttonEnfermidadePessoal;

    @FXML
    private Button buttonGerente;

    @FXML
    private Button buttonMedico;

    @FXML
    private Button buttonEnfermidade;

    @FXML
    private Button buttonEnfermeiro;

    @FXML
    private Button buttonAtendimento;

    @FXML
    private Button buttonAtendente;

    @FXML
    private Button buttonVoltar;



    @FXML
    void Administrador(ActionEvent event) throws IOException {
    	openPage(Rotas.Administrador);
    }

    @FXML
    void Atendente(ActionEvent event) throws IOException {
    	openPage(Rotas.Atendente);
    }

    @FXML
    void Atendimento(ActionEvent event) throws IOException {
    	openPage(Rotas.Atendimento);
    }

    @FXML
    void Enfermeiro(ActionEvent event) throws IOException {
    	openPage(Rotas.Enfermeiro);
    }

    @FXML
    void Enfermidade(ActionEvent event) throws IOException {
    	openPage(Rotas.Enfermidade);
    }

    @FXML
    void EnfermidadePessoal(ActionEvent event) throws IOException {
    	openPage(Rotas.EnfermidadePessoal);
    }

    @FXML
    void Entrada(ActionEvent event) throws IOException {
    	openPage(Rotas.Entrada);
    }

    @FXML
    void Gerente(ActionEvent event) throws IOException {
    	openPage(Rotas.Gerente);
    }

    @FXML
    void Medico(ActionEvent event) throws IOException {
    	openPage(Rotas.Medico);
    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	openPage(Rotas.Login);
    }

}
