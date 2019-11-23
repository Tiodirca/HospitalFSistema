package br.com.hospitalif.controllerLista;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.controller.PacienteControler;
import br.com.hospitalif.model.Paciente;
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

public class PacienteLista extends PacienteControler implements Initializable {

	@FXML
	private TableView<Paciente> tabela;

	@FXML
	private TableColumn<Paciente, String> nome;

	@FXML
	private TableColumn<Paciente, String> cpf;

	@FXML
	private TableColumn<Paciente, String> idade;

	@FXML
	private TableColumn<Paciente, String> tipoSanguineo;

	@FXML
	private TableColumn<Paciente, String> sexo;

	@FXML
	private TableColumn<Paciente, String> statusPessoa;

	@FXML
	private TableColumn<Paciente, String> doenca;

	@FXML
	private TableColumn<Paciente, String> historico;
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
	    	String rel = "reportPaciente.jrxml";
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
			String nome = txtNome.getText();
			int CPF = Integer.parseInt(txtCPF.getText());
			int idade = Integer.parseInt(txtIdade.getText());
			String StatusPessoa = txtStatusPessoa.getText();
			String tipoSanguineo = txtTipoSanguineo.getText();
			String sexo = txtSexo.getText();
			String doenca = txtDoenca.getText();
			String historico = txtHistorico.getText();
			Paciente itens = new Paciente();
			PacienteDAO itensDAO = new PacienteDAO();
			Paciente getId = tabela.getSelectionModel().getSelectedItem();
			itens.setIdPaciente(getId.getIdPaciente());
			itens.setNome(nome);
			itens.setCpf(CPF);
			itens.setIdade(idade);
			itens.setStatusDePessoa(StatusPessoa);
			itens.setTipoSanguineo(tipoSanguineo);
			itens.setSexo(sexo);
			itens.setDoenca(doenca);
			itens.setHistorico(historico);
			itensDAO.update(itens);
			openPage(Rotas.ListaPaciente);
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
		openPage(Rotas.Paciente);
	}

	@FXML
	void editar(ActionEvent event) {
		try {
			areaEdicao.setVisible(true);
			Paciente item = tabela.getSelectionModel().getSelectedItem();
			txtNome.setText(item.getNome());
			txtCPF.setText("" + item.getCpf());
			txtIdade.setText("" + item.getIdade());
			txtStatusPessoa.setText(item.getStatusDePessoa());
			txtTipoSanguineo.setText(item.getTipoSanguineo());
			txtSexo.setText(item.getSexo());
			txtDoenca.setText(item.getDoenca());
			txtHistorico.setText(item.getHistorico());
		} catch (NullPointerException e) {
			areaEdicao.setVisible(false);
			erroSelecao();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		try {
			Paciente excluir = tabela.getSelectionModel().getSelectedItem();
			PacienteDAO exclui = new PacienteDAO();
			exclui.removeById(excluir.getIdPaciente());
			openPage(Rotas.ListaPaciente);
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
		doenca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
		historico.setCellValueFactory(new PropertyValueFactory<>("historico"));

		// TODO Auto-generated method stub
		PacienteDAO selecao = new PacienteDAO();
		List<Paciente> selecaoItens = selecao.select();
		ObservableList<Paciente> itens = FXCollections.observableArrayList(selecaoItens);
		tabela.setItems(itens);
		areaEdicao.setVisible(false);
	}

}
