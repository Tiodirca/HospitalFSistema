package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.com.hospitalif.DAO.EntradaDAO;
import br.com.hospitalif.controller.EntradaControler;
import br.com.hospitalif.model.Entrada;
import br.com.hospitalif.reports.PrintReport;
import br.com.hospitalif.util.Rotas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;

public class EntradaLista extends EntradaControler implements Initializable {

	@FXML
	private TableView<Entrada> tabela;

	@FXML
	private TableColumn<Entrada, String> entrada;

	@FXML
	private TableColumn<Entrada, String> saida;

	@FXML
	private TableColumn<Entrada, String> comMedico;

	@FXML
	private TableColumn<Entrada, String> comEnfermeiro;

	@FXML
	private TableColumn<Entrada, String> doenca;

	@FXML
	private TableColumn<Entrada, String> sitPaciente;

	@FXML
	private TableColumn<Entrada, String> statusEntrada;

	@FXML
	private TableColumn<Entrada, String> altura;

	@FXML
	private TableColumn<Entrada, String> peso;

	@FXML
	private TableColumn<Entrada, Date> dataAtendimento;

	@FXML
	private AnchorPane areaEdicao;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button ButtonExcluir;

	@FXML
	private Button ButtonEditar;

	@FXML
	private Button buttonVoltar;
	 @FXML
	    private Button btnRelatorio;

	    @FXML
	    void Relatorio(ActionEvent event) {
	    	String rel = "reportEntrada.jrxml";
	    	try {
				new PrintReport().showReport(rel);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	@FXML
	void Salvar(ActionEvent event) {
		try {
			areaEdicao.setVisible(false);
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
			Entrada itens = new Entrada();
			EntradaDAO itensDAO = new EntradaDAO();
			Entrada getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdEntrada(getId.getIdEntrada());
			itens.setData(data);
			itens.setDataEntrada(dataEntrada);
			itens.setDataSaida(dataSaida);
			itens.setSituacaoDePaciente(StatusPaciente);
			itens.setStatusDeEntrada(StatusEntrada);
			itens.setDoenca(doenca);
			itens.setAltura(altura);
			itens.setPeso(peso);
			itens.setComentarioEnfermeiro(ComentarioEnfermeiro);
			itens.setComentarioMedico(ComentarioMedico);
			itensDAO.update(itens);
			openPage(Rotas.ListaEntrada);
		} catch (NumberFormatException e1) {
			areaEdicao.setVisible(false);
			erroSelecao();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		areaEdicao.setVisible(false);
	}

	@FXML
	void voltar(ActionEvent event) throws IOException {
		openPage(Rotas.Entrada);
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			Entrada item = tabela.getSelectionModel().getSelectedItem();
			txtDate.setValue(item.getData());
			txtDateEntrada.setValue(item.getDataEntrada());
			txtDateSaida.setValue(item.getDataSaida());
			txtStatusPaciente.setText(item.getSituacaoDePaciente());
			txtStatusEntrada.setText(item.getStatusDeEntrada());
			txtDoenca.setText(item.getDoenca());
			txtAltura.setText(""+item.getAltura());
			txtPeso.setText(""+item.getPeso());
			txtComEnfermeiro.setText(item.getComentarioEnfermeiro());
			txtComMedico.setText(item.getComentarioMedico());
		} catch (NullPointerException e) {
			areaEdicao.setVisible(false);
			erroSelecao();
		}
		areaEdicao.setVisible(true);
	}

	@FXML
	void excluir(ActionEvent event) throws SQLException {
		try {
			Entrada excluir = tabela.getSelectionModel().getSelectedItem();
			EntradaDAO exclui = new EntradaDAO();
			exclui.removeById(excluir.getIdEntrada());
			openPage(Rotas.ListaEntrada);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			erroSelecao();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		entrada.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
		saida.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		comMedico.setCellValueFactory(new PropertyValueFactory<>("comentarioMedico"));
		comEnfermeiro.setCellValueFactory(new PropertyValueFactory<>("comentarioEnfermeiro"));
		doenca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
		sitPaciente.setCellValueFactory(new PropertyValueFactory<>("situacaoDePaciente"));
		statusEntrada.setCellValueFactory(new PropertyValueFactory<>("StatusDeEntrada"));
		altura.setCellValueFactory(new PropertyValueFactory<>("altura"));
		peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		dataAtendimento.setCellValueFactory(new PropertyValueFactory<>("data"));
		EntradaDAO selecao = new EntradaDAO();
		List<Entrada> selecaoItens = selecao.select();
		ObservableList<Entrada> itens = FXCollections.observableArrayList(selecaoItens);
		tabela.setItems(itens);
		areaEdicao.setVisible(false);
	}
}
