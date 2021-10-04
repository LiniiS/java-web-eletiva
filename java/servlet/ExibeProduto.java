package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ProdutoDao;
import br.com.asantos.gerenciador.vo.Produto;

/**
 * Servlet implementation class ExibeProduto
 * apresenta os dados para edição
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/exibeProduto")
public class ExibeProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prdId = request.getParameter("id");
		Integer id = Integer.valueOf(prdId);

		ProdutoDao produtoDao = new ProdutoDao();
		
		//simular o findById
		Produto produto = produtoDao.buscaProdutoPorId(id);
	//	System.out.println(produto.getNome());
		
		//bota na requisição que será despachada os dados do  ${cliente.id}
		request.setAttribute("produto", produto);
		
		//chama a jsp que traz os dados daquele id
		RequestDispatcher rd = request.getRequestDispatcher("/produto/formAlteraProduto.jsp");
		rd.forward(request, response);
	}
	

}
