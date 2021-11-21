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
 * Servlet implementation class RemoveProduto
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.2
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
		
		Produto produto = new Produto();
		produto.setId(id);
		
		ProdutoDao produtoDao = new ProdutoDao();
		try {
			produtoDao.deleteProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		response.sendRedirect("listaProdutos");
		
		
		
		
	}



}
