package Model;

import java.math.BigDecimal;

public class Produto {

	private int id;
	private int produtoCategoria;
	private int codigoProduto;
	private String nome;
	private String descricao;
	private BigDecimal quantidade;
	private BigDecimal preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdutoCategoria() {
		return produtoCategoria;
	}
	public void setProdutoCategoria(int produtoCategoria) {
		this.produtoCategoria = produtoCategoria;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
}
