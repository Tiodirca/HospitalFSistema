package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.GerenteDAO;
import br.com.hospitalif.model.Gerente;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GerenteControler extends Main {

	@FXML
	private Button ButtonConfirmar;

	@FXML
	private Button ButtonLimpar;

	@FXML
	protected TextField txtCargo;

	@FXML
	private Button ButtonVoltar;

	@FXML
	protected TextField txtLogin;

	@FXML
	protected TextField txtSenha;

	@FXML
	protected TextField txtUsuario;

	@FXML
	protected TextField txtNome;

	@FXML
	protected TextField txtCPF;

	@FXML
	protected TextField txtIdade;

	@FXML
	protected TextField txtStatusPessoa;

	@FXML
	protected TextField txtSanguineo;

	@FXML
	protected TextField txtSexo;

	@FXML
	private Button buttonLista;

	@FXML
	void lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaGerente);
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void confirmar(ActionEvent event) throws IOException, SQLException {
		try {
			String cargo = txtCargo.getText();
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String usuario = txtUsuario.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String statusPessoa = txtStatusPessoa.getText();
			String Sanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();

			Gerente GerenteVariavel = new Gerente();
			GerenteDAO GerenteVariavelDAO = new GerenteDAO();
			GerenteVariavel.setCargo(cargo);
			GerenteVariavel.setLogin(login);
			GerenteVariavel.setSenha(senha);
			GerenteVariavel.setStatusDeUsuario(usuario);
			GerenteVariavel.setNome(nome);
			GerenteVariavel.setCpf(CPF);
			GerenteVariavel.setIdade(idade);
			GerenteVariavel.setStatusDePessoa(statusPessoa);
			GerenteVariavel.setTipoSanguineo(Sanguineo);
			GerenteVariavel.setSexo(sexo);
			GerenteVariavelDAO.save(GerenteVariavel);
			openPage(Rotas.Dash);
		} catch (NumberFormatException e) {
			ConfirmaCampoVazio2();
		}
	}

	@FXML
	void limpar(ActionEvent event) throws IOException {
		openPage(Rotas.Gerente);
	}
}
