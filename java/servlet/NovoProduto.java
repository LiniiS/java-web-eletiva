package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ProdutoDao;
import br.com.asantos.gerenciador.vo.Produto;

/**
 * Servlet implementation class NovoProduto
 * apresenta o formulario para cadastro
 * @author Aline S
 * @version 0.2
 */
@WebServlet("/produtos")
public class NovoProduto extends HttpServlet {

	/**
	 * Classe implementa o servlet que é chamado ao receber a requisição de um novo
	 * cadastro de produtos, redirecionando para a tela de sucesso
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//leitura
		String nomeProduto = req.getParameter("produto");
		String codigoProduto = req.getParameter("codigo");
		String precoProduto = req.getParameter("preco");
		
		
		
		//população
		Produto prd = new Produto();
		prd.setNomeProduto(nomeProduto);
		prd.setCodigoProduto(codigoProduto);
		prd.setPrecoProduto(new BigDecimal(precoProduto));
		
		//"armazena no banco"
		ProdutoDao prdDao = new ProdutoDao();
		
		try {
			prdDao.newProduto(prd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//redireciona pra evitar o reenvio de requisição duplicando o cadastro
//		RequestDispatcher rd = req.getRequestDispatcher("/novoProdutoCadastrado.jsp");
//			req.setAttribute("nomeProduto", p.getNomeProduto());
//			rd.forward(req, resp);
	

		resp.sendRedirect("produto/novoProdutoCadastrado.jsp");
	}
	
	
}
