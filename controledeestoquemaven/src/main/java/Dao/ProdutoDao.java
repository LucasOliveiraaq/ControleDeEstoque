package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Produto;

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
	
	public List<Produto> listarProdutos() throws SQLException{
		Connection conexao = new Conexao().getConnection();
		String sql = "select * from produto";
		PreparedStatement statment = conexao.prepareStatement(sql);
		List<Produto> produtos = new ArrayList<>();
		ResultSet rs =  statment.executeQuery();
		while (rs.next()) {
			Produto produto = new Produto();
			produto.setCodigoProduto(rs.getInt("fk_produto_categoria"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setQuantidade(rs.getBigDecimal("quantidade"));
			produto.setPreco(rs.getBigDecimal("preco"));
			
			produtos.add(produto);
		}
		return produtos;
	}
}
