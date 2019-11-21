package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Entrada;
public class EntradaDAO {

	public void save(Entrada en) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "insert into Entrada VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			stmt.setInt(1,en.getIdEntrada());
			stmt.setDate(2,java.sql.Date.valueOf(en.getDataEntrada()));
			stmt.setDate(3,java.sql.Date.valueOf(en.getDataSaida()));
			stmt.setString(4,en.getComentarioEnfermeiro());
			stmt.setString(5,en.getComentarioMedico());
			stmt.setString(6,en.getDoenca());
			stmt.setString(7,en.getSituacaoDePaciente());
			stmt.setString(8,en.getStatusDeEntrada());
		    stmt.setFloat(9,en.getAltura());
		    stmt.setFloat(10,en.getPeso());
			stmt.setDate(11,java.sql.Date.valueOf(en.getData()));
			stmt.execute();
	}
	public void removeById(int id) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "DELETE FROM Entrada WHERE idEntrada=(?)";	
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			stmt.setInt(1,id);	
			stmt.execute();
	}
	public List<Entrada> select() {
		List<Entrada> selecaoItens = new ArrayList<Entrada>();
		try {	
			Conexao conn = new  Conexao();
			Connection conexao = conn.getConnection();
			System.out.println(conn.getStatus());
			String sqlInsere = "select * from Entrada";
			PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
			ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			Entrada entrada = new Entrada();
			entrada.setIdEntrada(rs.getInt("idEntrada"));
			entrada.setDataEntrada(rs.getDate("entrada").toLocalDate());
			entrada.setDataSaida(rs.getDate("saida").toLocalDate());
			entrada.setComentarioEnfermeiro(rs.getString("comentarioEnfermeiro"));
			entrada.setComentarioMedico(rs.getString("comentarioMedico"));
			entrada.setDoenca(rs.getString("doenca"));
			entrada.setSituacaoDePaciente(rs.getString("situacaoPaciente"));
			entrada.setStatusDeEntrada(rs.getString("statusEntrada"));
			entrada.setAltura(rs.getFloat("altura"));
			entrada.setPeso(rs.getFloat("peso"));
			entrada.setData(rs.getDate("dataAtendimento").toLocalDate());
			
			selecaoItens.add(entrada);
		}}catch (SQLException e) {
			// TODO: handle exception
		}
		return selecaoItens;

	}
	public void update(Entrada entrada) throws SQLException {
		Conexao conn = new Conexao();
		Connection conexao = conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "UPDATE Entrada SET entrada=(?),saida=(?),comentarioEnfermeiro=(?),comentarioMedico=(?),doenca=(?),situacaoPaciente=(?),statusEntrada=(?),altura=(?),peso=(?),dataAtendimento=(?) where idEntrada =(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);     
		  
		stmt.setDate(1,java.sql.Date.valueOf(entrada.getDataEntrada()));
		stmt.setDate(2,java.sql.Date.valueOf(entrada.getDataSaida()));
		stmt.setString(3,entrada.getComentarioEnfermeiro());
		stmt.setString(4,entrada.getComentarioMedico());
		stmt.setString(5,entrada.getDoenca());
		stmt.setString(6,entrada.getSituacaoDePaciente());
		stmt.setString(7,entrada.getStatusDeEntrada());
	    stmt.setFloat(8,entrada.getAltura());
	    stmt.setFloat(9,entrada.getPeso());
		stmt.setDate(10,java.sql.Date.valueOf(entrada.getData()));
		 stmt.setInt(11,entrada.getIdEntrada());
	   stmt.execute();
	}
	
}
