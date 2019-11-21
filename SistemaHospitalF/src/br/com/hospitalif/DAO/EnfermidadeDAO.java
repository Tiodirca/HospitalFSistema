package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Enfermidade;

public class EnfermidadeDAO {
	public void save(Enfermidade en) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "insert into Enfermidade VALUES(?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			stmt.setInt(1,en.getIdEnfermidade());
			stmt.setString(2,en.getNome());
			stmt.setString(3,en.getTipo());
			stmt.setString(4,en.getDescricao());
			stmt.execute();
	}
	public void  removeId(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "DELETE  FROM Enfermidade WHERE idEnfermidade=(?)";	
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);
		stmt.execute();

	}

	public List<Enfermidade> select() {
		List<Enfermidade> selecaoItens = new ArrayList<Enfermidade>();
		try {
				Conexao conn = new Conexao();
				Connection conexao = conn.getConnection();
				System.out.println(conn.getStatus());
				String sqlInsere = "select * from Enfermidade";
				PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
				ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Enfermidade a1 = new Enfermidade();
				a1.setIdEnfermidade(rs.getInt("idEnfermidade"));
				a1.setNome(rs.getString("nome"));
				a1.setTipo(rs.getString("tipo"));
				a1.setDescricao(rs.getString("descricao"));
				
				selecaoItens.add(a1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;

	}
	public void update(Enfermidade en) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "UPDATE Enfermidade SET nome=(?),tipo=(?),descricao=(?)where idEnfermidade=(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			
			stmt.setString(1,en.getNome());
			stmt.setString(2,en.getTipo());
			stmt.setString(3,en.getDescricao());
			stmt.setInt(4,en.getIdEnfermidade());
			stmt.execute();
	}
	
}
