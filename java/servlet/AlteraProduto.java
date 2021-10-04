package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ProdutoDao;
import br.com.asantos.gerenciador.vo.Produto;

/**
 * Servlet implementation class AlteraProduto 
 * as altera��es dos dados j�
 * cadastrados ser�o mapeadas por este servlet
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/alteraProduto")
public class AlteraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//leitura
		String nomeProduto = request.getParameter("produto");
		String codigoProduto = request.getParameter("codigo");
		
		String prdId = request.getParameter("id");
		//novamente est� dadno erro aqui ao salvar as altera��es
		//verificar asap
		Integer id = Integer.valueOf(prdId);

		//busca na lista qual � o objeto daquele id pra exibir e repopular onde for necess�rio
		ProdutoDao produtoDao = new ProdutoDao();
		Produto p = produtoDao.buscaProdutoPorId(id);
		
		//popula��o
		p.setNomeProduto(nomeProduto);
		p.setCodigoProduto(codigoProduto);
		

		response.sendRedirect("produto/novoProdutoCadastrado.jsp");
	}
}
