package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.TerrenoDao;
import br.com.asantos.gerenciador.vo.Terreno;

/**
 * Servlet implementation class ListaTerrenos
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.1
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
		List<Terreno> lista = terrenoDao.getTerrenos();

		String campoPesquisa = request.getParameter("pesquisa");

		if (campoPesquisa == "" || campoPesquisa == null) {
			request.setAttribute("terrenos", lista);
		} else {
			request.setAttribute("terrenos", terrenoDao.buscaTerreno(campoPesquisa));

		}

		RequestDispatcher rd = request.getRequestDispatcher("terreno/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
