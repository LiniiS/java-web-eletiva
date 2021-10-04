package br.com.asantos.gerenciador.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.asantos.gerenciador.vo.Cliente;

/**
 * Classe que simula um Banco de Dados para a classe Cliente
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.1
 */
public class ClienteDao {
	
	
	private static List<Cliente> lista = new ArrayList<>();
	//simular uma chave sequencial pra atribuir aos cadastros:
	private static Integer id = 1;
	
	static {
		Cliente c1 = new Cliente();
		c1.setId(id++);
		c1.setNome("Carlos Daniel");
		c1.setSobrenome("Almeida");
		c1.setDtNascimento("25/12/2001");
		c1.setEmail("cda@email.com");
		c1.setLogradouro("Travessa 4A");
		c1.setBairro("Pantanal");
		c1.setCidade("Pauini");
		c1.setEstado("AM");
		c1.setTelefone("97995884570");
		c1.setCEP("69860-000");
		
		Cliente c2 = new Cliente();
		c2.setId(id++);
		c2.setNome("Paola");
		c2.setSobrenome("Bracho");
		c2.setDtNascimento("14/02/1965");
		c2.setEmail("pb@email.com");
		c2.setLogradouro("Travessa 4A");
		c2.setBairro("Pantanal");
		c2.setCidade("Pauini");
		c2.setEstado("AM");
		c2.setTelefone("97887484532");
		c2.setCEP("69860-000");
		
		lista.add(c1);
		lista.add(c2);
	}
	
	
	
	public void adiciona(Cliente cliente) {
		cliente.setId(ClienteDao.id++);
		ClienteDao.lista.add(cliente);
		
	}
	
	public List<Cliente> getClientes(){
		//atributo de classe
		return ClienteDao.lista;
	}
	
	public List<Cliente> buscaCliente(String pesquisado) {
		//temporariamente simular o resultado da busca
		ArrayList<Cliente> lista = new ArrayList<>();
		Cliente clienteBuscado = new Cliente();
		
		clienteBuscado.setId(id++);
		clienteBuscado.setNome("Leonardo");
		clienteBuscado.setSobrenome("Souza");
		clienteBuscado.setDtNascimento("25/02/1965");
		clienteBuscado.setEmail("ls@email.com");
		clienteBuscado.setLogradouro("Rua Bella");
		clienteBuscado.setBairro("Centro");
		clienteBuscado.setCidade("São Paulo");
		clienteBuscado.setEstado("SP");
		clienteBuscado.setTelefone("11887224532");
		clienteBuscado.setCEP("08775-000");
		lista.add(clienteBuscado);
		
		return lista;
	}
	
	//
	public void removeCliente(Integer id) {
		//método tradicional para iterar uma lista
		//mais comum em código legado
		//daria pra usar stream e =>
		Iterator<Cliente> it = lista.iterator();
		
		while(it.hasNext()) {
			Cliente cliente = it.next();
			
			if(cliente.getId() == id) {
				it.remove();
			}
		}
	}

	public Cliente buscaClientePorId(Integer id) {
		//realizar um forEach pela lista de clientes
		//daria pra utilizar os métodos mais modernos cm lambda
		for(Cliente cliente : lista) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}

		//deixar retornando null, mas deveria tratar a exceção caso o ID não exista
		//supondo que o id passado sempre irá existir
		//o risco de retornar um null sem tratar exceção é sabido 
		return null;
	}

}
