package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao {

	public void cadastrarUsuario(String nome, String email, String senha) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		/*
		 * PreparedStatement assume a responsabilidade de montar a query.
		 * 
		 * PreparedStatement takes responsibility for assembling a query.
		 */
		String sql = "insert into login(nome, email, senha) values ('"+nome+"', '"+email+"', '"+senha+"')";
		PreparedStatement statment = conexao.prepareStatement(sql);
		statment.execute();
		conexao.close();
	}
}
