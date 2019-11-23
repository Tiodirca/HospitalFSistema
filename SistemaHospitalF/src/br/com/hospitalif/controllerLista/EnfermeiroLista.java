package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.EnfermeiroDAO;
import br.com.hospitalif.controller.EnfermeiroControler;
import br.com.hospitalif.model.Enfermeiro;
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

public class EnfermeiroLista extends EnfermeiroControler implements Initializable {

	@FXML
	private TableView<Enfermeiro> tabela;

	@FXML
	private TableColumn<Enfermeiro, String> clmNome;

	@FXML
	private TableColumn<Enfermeiro, String> clmCPF;

	@FXML
	private TableColumn<Enfermeiro, String> clmIdade;

	@FXML
	private TableColumn<Enfermeiro, String> clmSanguineo;

	@FXML
	private TableColumn<Enfermeiro, String> clmSexo;

	@FXML
	private TableColumn<Enfermeiro, String> clmStatusPessoa;

	@FXML
	private TableColumn<Enfermeiro, String> clmLogin;

	@FXML
	private TableColumn<Enfermeiro, String> clmSenha;

	@FXML
	private TableColumn<Enfermeiro, String> clmStatusUsuario;

	@FXML
	private TableColumn<Enfermeiro, String> clmRegistro;
	@FXML
    private AnchorPane areaEdicao;

    @FXML
    private Button btnSalvar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnVoltar;
	 @FXML
	    private Button btnRelatorio;

	    @FXML
	    void Relatorio(ActionEvent event) {
	    	String rel = "reportEnfermeiro.jrxml";
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
			String numRegistro = txtNumeroRegistro.getText();
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String usuario = txtUsuario.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String tipoSanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();
			Enfermeiro itens = new Enfermeiro();
			EnfermeiroDAO itensDAO = new EnfermeiroDAO();
			Enfermeiro getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdEnfermeiro(getId.getIdEnfermeiro());
			itens.setNumeroDeRegistro(numRegistro);
			itens.setLogin(login);
			itens.setSenha(senha);
			itens.setStatusDeUsuario(usuario);
			itens.setNome(nome);
			itens.setCpf(CPF);
			itens.setIdade(idade);
			itens.setStatusDePessoa(StatusPessoa);
			itens.setTipoSanguineo(tipoSanguineo);
			itens.setSexo(sexo);
			itensDAO.update(itens);
			openPage(Rotas.ListaEnfermeiro);
    } catch (NumberFormatException e1) {
		areaEdicao.setVisible(false);
		erroSelecao();
	} catch (SQLException e2) {

	} catch (IOException e3) {

	}
	areaEdicao.setVisible(false);
}


	@FXML
	void voltar(ActionEvent event) {
		try {
			openPage(Rotas.Dash);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			Enfermeiro item = tabela.getSelectionModel().getSelectedItem();
			txtNumeroRegistro.setText(item.getNumeroDeRegistro());
			txtLogin.setText(item.getLogin());
			txtSenha.setText(item.getSenha());
			txtUsuario.setText(item.getStatusDeUsuario());
			txtNome.setText(item.getNome());
			txtCPF.setText("" + item.getCpf());
			txtIdade.setText("" + item.getIdade());
			txtStatusPessoa.setText(item.getStatusDePessoa());
			txtSanguineo.setText(item.getTipoSanguineo());
			txtSexo.setText(item.getSexo());
		} catch (NullPointerException e) {
			erroSelecao();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		try {
			Enfermeiro excluir = tabela.getSelectionModel().getSelectedItem();
			EnfermeiroDAO exclui = new EnfermeiroDAO();
			exclui.removeById(excluir.getIdEnfermeiro());
			openPage(Rotas.ListaEnfermeiro);
		} catch (SQLException e) {

		} catch (IOException e) {
		} catch (NullPointerException e) {
			erroSelecao();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		clmCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		clmIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
		clmSanguineo.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
		clmSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		clmStatusPessoa.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
		clmLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
		clmSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		clmStatusUsuario.setCellValueFactory(new PropertyValueFactory<>("statusDeUsuario"));
		clmRegistro.setCellValueFactory(new PropertyValueFactory<>("numeroDeRegistro"));
		EnfermeiroDAO endao = new EnfermeiroDAO();
		List<Enfermeiro> atendimentos = endao.select();
		ObservableList<Enfermeiro> obsen = FXCollections.observableArrayList(atendimentos);
		tabela.setItems(obsen);
		areaEdicao.setVisible(false);
	}
}
