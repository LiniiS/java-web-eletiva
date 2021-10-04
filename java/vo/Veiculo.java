package br.com.asantos.gerenciador.vo;

/**
 * Classe que representa a superclasse referentes à Frota
 * com base no cenário fornecido em aula
 * @author Aline S
 * @version 0.1
 */
public abstract class Veiculo {
	private Integer id;
	private String marca;
	private String placa;
	private Integer velocidade;
	private Integer marcha;

	
	
	public String getMarcaVeiculo() {
		return marca;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marca = marcaVeiculo;
	}
	public String getPlacaVeiculo() {
		return placa;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placa = placaVeiculo;
	}
	public Integer getVelocidadeVeiculo() {
		return velocidade;
	}
	public void setVelocidadeVeiculo(Integer velocidadeVeiculo) {
		this.velocidade = velocidadeVeiculo;
	}
	public Integer getMarchaVeiculo() {
		return marcha;
	}
	public void setMarchaVeiculo(Integer marchaVeiculo) {
		this.marcha = marchaVeiculo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	

}
