package br.com.asantos.gerenciador.vo;

/**
 * Classe que representa o Produto para cadastro simplificado
 * com base no cenário fornecido em aula
 * @author Aline S
 * @version 0.1
 */
public class Produto {
	
	//id do banco de dados simulado pelo ProdutoDao
	private Integer id;
	//código interno do sistema do cliente
	private String codigoProduto; //id
	private String nomeProduto;
	
	
	public Produto() {
	}
	
	
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	

}
