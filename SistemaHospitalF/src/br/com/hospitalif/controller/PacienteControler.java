package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.model.Paciente;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteControler extends Main {

	@FXML
	private Button ButtonConfirmar;

	@FXML
	private Button buttonLimpar;

	@FXML
	protected TextArea txtHistorico;

	@FXML
	private Button buttonVoltar;

	@FXML
	protected TextField txtNome;

	@FXML
	protected TextField txtCPF;

	@FXML
	protected TextField txtIdade;

	@FXML
	protected TextField txtStatusPessoa;

	@FXML
	protected TextField txtTipoSanguineo;

	@FXML
	protected TextField txtSexo;

	@FXML
	protected TextField txtDoenca;

	@FXML
	private Button buttonLista;

	@FXML
	void lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaPaciente);
	}

	@FXML
	void Confirmar(ActionEvent event) throws IOException, SQLException {
		try {
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String tipoSanguineo = txtTipoSanguineo.getText();
			String sexo = txtSexo.getText();
			String doenca = txtDoenca.getText();
			String historico = txtHistorico.getText();

			Paciente PacienteVariavel = new Paciente();
			PacienteDAO PacienteVariavelDAO = new PacienteDAO();
			PacienteVariavel.setNome(nome);
			PacienteVariavel.setCpf(CPF);
			PacienteVariavel.setIdade(idade);
			PacienteVariavel.setStatusDePessoa(StatusPessoa);
			PacienteVariavel.setTipoSanguineo(tipoSanguineo);
			PacienteVariavel.setSexo(sexo);
			PacienteVariavel.setDoenca(doenca);
			PacienteVariavel.setHistorico(historico);
			PacienteVariavelDAO.save(PacienteVariavel);
			openPage(Rotas.Dash);
		} catch (NumberFormatException e) {
			ConfirmaCampoVazio2();
		}
	}

	@FXML
	void Limpar(ActionEvent event) throws IOException {
		openPage(Rotas.Paciente);
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	public void setandoDadosPaciente(Paciente p) {
		try {
			openPage(Rotas.Paciente);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

		}
	}
}
