package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProdutoDao {
	
	public ResultSet buscarCategoria() throws SQLException {
		Connection conexao = new Conexao().getConnection();
		String sql = "select * from produto_categoria ORDER by namecategoria";
		PreparedStatement statment = conexao.prepareStatement(sql);
		return statment.executeQuery();
	}

	public void cadastrarProduto(Integer tipoProduto, Integer codigoProduto, String nome, String descricao, BigDecimal quantidade, BigDecimal preco) throws SQLException{
		Connection conexao = new Conexao().getConnection();
		String sql = "insert into produto(fk_produto_categoria, codigo_produto, nome, descricao, quantidade, preco) values('"+ tipoProduto +"', '" + codigoProduto + "', '"+ nome +"','"+ descricao +"','" + quantidade + "', '"+ preco +"')";
		PreparedStatement statment = conexao.prepareStatement(sql);
		statment.execute();
		conexao.close();
	}
}
