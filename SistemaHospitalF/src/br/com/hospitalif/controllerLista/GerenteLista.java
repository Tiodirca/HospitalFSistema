package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.GerenteDAO;
import br.com.hospitalif.controller.GerenteControler;
import br.com.hospitalif.model.Gerente;
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

public class GerenteLista extends GerenteControler implements Initializable {

	@FXML
	private TableView<Gerente> tabela;

	@FXML
	private TableColumn<Gerente, String> nome;

	@FXML
	private TableColumn<Gerente, String> cpf;

	@FXML
	private TableColumn<Gerente, String> idade;

	@FXML
	private TableColumn<Gerente, String> tipoSanguineo;

	@FXML
	private TableColumn<Gerente, String> sexo;

	@FXML
	private TableColumn<Gerente, String> statusPessoa;

	@FXML
	private TableColumn<Gerente, String> login;

	@FXML
	private TableColumn<Gerente, String> senha;

	@FXML
	private TableColumn<Gerente, String> statusUsuario;

	@FXML
	private TableColumn<Gerente, String> cargo;
	@FXML
	private AnchorPane areaEdicao;

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

	    }

	@FXML
	void Salvar(ActionEvent event) {
		try {
			String cargo = txtCargo.getText();
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			String usuario = txtUsuario.getText();
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String statusPessoa = txtStatusPessoa.getText();
			String Sanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();
			Gerente itens = new Gerente();
			GerenteDAO itensDAO = new GerenteDAO();
			Gerente getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdFuncionario(getId.getIdFuncionario());
			itens.setCargo(cargo);
			itens.setLogin(login);
			itens.setSenha(senha);
			itens.setStatusDeUsuario(usuario);
			itens.setNome(nome);
			itens.setCpf(CPF);
			itens.setIdade(idade);
			itens.setStatusDePessoa(statusPessoa);
			itens.setTipoSanguineo(Sanguineo);
			itens.setSexo(sexo);
			itensDAO.update(itens);
			openPage(Rotas.ListaGerente);
		} catch (NumberFormatException e1) {
			areaEdicao.setVisible(false);
			erroSelecao();
		} catch (SQLException e2) {

		} catch (IOException e3) {

		}
		areaEdicao.setVisible(false);
	}

	@FXML
	void voltar(ActionEvent event) throws IOException {
		openPage(Rotas.Gerente);
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			areaEdicao.setVisible(true);
			Gerente item = tabela.getSelectionModel().getSelectedItem();
			txtCargo.setText(item.getCargo());
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
			Gerente excluir = tabela.getSelectionModel().getSelectedItem();
			GerenteDAO exclui = new GerenteDAO();
			exclui.removeById(excluir.getIdFuncionario());
			openPage(Rotas.ListaGerente);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			erroSelecao();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
		tipoSanguineo.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
		sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		statusPessoa.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
		login.setCellValueFactory(new PropertyValueFactory<>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		statusUsuario.setCellValueFactory(new PropertyValueFactory<>("statusDeUsuario"));
		cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		GerenteDAO selecao = new GerenteDAO();
		List<Gerente> selecaoItens = selecao.select();
		ObservableList<Gerente> itens = FXCollections.observableArrayList(selecaoItens);
		tabela.setItems(itens);
		areaEdicao.setVisible(false);
	}

}
