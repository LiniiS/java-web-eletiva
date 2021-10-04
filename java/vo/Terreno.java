package br.com.asantos.gerenciador.vo;

/**
 * Classe que representa o modelo de um Terreno
 * com base no cenário fornecido em aula e aqui adaptada
 * @author Aline S
 * @version 0.1
 */
public class Terreno {

	private Integer id;
	//manter como texto por enqto
	private String latitude;
	private String longitude;
	private String alturaMax;
	private String alturaMin;
	private Integer cotasTerreno;
	private Integer qtdeTerreno;
	
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAlturaMax() {
		return alturaMax;
	}
	public void setAlturaMax(String alturaMax) {
		this.alturaMax = alturaMax;
	}
	public String getAlturaMin() {
		return alturaMin;
	}
	public void setAlturaMin(String alturaMin) {
		this.alturaMin = alturaMin;
	}
	public Integer getCotasTerreno() {
		return cotasTerreno;
	}
	public void setCotasTerreno(Integer cotasTerreno) {
		this.cotasTerreno = cotasTerreno;
	}
	public Integer getQtdeTerreno() {
		return qtdeTerreno;
	}
	public void setQtdeTerreno(Integer qtdeTerreno) {
		this.qtdeTerreno = qtdeTerreno;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
