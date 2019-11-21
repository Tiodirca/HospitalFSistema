package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.model.EnfermidadePessoal;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EnfermidadePessoalControler extends Main {

	@FXML
	private Button ButtonConfirmar;

	@FXML
	private Button ButtonLimpar;

	@FXML
	protected TextArea txtComentario;

	@FXML
	protected TextArea txtEnfermidade;

	@FXML
	private Button ButtonVoltar;

	@FXML
	protected TextField txtNome;

	@FXML
	protected TextField txtTipo;

	@FXML
	protected TextArea txtDescricao;
	@FXML
	private Button buttonLista;

	@FXML
	void lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaEnfermidadePessoal);
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void confirmar(ActionEvent event) throws IOException, SQLException {
		String comentario = txtComentario.getText();
		String situacaoEnfermidade = txtEnfermidade.getText();
		String nome = txtNome.getText();
		String tipo = txtTipo.getText();
		String descricao = txtDescricao.getText();

		EnfermidadePessoal EnfermidadePessoalVariavel = new EnfermidadePessoal();
		EnfermidadePessoalDAO EnfermidadePessoalDAO = new EnfermidadePessoalDAO();
		EnfermidadePessoalVariavel.setComentario(comentario);
		EnfermidadePessoalVariavel.setStatusDeEnfermidade(situacaoEnfermidade);
		EnfermidadePessoalVariavel.setNome(nome);
		EnfermidadePessoalVariavel.setTipo(tipo);
		EnfermidadePessoalVariavel.setDescricao(descricao);
		EnfermidadePessoalDAO.save(EnfermidadePessoalVariavel);
		openPage(Rotas.Dash);
	}

	@FXML
	void limpar(ActionEvent event) throws IOException {
		openPage(Rotas.EnfermidadePessoal);
	}
}
