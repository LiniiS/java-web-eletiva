package br.com.asantos.gerenciador.vo;

/**
 * Classe que representa o modelo de um Cliente
 * com base no form fornecido em aula e aqui adaptada
 * @author Aline S
 * @version 0.1
 */

public class Cliente {
	
	private Integer id;
	
	private String nomeCliente;
	private String sobrenomeCliente;
	private String emailCliente;
	private String telefoneCliente;
	
	//é Date, testando como será a requisição q vem do form deixar como String
	//na recuperação da DtNascimento pra alteraçaõ de cadastro:  <fmt:formatDate value="${cliente.dtNascimento }" pattern="MM/dd/yyyy"/>
	//é preciso mudar o tp, joga a exceção de q n pode converter de String -> Date
	private String dtNascimentoCliente;
	private String logradouroCliente;
	private String bairroCliente;
	private String complementoCliente;
	private String cidadeCliente;
	private String estadoCliente;
	private String cepCliente;
	
	public Cliente() {
	}
	
	public String getNome() {
		return nomeCliente;
	}
	public void setNome(String nome) {
		this.nomeCliente = nome;
	}
	public String getSobrenome() {
		return sobrenomeCliente;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenomeCliente = sobrenome;
	}
	public String getEmail() {
		return emailCliente;
	}
	public void setEmail(String email) {
		this.emailCliente = email;
	}
	public String getTelefone() {
		return telefoneCliente;
	}
	public void setTelefone(String telefone) {
		this.telefoneCliente = telefone;
	}
	public String getDtNascimento() {
		return dtNascimentoCliente;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimentoCliente = dtNascimento;
	}
	public String getLogradouro() {
		return logradouroCliente;
	}
	public void setLogradouro(String logradouro) {
		this.logradouroCliente = logradouro;
	}
	public String getBairro() {
		return bairroCliente;
	}
	public void setBairro(String bairro) {
		this.bairroCliente = bairro;
	}
	public String getComplemento() {
		return complementoCliente;
	}
	public void setComplemento(String complemento) {
		this.complementoCliente = complemento;
	}
	public String getCidade() {
		return cidadeCliente;
	}
	public void setCidade(String cidade) {
		this.cidadeCliente = cidade;
	}
	public String getEstado() {
		return estadoCliente;
	}
	public void setEstado(String estado) {
		this.estadoCliente = estado;
	}
	public String getCEP() {
		return cepCliente;
	}
	public void setCEP(String CEP) {
		this.cepCliente = CEP;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
