package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.LoginDAO;
import br.com.hospitalif.model.Login;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControler extends Main{

    @FXML
    private TextField txtLogin;
    	
    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button ButtonEsqueciSenha;

    @FXML
    private Button ButtonLogin;

    @FXML
    private Button ButtonVoltar;
    
    @FXML
    private Button buttonLista;
    
    @FXML
    void lista(ActionEvent event) throws IOException {
    	openPage(Rotas.ListaLogin);
    }


    @FXML
    void login(ActionEvent event) throws IOException, SQLException {
    	String login = txtLogin.getText();
    	String Senha = txtSenha.getText();
    	Login loginVariavel = new Login();
    	LoginDAO loginVariavelDAO = new LoginDAO();
    	loginVariavel.setLogin(login);
    	loginVariavel.setSenha(Senha);
    	loginVariavelDAO.save(loginVariavel);
    	openPage(Rotas.Dash);
    }
    @FXML
    void esqueciSenha(ActionEvent event) throws IOException {
    }

}
