package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Dao.ProdutoDao;

public class ProdutoTableModel extends AbstractTableModel{
	
	private List<Produto> produtos = new ArrayList<>();
	private final String[] colunas = {"Categoria Produto", "codigo", "nome", "descrição", "quantidade", "preco"};

	//Quantidade de linhas
	@Override
	public int getRowCount() {
		return produtos.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	//Quantidade de colunas
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	//Pega valores da tabela
	@Override
	public Object getValueAt(int linha, int colunas) {
		switch (colunas) {
		case 0:
			return produtos.get(linha).getProdutoCategoria();
		case 1:
			return produtos.get(linha).getCodigoProduto();
		case 2: 
			return produtos.get(linha).getNome();
		case 3:
			return produtos.get(linha).getDescricao();
		case 4:
			return produtos.get(linha).getQuantidade();
		case 5:
			return produtos.get(linha).getQuantidade();
		default:
			break;
		}
		return null;
	}
	
	public void addRow(Produto p) {
		this.produtos.add(p);
		this.fireTableDataChanged();
	}
	
	public void removeRow(int linha) {
		this.produtos.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
	public void carregarTabela() throws SQLException {
		ProdutoDao pDao = new ProdutoDao();
		produtos = pDao.listarProdutos();
	}
	
}
