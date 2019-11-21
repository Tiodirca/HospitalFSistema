package App;

import java.io.IOException;
import java.sql.SQLException;
import br.com.hospitalif.util.Rotas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {
	static Stage stageAtual;
	static FXMLLoader loader;
	@Override
	public void start(Stage Stage) throws Exception {
		stageAtual = Stage;
		try {
			openPage(Rotas.Login);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void openPage(String rota) throws IOException {
		loader = new FXMLLoader(getClass().getResource(rota));
		Scene scene = new Scene(loader.load());
		stageAtual.setScene(scene);
		stageAtual.show();
	}
	
	public static void main(String[] args) throws SQLException {
		launch(args);
	}
	
	// Alertas de Erros
	public void ConfirmaCampoVazio(){
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Campo com valor Vazio");
    	alert.setContentText("Por Favor Preencha os Campos ALTURA e PESO");
    	alert.show();
    }
	public void ConfirmaCampoVazio2(){
	
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Campo com valor Vazio");
    	alert.setContentText("Por Favor Preencha os Campos CPF(Com 11 numeros) e IDADE");
    	alert.show();
    }
	public void ConfirmaDataVazia(){
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Campo com valor Vazio");
    	alert.setContentText("Por Favor Preencha os Campos Data");
    	alert.show();
    }
	public void erroSelecao(){
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Nenhum campo Selecionado");
    	alert.setContentText("Selecione um campo por favor !!");
    	alert.show();
    }
}