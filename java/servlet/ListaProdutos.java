package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ProdutoDao;
import br.com.asantos.gerenciador.vo.Produto;

/**
 * Servlet implementation class ListaProdutos
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/listaProdutos")
public class ListaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	ProdutoDao produtoDao = new ProdutoDao();
	List<Produto> lista = produtoDao.getProdutos();
	
	
	String campoPesquisa = request.getParameter("pesquisa");
	
	
	if(campoPesquisa =="" || campoPesquisa == null) {
		request.setAttribute("produtos", lista);
	}else {
		request.setAttribute("produtos", produtoDao.buscaProduto(campoPesquisa));
	}
	
	
	
	RequestDispatcher rd = request.getRequestDispatcher("produto/index.jsp");
	rd.forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

