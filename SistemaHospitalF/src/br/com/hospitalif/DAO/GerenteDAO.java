package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Gerente;

public class GerenteDAO {
	public void save(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "INSERT INTO  Gerente VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,g.getIdFuncionario());
		stmt.setString(2,g.getNome());
		stmt.setInt(3, g.getCpf());
		stmt.setInt(4, g.getIdade());
		stmt.setString(5, g.getTipoSanguineo());
		stmt.setString(6,g.getSexo());
		stmt.setString(7, g.getStatusDePessoa());
		stmt.setString(8, g.getLogin());
		stmt.setString(9, g.getSenha());
		stmt.setString(10, g.getStatusDeUsuario());
		stmt.setString(11,g.getCargo());
		stmt.execute();
	}
	public void removeById(int id) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "DELETE from Gerente where idGerente = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);
		stmt.execute();
		
	}
	public List<Gerente> select() {
		List<Gerente> selecaoItens = new ArrayList<Gerente>();
		try {	
			Conexao conn = new  Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from Gerente";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Gerente g2 = new Gerente();
			g2.setIdFuncionario(rs.getInt("idGerente"));
			g2.setNome(rs.getString("nome"));
			g2.setCpf(rs.getInt("cpf"));
			g2.setIdade(rs.getInt("idade"));
			g2.setTipoSanguineo(rs.getString("tipoSanguineo"));
			g2.setSexo(rs.getString("sexo"));
			g2.setStatusDePessoa(rs.getString("statusPessoa"));
			g2.setLogin(rs.getString("login"));
			g2.setSenha(rs.getString("senha"));
			g2.setStatusDeUsuario(rs.getString("statusUsuario"));
			g2.setCargo(rs.getString("cargo"));
			selecaoItens.add(g2);
		}}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;
		
	}
	public void update(Gerente g) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "UPDATE Gerente SET nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),statusPessoa=(?),login=(?),senha=(?),statusUsuario=(?),cargo=(?) WHERE idGerente=(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setString(1,g.getNome());
		stmt.setInt(2, g.getCpf());
		stmt.setInt(3, g.getIdade());
		stmt.setString(4, g.getTipoSanguineo());
		stmt.setString(5,g.getSexo());
		stmt.setString(6, g.getStatusDePessoa());
		stmt.setString(7, g.getLogin());
		stmt.setString(8, g.getSenha());
		stmt.setString(9, g.getStatusDeUsuario());
		stmt.setString(10,g.getCargo());
		stmt.setInt(11,g.getIdFuncionario());
				stmt.execute();
	}
}
