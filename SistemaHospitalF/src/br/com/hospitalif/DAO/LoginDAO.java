package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Login;

public class LoginDAO {
	public void save(Login l) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="INSERT INTO Login VALUES(?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setInt(1,l.getIdPessoa());
		stmt.setString(2,l.getLogin());
		stmt.setString(3,l.getSenha());
		stmt.execute();
	}
	public List<Login> select() {
		List<Login> selecaoItens = new ArrayList<Login>();
		try {	
			Conexao conn = new  Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from Login";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			Login login = new Login();
			login.setLogin(rs.getString("Login"));
			login.setSenha(rs.getString("Senha"));
			selecaoItens.add(login);
		}}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;
	}
	public void update (Login enf) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="UPDATE Login set(?,?,?) where id=(?) ";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setInt(1,enf.getIdPessoa());
		stmt.setString(2,enf.getLogin());
		stmt.setString(3,enf.getSenha());
		stmt.execute();

	}
}
