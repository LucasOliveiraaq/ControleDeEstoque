package Controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Conexao;
import Dao.LoginDao;
import Dao.ProdutoDao;
import Tela.jFrameCadastroDeProdutos;
import Tela.jFrameLogin;

public class ProdutoController {

	public void buscarCategoria(jFrameCadastroDeProdutos telaView) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.buscarCategoria();
		
	}
	public void cadastrarProduto(jFrameCadastroDeProdutos telaView) throws SQLException{
		Connection conexao = new Conexao().getConnection();
		ProdutoDao produtoDao = new ProdutoDao();
		String quantidade = telaView.getTextFieldQuantidade().getText();
		String preco = telaView.getTextFieldPreco().getText();
		Integer codigoProduto = Integer.parseInt(telaView.getTextFieldCodigoProduto().getText());
		BigDecimal quantidadeConvertida = new BigDecimal(quantidade);
		BigDecimal precoConvertido = new BigDecimal(preco);
		produtoDao.cadastrarProduto(telaView.getButtonCategoria().getSelectedIndex(), codigoProduto, telaView.getTextFieldNome().getText(), telaView.getTextAreaDescricao().getText(), quantidadeConvertida, precoConvertido);
	}
}
