package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.TerrenoDao;

/**
 * Servlet implementation class ListaTerrenos
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.2
 */
@WebServlet("/listaTerrenos")
public class ListaTerrenos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TerrenoDao terrenoDao = new TerrenoDao();
		
		//melhorar essa pesquisa, por enqto tá buscando por cotas
		String campoPesquisa = request.getParameter("pesquisa");
	
		
		
		try {
			if (campoPesquisa == "" || campoPesquisa == null) {
				request.setAttribute("terrenos", terrenoDao.getTerrenos());
			} else {
				request.setAttribute("terrenos", terrenoDao.findTerrenos(campoPesquisa));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//TODO melhorar msg de erro, configurar uma msg/jsp
		}
		
		

		RequestDispatcher rd = request.getRequestDispatcher("terreno/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
