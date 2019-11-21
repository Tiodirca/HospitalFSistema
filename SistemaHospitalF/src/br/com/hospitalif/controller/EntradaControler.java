package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import App.Main;
import br.com.hospitalif.DAO.EntradaDAO;
import br.com.hospitalif.model.Entrada;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EntradaControler extends Main {

	@FXML
	private Button ButtonConfirmar;

	@FXML
	private Button ButtonLimpar;

	@FXML
	protected DatePicker txtDateEntrada;

	@FXML
	protected DatePicker txtDateSaida;

	@FXML
	protected TextArea txtStatusPaciente;

	@FXML
	private Button ButtonVoltar;

	@FXML
	protected TextArea txtStatusEntrada;

	@FXML
	protected TextField txtDoenca;

	@FXML
	protected TextField txtAltura;

	@FXML
	protected TextField txtPeso;

	@FXML
	protected DatePicker txtDate;

	@FXML
	protected TextArea txtComEnfermeiro;

	@FXML
	protected TextArea txtComMedico;
	@FXML
	private Button buttonLista;
	

	@FXML
	void lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaEntrada);
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void confirmar(ActionEvent event) throws IOException, SQLException {
		try {
			LocalDate data = txtDate.getValue();
			LocalDate dataEntrada = txtDateEntrada.getValue();
			LocalDate dataSaida = txtDateSaida.getValue();
			String StatusPaciente = txtStatusPaciente.getText();
			String StatusEntrada = txtStatusEntrada.getText();
			String doenca = txtDoenca.getText();
			float altura = Float.parseFloat(txtAltura.getText());
			float peso = Float.parseFloat(txtPeso.getText());
			String ComentarioEnfermeiro = txtComEnfermeiro.getText();
			String ComentarioMedico = txtComMedico.getText();
			Entrada EntradaVariavel = new Entrada();
			EntradaDAO EntradaVariavelDAO = new EntradaDAO();
			EntradaVariavel.setSituacaoDePaciente(StatusPaciente);
			EntradaVariavel.setStatusDeEntrada(StatusEntrada);
			EntradaVariavel.setDoenca(doenca);
			EntradaVariavel.setAltura(altura);
			EntradaVariavel.setDataSaida(dataSaida);
			EntradaVariavel.setDataEntrada(dataEntrada);
			EntradaVariavel.setData(data);
			EntradaVariavel.setAltura(altura);
			EntradaVariavel.setPeso(peso);
			EntradaVariavel.setComentarioEnfermeiro(ComentarioEnfermeiro);
			EntradaVariavel.setComentarioMedico(ComentarioMedico);
			EntradaVariavelDAO.save(EntradaVariavel);
			openPage(Rotas.Dash);

		} catch (NumberFormatException e) {
			ConfirmaCampoVazio();
		} catch (NullPointerException npe) {
			ConfirmaDataVazia();
		}
	}

	@FXML
	void limpar(ActionEvent event) throws IOException {
		openPage(Rotas.Entrada);
	}
}
