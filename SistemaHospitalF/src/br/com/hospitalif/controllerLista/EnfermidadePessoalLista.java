package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.controller.EnfermidadePessoalControler;
import br.com.hospitalif.model.EnfermidadePessoal;
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

public class EnfermidadePessoalLista extends EnfermidadePessoalControler implements Initializable{

    @FXML
    private TableView<EnfermidadePessoal> tabela;

    @FXML
    private TableColumn<EnfermidadePessoal, String> clmNome;

    @FXML
    private TableColumn<EnfermidadePessoal, String> clmTipo;

    @FXML
    private TableColumn<EnfermidadePessoal, String> clmDescricao;

    @FXML
    private TableColumn<EnfermidadePessoal, String> clmComentario;

    @FXML
    private TableColumn<EnfermidadePessoal, String> clmEnfermidade;
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
    	String rel = "reportEnfermidadePessoal.jrxml";
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
	    	String nome =  txtNome.getText();
	    	String tipo = txtTipo.getText();
	    	String descricao = txtDescricao.getText();
	    	String comentario = txtComentario.getText();
	    	String enfermidade = txtEnfermidade.getText();
	    	EnfermidadePessoal itens = new EnfermidadePessoal();
			EnfermidadePessoalDAO itensDAO = new EnfermidadePessoalDAO();
			EnfermidadePessoal getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdEnfermidadePessoal(getId.getIdEnfermidadePessoal());
			itens.setNome(nome);
			itens.setTipo(tipo);
			itens.setDescricao(descricao);
			itens.setComentario(comentario);
			itens.setStatusDeEnfermidade(enfermidade);
			itensDAO.update(itens);
			openPage(Rotas.ListaEnfermidadePessoal);
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
    	openPage(Rotas.Dash);
    }

    @FXML
    void editar(ActionEvent event) {
    	try {
    		areaEdicao.setVisible(true);
			EnfermidadePessoal item = tabela.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtTipo.setText(item.getTipo());
			txtDescricao.setText(item.getDescricao());
			txtComentario.setText(item.getComentario());
			txtEnfermidade.setText(item.getStatusDeEnfermidade());
		} catch (NullPointerException e) {
			areaEdicao.setVisible(false);
			erroSelecao();
		}
    }

    @FXML
    void excluir(ActionEvent event) {
    	try {
			EnfermidadePessoal excluir = tabela.getSelectionModel().getSelectedItem();
			EnfermidadePessoalDAO exclui = new EnfermidadePessoalDAO();
			exclui.removeById(excluir.getIdEnfermidadePessoal());
			openPage(Rotas.ListaEnfermidadePessoal);
		} catch (SQLException e) {

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
    	clmComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));
    	clmEnfermidade.setCellValueFactory(new PropertyValueFactory<>("statusDeEnfermidade"));
    	EnfermidadePessoalDAO selecao = new EnfermidadePessoalDAO();
    	List<EnfermidadePessoal> selecaoItens = selecao.select();
    	ObservableList<EnfermidadePessoal> itens = FXCollections.observableArrayList(selecaoItens);
    	tabela.setItems(itens);
    	areaEdicao.setVisible(false);
	}

}
