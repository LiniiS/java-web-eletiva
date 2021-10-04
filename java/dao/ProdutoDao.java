package br.com.asantos.gerenciador.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.asantos.gerenciador.vo.Produto;

/**
 * Classe que simula um Banco de Dados para a classe Produto
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.1
 */
public class ProdutoDao {

	private static List<Produto> lista = new ArrayList<>();
	private static Integer id = 1;

	static {
		Produto p1 = new Produto();
		p1.setId(id++);
		p1.setCodigoProduto("COD1254");
		p1.setNomeProduto("Jabuticaba");

		Produto p2 = new Produto();
		p2.setId(id++);
		p2.setCodigoProduto("COD4875");
		p2.setNomeProduto("Laranja");

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

}
