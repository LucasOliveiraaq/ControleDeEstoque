package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class FuncionarioDao {

	public void cadastrarFuncionario(String nome, String idade, Date dataCadastro) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		String sql = "insert into funcionario(nome, idade, datacadastro) values ('"+nome+"', '"+idade+"', '"+dataCadastro+"')";
		PreparedStatement statment = conexao.prepareStatement(sql);
		statment.execute();
		conexao.close();
	}
}
