package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Enfermeiro;

public class EnfermeiroDAO {
	public void save(Enfermeiro e) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="INSERT INTO Enfermeiro VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setInt(1,e.getIdEnfermeiro());
		stmt.setString(2,e.getNome());
		stmt.setInt(3, e.getCpf());
		stmt.setInt(4, e.getIdade());
		stmt.setString(5, e.getTipoSanguineo());
		stmt.setString(6, e.getSexo());
		stmt.setString(7, e.getStatusDePessoa());
		stmt.setString(8, e.getLogin());
		stmt.setString(9, e.getSenha());
		stmt.setString(10, e.getStatusDeUsuario());
		stmt.setString(11, e.getNumeroDeRegistro());
		
		
		stmt.execute();
	}

	public void removeById(int id) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="DELETE from Enfermeiro where idEnfermeiro =(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);
		stmt.execute();
		
	}
	
	
	public List<Enfermeiro> select() {
		List<Enfermeiro> selecaoItens = new ArrayList<Enfermeiro>();
		try {	
			Conexao conn = new  Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from Enfermeiro";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			Enfermeiro e2 = new Enfermeiro();
			e2.setIdEnfermeiro(rs.getInt("idEnfermeiro"));
			e2.setNome(rs.getString("nome"));
			e2.setCpf(rs.getInt("cpf"));
			e2.setIdade(rs.getInt("idade"));
			e2.setTipoSanguineo(rs.getString("tipoSanguineo"));
			e2.setSexo(rs.getString("sexo"));
			e2.setStatusDePessoa(rs.getString("statusPessoa"));
			e2.setLogin(rs.getString("login"));
			e2.setSenha(rs.getString("senha"));
			e2.setStatusDeUsuario(rs.getString("statusUsuario"));
			e2.setNumeroDeRegistro(rs.getString("numRegistro"));
			selecaoItens.add(e2);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;
		
	}
	public void update (Enfermeiro e) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="UPDATE Enfermeiro set nome=(?),cpf=(?),idade=(?),tipoSanguineo=(?),sexo=(?),statusPessoa=(?),login=(?),senha=(?),statusUsuario=(?),numRegistro=(?) WHERE idEnfermeiro=(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		
		
		stmt.setString(1,e.getNome());
		stmt.setInt(2,e.getCpf());
		stmt.setInt(3,e.getIdade());
		stmt.setString(4,e.getTipoSanguineo());
		stmt.setString(5,e.getSexo());
		stmt.setString(6,e.getStatusDePessoa());
		stmt.setString(7,e.getLogin());
		stmt.setString(8,e.getSenha());
		stmt.setString(9,e.getStatusDeUsuario());
		stmt.setString(10,e.getNumeroDeRegistro());
		stmt.setInt(11,e.getIdEnfermeiro());
		stmt.execute();

	}
}
