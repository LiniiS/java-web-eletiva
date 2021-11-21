package br.com.asantos.gerenciador.vo;

public class Categoria {

	//esse vem do bd
	private int id;
	private String nomeCategoria;
	//categoria dentro da regra de negócios
	private Integer codigoCategoria;
	
	
	
	public String getNome() {
		return nomeCategoria;
	}
	public void setNome(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	
	
}
