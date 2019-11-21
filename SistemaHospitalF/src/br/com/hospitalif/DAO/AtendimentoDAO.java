package br.com.hospitalif.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.hospitalif.conexao.Conexao;
import br.com.hospitalif.model.Atendimento;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class AtendimentoDAO {

	public void save(Atendimento a) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="INSERT INTO Atendimento VALUES (?,?,?,?,?,?,?) ";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1, a.getIdAtendimento());
		stmt.setString(2, a.getComentarioEnfermeiro());
		stmt.setString(3, a.getComentarioMedico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,java.sql.Date.valueOf(a.getData()));
		stmt.setString(7, a.getDoenca());
		stmt.execute();
	}
	public void removeById(int id) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "DELETE from Atendimento where idAtendimento =(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);
		stmt.execute();
		
	}
	public List<Atendimento> select() {
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		try {
				Conexao conn = new Conexao();
				Connection conexao = conn.getConnection();
				System.out.println(conn.getStatus());
				String sqlInsere = "select * from Atendimento";
				PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
				ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Atendimento a1 = new Atendimento();
				a1.setIdAtendimento(rs.getInt("idAtendimento"));
				a1.setComentarioEnfermeiro(rs.getString("comentarioEnfermeiro"));
				a1.setComentarioMedico(rs.getString("comentarioMedico"));
				a1.setPeso(rs.getFloat("peso"));
				a1.setAltura(rs.getFloat("altura"));
				a1.setData(rs.getDate("dataAtendimento").toLocalDate());
				a1.setDoenca(rs.getString("doenca"));
				atendimentos.add(a1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return atendimentos;

	}
	public void update (Atendimento a) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "update Atendimento set comentarioEnfermeiro=(?),comentarioMedico =(?),peso=(?),altura=(?),dataAtendimento=(?),doenca=(?) where idAtendimento=(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setString(1, a.getComentarioEnfermeiro());
		stmt.setString(2, a.getComentarioMedico());
		stmt.setFloat(3, a.getPeso());
		stmt.setFloat(4, a.getAltura());
		stmt.setDate(5,java.sql.Date.valueOf(a.getData()));
		stmt.setString(6, a.getDoenca());
		stmt.setInt(7,a.getIdAtendimento());
		stmt.execute();
		
	}
	
}
