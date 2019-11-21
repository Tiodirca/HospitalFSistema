package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.EnfermidadePessoal;

public class EnfermidadePessoalDAO {
	
public void save(EnfermidadePessoal enp) throws SQLException {

	Conexao conn = new  Conexao();
	Connection conexao =  conn.getConnection();
	System.out.println(conn.getStatus());
	String sqlInsere = "INSERT INTO EnfermidadePessoal VALUES(?,?,?,?,?,?)";
	PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
	stmt.setInt(1,enp.getIdEnfermidadePessoal());
	stmt.setString(2,enp.getNome());
	stmt.setString(3,enp.getTipo());
	stmt.setString(4,enp.getDescricao());
	stmt.setString(5,enp.getComentario());
	stmt.setString(6,enp.getStatusDeEnfermidade());
	stmt.execute();	
	}
public void removeById(int id) throws SQLException {
	Conexao conn = new Conexao();
	Connection conexao = conn.getConnection();
	System.out.println(conn.getStatus());
	String sqlInsere = "DELETE FROM EnfermidadePessoal WHERE idEnfermidadePessoal=(?)";	
	PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);	
		stmt.execute();
}
public List<EnfermidadePessoal> select() {
	List<EnfermidadePessoal> selecaoItens = new ArrayList<EnfermidadePessoal>();
	try {
			Conexao conn = new Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from EnfermidadePessoal";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			EnfermidadePessoal a1 = new EnfermidadePessoal();
			a1.setIdEnfermidadePessoal(rs.getInt("idEnfermidadePessoal"));
			a1.setNome(rs.getString("nome"));
			a1.setTipo(rs.getString("tipo"));
			a1.setDescricao(rs.getString("descricao"));
			a1.setComentario(rs.getString("comentario"));
			a1.setStatusDeEnfermidade(rs.getString("statusEnfermidade"));
			
			selecaoItens.add(a1);
		}
		
	} catch (SQLException e) {
		// TODO: handle exception
	}
	return selecaoItens;

}
public void update(EnfermidadePessoal enp) throws SQLException {
	Conexao conn = new Conexao();
	Connection conexao = conn.getConnection();
	System.out.println(conn.getStatus());
	String sqlInsere = "UPDATE EnfermidadePessoal SET nome=(?),tipo=(?),descricao=(?),comentario=(?),statusEnfermidade=(?) where idEnfermidadePessoal =(?)";
	PreparedStatement stmt = conexao.prepareStatement(sqlInsere);

	stmt.setString(1,enp.getNome());
	stmt.setString(2,enp.getTipo());
	stmt.setString(3,enp.getDescricao());
	stmt.setString(4,enp.getComentario());
	stmt.setString(5,enp.getStatusDeEnfermidade());
	stmt.setInt(6,enp.getIdEnfermidadePessoal());
			stmt.execute();
}
}
