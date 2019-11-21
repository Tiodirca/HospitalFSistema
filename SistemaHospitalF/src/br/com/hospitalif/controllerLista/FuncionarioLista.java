package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.FuncionarioDAO;
import br.com.hospitalif.controller.FuncionarioControler;
import br.com.hospitalif.model.Funcionario;
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

public class FuncionarioLista extends FuncionarioControler implements Initializable {

	@FXML
	private TableView<Funcionario> tabela;

	@FXML
	private TableColumn<Funcionario, String> login;

	@FXML
	private TableColumn<Funcionario, String> senha;

	@FXML
	private TableColumn<Funcionario, String> statusUsuario;

	@FXML
	private TableColumn<Funcionario, String> nome;

	@FXML
	private TableColumn<Funcionario, String> cpf;

	@FXML
	private TableColumn<Funcionario, String> idade;

	@FXML
	private TableColumn<Funcionario, String> tipoSanguineo;

	@FXML
	private TableColumn<Funcionario, String> sexo;

	@FXML
	private TableColumn<Funcionario, String> statusPessoa;
	@FXML
	private AnchorPane areaEdicao;

	@FXML
	private Button ButtonExcluir;

	@FXML
	private Button ButtonEditar;

	@FXML
	private Button buttonVoltar;
	@FXML
	private Button btnSalvar;
	 @FXML
	    private Button btnRelatorio;

	    @FXML
	    void Relatorio(ActionEvent event) {

	    }

	@FXML
	void Salvar(ActionEvent event) {
		try {
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String usuario = txtUsuario.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String Sanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();
			Funcionario itens = new Funcionario();
			FuncionarioDAO itensDAO = new FuncionarioDAO();
			Funcionario getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdFuncionario(getId.getIdFuncionario());
			itens.setLogin(login);
			itens.setSenha(senha);
			itens.setStatusDeUsuario(usuario);
			itens.setNome(nome);
			itens.setCpf(CPF);
			itens.setIdade(idade);
			itens.setStatusDePessoa(StatusPessoa);
			itens.setTipoSanguineo(Sanguineo);
			itens.setSexo(sexo);
			itensDAO.update(itens);
			openPage(Rotas.ListaFuncionario);
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
		openPage(Rotas.Funcionario);
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			areaEdicao.setVisible(true);
			Funcionario item = tabela.getSelectionModel().getSelectedItem();
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
			areaEdicao.setVisible(false);
			erroSelecao();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		try {
			Funcionario excluir = tabela.getSelectionModel().getSelectedItem();
			FuncionarioDAO exclui = new FuncionarioDAO();
			exclui.removeById(excluir.getIdFuncionario());
			openPage(Rotas.ListaFuncionario);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			erroSelecao();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		login.setCellValueFactory(new PropertyValueFactory<>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		statusUsuario.setCellValueFactory(new PropertyValueFactory<>("statusDeUsuario"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
		tipoSanguineo.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
		sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		statusPessoa.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
		FuncionarioDAO selecao = new FuncionarioDAO();
		List<Funcionario> selecaoItens = selecao.select();
		ObservableList<Funcionario> itens = FXCollections.observableArrayList(selecaoItens);
		tabela.setItems(itens);
		areaEdicao.setVisible(false);
	}

}
