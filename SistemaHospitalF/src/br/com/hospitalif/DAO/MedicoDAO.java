package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Medico;

public class MedicoDAO {
	public void save(Medico m) throws SQLException  {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "INSERT INTO Medico VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,m.getIdFuncionario());
		stmt.setString(2,m.getNome());
		stmt.setInt(3, m.getCpf());
		stmt.setInt(4, m.getIdade());
		stmt.setString(5, m.getTipoSanguineo());
		stmt.setString(6, m.getSexo());
		stmt.setString(7, m.getStatusDePessoa());
		stmt.setString(8, m.getLogin());
		stmt.setString(9, m.getSenha());
		stmt.setString(10, m.getStatusDeUsuario());
		stmt.setInt(11, m.getNumeroDeRegistro());
		stmt.setString(12, m.getEspecialidade());
		stmt.execute();
		
	}
	public void removeById(int id) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "DELETE from medico where idMedico =(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);
		stmt.execute();
		
	}
	public List<Medico> select() {
		List<Medico> selecaoItens = new ArrayList<Medico>();
		try {	
			Conexao conn = new  Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from Medico";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Medico m2 = new Medico();
			m2.setIdFuncionario(rs.getInt("idMedico"));
			m2.setNome(rs.getString("nome"));
			m2.setCpf(rs.getInt("cpf"));
			m2.setIdade(rs.getInt("idade"));
			m2.setTipoSanguineo(rs.getString("tipoSanguineo"));
			m2.setSexo(rs.getString("sexo"));
			m2.setStatusDePessoa(rs.getString("statusPessoa"));
			m2.setLogin(rs.getString("login"));
			m2.setSenha(rs.getString("senha"));
			m2.setStatusDeUsuario(rs.getString("statusUsuario"));
			m2.setNumeroDeRegistro(rs.getInt("numeroRegistro"));
			m2.setEspecialidade(rs.getString("especialidade"));
			selecaoItens.add(m2);
		}}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;
	}
	public void update(Medico m) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "UPDATE Medico SET nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),statusPessoa=(?),login=(?),senha=(?),statusUsuario=(?),numeroRegistro=(?),especialidade=(?) WHERE idMedico=(?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setString(1,m.getNome());
		stmt.setInt(2, m.getCpf());
		stmt.setInt(3, m.getIdade());
		stmt.setString(4, m.getTipoSanguineo());
		stmt.setString(5, m.getSexo());
		stmt.setString(6, m.getStatusDePessoa());
		stmt.setString(7, m.getLogin());
		stmt.setString(8, m.getSenha());
		stmt.setString(9, m.getStatusDeUsuario());
		stmt.setInt(10, m.getNumeroDeRegistro());
		stmt.setString(11, m.getEspecialidade());
		stmt.setInt(12,m.getIdFuncionario());
		stmt.execute();
	}
}
