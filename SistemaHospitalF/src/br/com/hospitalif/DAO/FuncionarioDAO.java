package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Funcionario;

public class FuncionarioDAO {
		public void save(Funcionario f) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "INSERT INTO Funcionario VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
				stmt.setInt(1,f.getIdFuncionario());
				stmt.setString(2,f.getLogin());
				stmt.setString(3,f.getSenha());
				stmt.setString(4,f.getStatusDeUsuario());
				stmt.setString(5,f.getNome());
				stmt.setInt(6, f.getCpf());
				stmt.setInt(7, f.getIdade());
				stmt.setString(8, f.getTipoSanguineo());
				stmt.setString(9,f.getSexo());
				stmt.setString(10,f.getStatusDePessoa());
				stmt.execute();
		}
		public void removeById(int id) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "DELETE FROM Funcionario WHERE idFuncionario=(?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
				stmt.setInt(1,id);	
				stmt.execute();
		}
		public List<Funcionario> select() {
			List<Funcionario> selecaoItens = new ArrayList<Funcionario>();
			try {	
				Conexao conn = new  Conexao();
				Connection conexao = conn.getConnection();
				System.out.println(conn.getStatus());
				String sqlInsere = "select * from Funcionario";
				PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
				ResultSet rs = stmt.executeQuery();
				
			while(rs.next()) {
				Funcionario p2 = new Funcionario();
				p2.setIdFuncionario(rs.getInt("idFuncionario"));
				p2.setLogin(rs.getString("login"));
				p2.setSenha(rs.getString("senha"));
				p2.setStatusDeUsuario(rs.getString("statusUsuario"));
				p2.setNome(rs.getString("nome"));
				p2.setCpf(rs.getInt("cpf"));
				p2.setIdade(rs.getInt("idade"));
				p2.setTipoSanguineo(rs.getString("tipoSanguineo"));
				p2.setSexo(rs.getString("sexo"));
				p2.setStatusDePessoa(rs.getString("statusPessoa"));
				selecaoItens.add(p2);
				
			}}catch (SQLException e) {
				// TODO: handle exception
			}
			return selecaoItens;
			
		}
		public void update(Funcionario fun) throws SQLException {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "UPDATE Funcionario SET login=(?),senha=(?),statusUsuario=(?),nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),statusPessoa=(?) where idFuncionario=(?)";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			stmt.setString(1,fun.getLogin());
			stmt.setString(2,fun.getSenha());
			stmt.setString(3,fun.getStatusDeUsuario());
			stmt.setString(4,fun.getNome());
			stmt.setInt(5,fun.getCpf());
			stmt.setInt(6,fun.getIdade());
			stmt.setString(7,fun.getTipoSanguineo());
			stmt.setString(8,fun.getSexo());
			stmt.setString(9,fun.getStatusDePessoa());
			stmt.setInt(10,fun.getIdFuncionario());
			stmt.execute();
			
		}
	}

