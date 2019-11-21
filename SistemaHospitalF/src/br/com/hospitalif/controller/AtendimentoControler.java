package br.com.hospitalif.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import App.Main;
import br.com.hospitalif.DAO.AtendimentoDAO;
import br.com.hospitalif.model.Atendimento;
import br.com.hospitalif.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AtendimentoControler extends Main implements Initializable {
	@FXML
	private TextField txtDoenca;

	@FXML
	private TextField txtAltura;

	@FXML
	private TextField txtPeso;

	 @FXML
	    private Button btnFinalizar;

	    @FXML
	    private Button btnLimpar;


	@FXML
	private DatePicker txtDate;

	@FXML
	private TextArea txtComEnfermeiro;

	@FXML
	private TextArea txtComMedico;
	@FXML
    private Button btnVoltar;

    @FXML
    private Button btnLista;

	@FXML
	void Lista(ActionEvent event) throws IOException {
		openPage(Rotas.ListaAtendimento);
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		openPage(Rotas.Dash);
	}

	@FXML
	void confirmar(ActionEvent event) throws IOException, SQLException {
		try {
			LocalDate dataAtendimento = txtDate.getValue();
			String doenca = txtDoenca.getText();
			float altura = Float.parseFloat(txtAltura.getText());
			float peso = Float.parseFloat(txtPeso.getText());
			String ComentarioEnfermeiro = txtComEnfermeiro.getText();
			String ComentarioMedico = txtComMedico.getText();

			Atendimento AtendimentoVariavel = new Atendimento();
			AtendimentoDAO AtendimentoVariavelDAO = new AtendimentoDAO();
			AtendimentoVariavel.setDoenca(doenca);
			AtendimentoVariavel.setAltura(altura);
			AtendimentoVariavel.setPeso(peso);
			AtendimentoVariavel.setData(dataAtendimento);
			AtendimentoVariavel.setComentarioEnfermeiro(ComentarioEnfermeiro);
			AtendimentoVariavel.setComentarioMedico(ComentarioMedico);
			AtendimentoVariavelDAO.save(AtendimentoVariavel);
			openPage(Rotas.Dash);

		} catch (NumberFormatException e) {
			ConfirmaCampoVazio();
		} catch (NullPointerException npe) {
			ConfirmaDataVazia();
		}
	}

	@FXML
	void limpar(ActionEvent event) throws IOException {
		openPage(Rotas.Atendimento);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	

}