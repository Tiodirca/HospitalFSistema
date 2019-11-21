package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Paciente;

public class PacienteDAO {
	public void save(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "INSERT INTO Paciente VALUES(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			stmt.setInt(1,p.getIdPaciente());	
			stmt.setString(2,p.getNome());
			stmt.setInt(3, p.getCpf());
			stmt.setInt(4, p.getIdade());
			stmt.setString(5, p.getTipoSanguineo());
			stmt.setString(6,p.getSexo());
			stmt.setString(7, p.getStatusDePessoa());
			stmt.setString(8,p.getDoenca());
			stmt.setString(9,p.getHistorico());
			stmt.execute();
	}
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "Delete from Paciente where idPaciente=(?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			stmt.setInt(1,id);	
			stmt.execute();
	}
	public List<Paciente> select() {
		List<Paciente> selecaoItens = new ArrayList<Paciente>();
		try {	
			Conexao conn = new  Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from Paciente";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			Paciente p2 = new Paciente();
			p2.setIdPaciente(rs.getInt("idPaciente"));
			p2.setNome(rs.getString("nome"));
			p2.setCpf(rs.getInt("cpf"));
			p2.setIdade(rs.getInt("idade"));
			p2.setTipoSanguineo(rs.getString("tipoSanguineo"));
			p2.setSexo(rs.getString("sexo"));
			p2.setStatusDePessoa(rs.getString("statusPessoa"));
			p2.setDoenca(rs.getString("doenca"));
			p2.setHistorico(rs.getString("historico"));
			selecaoItens.add(p2);
			
		}}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;
		
	}
	public void update(Paciente p) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "UPDATE Paciente SET nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),statusPessoa=(?),doenca=(?),historico=(?) WHERE idPaciente=(?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setString(1,p.getNome());
		stmt.setInt(2, p.getCpf());
		stmt.setInt(3, p.getIdade());
		stmt.setString(4, p.getTipoSanguineo());
		stmt.setString(5,p.getSexo());
		stmt.setString(6, p.getStatusDePessoa());
		stmt.setString(7,p.getDoenca());
		stmt.setString(8,p.getHistorico());
		stmt.setInt(9,p.getIdPaciente());
		stmt.execute();
		
	}
}
