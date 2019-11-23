package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.EnfermidadeDAO;
import br.com.hospitalif.controller.EnfermidadeControler;
import br.com.hospitalif.model.Enfermidade;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;

public class EnfermidadeLista extends EnfermidadeControler implements Initializable {

	@FXML
	private TableView<Enfermidade> tabela;

	@FXML
	private TableColumn<Enfermidade, String> clmNome;

	@FXML
	private TableColumn<Enfermidade, String> clmTipo;

	@FXML
	private TableColumn<Enfermidade, String> clmDescricao;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnVoltar;

	@FXML
	private AnchorPane AreaEdicao;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTipo;

	@FXML
	private Button btnSalvar;

	@FXML
	private TextArea txtDescricao;
	 @FXML
	    private Button btnRelatorio;

	    @FXML
	    void Relatorio(ActionEvent event) {
	    	String rel = "reportEnfermidade.jrxml";
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
		    	String nome =  txtNome.getText();
		    	String tipo = txtTipo.getText();
		    	String descricao = txtDescricao.getText();
				Enfermidade itens = new Enfermidade();
				EnfermidadeDAO itensDAO = new EnfermidadeDAO();
				Enfermidade getId = tabela.getSelectionModel().getSelectedItem();
				itens.setIdEnfermidade(getId.getIdEnfermidade());
				itens.setNome(nome);
				itens.setTipo(tipo);
				itens.setDescricao(descricao);
				itensDAO.update(itens);
				openPage(Rotas.ListaEnfermidade);
			} catch (NumberFormatException e1) {
				erroSelecao();
			} catch (SQLException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
	    	AreaEdicao.setVisible(false);
	    	}

	@FXML
	void voltar(ActionEvent event) throws IOException {
		openPage(Rotas.Enfermidade);
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			AreaEdicao.setVisible(true);
			Enfermidade item = tabela.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtTipo.setText(item.getTipo());
			txtDescricao.setText(item.getDescricao());
		} catch (NullPointerException e) {
			AreaEdicao.setVisible(false);
			erroSelecao();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		try {
			Enfermidade exclui = tabela.getSelectionModel().getSelectedItem();
			EnfermidadeDAO excluir = new EnfermidadeDAO();
			excluir.removeId(exclui.getIdEnfermidade());
			openPage(Rotas.ListaEnfermidade);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			erroSelecao();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		clmTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		clmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		EnfermidadeDAO selecao = new EnfermidadeDAO();
		List<Enfermidade> selecaoItens = selecao.select();
		ObservableList<Enfermidade> itens = FXCollections.observableArrayList(selecaoItens);
		tabela.setItems(itens);
		AreaEdicao.setVisible(false);
	}

}
