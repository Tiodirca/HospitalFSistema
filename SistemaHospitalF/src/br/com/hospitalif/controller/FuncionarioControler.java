package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.FuncionarioDAO;
import br.com.hospitalif.model.Funcionario;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FuncionarioControler extends Main {

	@FXML
	protected TextField txtLogin;

	@FXML
	protected TextField txtSenha;

	@FXML
	protected TextField txtUsuario;

	@FXML
	private Button buttonComfirmar;

	@FXML
	private Button ButtonLimpar;

	@FXML
	private Button ButtonVoltar;

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
		openPage(Rotas.ListaFuncionario);
	}

	@FXML
	void Confirmar(ActionEvent event) throws IOException, SQLException {
		try {
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String usuario = txtUsuario.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String Sanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();

			Funcionario FuncionarioVariavel = new Funcionario();
			FuncionarioDAO FuncionarioVariavelDAO = new FuncionarioDAO();
			FuncionarioVariavel.setLogin(login);
			FuncionarioVariavel.setSenha(senha);
			FuncionarioVariavel.setStatusDeUsuario(usuario);
			FuncionarioVariavel.setNome(nome);
			FuncionarioVariavel.setCpf(CPF);
			FuncionarioVariavel.setIdade(idade);
			FuncionarioVariavel.setStatusDePessoa(StatusPessoa);
			FuncionarioVariavel.setTipoSanguineo(Sanguineo);
			FuncionarioVariavel.setSexo(sexo);
			FuncionarioVariavelDAO.save(FuncionarioVariavel);
			openPage(Rotas.Dash);
		} catch (NumberFormatException e) {
			ConfirmaCampoVazio2();
		}
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void limpar(ActionEvent event) throws IOException, SQLException {
		openPage(Rotas.Funcionario);
	}
}
