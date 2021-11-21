package br.com.asantos.gerenciador.vo;

/**
 * Classe que representa o Carro referente à Frota
 * com base no cenário fornecido em aula
 * @author Aline S
 * @version 0.1
 */
public class Carro extends Veiculo{
	
	
	//int, para testar deixar String -> mudar no form o type de text pra number
	private String portasCarro;
	private boolean arCarro;
	
	public String getPortasCarro() {
		return portasCarro;
	}
	public void setPortasCarro(String portasCarro) {
		this.portasCarro = portasCarro;
	}

	public boolean isArCarro() {
		return arCarro;
	}
	public void setArCarro(boolean arCarro) {
		this.arCarro = arCarro;
	}
	

	
	//TODO: verificar a situação do ParseBoolean e o switch/

	
}
