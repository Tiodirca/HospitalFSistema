package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.model.Medico;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MedicoControler extends Main {

	@FXML
	protected TextField txtNome;

	@FXML
	protected TextField txtCPF;

	@FXML
	protected TextField txtIdade;

	@FXML
	private Button ButtonFinalizar;

	@FXML
	private Button ButtonLimpar;

	@FXML
	private Label txtLabelSanguineo;

	@FXML
	private Button ButtonVoltar;

	@FXML
	protected TextField txtSanguineo;

	@FXML
	protected TextField txtSexo;

	@FXML
	protected TextField txtNumRegistro;

	@FXML
	protected TextField txtStatusPessoa;

	@FXML
	protected TextField txtStatusDeUsuario;

	@FXML
	protected TextField txtSenha;

	@FXML
	protected TextField txtEspecialidade;

	@FXML
	protected TextField txtLogin;

	@FXML
	private Button buttonLista;

	@FXML
	void lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaMedico);
	}

	@FXML
	void Back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void Finalizar(ActionEvent event) throws IOException, SQLException {
		try {
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String tipoSanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();
			int numRegistro = Integer.parseInt(txtNumRegistro.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String StatusUsuario = txtStatusDeUsuario.getText();
			String senha = txtSenha.getText();
			String especialidade = txtEspecialidade.getText();
			String login = txtLogin.getText();
			
			Medico medicoVariavel = new Medico();
			MedicoDAO medicoVariavelDAO = new MedicoDAO();
			medicoVariavel.setNome(nome);
			medicoVariavel.setCpf(CPF);
			medicoVariavel.setTipoSanguineo(tipoSanguineo);
			medicoVariavel.setSexo(sexo);
			medicoVariavel.setIdade(idade);
			medicoVariavel.setNumeroDeRegistro(numRegistro);
			medicoVariavel.setStatusDePessoa(StatusPessoa);
			medicoVariavel.setStatusDeUsuario(StatusUsuario);
			medicoVariavel.setSenha(senha);
			medicoVariavel.setEspecialidade(especialidade);
			medicoVariavel.setLogin(login);
			medicoVariavelDAO.save(medicoVariavel);
			openPage(Rotas.Dash);
		} catch (NumberFormatException e) {
			ConfirmaCampoVazio2();
		}
	}

	@FXML
	void Limpar(ActionEvent event) throws IOException {
		openPage(Rotas.Medico);
	}
}
