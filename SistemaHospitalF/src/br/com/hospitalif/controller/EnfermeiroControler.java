package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.EnfermeiroDAO;
import br.com.hospitalif.model.Enfermeiro;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnfermeiroControler extends Main {

	@FXML
	private Button ButtonConfirmar;

	@FXML
	private Button ButtonLimpar;

	@FXML
	protected TextField txtNumeroRegistro;

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
		openPage(Rotas.ListaEnfermeiro);
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void confirmar(ActionEvent event) throws IOException, SQLException {
		try {
			String numRegistro = txtNumeroRegistro.getText();
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String usuario = txtUsuario.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String tipoSanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();

			Enfermeiro EnfermeiroVariavel = new Enfermeiro();
			EnfermeiroDAO enfermeiroVariavelDAO = new EnfermeiroDAO();
			EnfermeiroVariavel.setNumeroDeRegistro(numRegistro);
			EnfermeiroVariavel.setLogin(login);
			EnfermeiroVariavel.setSenha(senha);
			EnfermeiroVariavel.setStatusDeUsuario(usuario);
			EnfermeiroVariavel.setNome(nome);
			EnfermeiroVariavel.setCpf(CPF);
			EnfermeiroVariavel.setIdade(idade);
			EnfermeiroVariavel.setStatusDePessoa(StatusPessoa);
			EnfermeiroVariavel.setTipoSanguineo(tipoSanguineo);
			EnfermeiroVariavel.setSexo(sexo);
			enfermeiroVariavelDAO.save(EnfermeiroVariavel);
			openPage(Rotas.Dash);
		} catch (NumberFormatException e) {
			ConfirmaCampoVazio2();
		}
	}

	@FXML
	void limpar(ActionEvent event) throws IOException {
		openPage(Rotas.Enfermeiro);
	}
}
