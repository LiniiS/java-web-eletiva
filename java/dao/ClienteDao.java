package br.com.asantos.gerenciador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.asantos.gerenciador.vo.Cliente;

/**
 * Classe que simula um Banco de Dados para a classe Cliente
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.2
 */
public class ClienteDao extends BaseDao {

	public ArrayList<Cliente> getClientes() throws Exception{
		open();
		ArrayList<Cliente> lst = new ArrayList<>();
		Statement stm = getConn().createStatement();
		
		String sql = "SELECT cli_id, cli_nome, cli_email, cli_cidade FROM cliente";
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			Cliente cli = new Cliente();
			cli.setId(rs.getInt(1));
			cli.setNome(rs.getString(2));
			cli.setEmail(rs.getString(3));
			cli.setCidade(rs.getString(4));
			
			lst.add(cli);
			
		}
		stm.close();
		rs.close();
		close();
		return lst;
	}
	
	public ArrayList<Cliente> findClientes(String nome) throws Exception {
		super.open();
		ArrayList<Cliente> lst = new ArrayList<>();
		
		String sql = "SELECT cli_id, cli_nome, cli_email, cli_cidade FROM cliente where cli_nome like ?";
		PreparedStatement pstm = getConn().prepareStatement(sql);
		pstm.setString(1, nome + '%');
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Cliente cli = new Cliente();
			cli.setId(Integer.parseInt(rs.getString(1)));
			cli.setNome(rs.getString(2));
			cli.setEmail(rs.getString(3));
			cli.setCidade(rs.getString(4));
			
			lst.add(cli);
		}
		pstm.close();
		rs.close();
		close();
		return lst;
	}
	
	public void newCliente(Cliente cliente) throws Exception {
		open();
		//										1			2				3			4				5			6		7				8			9			10		11	
		String query = "INSERT INTO cliente (cli_nome, cli_sobrenome, cli_logradouro, cli_bairro, cli_estado, cli_cidade, cli_complemento, cli_cep, cli_dt_nasc, cli_email, cli_telefone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getSobrenome());
		pstm.setString(3, cliente.getLogradouro());
		pstm.setString(4, cliente.getBairro());
		pstm.setString(5, cliente.getEstado());
		pstm.setString(6, cliente.getCidade());
		pstm.setString(7, cliente.getComplemento());
		pstm.setString(8,  cliente.getCEP());
		//TODO modificar tipo data, ajustar pra date - no form tá como date, no bd e VO tá como string 
		pstm.setString(9, cliente.getDtNascimento());
		pstm.setString(10, cliente.getEmail());
		pstm.setString(11, cliente.getTelefone());
		pstm.execute();
		close();
	
	
	}
	
	public void editCliente(Cliente cliente) throws Exception {
		open();

		
		String query = "UPDATE cliente SET cli_nome=?, cli_sobrenome=?, cli_email=?, cli_telefone=?, cli_dt_nasc=?, cli_logradouro=?, cli_bairro=?, cli_complemento=?, cli_cidade=?, cli_estado=?, cli_cep=? where cli_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getSobrenome());
		pstm.setString(3, cliente.getEmail());
		pstm.setString(4, cliente.getTelefone());
		pstm.setString(5, cliente.getDtNascimento());
		pstm.setString(6, cliente.getLogradouro());
		pstm.setString(7, cliente.getBairro());
		pstm.setString(8, cliente.getComplemento());
		pstm.setString(9, cliente.getCidade());
		pstm.setString(10, cliente.getEstado());
		pstm.setString(11, cliente.getCEP());
		pstm.setInt(12, cliente.getId());
		
		
		pstm.execute();
		close();
		
	}
	
	public void deleteCliente(Cliente cliente) throws Exception{
		open();
		String query = "DELETE FROM cliente WHERE cli_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setInt(1, cliente.getId());
		pstm.execute();
		pstm.close();
		close();
	}
	
	public Cliente findByIdCliente(int id) throws Exception{
		super.open();
		
		String sql = "SELECT cli_id, cli_nome, cli_sobrenome, cli_email, cli_telefone, cli_dt_nasc, cli_logradouro, cli_bairro, cli_complemento, cli_cidade, cli_estado, cli_cep FROM cliente where cli_id=?";
	//	String sql = "SELECT cli_id, cli_nome, cli_sobrenome, cli_email, cli_telefone, cli_dt_nasc, cli_logradouro, cli_bairro, cli_complemento, cli_cidade, cli_estado, cli_cep FROM cliente where cli_id=?";
		PreparedStatement pstm = getConn().prepareStatement(sql);
		pstm.setInt(1, id);
		
		ResultSet rs = pstm.executeQuery();
		Cliente cliente = new Cliente();
		while(rs.next()) {
			cliente.setId(Integer.parseInt(rs.getString(1)));
			cliente.setNome(rs.getString(2));
			cliente.setSobrenome(rs.getString(3));
			cliente.setEmail(rs.getString(4));
			cliente.setTelefone(rs.getString(5));
			cliente.setDtNascimento(rs.getString(6));
			cliente.setLogradouro(rs.getString(7));
			cliente.setBairro(rs.getString(8));
			cliente.setComplemento(rs.getString(9));
			cliente.setCidade(rs.getString(10));
			cliente.setEstado(rs.getString(11));
			cliente.setCEP(rs.getString(12));
			
		}
		rs.close();
		return cliente;
	}
	
	

	
	
}
/*	
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
*/

