package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.CategoriaDao;

/**
 * Servlet implementation class ListaCategorias
 */
@WebServlet("/listaCategorias")
public class ListaCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// utilizar o service para contornar o erro do form = method post e o doGet de
	// trazer a lista
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoriaDao categoriaDao = new CategoriaDao();


		// referente ao Search
		String campoPesquisa = request.getParameter("pesquisa");

		try {
			
			// cadastrados)
			if (campoPesquisa == "" || campoPesquisa == null) {
				request.setAttribute("categorias", categoriaDao.getCategorias());
			} else {
				// se tiver algo no campo de pesquisa, pegar da req e enviar ao DAO
				request.setAttribute("categorias", categoriaDao.findCategorias(campoPesquisa));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("categoria/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


}
