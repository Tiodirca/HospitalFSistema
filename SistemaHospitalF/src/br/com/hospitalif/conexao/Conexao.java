package br.com.hospitalif.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public String status = "Não conectado !";
	java.sql.Connection conn = null;
	String user = "root";
	String pwd = "";
	String driverName = "com.mysql.jdbc.Driver";
	String server = "localhost";
	String bdName = "hospital";
	String url = "jdbc:mysql://" + server + ":3306/" + bdName;
	public Connection getConnection() {
		try {
			Class.forName(this.driverName);	
			this.conn =DriverManager.getConnection(url, user, pwd);
			if(conn != null) {
				this.status = "Conectado com sucesso";
			}else {
				this.status = "Não conectado";
			}
		}catch(ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.conn;
	}
	public String getStatus() {
		return this.status;
	}
	public boolean closeConnection() throws SQLException{
		this.conn.close();
		return false;
	}
	public void resetConnection() {
		try {
		this.closeConnection();
		this.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
