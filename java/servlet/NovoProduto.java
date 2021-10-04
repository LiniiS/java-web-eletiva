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
 * Servlet implementation class NovoProduto
 * apresenta o formulario para cadastro
 * @author Aline S
 * @version 0.1
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
		
		//população
		Produto p = new Produto();
		p.setNomeProduto(nomeProduto);
		p.setCodigoProduto(codigoProduto);
		
		//"armazena no banco"
		ProdutoDao lst = new ProdutoDao();
		lst.adiciona(p);
		
		//redireciona pra evitar o reenvio de requisição duplicando o cadastro
//		RequestDispatcher rd = req.getRequestDispatcher("/novoProdutoCadastrado.jsp");
//			req.setAttribute("nomeProduto", p.getNomeProduto());
//			rd.forward(req, resp);
	

		resp.sendRedirect("produto/novoProdutoCadastrado.jsp");
	}
	
	
}
