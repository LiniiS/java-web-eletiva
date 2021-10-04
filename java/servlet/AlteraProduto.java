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
 * as alterações dos dados já
 * cadastrados serão mapeadas por este servlet
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
		//novamente está dadno erro aqui ao salvar as alterações
		//verificar asap
		Integer id = Integer.valueOf(prdId);

		//busca na lista qual é o objeto daquele id pra exibir e repopular onde for necessário
		ProdutoDao produtoDao = new ProdutoDao();
		Produto p = produtoDao.buscaProdutoPorId(id);
		
		//população
		p.setNomeProduto(nomeProduto);
		p.setCodigoProduto(codigoProduto);
		

		response.sendRedirect("produto/novoProdutoCadastrado.jsp");
	}
}
