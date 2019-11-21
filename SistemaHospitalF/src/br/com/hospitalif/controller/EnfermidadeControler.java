package br.com.hospitalif.controller;

import java.io.IOException;
import java.sql.SQLException;

import App.Main;
import br.com.hospitalif.DAO.EnfermidadeDAO;
import br.com.hospitalif.model.Enfermidade;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EnfermidadeControler extends Main {

	@FXML
    private Button btnConfirmar;

    @FXML
    private Button btnLimpar;
	@FXML
	private TextField txtTipo;

	@FXML
	private TextField txtNome;

	@FXML
	private TextArea txtDescricao;

	 @FXML
	    private Button btnVoltar;

	    @FXML
	    private Button btnLista;

	@FXML
	void lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaEnfermidade);
	}

	@FXML
	void confirmar(ActionEvent event) {
		try {
			String tipo = txtTipo.getText();
			String nome = txtNome.getText();
			String descricao = txtDescricao.getText();
			openPage(Rotas.Dash);
			Enfermidade EnfermidadeVariavel = new Enfermidade();
			EnfermidadeDAO EnfermidadeVariavelDAO = new EnfermidadeDAO();
			EnfermidadeVariavel.setNome(nome);
			EnfermidadeVariavel.setTipo(tipo);
			EnfermidadeVariavel.setDescricao(descricao);
			EnfermidadeVariavelDAO.save(EnfermidadeVariavel);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void limpar(ActionEvent event) {
		try {
			openPage(Rotas.Enfermidade);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void back(ActionEvent event) {
		try {
			openPage(Rotas.Dash);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setandoDadosEnfermidade(Enfermidade e) {
		try {
			
			txtNome.setText(e.getNome());
			txtTipo.setText(e.getTipo());
			txtDescricao.setText(e.getDescricao());
			openPage(Rotas.Enfermidade);
		} catch (IOException i) {
			i.printStackTrace();
		} catch (NullPointerException i) {

		}
	}

}
