package br.com.asantos.gerenciador.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.asantos.gerenciador.vo.Produto;

/**
 * Classe que simula um Banco de Dados para a classe Produto
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.2
 */
public class ProdutoDao extends BaseDao{

	public ArrayList<Produto> getProdutos() throws Exception{
		//abre conexão cm bd
		open();
		//cria a lista q será retornada
		ArrayList<Produto> lst = new ArrayList<>();
		//cria o statement para ser passado na conexão
		Statement stm = getConn().createStatement();
		//gera a query
		String sql = "SELECT prd_id, prd_nome, prd_codigo, prd_preco FROM produto";
		//o statement que executa a query retorna um cnjto de statements
		ResultSet rs = stm.executeQuery(sql);
		//enqto houver um próximo conjunto de resultados, o conteudo do BD é atribuido ao Produto
		while(rs.next()) {
			Produto prd = new Produto();
			prd.setId(rs.getInt(1));
			prd.setNomeProduto(rs.getString(2));
			prd.setCodigoProduto(rs.getString(3));
			prd.setPrecoProduto(rs.getBigDecimal(4));
			
			//todos os produtos cm seus atributos povoados são adicionados à lista
			lst.add(prd);
		}
		//encerra o statement
		stm.close();
		//encerra e libera o result set object
		rs.close();
		//fecha a conexão cm o bd
		close();
		//retorna a lista deprodutos povoada com os dados do bd
		return lst;
	}
	
	public ArrayList<Produto> findProdutos(String nome) throws Exception{
		super.open();
		ArrayList<Produto> lst = new ArrayList<>();
		String sql = "SELECT prd_id, prd_nome, prd_codigo, prd_preco FROM produto where prd_nome like ?";
		PreparedStatement pstm = getConn().prepareStatement(sql);
		pstm.setString(1, nome + '%');
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Produto prd = new Produto();
			prd.setId(Integer.parseInt(rs.getString(1)));
			prd.setNomeProduto(rs.getString(2));
			prd.setCodigoProduto(rs.getString(3));
			prd.setPrecoProduto(new BigDecimal(rs.getString(4)));
			
			lst.add(prd);
		}
		pstm.close();
		rs.close();
		close();
		return lst;
		
	}
	
	public void newProduto(Produto produto) throws Exception {
		open();
		String query = " INSERT INTO produto (prd_nome, prd_codigo, prd_preco) values (?, ?, ?)";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, produto.getNomeProduto());
		pstm.setString(2, produto.getCodigoProduto());
		pstm.setBigDecimal(3, produto.getPrecoProduto());
		pstm.execute();
		close();
	}
	
	public void editProduto(Produto produto) throws Exception {
		open();
		String query = " UPDATE produto set prd_nome=?, prd_codigo=?, prd_preco=? where prd_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, produto.getNomeProduto());
		pstm.setString(2, produto.getCodigoProduto());
		pstm.setBigDecimal(3, produto.getPrecoProduto());
		pstm.setInt(4, produto.getId());
		pstm.execute();
		close();
	}
	
	public void deleteProduto(Produto produto) throws Exception{
		open();
		String query = "DELETE from produto where prd_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setInt(1, produto.getId());
		pstm.execute();
		pstm.close();
		close();
	}
	
	public Produto findByIdProduto(int id) throws Exception{
		super.open();
		
		String sql = "SELECT prd_id, prd_nome, prd_codigo, prd_preco FROM produto where prd_id=?";
		PreparedStatement pstm = getConn().prepareStatement(sql);
		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();
		Produto produto = new Produto();
		while(rs.next()) {
			produto.setId(Integer.parseInt(rs.getString(1)));
			produto.setNomeProduto(rs.getString(2));
			produto.setCodigoProduto(rs.getString(3));
			produto.setPrecoProduto(new BigDecimal(rs.getString(4)));
		}
		rs.close();
		return produto;
		
		
		
	}
}
	/*
	private static List<Produto> lista = new ArrayList<>();
	private static Integer id = 1;

	static {
		Produto p1 = new Produto();
		p1.setId(id++);
		p1.setCodigoProduto("COD1254");
		p1.setNomeProduto("Jabuticaba");
		p1.setPrecoProduto(new BigDecimal("5.00"));

		Produto p2 = new Produto();
		p2.setId(id++);
		p2.setCodigoProduto("COD4875");
		p2.setNomeProduto("Laranja");
		p2.setPrecoProduto(new BigDecimal("15.00"));

		lista.add(p1);
		lista.add(p2);
	}

	public void adiciona(Produto produto) {
		produto.setId(id++);
		ProdutoDao.lista.add(produto);

	}

	public List<Produto> getProdutos() {
		return ProdutoDao.lista;
	}

	public ArrayList<Produto> buscaProduto(String produtoPesquisado) {
		ArrayList<Produto> lista = new ArrayList<>();
		Produto produtoBuscado = new Produto();
		produtoBuscado.setId(id++);
		produtoBuscado.setCodigoProduto("COD4487");
		produtoBuscado.setNomeProduto("Melancia");
		produtoBuscado.setPrecoProduto(new BigDecimal("45.00"));
		lista.add(produtoBuscado);

		return lista;
	}

	public void removeProduto(Integer id) {

		Iterator<Produto> it = lista.iterator();

		while (it.hasNext()) {
			Produto produto = it.next();

			if (produto.getId() == id) {
				it.remove();
			}
		}

	}

	public Produto buscaProdutoPorId(Integer id2) {

		for (Produto produto : lista) {
			if (produto.getId() == id2) {
				return produto;
			}
		}

		return null;
	}
*/

