package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.controller.MedicoControler;
import br.com.hospitalif.model.Medico;
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

public class MedicoLista extends MedicoControler implements Initializable {

	@FXML
	private TableView<Medico> tabela;

	@FXML
	private TableColumn<Medico, String> nome;

	@FXML
	private TableColumn<Medico, String> cpf;

	@FXML
	private TableColumn<Medico, String> idade;

	@FXML
	private TableColumn<Medico, String> tipoSanguineo;

	@FXML
	private TableColumn<Medico, String> sexo;

	@FXML
	private TableColumn<Medico, String> statusPessoa;

	@FXML
	private TableColumn<Medico, String> login;

	@FXML
	private TableColumn<Medico, String> senha;

	@FXML
	private TableColumn<Medico, String> statusUsuario;

	@FXML
	private TableColumn<Medico, String> numeroRegistro;

	@FXML
	private TableColumn<Medico, String> especialidade;
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

	    }

	@FXML
	void Salvar(ActionEvent event) {
		try {
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String tipoSanguineo = txtSanguineo.getText();
			String sexo = txtSexo.getText();
			int numRegistro = Integer.parseInt(txtNumRegistro.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String StatusUsuario = txtStatusDeUsuario.getText();
			String senha = txtSenha.getText();
			String especialidade = txtEspecialidade.getText();
			String login = txtLogin.getText();
			Medico itens = new Medico();
			MedicoDAO itensDAO = new MedicoDAO();
			Medico getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdFuncionario(getId.getIdFuncionario());
			itens.setNome(nome);
			itens.setCpf(CPF);
			itens.setIdade(idade);
			itens.setTipoSanguineo(tipoSanguineo);
			itens.setSexo(sexo);
			itens.setNumeroDeRegistro(numRegistro);
			itens.setStatusDePessoa(StatusPessoa);
			itens.setStatusDeUsuario(StatusUsuario);
			itens.setSenha(senha);
			itens.setEspecialidade(especialidade);
			itens.setLogin(login);
			itensDAO.update(itens);
			openPage(Rotas.ListaMedico);
	} catch (NumberFormatException e1) {
		areaEdicao.setVisible(false);
		erroSelecao();
	} catch (SQLException e2) {

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	areaEdicao.setVisible(false);
}

	@FXML
	void voltar(ActionEvent event) throws IOException {
		openPage(Rotas.Medico);
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			areaEdicao.setVisible(true);
			Medico item = tabela.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtCPF.setText("" + item.getCpf());
			txtIdade.setText("" + item.getIdade());
			txtSanguineo.setText(item.getTipoSanguineo());
			txtSexo.setText(item.getSexo());
			txtNumRegistro.setText("" + item.getNumeroDeRegistro());
			txtStatusPessoa.setText(item.getStatusDePessoa());
			txtStatusDeUsuario.setText(item.getStatusDeUsuario());
			txtSenha.setText(item.getSenha());
			txtEspecialidade.setText(item.getEspecialidade());
			txtLogin.setText(item.getLogin());
		} catch (NullPointerException e) {
			areaEdicao.setVisible(false);
			erroSelecao();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		try {
			Medico excluir = tabela.getSelectionModel().getSelectedItem();
			MedicoDAO exclui = new MedicoDAO();
			exclui.removeById(excluir.getIdFuncionario());
			openPage(Rotas.ListaMedico);
		} catch (SQLException e) {
			e.printStackTrace();
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
		numeroRegistro.setCellValueFactory(new PropertyValueFactory<>("numeroDeRegistro"));
		especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
		MedicoDAO selecao = new MedicoDAO();
		List<Medico> selecaoItens = selecao.select();
		ObservableList<Medico> itens = FXCollections.observableArrayList(selecaoItens);
		tabela.setItems(itens);
		areaEdicao.setVisible(false);
	}

}
