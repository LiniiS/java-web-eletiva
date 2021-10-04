package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ProdutoDao;

/**
 * Servlet implementation class RemoveProduto
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/removeProduto")
public class RemoveProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//mais adequado seria um doDelete
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String prdId = request.getParameter("id");
		Integer id = Integer.valueOf(prdId);
		
		ProdutoDao produtos = new ProdutoDao();
		produtos.removeProduto(id);
	
		response.sendRedirect("listaProdutos");
		
		
		
		
	}



}
