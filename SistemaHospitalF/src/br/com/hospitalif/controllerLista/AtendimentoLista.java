package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.AtendimentoDAO;
import br.com.hospitalif.controller.AtendimentoControler;
import br.com.hospitalif.model.Atendimento;
import br.com.hospitalif.util.Rotas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AtendimentoLista extends AtendimentoControler implements Initializable {

	@FXML
	private TableView<Atendimento> tabela;

	@FXML
	private TableColumn<Atendimento, String> comMedico;

	@FXML
	private TableColumn<Atendimento, String> comEnfermeiro;

	@FXML
	private TableColumn<Atendimento, Float> peso;

	@FXML
	private TableColumn<Atendimento, Float> altura;

	@FXML
	private TableColumn<Atendimento, Date> data;

	@FXML
	private TableColumn<Atendimento, String> doenca;
	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;
	@FXML
	private Button buttonVoltar;

	@FXML
	private TextField txtDoenca;

	@FXML
	private TextField txtAltura;

	@FXML
	private TextField txtPeso;

	@FXML
	private Button btnSalvar;

	@FXML
	private DatePicker txtDate;

	@FXML
	private TextArea txtComEnfermeiro;

	@FXML
	private TextArea txtComMedico;
	@FXML
    private AnchorPane areaEdicao;
	 @FXML
	    private Button btnRelatorio;

	    @FXML
	    void Relatorio(ActionEvent event) {

	    }

	@FXML
	void Salvar(ActionEvent event) {
		try {
			areaEdicao.setVisible(false);
			LocalDate data = txtDate.getValue();
			float peso = Float.parseFloat(txtPeso.getText());
			String doenca = txtDoenca.getText();
			String ComentarioEnfermeiro = txtComEnfermeiro.getText();
			float altura = Float.parseFloat(txtAltura.getText());
			String ComentarioMedico = txtComMedico.getText();
			Atendimento a = new Atendimento();
			AtendimentoDAO aDAO = new AtendimentoDAO();
			Atendimento getId = tabela.getSelectionModel().getSelectedItem();
			a.setIdAtendimento(getId.getIdAtendimento());
			a.setData(data);
			a.setPeso(peso);
			a.setDoenca(doenca);
			a.setComentarioEnfermeiro(ComentarioEnfermeiro);
			a.setAltura(altura);
			a.setComentarioMedico(ComentarioMedico);
			aDAO.update(a);
			openPage(Rotas.ListaAtendimento);
		} catch (NumberFormatException e1) {
			erroSelecao();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}

	@FXML
	void editar(ActionEvent event) {
		try {
		areaEdicao.setVisible(true);
		Atendimento a = tabela.getSelectionModel().getSelectedItem();
		txtDate.setValue(a.getData());
		txtDoenca.setText(a.getDoenca());
		txtAltura.setText("" + a.getAltura());
		txtPeso.setText("" + a.getPeso());
		txtComEnfermeiro.setText(a.getComentarioEnfermeiro());
		txtComMedico.setText(a.getComentarioMedico());
		}catch (NullPointerException e) {
			areaEdicao.setVisible(false);
			erroSelecao();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		try {
			Atendimento a = tabela.getSelectionModel().getSelectedItem();
			System.out.println(a.getIdAtendimento());
			AtendimentoDAO adao = new AtendimentoDAO();
			adao.removeById(a.getIdAtendimento());
			openPage(Rotas.ListaAtendimento);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			erroSelecao();
		}
	}

	@FXML
	void voltar(ActionEvent event) throws IOException {
		openPage(Rotas.Atendimento);
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		comMedico.setCellValueFactory(new PropertyValueFactory<>("comentarioMedico"));
		comEnfermeiro.setCellValueFactory(new PropertyValueFactory<>("comentarioEnfermeiro"));
		peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		altura.setCellValueFactory(new PropertyValueFactory<>("altura"));
		data.setCellValueFactory(new PropertyValueFactory<>("data"));
		doenca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
		AtendimentoDAO adao = new AtendimentoDAO();
		List<Atendimento> atendimentos = adao.select();
		System.out.println("Tamanho " + atendimentos.size());
		ObservableList<Atendimento> itens = FXCollections.observableArrayList(atendimentos);
		tabela.setItems(itens);
		areaEdicao.setVisible(false);
	}

	public void setandoDadosAtendimento(Atendimento a) {

	}
}
